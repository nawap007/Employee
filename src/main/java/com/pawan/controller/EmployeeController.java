package com.pawan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pawan.data.service.EmployeeService;
import com.pawan.dto.EmployeeDTO;
import com.pawan.dto.UpdateEmployeeDTO;
import com.pawan.utility.ResponseWrapper;

@RestController
@RequestMapping("employee")
public class EmployeeController {//master commit

	@Autowired
	private EmployeeService employeeService;

	// 1
	@RequestMapping(method = RequestMethod.GET, value = "/fetchAll/{pageNumber}")
	public ResponseWrapper fetchAll(@PathVariable("pageNumber") String pageNumber) {
		return employeeService.fetchAllEmployee(pageNumber);
	}

	// 2
	@RequestMapping(method = RequestMethod.GET, value = "/{empId}")
	public ResponseWrapper fetchOne(@PathVariable("empId") long empId) {
		return employeeService.fetchEmployee(empId);
	}

	// 3
	@RequestMapping(method = RequestMethod.GET, value = "/count")
	public ResponseWrapper getCount() {
		return employeeService.getCount();
	}

	// 4
	@RequestMapping(method = RequestMethod.POST, value = "/saveEmp" , consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseWrapper saveEmployee(@RequestBody EmployeeDTO userDTO) {

		return employeeService.saveEmployee(userDTO);
	}

	// 5
	@RequestMapping(method = RequestMethod.PUT, value = "/updateEmp" )
	public ResponseWrapper updateEmployee(@RequestBody UpdateEmployeeDTO updateDTO) {

		return employeeService.upadteEmployee(updateDTO);
	}

	// 6
	@RequestMapping(method = RequestMethod.DELETE, value = "/remove/{empId}")
	public ResponseWrapper deleteEmployee(@PathVariable("empId") long empId) {

		return employeeService.deleteEmployee(empId);
	}

}
