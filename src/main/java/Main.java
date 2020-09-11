import core.op.imp.AutoHeatSaveOp;
import core.op.AutoOpPool;
import entity.User;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        AutoHeatSaveOp autoHeatSaveOp = new AutoHeatSaveOp();
        User user = new User();
        user.setToken("xx");
        AutoOpPool.addUser(user);
        IntStream.rangeClosed(1, 10).forEach(i -> autoHeatSaveOp.request());
        AutoOpPool.removeUser();
    }
}
