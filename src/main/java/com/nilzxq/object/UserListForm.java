package com.nilzxq.object;

import java.util.List;

/**
 * @author zxq @date 2017年1月3日
 *
 */
public class UserListForm {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserListForm{" +
                "users=" + users +
                '}';
    }
}
