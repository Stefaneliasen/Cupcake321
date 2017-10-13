package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

public class UserMapper {
    //test

    public static void main(String[] args) {
        UserMapper dm = new UserMapper();
        dm.registerUser("mjaay", "hey123", true, 1, 50, "mbj3400@gmail.com");
        System.out.println(dm.getUser("mjaay"));
        System.out.println(dm.validateLogin("mjaay", "hey123"));
    }

    private Connection con;

    public UserMapper() {
        con = new DB().getConnection();
    }
    public User getUser(String u) {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        User user = null;

        String SQLString
                = "select * from user1 where username = ?";
        try {
            stmt = con.prepareStatement(SQLString);
            stmt.setString(1, u);
            rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User(u, rs.getString("password"), rs.getBoolean("admin"), rs.getInt("userId"), rs.getInt("balance"), rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println("Fail in dataMapper - getUser");
            e.printStackTrace();
        }
        return user;
    }

    public void registerUser(String username, String password, boolean admin, int userId, int balance, String email) {
        PreparedStatement newUser = null;
        String SQLString = "insert into user1 (username, password, userId, balance, email) values (?,?,?,?,?)";
        try {
            con.setAutoCommit(false);
            newUser = con.prepareStatement(SQLString);
            newUser.setString(1, username);
            newUser.setString(2, password);
            newUser.setInt(3, userId);
            newUser.setInt(4, balance);
            newUser.setString(5, email);
            newUser.executeUpdate();

            con.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println("Fail in DataMapper - registerUser");
            System.out.println(e.getMessage());
        }
    }

    public User validateLogin(String username, String password) {
        User user = getUser(username);
        if (user == null) {
            return null;
        }
        if (password != null && password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }

}
