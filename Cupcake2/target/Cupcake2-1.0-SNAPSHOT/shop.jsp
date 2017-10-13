<%-- 
    Document   : shop
    Created on : 21-09-2017, 12:39:39
    Author     : Arne
--%>
<%@page import="model.Cart"%>
<%@page import="model.Orderline"%>
<%@page import="model.Topping"%>
<%@page import="model.Bottom"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Cart cart = new Cart(); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <title>Cupcake Shop</title>
    </head>
    <body>
        <form id="addProduct" action="ProductServlet" method="POST">
            <input type="hidden" name="action" value="addProduct">
            <table class="table table-striped">
                <thead><tr><th>Bottom</th><th>Topping</th><th>Quantity</th><th>Select</th></tr></thead>
                <tbody>
                    <tr>
                        <td><select name="bottom" id="bottomSelect">
                                <option value="0">Choose bottom</option>
                                <%
                                    List<Bottom> bottoms = (List<Bottom>) session.getAttribute("bottoms");
                                    for (Bottom bottom : bottoms) {
                                        out.print("<option value=\"" + bottom.getBottomId() + "\">" + bottom.getFlavourBot() + ": " + bottom.getPriceBot() + "</option>");
                                    }
                                %>
                            </select></td>
                        <td><select name="topping" id="toppingSelect">
                                <option value="0">Choose topping</option>


                                <% List<Topping> toppings = (List<Topping>) session.getAttribute("toppings");
                                    for (Topping topping : toppings) {
                                        out.print("<option value=\"" + topping.getToppingId() + "\">" + topping.getFlavourTop() + ": " + topping.getPriceTop() + "</option>");
                                    }
                                %>
                            </select></td>
                        <td><input type="text" name="qty" placeholder="quantity" id="qtyInput"></td>
                        <td><input type="submit" name="submit" value="Add to cart"></td><td><span id="errorContainer"></span></td>
                    </tr>
                    <tr>
                        <th> Bottom </th>
                        <th> Topping </th>
                        <th> Price </th>
                        <th> Quantity </th>
                    </tr>

                    <% Cart orderlines = (Cart) session.getAttribute("cart");
                        if (cart.getLines() != null) {
                            for (Orderline orderline : orderlines.getLines()) {
                                out.print("<tr><td>" + orderline.getBottomId() + "</td>" + "<td>" + orderline.getToppingId() + "</td>" + "<td>" + orderline.getTotalPrice() + "</td>" + "<td>" + orderline.getQuantity() + "</td>" + "</tr>");
                            }
                        }
                    %>

                </tbody>
            </table>
        </form>
        <form id="Finalize" action="ProductServlet" method="POST">
            <input type="hidden" name="action" value="Finalize">
            <input type="submit" name="submit" value="Finalize Order">
        </form>
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>
