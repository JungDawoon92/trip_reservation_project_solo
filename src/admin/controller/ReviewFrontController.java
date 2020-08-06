package admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.comment.action.AdminBoardDeleteAction;
import admin.comment.action.AdminBoardListAction;
import admin.comment.action.AdminBoardViewAction;
import admin.comment.action.AdminCheckDeleteAction;
import admin.comment.action.AdminCommentAddAction;
import admin.comment.action.AdminCommentDeleteAction;
import admin.comment.action.AdminCommentReplyAction;
import aqua.module.Action;
import aqua.module.ActionForward;


public class ReviewFrontController extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
		
		System.out.println("debug >>" + command);
		if (command.equals("/AdminBoardListAction.adr")) { //관리자모드 게시판 조회action
			action = new AdminBoardListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/AdminBoardViewAction.adr")) { //관리자모드 게시판 상세 조회
			action = new AdminBoardViewAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/AdminBoardDeleteAction.adr")) { //관리자게시판 delete
			action = new AdminBoardDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/AdminCheckDeleteAction.adr")) { //관리자게시판체크박스 delete
			action = new AdminCheckDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}  else if (command.equals("/AdminCommentAddAction.adr")) { // 관리자가 댓글달기
			action = new AdminCommentAddAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}  else if (command.equals("/AdminCommentReplyAction.adr")) { // 관리자가 답글달기
			action = new AdminCommentReplyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}  else if (command.equals("/AdminCommentDeleteAction.adr")) { // 관리자 댓글삭제
			action = new AdminCommentDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		 
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}