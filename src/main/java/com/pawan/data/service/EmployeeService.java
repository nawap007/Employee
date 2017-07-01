package com.pawan.data.service;

import com.pawan.dto.EmployeeDTO;
import com.pawan.dto.UpdateEmployeeDTO;
import com.pawan.utility.ResponseWrapper;

public interface EmployeeService {
	
	public ResponseWrapper saveEmployee(EmployeeDTO employeeDTO);
	public ResponseWrapper fetchEmployee(long empId);
	public ResponseWrapper  fetchAllEmployee(String pageNumber);
	public ResponseWrapper getCount();
	public ResponseWrapper upadteEmployee(UpdateEmployeeDTO updateDTO);
	public ResponseWrapper deleteEmployee(long empId);
	

}
