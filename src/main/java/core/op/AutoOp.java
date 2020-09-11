package core.op;

import core.op.param.AutoOpParam;
import exceptions.UserException;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.Asserts;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutoOp {

    private AutoOpType autoOpType = null;

    private static HttpClient httpClient = null;

    static {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(60000,
                TimeUnit.MILLISECONDS);
        connectionManager.setMaxTotal(1000);
        connectionManager.setDefaultMaxPerRoute(50);
        httpClient = HttpClients.custom().disableAutomaticRetries().build();
    }
    public AutoOp() {
        this.autoOpType = AutoOpType.HOME;
    }

    public AutoOp(AutoOpType autoOpType) {
        this.autoOpType = autoOpType;
    }


    private void sendPost(AutoOpType autoOpType, List<Header> headers, List<NameValuePair> requestBody) {
        HttpPost httpPost = new HttpPost(autoOpType.url);
        for (Header header : headers) {
            httpPost.addHeader(header);
        }
        // 以 form 形式发送数据
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(requestBody, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
            @Override
            public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
                int status = response.getStatusLine().getStatusCode();
                if(status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null? EntityUtils.toString(response.getEntity()): null;
                }
                EntityUtils.consume(response.getEntity());
                throw new ClientProtocolException("111");
            }
        };
        try {
            String response = httpClient.execute(httpPost, responseHandler);
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void sendGet(AutoOpType autoOpType, List<Header> headers, List<NameValuePair> requestBody) {
    }

    private void send(AutoOpType autoOpType, List<Header> headers,
                             List<NameValuePair> requestBody) {
        Asserts.notNull(headers, "header");
        Asserts.notNull(requestBody, "requestBody");
        if (RequestType.POST.equals(autoOpType.requestType)) {
            headers.add(new BasicHeader(HttpHeaders.CONTENT_TYPE, AutoOpHeaders.POST_CONTENT_TYPE));
            sendPost(autoOpType, headers, requestBody);
        }
        if (RequestType.GET.equals(autoOpType.requestType)) {
            sendGet(autoOpType, headers, requestBody);
        }
    }
    private List<Header> createHeader() {
        List<Header> headerList = new ArrayList<>();
        headerList.add(new BasicHeader(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate, br"));
        headerList.add(new BasicHeader("token", AutoOpPool.getUser().getToken()));
        headerList.add(new BasicHeader(HttpHeaders.USER_AGENT, AutoOpHeaders.USER_AGENT));
        return headerList;
    }
    private List<NameValuePair> createRequestBody(AutoOpParam autoOpParam) {
        List<NameValuePair> requestBody = new ArrayList<>();
        if (autoOpParam == null) {
            return requestBody;
        }
        Method[] methods = autoOpParam.getClass().getDeclaredMethods();
        try {
            for (Method method : methods) {
                if(method.getName().startsWith("get")) {
                    Object o = method.invoke(autoOpParam);
                    StringBuilder sb = new StringBuilder(method.getName());
                    sb.delete(0, 3);
                    sb.setCharAt(0, (char)('a' - 'A' + sb.charAt(0)));
                    if(o == null) {
                        requestBody.add(new BasicNameValuePair(sb.toString(), ""));
                    } else {
                        requestBody.add(new BasicNameValuePair(sb.toString(), o.toString()));
                    }
                }
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return requestBody;

    }
    protected void addHeader(List<Header> headers) {

    }
    protected AutoOpParam getAutoOpParam() {
        return null;
    }

    public void request() {
        List<Header> headers = createHeader();
        addHeader(headers);
        List<NameValuePair> requestBody = createRequestBody(getAutoOpParam());
        try {
            send(autoOpType, headers, requestBody);
        } catch (UserException ignored) {
        }
    }
}
