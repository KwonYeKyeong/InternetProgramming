package com.daniel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.daniel.model.Board;
import com.daniel.util.DbUtil;

public class BoardDao {

	private Connection connection;

	public BoardDao() {
		connection = DbUtil.getConnection();
	}

	public void addBoard(Board board) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into board_info(title, writer, date, memo) values (?, ?, ?, ? )");
			// Parameters start with 1
			preparedStatement.setString(1, board.getTitle());
			preparedStatement.setString(2, board.getWriter());
			preparedStatement.setDate(3, new java.sql.Date(board.getDate().getTime()));
			preparedStatement.setString(4, board.getMemo());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteBoard(int boardId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from board_info where boardid=?");
			// Parameters start with 1
			preparedStatement.setInt(1, boardId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateBoard(Board board) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update board_info set title=?, writer=?, date=?, memo=?" +
							"where boardid=?");
			// Parameters start with 1
			preparedStatement.setString(1, board.getTitle());
			preparedStatement.setString(2, board.getWriter());
			preparedStatement.setDate(3, new java.sql.Date(board.getDate().getTime()));
			preparedStatement.setString(4, board.getMemo());
			preparedStatement.setInt(5, board.getBoardid());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Board> getAllBoards() {
		List<Board> boards = new ArrayList<Board>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from board_info");
			while (rs.next()) {
				Board board = new Board();
				board.setBoardid(rs.getInt("boardid"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setDate(rs.getDate("date"));
				board.setMemo(rs.getString("memo"));
				boards.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return boards;
	}
	
	public Board getBoardByBoardId(int boardId) {
		Board board = new Board();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from board_info where boardid=?");
			preparedStatement.setInt(1, boardId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				board.setBoardid(rs.getInt("boardid"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setDate(rs.getDate("date"));
				board.setMemo(rs.getString("memo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return board;
	}
	
}
