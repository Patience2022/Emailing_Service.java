/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Models.SendEmail;
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
@WebServlet(name = "UserVerification", urlPatterns = {"/UserVerification"})
public class UserVerification extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        try
        {
            //Fetching values from  the user
            String name = request.getParameter("username");
            String email = request.getParameter("userEmail");
            
            //Instantiating user class
            SendEmail sm = new SendEmail();
            
            // Generating verification code
            String code = sm.getRandom();
            
            //Instatiating user object
            User user = new User(name, email, code);
            
            //sending an email
            boolean test = sm.sendEmail(user);
            
            //Setting a condition  for the user's next step
            if(test)//if email was sent successfully, we create a session and direct the user to a page to insert the code
            {
                HttpSession session = request.getSession();
                session.setAttribute("authCode", user);
                response.sendRedirect("verify.jsp");
            }
            else // if send email was unsuccessful, the user is redirecting to the home page to re-enter details
                response.sendRedirect("index.jsp");
        }
        catch(Exception e){out.println(e.getMessage());}
    }

  
}
