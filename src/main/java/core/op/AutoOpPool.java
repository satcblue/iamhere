package core.op;

import entity.User;
import org.apache.http.util.Asserts;

import java.util.concurrent.ConcurrentSkipListSet;

public class AutoOpPool{
    private final static ConcurrentSkipListSet<User> AUTO_OP_POOL = new ConcurrentSkipListSet<>();
    private final static ThreadLocal<User> OPERATING_USER = new ThreadLocal<>();
    private static final Object o = new Object();

    public static User getUser() {
        User user = null;
        if (OPERATING_USER.get() == null) {
            user = AUTO_OP_POOL.pollFirst();
            OPERATING_USER.set(user);
        } else {
            user = OPERATING_USER.get();
        }
        return user;
    }

    public static void addUser(User user) {
        Asserts.notNull(user, "user");
        AUTO_OP_POOL.add(user);
    }

    public static void removeUser() {
        OPERATING_USER.remove();
    }
}
