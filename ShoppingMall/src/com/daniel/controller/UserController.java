package com.daniel.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daniel.dao.UserDao;
import com.daniel.model.User;

public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/signup.jsp";
    private static String LIST_USER = "/userlist.jsp";
    private static String USER_JOIN = "/userjoinsuccess.jsp";
    private UserDao dao;

    public UserController() {
        super();
        dao = new UserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    	
    	String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int userId = Integer.parseInt(request.getParameter("userId"));
            dao.deleteUser(userId);
            forward = LIST_USER;
            request.setAttribute("user_info", dao.getAllUsers());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int userId = Integer.parseInt(request.getParameter("userId"));
            User user = dao.getUserByUserId(userId);
            request.setAttribute("user", user);
        } else if (action.equalsIgnoreCase("listUser")){
            forward = LIST_USER;
            request.setAttribute("user_info", dao.getAllUsers());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String action = request.getParameter("action");
		String forward=LIST_USER;

		if (action.equalsIgnoreCase("userjoin")) {
			forward = USER_JOIN;
		}
		User user = new User();
		user.setId(request.getParameter("id"));
		user.setPw(request.getParameter("pw"));
		user.setName(request.getParameter("name"));
		try {
			Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("dob"));
			user.setDob(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setAddress(request.getParameter("address"));
		String userid = request.getParameter("userid");
		if (userid == null || userid.isEmpty()) {
			dao.addUser(user);
		} else {
			user.setUserid(Integer.parseInt(userid));
			dao.updateUser(user);
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		request.setAttribute("user_info", dao.getAllUsers());
		view.forward(request, response);

	}
}