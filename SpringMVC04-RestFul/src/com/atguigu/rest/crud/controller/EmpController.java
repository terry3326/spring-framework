package com.atguigu.rest.crud.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atguigu.rest.crud.bean.Department;
import com.atguigu.rest.crud.bean.Employee;
import com.atguigu.rest.crud.dao.DepartmentDao;
import com.atguigu.rest.crud.dao.EmployeeDao;

@Controller
public class
EmpController {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	/**
	 * 獲取所有的員工信息
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/emps")
	public String getAll(Map<String, Object> map) {
		Collection<Employee> emps = employeeDao.getAll();
		map.put("emps", emps);
		return "list";
	}
	
	/**
	 * 跳轉到添加頁面
	 * @return
	 */
	@RequestMapping(value="/emp", method=RequestMethod.GET)
	public String toAdd(Map<String, Object> map) {
		//獲取所有的部門信息
		Collection<Department> depts = departmentDao.getDepartments();
		//創建存儲性别gender的信息

		Map<String, String> genders = new HashMap<>();
		genders.put("0", "女");
		genders.put("1", "男");
		map.put("depts", depts);
		map.put("genders", genders);
		//form標籤有自動回顯的功能，會在頁面中能夠默認獲取request作用於中command屬性的值
		//map.put("command", new Employee());
		//若在<form:form>設置了modelAttribute，就可以自定義回顯對象的屬性名
		//若不要回顯資料就給它存放一個空對象,
		map.put("emp", new Employee());
		return "edit";
	}
	
	/**
	 * 添加員工信息
	 * @param employee
	 * @return
	 */
	@RequestMapping(value="/emp", method=RequestMethod.POST)
	public String addEmp(Employee employee) {
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	/**
	 * 獲取要回顯的數據，跳轉到修改頁面，並回顯
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/emp/{id}", method=RequestMethod.GET)
	public String toUpdate(@PathVariable("id") Integer id, Map<String, Object> map) {
		//獲取要修改的員工信息
		Employee emp = employeeDao.get(id);
		//所有的部門信息，供用戶選擇
		Collection<Department> depts = departmentDao.getDepartments();
		//設置存儲性别的map集合
		Map<String, String> genders = new HashMap<>();
		genders.put("0", "女");
		genders.put("1", "男");
		map.put("emp", emp);
		map.put("depts", depts);
		map.put("genders", genders);
		return "edit";
	}
	
	/**
	 * 修改員工信息
	 * @param employee
	 * @return
	 */
	@RequestMapping(value="/emp", method=RequestMethod.PUT)
	public String updateEmp(Employee employee) {
		employeeDao.save(employee);//修改
		return "redirect:/emps";
	}
	
	@RequestMapping(value="/emp/{id}",method=RequestMethod.DELETE)
	public String deleteEmp(@PathVariable("id") Integer id) {
		employeeDao.delete(id);
		return "redirect:/emps";
	}
	
}
