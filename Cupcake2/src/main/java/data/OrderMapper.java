package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import model.Order;
import model.Orderline;

public class OrderMapper {

    private Connection con;
    UserMapper um = new UserMapper();

    public static void main(String[] args) throws SQLException {
        OrderMapper om = new OrderMapper();
        Orderline ol = new Orderline(1, 1, 1, 1, 1, 1, 1);
        //   om.addOrder(ol);
        //om.addOdetails();

    }

    public OrderMapper() {
        con = new DB().getConnection();
    }

    public int addOrder(Order order) throws SQLException {
        PreparedStatement addUserID = null;
        String sql = "insert into order1 (User_userId) values (?);";
        try (
                PreparedStatement statement = con.prepareStatement(sql,
                        Statement.RETURN_GENERATED_KEYS);) {
            con.setAutoCommit(false);
            statement.setInt(1, order.getUserId());
            int affectedRows = statement.executeUpdate();
            //  con.setAutoCommit(true);
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    order.setOrderId(generatedKeys.getInt(1));
                    addOdetails(order);

                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        }
        return order.getOrderId();
    }

    public void addOdetails(Order order) {
        PreparedStatement order1 = null;
        String SQLString = "insert into odetails (Order_orderId, totalPrice, quantity, "
                + "bottom_bottomId, topping_toppingId) values (?,?,?,?,?)";
        try {
            // con.setAutoCommit(false);
            order1 = con.prepareStatement(SQLString);
            order1.setInt(1, order.getOrderId());
            for (int i = 0; i < order.getOrderlines().size(); i++) {

                order1.setInt(2, order.getOrderlines().get(i).getTotalPrice());
                order1.setInt(3, order.getOrderlines().get(i).getQuantity());
                order1.setInt(4, order.getOrderlines().get(i).getBottomId());
                order1.setInt(5, order.getOrderlines().get(i).getToppingId());
                order1.executeUpdate();
            }

            con.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println("Fail in OrderMapper - Odetails");
            System.out.println(e.getMessage());
        }
    }
}
