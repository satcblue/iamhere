package watcher;

import core.op.AutoOpType;

public class Watcher {

    public static void send(AutoOpType autoOpType, WatcherType watcherType, String msg) {

    }
    public static void sendSuccess(AutoOpType autoOpType) {
        send(autoOpType, WatcherType.SUCCESS, "");
    }
    public static void sendError(AutoOpType autoOpType, String msg) {
        send(autoOpType, WatcherType.ERROR, msg);
    }
}
