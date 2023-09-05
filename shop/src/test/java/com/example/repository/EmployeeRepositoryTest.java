package com.example.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.example.entity.Employee;

@SpringBootTest
@TestPropertySource(locations = {"classpath:application.properties"})
public class EmployeeRepositoryTest {
	
	@Autowired
	EmployeeRepository repository;
	
	@Test
	public void repositoryTest() {
		assertNotNull(repository);
	}
	@Test
	@DisplayName("직원 인원 카운트 테스트")
	public void countTest() {
		assertEquals(107, repository.count());
	}
	@Test
	@DisplayName("스티븐 조회 테스트")
	public void getIdTest() {
		Employee emp = repository.findById(100).get();
		System.out.println(emp);
	}
	@Test
	@DisplayName("사원테이블 전체 조회 테스트")
	public void findAllTest(){
		//iterable (List<Employee>)형변환
		List<Employee> employees = (List<Employee>) repository.findAll();
		for(Employee emp : employees) 
			System.out.println(emp.toString());
		
		employees.forEach(emp -> System.out.println(emp));
	}
	@Test
	public void saveDeleteTest() {
/*		Employee emp = Employee.builder()
					.DEPARTMENT_ID(90)
					.EMAIL("backyee@aaa.com")
					.JOB_ID("AD_PRES")
					.FIRST_NAME("BAC")
					.LAST_NAME("KY")
					.COMMISSION_PCT(null)
					.MANAGER_ID(101)
					.SALARY("15000")
					.PHONE_NUMBER("01012341234")
					.HIRE_DATE(new java.sql.Date(new java.util.Date().getTime()))
					.build();
		Employee saveResult = repository.save(emp);
		Employee getSaveEmp = repository.findById(saveResult.getEmployeeId()).get();
		System.out.println("save Emp : " + getSaveEmp);
		*/
		
//		repository.deleteById(getSaveEmp.getEmployeeId());
////		Employee emp2 = new Employee(); emp2.setDEPARTMENT_ID(90);
//		
//		Employee getSaveEmp2 = repository.findById(207).get();
//		System.out.println("------------" + getSaveEmp2);
//		repository.deleteById(207);
//		getSaveEmp.setemail("backie@aaa.com");
//		getSaveEmp.setphoneNumber("01078907890");
//		repository.save(getSaveEmp);
	}
	@Test
	public void userDefineQueryMethodTest() {
		List<Employee> result = repository.findByfirstName("Lisa");
		if( result != null ) System.out.println(result.get(0));
		else System.out.println("조건에 맞는 데이터가 발견되지 않았습니다.");
	}
	@Test
	public void firstNameA() {
		List<Employee> result = repository.findByFirstLike("A");
		if( result != null ) System.out.println(result.get(0));
		else System.out.println("조건에 맞는 데이터가 발견되지 않았습니다.");
		
		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
	@Test
	public void firstNamelike() {
		List<Employee> result = repository.findByFirstParam("A","l");
		if( result != null ) System.out.println(result.get(0));
		else System.out.println("조건에 맞는 데이터가 발견되지 않았습니다.");
		
		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}
