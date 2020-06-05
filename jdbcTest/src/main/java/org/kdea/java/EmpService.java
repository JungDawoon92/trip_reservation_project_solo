package org.kdea.java;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("empService")
public class EmpService {
	private EmpDAO empDao;
	
	@Autowired
	public EmpService(EmpDAO empDao) {
		this.empDao = empDao;
	}
	
	public List<Emp> getEmpList() {
		return empDao.getEmpList();
	}
	
	public Emp getEmp(int empno) {
		return empDao.getEmp(empno);
	}
	
	public boolean insertEmp(Emp emp) {
		return empDao.insertEmp(emp);
	}
	
	public boolean updateEmp(Emp emp) {
		return empDao.updateEmp(emp);
	}
	
	public boolean deleteEmp(int empno) {
		return empDao.deleteEmp(empno);
	}

}
