package com.daniel.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String adminID = "kwon";
    private static String adminPW = "happy";
    
    public AdminController() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    	
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        if((id!=null && !id.equals("")) && (pwd!=null && !pwd.equals(""))) {
        	if(id.equals(adminID) && pwd.equals(adminPW))
        		request.getRequestDispatcher("admin.jsp").forward(request, response);
        	else
        		request.getRequestDispatcher("adminloginerror.jsp").forward(request, response);
        }
    }
}