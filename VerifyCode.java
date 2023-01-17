/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Models.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author patce
 */
@WebServlet(name = "VerifyCode", urlPatterns = {"/VerifyCode"})
public class VerifyCode extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try 
        {
            HttpSession session =request.getSession();
            User user = (User)session.getAttribute("authCode");
            String code = request.getParameter("authcode");
            if(user!=null && code !=null)
            {
                if(code.equals(user.getCode()))
                {
                    out.println("verification code completed successfully");
                }
                else
                    out.println("You have entered incorrect code");
            }
            
            else
                response.sendRedirect("index.jsp");
        }
        catch(Exception e){out.println(e.getMessage());}
    }
}
