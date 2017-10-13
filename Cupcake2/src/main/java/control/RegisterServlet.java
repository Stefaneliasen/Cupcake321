package control;

import data.UserMapper;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    UserMapper dm = new UserMapper();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");

        // register user
        User user = (User) request.getSession().getAttribute("user");
        if ("register".equals(action)) {
            String username = request.getParameter("registerUsername");
            String password = request.getParameter("registerPassword");
            boolean admin = Boolean.parseBoolean(request.getParameter("admin"));
            int userId = Integer.parseInt(request.getParameter("registeruserId"));
            int balance = Integer.parseInt(request.getParameter("balance"));
            String email = request.getParameter("registerEmail");

            dm.registerUser(username, password, admin, userId, balance, email);
            user = dm.getUser(username);
            request.getSession().setAttribute("user", user);
            sendLoginForm(request, response);
            if (user == null) {
                //registration fail
                sendRegisterForm(request, response);
            } else {
                sendFrontPage(request, response);
            }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
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
            RequestDispatcher rd = request.getRequestDispatcher("shop.jsp");
            rd.forward(request, response);

        } catch (IOException | ServletException e) {
            e.getMessage();
        }
    }

}
