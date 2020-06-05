package org.kdea.mybatis;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmpMBController {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	// 설정파일에 빈으로 등록되었기 때문에 생성자나 Setter 없이 자동으로 주입
	
	@RequestMapping("/mb/empList")
	public String getEmpList(Model model) {
		EmpDAO dao = sqlSessionTemplate.getMapper(EmpDAO.class);
		List<Emp> list = dao.list();
		model.addAttribute("empList",list);
		return "mb/empList";
	}
	
	@RequestMapping("/mb/empInfo")
	public String getEmp(Model model, @RequestParam int empno) {
		EmpDAO dao = sqlSessionTemplate.getMapper(EmpDAO.class);
		Emp emp = dao.info(empno);
		model.addAttribute("empInfo",emp);
		return "mb/empInfo";
	}
	
	@RequestMapping(value="/mb/empInputForm", method=RequestMethod.GET)
	public String empInputForm(Emp emp) {
		return "/mb/empInputForm";
	}
	
	@RequestMapping(value="/mb/empInsert", method=RequestMethod.POST)
	public String empInsert(Emp emp) {
		EmpDAO dao = sqlSessionTemplate.getMapper(EmpDAO.class);
		int n = dao.insert(emp);
		return "redirect:/mb/empList";
	}
	
	@RequestMapping("/mb/empEdit")
	public String empEdit(Model model, @RequestParam int empno) {
		EmpDAO dao = sqlSessionTemplate.getMapper(EmpDAO.class);
		Emp emp = dao.info(empno);
		model.addAttribute("empInfo", emp);
		return "/mb/empEdit";
	}
	
	@RequestMapping("/mb/empUpdate")
	public String empUpdate(Model model, Emp emp) {
		EmpDAO dao = sqlSessionTemplate.getMapper(EmpDAO.class);
		int n = dao.update(emp);
		model.addAttribute("empno", emp.getEmpno());
		return "redirect:/mb/empInfo";
	}
	
	@RequestMapping("/mb/empDelete")
	public String empDelete(@RequestParam int empno) {
		EmpDAO dao = sqlSessionTemplate.getMapper(EmpDAO.class);
		int n = dao.delete(empno);
		return "redirect:/mb/empList";
	}
}
