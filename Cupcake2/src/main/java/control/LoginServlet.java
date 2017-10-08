package control;

import data.ProductMapper;
import data.UserMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cart;
import model.User;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    UserMapper dm = new UserMapper();
    ProductMapper pm = new ProductMapper();
    Cart cart = new Cart();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        User u = dm.getUser(request.getParameter("username"));
        request.getSession().setAttribute("user", u);

        String action = request.getParameter("action");

        if ("login".equals(action)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = dm.validateLogin(username, password);
            if (user == null) {
                sendLoginForm(request, response);
                return;
            }
            request.getSession().setAttribute("cart", new Cart());
            request.getSession().setAttribute("bottoms", pm.getBottoms());
            request.getSession().setAttribute("toppings", pm.getToppings());

            sendFrontPage(request, response);
            return;
        }

        if ("logout".equals(action)) {
            request.removeAttribute("username");
            request.getSession().invalidate();
        }
//          sendFrontPage(request,response);

        if ("FrontPage".equals(action)) {
            sendFrontPage(request, response);
            return;
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
            ex.printStackTrace();
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
            ex.printStackTrace();
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

    private void sendLoginForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            try {
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);

            } catch (IOException | ServletException e) {
                e.getMessage();
            }
        }
    }

    private void sendFrontPage(HttpServletRequest request, HttpServletResponse response) {
        try {

            RequestDispatcher rd = request.getRequestDispatcher("shop.jsp");
            rd.forward(request, response);

        } catch (IOException | ServletException e) {
            e.getMessage();
        }
    }

    private void sendRegisterForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
            rd.forward(request, response);

        } catch (IOException | ServletException e) {
            e.getMessage();
        }
    }

}
