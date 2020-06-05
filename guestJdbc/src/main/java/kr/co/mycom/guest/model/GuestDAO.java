package kr.co.mycom.guest.model;

import java.util.List;

public interface GuestDAO {
	public void insertGuest(GuestDTO dto);
	
	public List listGuest();

}
