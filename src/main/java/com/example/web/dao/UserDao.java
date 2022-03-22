package com.example.web.dao;

import java.sql.*;
import java.util.ArrayList;

import com.example.web.models.Course;
import com.example.web.models.User;

public class UserDao {

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_assessment", "root", "thomasmerton");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public User getUser(int userId) {
        User user = null;
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE id = " + userId);
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String role = resultSet.getString("role");
                String password = resultSet.getString("password");
                user = new User(id, name, role, password);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();

        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users;");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String role = resultSet.getString("role");
                String password = resultSet.getString("password");
                users.add(new User(id, name, role, password));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return users;
    }

    public User validateUser(String enteredName, String enteredPassword) {
        User validatedUser = null;
        try (Connection connection = getConnection()) {
            String sql = "SELECT * from users WHERE name = '" + enteredName + "' AND password = '" + enteredPassword + "';";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String role = resultSet.getString("role");
                String password = resultSet.getString("password");
                validatedUser = new User(id, name, role, password);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("validated user " + validatedUser.toString());
        return validatedUser;
    }

    public void createUser(User user) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();

            String name = user.getName();
            String role = user.getRole();
            String password = user.getPassword();

            String sql = "INSERT INTO users (name, role, password) VALUES('" + name + "','" + role + "','" + password + "');";
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean updateUser(User user) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            int id = user.getId();
            String name = user.getName();
            String role = user.getRole();
            String password = user.getPassword();
            rowUpdated = statement.executeUpdate("UPDATE users SET id = " + id +
                    ", name = " + name +
                    ", role = " + role +
                    ", password = " + password +
                    " WHERE id = " + id) > 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return rowUpdated;
    }

    public boolean deleteUser(int userId) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            rowDeleted = statement.executeUpdate("DELETE FROM users WHERE id = " + userId) > 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return rowDeleted;
    }
}
