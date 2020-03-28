package com.company.inter;

import com.company.entity.User;
import java.util.List;

public interface UserInter {

    List<User> getAllUsers();

    User getById(int id);

    boolean insertUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(int id);

    List<User> searchAllUser(String name, String surname);
}
