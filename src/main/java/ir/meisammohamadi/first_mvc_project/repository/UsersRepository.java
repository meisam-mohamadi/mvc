package ir.meisammohamadi.first_mvc_project.repository;

import ir.meisammohamadi.first_mvc_project.model.User;

import java.sql.*;

public class UsersRepository {
    Connection connection;
    PreparedStatement preparedStatement;

    public UsersRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_servlet_mvc", "root", "1234");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int save(User user) {
        try {
            preparedStatement = connection.prepareStatement("insert into users (username , password) values (?,?)");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows;

        } catch (SQLException e) {
            System.out.println("Error inserting user command ..."); // please use log4j(database)
            return 0;
        }
    }

    public boolean login(User user) {
        try {
            preparedStatement = connection.prepareStatement("SELECT count(id) AS users_count FROM users WHERE username=? AND password=?");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt("users_count");
            if (count == 1)
                return true;
            else
                return false;
        } catch (SQLException e) {
            System.out.println("Error selecting user command ..."); // please use log4j(database)
            return false;
        }
    }

}
