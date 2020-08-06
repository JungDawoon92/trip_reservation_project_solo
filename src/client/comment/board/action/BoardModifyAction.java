package client.comment.board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import aqua.module.Action;
import aqua.module.ActionForward;
import client.comment.board.db.BoardBean;
import client.comment.board.db.BoardDAO;

public class BoardModifyAction implements Action {
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		boolean result = false;
		BoardDAO boarddao = new BoardDAO();
		BoardBean boarddata = new BoardBean();
		String realFolder = "";
		String saveFolder = "/boardupload";
		int fileSize = 5 * 1024 * 1024;
		realFolder = request.getRealPath(saveFolder);

		try {
			MultipartRequest multi = null;
			multi = new MultipartRequest(request, realFolder, fileSize,
					"UTF-8", new DefaultFileRenamePolicy());
			
			int num = Integer.parseInt(multi.getParameter("BOARD_NUM"));

			int pager=1;
			if (request.getParameter("pager") != null) {
				pager = Integer.parseInt(multi.getParameter("pager"));
			}
		
			boarddata.setBOARD_NUM(num);
			boarddata.setBOARD_SUBJECT(multi.getParameter("BOARD_SUBJECT"));
			boarddata.setBOARD_CONTENT(multi.getParameter("BOARD_CONTENT"));
			
			
			if(multi.getFilesystemName((String) multi.getFileNames().nextElement()) != null) {
				boarddata.setBOARD_FILE(multi.getFilesystemName((String) multi.getFileNames().nextElement()));
			} else {
				if(!(multi.getParameter("H_BOARD_FILE").equals("null"))) {
					boarddata.setBOARD_FILE(multi.getParameter("H_BOARD_FILE"));
				} 
			}

			result = boarddao.boardModify(boarddata);
			
			
			if (result == false) {
				return null;
			}

			forward.setRedirect(true);
			forward.setPath("./BoardDetailAction.bo?num="
					+ boarddata.getBOARD_NUM() +"&pager="+pager);
			// return forward;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return forward;
	}
}