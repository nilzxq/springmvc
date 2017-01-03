package com.nilzxq.object;

import java.util.Map;

/**
 * @author zxq @date 2017年1月3日
 *
 */
public class UserMapForm {
    private Map<String,User> users;

    @Override
    public String toString() {
        return "UserMapForm{" +
                "users=" + users +
                '}';
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }
}
