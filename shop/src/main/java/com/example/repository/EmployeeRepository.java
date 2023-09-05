package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	public List<Employee> findByfirstName(String name);
	public List<Employee> findByemail(String email);
	public List<Employee> findByfirstNameLikeOrFirstNameLikeOrderByEmployeeIdDesc(String upperChar,String lowChar);
	@Query("select em from employee em where em.firstName like ?1% order by em.employeeId")
	public List<Employee> findByFirstLike(String likeData);
	@Query("select em from employee em where em.firstName like %:likeStr% and em.firstName like %:secStr%")
	public List<Employee> findByFirstParam(/*@Param("likeStr")*/ String likeStr, String secStr);
	
}
