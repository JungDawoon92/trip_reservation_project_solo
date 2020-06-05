package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import board.dao.BoardDao;
import board.dto.BoardDto;

@Controller
public class BoardInsertFormController {
	private BoardDao boardDao;

	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	@RequestMapping(value="/board_insert_form.do",method = RequestMethod.GET)
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,HttpServletResponse arg1)throws Exception{
		System.out.println("실행됨.[GET]방식");
		return new ModelAndView("insert");
	}
	@RequestMapping(value="/board_insert_form.do",method = RequestMethod.POST)
	protected ModelAndView handleRequestInternal2(HttpServletRequest arg0,HttpServletResponse arg1)throws Exception{
		System.out.println("실행됨.[POST]방식");
		String title= arg0.getParameter("title");
		String writer= arg0.getParameter("writer");
		String content= arg0.getParameter("content");
		BoardDto dto = new BoardDto();
		dto.setTitle(title); dto.setWriter(writer);
		dto.setContent(content);
		boardDao.insert(dto);
		System.out.printf("%s,%s,%s\n",title,writer,content);
		return new ModelAndView("redirect:board_list.do");
	}
	
}
