package com.pawan.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pawan.data.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	

	@Query(value="select * from employee_details order by created_on DESC limit :page,20",nativeQuery=true)
	public List<Employee> fetchAllEmployees(@Param("page")int page);

	
	
	
	//public long getCountAllEmployees();
	
	

}
