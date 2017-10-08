package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Bottom;
import model.Topping;

public class ProductMapper {

    private Connection con;

    public ProductMapper() {
        con = new DB().getConnection();
    }

    public static void main(String[] args) throws SQLException {
        ProductMapper pm = new ProductMapper();
        pm.getToppings();
        for (Topping topping : pm.getToppings()) {
            System.out.println(topping.getFlavourTop());
        }
        pm.getBottoms();
        for (Bottom bottom : pm.getBottoms()) {
            System.out.println(bottom.getFlavourBot());
        }
        System.out.println(pm.getPriceBottom(2).getPriceBot());
        System.out.println(pm.getPriceTopping(1).getPriceTop());
    }

    public ArrayList<Topping> getToppings() throws SQLException {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        String SQLString
                = "select * from topping";

        Topping topping = null;
        ArrayList<Topping> toppings = new ArrayList<Topping>();

        try {
            stmt = con.prepareStatement(SQLString);
            rs = stmt.executeQuery();

            while (rs.next()) {
                topping = new Topping(rs.getInt("toppingId"), rs.getString("flavourTop"), rs.getInt("priceTop"));
                toppings.add(topping);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return toppings;
    }

    public ArrayList<Bottom> getBottoms() throws SQLException {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        String SQLString
                = "select * from bottom";

        Bottom bottom = null;
        ArrayList<Bottom> bottoms = new ArrayList<Bottom>();

        try {
            stmt = con.prepareStatement(SQLString);
            rs = stmt.executeQuery();

            while (rs.next()) {
                bottom = new Bottom(rs.getInt("bottomId"), rs.getString("flavourBot"), rs.getInt("priceBot"));
                bottoms.add(bottom);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return bottoms;
    }

    public Bottom getPriceBottom(int id) {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Bottom bottom = null;
        String SQLString
                = "select * from bottom where bottomId  = ?";
        try {
            stmt = con.prepareStatement(SQLString);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                bottom = new Bottom(id, rs.getString("flavourBot"), rs.getInt("priceBot"));
            }
        } catch (SQLException e) {
            System.out.println("Fail in dataMapper - getPriceBot");
            e.printStackTrace();
        }
        return bottom;
    }

    public Topping getPriceTopping(int id) {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Topping topping = null;
        String SQLString
                = "select * from topping where toppingId  = ?";
        try {
            stmt = con.prepareStatement(SQLString);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                topping = new Topping(id, rs.getString("flavourTop"), rs.getInt("priceTop"));
            }
        } catch (SQLException e) {
            System.out.println("Fail in dataMapper - getPriceTop");
            e.printStackTrace();
        }
        return topping;
    }
}
