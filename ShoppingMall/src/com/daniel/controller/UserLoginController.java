package com.daniel.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daniel.dao.UserDao;
import com.daniel.model.User;

@WebServlet("/UserLoginController")
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao dao; 
    
    public UserLoginController() {
        super();
        dao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    	
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        User user = dao.getUserById(id);
        if((id!=null && !id.equals("")) && (pwd!=null && !pwd.equals(""))) {
        	if(pwd.equals(user.getPw()))
        		request.getRequestDispatcher("main.jsp").forward(request, response);
        	else
        		request.getRequestDispatcher("userloginerror.jsp").forward(request, response);
        }
    }
}