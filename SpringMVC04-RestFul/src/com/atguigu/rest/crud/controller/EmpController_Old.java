package com.atguigu.rest.crud.controller;

import java.util.Collection;
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

public class EmpController_Old {

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
	 * 跳轉到員工添加頁面
	 * @return
	 */
	@RequestMapping(value="/emp", method=RequestMethod.GET)
	public String toAdd(Map<String, Object> map) {
		Collection<Department> depts = departmentDao.getDepartments();
		map.put("depts", depts);
		return "add";
	}
	
	/**
	 * 添加員工信息
	 * @param employee
	 * @return
	 */
	@RequestMapping(value="/emp", method=RequestMethod.POST)
	public String addEmp(Employee employee) {
		employeeDao.save(employee);
		//note:CRUD後,轉發頁面要用"redirect:/視圖名" 才不會有表單重複提交的狀況發生
		return "redirect:/emps";
	}
	
	/**
	 * 獲取要回顯的数據，跳轉到修改頁面，並回顯
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/emp/{id}", method=RequestMethod.GET)//因為是跳轉頁面所以是GET
	public String toUpdate(@PathVariable("id") Integer id, Map<String, Object> map) {
		//藉由表單中點擊修改,取得要修改的id,再藉由id查詢,獲取到要修改的員工信息
		Employee emp = employeeDao.get(id);
		//所有的部門信息，供用戶選擇
		Collection<Department> depts = departmentDao.getDepartments();
		map.put("emp", emp);
		map.put("depts", depts);
		return "update";
	}

	/**
	 * 儲存已修改的數據
	 * @param employee
	 * @return
	 */
	@RequestMapping(value="/emp", method=RequestMethod.PUT)
	public String updateEmp(Employee employee) {
		employeeDao.save(employee);//修改
		//note:CRUD後,轉發頁面要用"redirect:/視圖名" 才不會有表單重複提交的狀況發生
		return "redirect:/emps";
	}
	
}
