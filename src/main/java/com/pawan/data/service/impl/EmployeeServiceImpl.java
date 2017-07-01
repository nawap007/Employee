package com.pawan.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawan.data.model.Employee;
import com.pawan.data.repository.EmployeeRepository;
import com.pawan.data.service.EmployeeService;
import com.pawan.dto.EmployeeDTO;
import com.pawan.dto.UpdateEmployeeDTO;
import com.pawan.utility.ResponseWrapper;
import com.pawan.utility.constants.ResponseCodes;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public ResponseWrapper saveEmployee(EmployeeDTO employeeDTO) {

		try {
			Employee emp = prepareEmployee(employeeDTO);

			emp = employeeRepository.save(emp);
			if (emp == null) {
				return new ResponseWrapper(false, ResponseCodes.EMPLOYEE_SAVE_ERROR, "Employee could not be saved!!");
			}

			emp.setEmployeeCode("1000" + emp.getEmployeeId());

			emp = employeeRepository.save(emp);
			if (emp == null) {
				return new ResponseWrapper(false, ResponseCodes.EMPLOYEE_SAVE_ERROR, "Employee could not be saved!!");
			}

			return new ResponseWrapper(true, ResponseCodes.EMPLOYEE_SAVE_SUCCESFULL, emp,
					"Employee saved successfully!!");
		} catch (Exception e) {
			return new ResponseWrapper(false, ResponseCodes.EMPLOYEE_SAVE_FAILED,
					"Exception occured while saving employee!!");
		}

	}

	private Employee prepareEmployee(EmployeeDTO employeeDTO) {

		Employee emp = new Employee();
		emp.setFirstName(employeeDTO.getFirstName());
		emp.setLastName(employeeDTO.getLastName());
		emp.setAge(employeeDTO.getAge());
		emp.setMobileNumber(employeeDTO.getMobileNumber());

		return emp;
	}

	@Override
	public ResponseWrapper fetchEmployee(long empId) {
		try {

			Employee emp = employeeRepository.findOne(empId);
			if (emp == null) {
				return new ResponseWrapper(false, ResponseCodes.EMPLOYEE_FETCH_FAILED, "Employee not found!!");
			}

			return new ResponseWrapper(true, ResponseCodes.EMPLOYEE_FETCH_SUCCESFUL, emp,
					"Employee fetched successfully!!");
		} catch (Exception e) {
			return new ResponseWrapper(false, ResponseCodes.EMPLOYEE_FETCH_FAILED,
					"Exception occured while fetching employee!!");
		}
	}

	@Override
	public ResponseWrapper fetchAllEmployee(String pageNumber) {
		try {

			Integer page = Integer.valueOf(Integer.valueOf(pageNumber) * 20);

			List<Employee> employeeList = employeeRepository.fetchAllEmployees(page);
			if (employeeList == null) {
				return new ResponseWrapper(false, ResponseCodes.EMPLOYEE_FETCH_FAILED, "Employee List not found!!");
			}
			if (employeeList.size() == 0) {
				return new ResponseWrapper(false, ResponseCodes.EMPLOYEE_FETCH_FAILED, "No Employee Found !!");
			}

			return new ResponseWrapper(true, ResponseCodes.EMPLOYEE_FETCH_SUCCESFUL, employeeList,
					"Employee List fetched successfully!!");
		} catch (Exception e) {
			return new ResponseWrapper(false, ResponseCodes.EMPLOYEE_FETCH_FAILED,
					"Exception occured while fetching employee!!");
		}
	}

	@Override
	public ResponseWrapper getCount() {
		try {

			long employeeCount = employeeRepository.count();

			return new ResponseWrapper(true, ResponseCodes.EMPLOYEE_FETCH_SUCCESFUL, employeeCount,
					"Employee Count fetched successfully!!");
		} catch (Exception e) {
			return new ResponseWrapper(false, ResponseCodes.EMPLOYEE_FETCH_FAILED,
					"Exception occured while fetching employee count!!");
		}
	}

	@Override
	public ResponseWrapper upadteEmployee(UpdateEmployeeDTO updateDTO) {
		try {

			Employee oldEmployee = employeeRepository.findOne(updateDTO.getEmployeeId());
			if (oldEmployee == null) {
				return new ResponseWrapper(false, ResponseCodes.EMPLOYEE_FETCH_FAILED, "Employee Not Found !!");
			}

			Employee updatedEmployee = prepareEmployee(oldEmployee, updateDTO);

			updatedEmployee = employeeRepository.save(updatedEmployee);
			if (updatedEmployee == null) {
				return new ResponseWrapper(false, ResponseCodes.EMPLOYEE_SAVE_ERROR, "Employee could not be updated!!");
			}

			return new ResponseWrapper(true, ResponseCodes.EMPLOYEE_SAVE_SUCCESFULL, updatedEmployee,
					"Employee updated successfully!!");
		} catch (Exception e) {
			return new ResponseWrapper(false, ResponseCodes.EMPLOYEE_SAVE_FAILED,
					"Exception occured while updating employee!!");
		}
	}

	private Employee prepareEmployee(Employee oldEmployee, UpdateEmployeeDTO updateDTO) {

		if (updateDTO.getFirstName() != null)
			oldEmployee.setFirstName(updateDTO.getFirstName());

		if (updateDTO.getLastName() != null)
			oldEmployee.setLastName(updateDTO.getLastName());

		if (updateDTO.getAge() != 0)
			oldEmployee.setAge(updateDTO.getAge());

		if (updateDTO.getMobileNumber() != null)
			oldEmployee.setMobileNumber(updateDTO.getMobileNumber());

		return oldEmployee;
	}

	@Override
	public ResponseWrapper deleteEmployee(long empId) {

		try {

			Employee oldEmployee = employeeRepository.findOne(empId);

			if (oldEmployee == null) {
				return new ResponseWrapper(false, ResponseCodes.EMPLOYEE_FETCH_FAILED,
						"Can't delete Employee... Employee Not Found !!");
			}

			employeeRepository.delete(empId);

			return new ResponseWrapper(true, ResponseCodes.EMPLOYEE_DELETE_SUCCESFULL, oldEmployee,
					"Employee deleted successfully!!");
		} catch (Exception e) {
			return new ResponseWrapper(false, ResponseCodes.EMPLOYEE_DELETE_FAILED,
					"Exception occured while deleting employee !!");
		}

	}

}
