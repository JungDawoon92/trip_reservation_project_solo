package kr.co.mycom.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import kr.co.mycom.guest.model.GuestDAO;
import kr.co.mycom.guest.model.GuestDTO;

public class WriteController implements Controller {
	// WriteController는 GuestDAO에 의존하고 있으므로 세터 인젝션 해야 한다.
	
	private GuestDAO guestDAO;

	public void setGuestDAO(GuestDAO guestDAO) {
		this.guestDAO = guestDAO;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String home = request.getParameter("home");
		String content = request.getParameter("content");
		
		GuestDTO dto = new GuestDTO();
		dto.setName(name);
		dto.setPwd(pwd);
		dto.setEmail(email);
		dto.setHome(home);
		dto.setContent(content);
		guestDAO.insertGuest(dto);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:list.htm");
		// insert 완료 후 list.htm으로 이동
		return mav;
	}
}
