package entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class User implements Comparable{

    private Integer id;
    private String userId;
    private String token;
    private int priority;
    private String email;

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public int getPriority() {
        return priority;
    }

    public User setPriority(int priority) {
        this.priority = priority;
        return this;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof User)) return false;

        User user = (User) o;

        return new EqualsBuilder()
                .append(getUserId(), user.getUserId())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getUserId())
                .toHashCode();
    }

    @Override
    public int compareTo(Object o) {
        if(o == null) {
            return -1;
        }
        if(! (o instanceof User)) {
            return -1;
        }
        return this.priority - ((User) o).priority;
    }
}
