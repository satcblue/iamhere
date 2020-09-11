package core.op;

import static core.AppConfig.SERVER_URL;

public final class AutoOpUrl {
    public final static String HOME = SERVER_URL + "/home.json";
    public final static String USER_INFO_URL = SERVER_URL + "/my/getUserInfo.json";
    public final static String TODAY_HEAT_LIST = SERVER_URL + "/heat/getTodayHeatList.json";
    public final static String HEAT_SAVE = SERVER_URL + "/heat/save.json";
}
