package core.op.imp;

import core.op.AutoOp;
import core.op.AutoOpType;
import core.op.param.HeatSaveParam;
import core.op.param.AutoOpParam;
import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.message.BasicHeader;

import java.util.Collections;
import java.util.List;

public class AutoHeatSaveOp extends AutoOp {
    private final static String REFER = "https://servicewechat.com/wxce6d08f781975d91/142/page-frame.html";

    public AutoHeatSaveOp() {
        super(AutoOpType.HEAT_SAVE);
    }

    @Override
    protected void addHeader(List<Header> headers) {
        headers.add(new BasicHeader(HttpHeaders.REFERER, REFER));
    }

    @Override
    protected AutoOpParam getAutoOpParam() {
        HeatSaveParam heatSaveParam = new HeatSaveParam();
        heatSaveParam.setAnswers(Collections.singletonList("0"))
                .setLongitude("113.3541850000")
                .setLatitude("23.0922820000")
                .setTemperature(36.1f)
                .setCountry("中国")
                .setProvince("广东")
                .setCity("广州")
                .setSeq(3);
        return heatSaveParam;
    }
}
