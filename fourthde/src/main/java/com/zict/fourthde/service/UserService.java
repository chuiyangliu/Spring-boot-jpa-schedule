package com.zict.fourthde.service;



import com.zict.fourthde.model.User;

import java.util.List;

public interface UserService {

    public List<User> getUserList();

    public User findUserById(long id);

    public void save(User user);

}
