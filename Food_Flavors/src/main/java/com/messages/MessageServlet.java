package com.messages;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MessageServlet extends HttpServlet {
	
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	
        // Retrieve form parameters
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String messageText = request.getParameter("message");

        // Create a Message object
        Message message = new Message();
        message.setName(name);
        message.setEmail(email);
        message.setSubject(subject);
        message.setMessage(messageText);

        // Save the message to the database
        MessageDAO.saveMessage(message);

        // Redirect to a success page or display a success message
        RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
        dispatcher.forward(request, response);
        
       

    }
    
    
}


