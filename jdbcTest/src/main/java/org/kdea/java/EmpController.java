package org.kdea.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
	private EmpService empService;
	
	@Autowired
	public EmpController(EmpService empService) {
		this.empService = empService;
	}
	
	@RequestMapping(value = "/emp/list")
	public String getList(Model model) {
		model.addAttribute("list", empService.getEmpList());
		return "emp/empList";
	}
	
	@RequestMapping(value = "/emp/info")
	public String getEmp(Model model, @RequestParam int empno) {
		model.addAttribute("empInfo", empService.getEmp(empno));
		return "emp/empInfo";
	}
	
	@RequestMapping("/emp/insert")
	public String insertEmp(@ModelAttribute Emp emp) {
		if (emp.getEmpno() == 0) {
			return "emp/inputForm";
		} else {
			empService.insertEmp(emp);
			return "redirect:/emp/list";
		}
	}
	
	@RequestMapping("/emp/edit")
	public ModelAndView editEmp(@RequestParam int empno, @ModelAttribute Emp emp) {
		emp = empService.getEmp(empno);
		return new ModelAndView("/emp/empEdit", "empInfo", emp);
	}
	
	@RequestMapping("/emp/update")
	public String updateEmp(@ModelAttribute Emp emp) {
		empService.updateEmp(emp);
		return "redirect:/emp/list";
	}
	
	@RequestMapping("/emp/delete")
	public String deleteEmp(@RequestParam int empno) {
		empService.deleteEmp(empno);
		return "redirect:/emp/list";
	}
}
