package kr.co.mycom.guest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import kr.co.mycom.guest.model.GuestDAO;

public class ListController implements Controller {
	private GuestDAO guestDAO; // applicationContext에 선언된 이름과 같은것.

	public void setGuestDAO(GuestDAO guestDAO) {
		this.guestDAO = guestDAO;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List list = guestDAO.listGuest();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("list");
		return mav;
		
	}
}
