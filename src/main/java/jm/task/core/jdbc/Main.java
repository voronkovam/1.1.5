package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("name1", "last_name1", (byte) 55);
        userService.saveUser("name2", "last_name2", (byte) 45);
        userService.saveUser("name3", "last_name3", (byte) 15);
        userService.saveUser("name4", "last_name4", (byte) 65);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
