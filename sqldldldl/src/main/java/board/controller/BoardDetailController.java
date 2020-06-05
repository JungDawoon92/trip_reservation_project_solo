package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import board.dao.BoardDao;
import board.dto.BoardDto;

public class BoardDetailController extends AbstractController {
	private BoardDao boardDao;

	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,HttpServletResponse resp) throws Exception{
		ModelAndView mav = new ModelAndView();
		int iSeq = ServletRequestUtils.getIntParameter(req,"seq");
		BoardDto dto= boardDao.findBySeq(iSeq);
		mav.setViewName("detail"); mav.addObject("board",dto);
		return mav;
	}
}
