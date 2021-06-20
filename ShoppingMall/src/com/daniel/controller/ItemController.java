package com.daniel.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daniel.dao.ItemDao;
import com.daniel.model.Item;

@WebServlet("/ItemController")
public class ItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/item.jsp";
    private static String LIST_ITEM = "/itemlist.jsp";
    private static String MAIN_ITEM = "/mainitemlist.jsp";
    private static String ORDER_ITEM ="/orderitem.jsp";
    private ItemDao dao;

    public ItemController() {
        super();
        dao = new ItemDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    	
    	String forward="";
        String action = request.getParameter("action");
       	if(action==null) action="order";
        
        if (action.equalsIgnoreCase("delete")){
            int itemId = Integer.parseInt(request.getParameter("itemId"));
            dao.deleteItem(itemId);
            forward = LIST_ITEM;
            request.setAttribute("item_info", dao.getAllItems());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int itemId = Integer.parseInt(request.getParameter("itemId"));
            Item item = dao.getItemByItemId(itemId);
            request.setAttribute("item", item);
        } else if (action.equalsIgnoreCase("listItem")){
            forward = LIST_ITEM;
            request.setAttribute("item_info", dao.getAllItems());
        } else if (action.equalsIgnoreCase("mainItem")) {
        	forward=MAIN_ITEM;
        	request.setAttribute("item_info", dao.getAllItems());
        } else if (action.equalsIgnoreCase("order")) {
        	String[] ids=request.getParameterValues("itemid");
        	forward=ORDER_ITEM;
        	dao.decreaseQtybyItemId(ids);
        	request.setAttribute("item_info", dao.getAllItems());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    	
    	Item item = new Item();
        item.setName(request.getParameter("name"));
        item.setAuthor(request.getParameter("author"));
        item.setPrice(Integer.parseInt(request.getParameter("price")));
        item.setQty(Integer.parseInt(request.getParameter("qty")));
        item.setMemo(request.getParameter("memo"));
        String itemid = request.getParameter("itemid");
        if(itemid == null || itemid.isEmpty())
        {
            dao.addItem(item);
        }
        else
        {
            item.setItemid(Integer.parseInt(itemid));
            dao.updateItem(item);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_ITEM);
        request.setAttribute("item_info", dao.getAllItems());
        view.forward(request, response);
    }
}