/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import data.OrderMapper;
import data.ProductMapper;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cart;
import model.Order;
import model.User;

/**
 *
 * @author Arne
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/ProductServlet"})
public class ProductServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        ProductMapper pm = new ProductMapper();
        OrderMapper om = new OrderMapper();
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        String action = request.getParameter("action");
        User user = (User) request.getSession().getAttribute("user"); //Integer.parseInt(request.getParameter("userId"));
        switch (action) {
            case "addProduct":
                int bottomId = Integer.parseInt(request.getParameter("bottom"));
                int toppingId = Integer.parseInt(request.getParameter("topping"));
                int quantity = Integer.parseInt(request.getParameter("qty"));
                // int totalPrice = cart.totalPrice(bottomId, toppingId, quantity);
                int toppingPrice = pm.getPriceTopping(toppingId).getPriceTop();
                int bottomPrice = pm.getPriceBottom(bottomId).getPriceBot();
                int totalPrice = cart.totalPrice(bottomPrice, toppingPrice, quantity);
                //int totalPrice = cart1.totalPrice(orderline.getBottomPrice(), orderline.getToppingPrice(), orderline.getQuantity());

                cart.addOrderline(user.getUserId(), bottomId, bottomPrice, toppingId, toppingPrice, quantity, totalPrice);
                request.getSession().setAttribute("cart", cart);
                RequestDispatcher rd = request.getRequestDispatcher("shop.jsp");
                rd.forward(request, response);

                break;
            case "Finalize":

                Order order = new Order(user.getUserId(), cart.getLines());
                try {
                    om.addOrder(order);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                RequestDispatcher rd1 = request.getRequestDispatcher("myOrders.jsp");
                rd1.forward(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
