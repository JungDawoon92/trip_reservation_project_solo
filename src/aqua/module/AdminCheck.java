package aqua.module;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class AdminCheck {
	public boolean adminCheck(HttpServletRequest request, ActionForward forward)
	{
		HttpSession session = request.getSession();
		boolean result = false;
		
		String adminid = (String) session.getAttribute("adminid");
		if (adminid == null) 
		{
			forward.setRedirect(true);
			forward.setPath("./loginformM.ad");
		}
		else
		{
			//adminCheck = adminbiz.idCheck(adminid);
			
			if(adminid.equals("admin") == false) 
			{
				String notAdminError = "trueError";
				request.setAttribute("notAdminError", notAdminError);
				forward.setRedirect(false);
				forward.setPath("./indexAdmin.adx");
			}
			else
				result = true;
		}
		return result;
	}
}
