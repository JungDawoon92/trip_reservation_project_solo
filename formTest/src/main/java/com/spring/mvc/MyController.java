package com.spring.mvc;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.service.MyService;

@Controller
public class MyController {
	
	@Autowired
	private MyService myservice; // Setter Injection
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String home(Locale local, Model model) {
		model.addAttribute("sampleData", myservice.getMsg());
		return "form";
	}
	
	@RequestMapping(value="/formProc", method = RequestMethod.POST)
	public String formProc(FormBean fb, Model model) {
		
		/*브라우저에서 전달된 파라미터는 자동으로 model 오브젝트에 추가되고,
		 * model에 추가된 데이터는 자동으로 request 객체에 저장되므로 뷰에서도 출력가능
		 * 위으 FormBean은 브라우저 폼에서 전달된 파라미터를 자동으로 저장하고,
		 * 또한 Model 오브젝트에도 자동으로 Formbean이라는 이름으로 저장되므로
		 * 뷰에서 ${formBean.num} 으로 접근 가능
		 * 그러므로 아래처럼 명시적으로 fb를 	Model에 저장하는것은 이중으로 저장되는 셈이다.
		 */
//		
//		model.addAttribute("fb", fb);
		return "result";
	}
	public MyService getMyservice() {
		return myservice;
	}
	
	//없어도됨.
//	public void setMyservice(MyService myservice) {
//		this.myservice = myservice;
//	}

}
