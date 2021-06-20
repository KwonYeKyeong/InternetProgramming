package com.daniel.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daniel.dao.BoardDao;
import com.daniel.model.Board;

@WebServlet("/BoardController")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/board.jsp";
	private static String LIST_BOARD = "/boardlist.jsp";
	private static String USER_BOARD = "/userboard.jsp";
	private BoardDao dao;

	public BoardController() {
		super();
		dao = new BoardDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("delete")) {
			int boardId = Integer.parseInt(request.getParameter("boardId"));
			dao.deleteBoard(boardId);
			forward = LIST_BOARD;
			request.setAttribute("board_info", dao.getAllBoards());
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			int boardId = Integer.parseInt(request.getParameter("boardId"));
			Board board = dao.getBoardByBoardId(boardId);
			request.setAttribute("board", board);
		} else if (action.equalsIgnoreCase("listBoard")) {
			forward = LIST_BOARD;
			request.setAttribute("board_info", dao.getAllBoards());
		} else if (action.equalsIgnoreCase("mainBoard")){
			forward=USER_BOARD;
			request.setAttribute("board_info",  dao.getAllBoards());
		} else {
			forward = INSERT_OR_EDIT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String action = request.getParameter("action");
		if(action==null) action="userinsert";

		if (action.equalsIgnoreCase("userinsert")) {
			Board board = new Board();
			board.setTitle(request.getParameter("title"));
			board.setWriter(request.getParameter("writer"));
			try {
				Date date = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("date"));
				board.setDate(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			board.setMemo(request.getParameter("memo"));
			dao.addBoard(board);
			
			RequestDispatcher view = request.getRequestDispatcher(USER_BOARD);
			request.setAttribute("board_info", dao.getAllBoards());
			view.forward(request, response);
		} else {
			Board board = new Board();
			board.setTitle(request.getParameter("title"));
			board.setWriter(request.getParameter("writer"));
			try {
				Date date = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("date"));
				board.setDate(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			board.setMemo(request.getParameter("memo"));
			String boardid = request.getParameter("boardid");
			if (boardid == null || boardid.isEmpty()) {
				dao.addBoard(board);
			} else {
				board.setBoardid(Integer.parseInt(boardid));
				dao.updateBoard(board);
			}
			RequestDispatcher view = request.getRequestDispatcher(LIST_BOARD);
			request.setAttribute("board_info", dao.getAllBoards());
			view.forward(request, response);
		}
	}
}