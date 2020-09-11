package core.op;

public enum AutoOpType {
    HOME(AutoOpUrl.HOME, RequestType.POST),
    HEAT_SAVE(AutoOpUrl.HEAT_SAVE, RequestType.POST);
    AutoOpType(String url, RequestType requestType) {
        this.url = url;
        this.requestType = requestType;
    }
    public String url;
    public RequestType requestType;
}
