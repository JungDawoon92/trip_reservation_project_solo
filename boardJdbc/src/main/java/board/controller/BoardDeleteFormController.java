package board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.dao.BoardDao;

@Controller
public class BoardDeleteFormController {
	private BoardDao boardDao;

	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@RequestMapping(value="/board_delete.do", method = RequestMethod.GET)
	protected ModelAndView deleteProcess(@RequestParam int seq) {
		System.out.println("글번호:" + seq);
		boardDao.delete(seq);
		return new ModelAndView("redirect:board_list.do");
	}
}
