package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        System.out.println("User таблица создана");
        userService.saveUser("Рита", "Мухина", (byte) 23);
        System.out.println("User Рита Мухина добавлена в базу данных");

        userService.saveUser("Вася", "Умный", (byte) 25);
        System.out.println("User Вася Умный добавлен в базу данных");

        userService.saveUser("Игнат", "Петров", (byte) 22);
        System.out.println("User Игнат Пертов добавлен в базу данных");

        userService.saveUser("Полина", "Березкина", (byte) 35);
        System.out.println("User Полина Березкина добавлена в базу данных");

        for (User user : userService.getAllUsers()) {
            System.out.println(user);
        }
        userService.cleanUsersTable();
        System.out.println("Таблица Users очищена");

        userService.dropUsersTable();
        System.out.println("Таблица Users удалена");

    }
}
