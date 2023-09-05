package com.example.entity;

import java.sql.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "employee")
@Table(name = "employees")
@SequenceGenerator(
		name = "empSeq",
		sequenceName = "EMPLOYEES_SEQ",
		initialValue = 300,
		allocationSize = 1
		)
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString @Builder
public class Employee {
	@Id
	@Column(name = "EMPLOYEE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empSeq")
	private Integer employeeId;
//	@Column(name = "FIRST_NAME")
	private String firstName;
//	@Column(name = "LAST_NAME")
	private String lastName;
//	@Column(name = "EMAIL")
	private String email;
//	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
//	@Column(name = "HIRE_DATE")
	private Date hireDate;
//	@Column(name = "JOB_ID")
	private String jobId;
//	@Column(name = "SALARY")
	private String salary;
//	@Column(name = "COMMISSION_PCT")
	private String commissionPct;
//	@Column(name = "MANAGER_ID")
	private Integer managerId;
//	@Column(name = "DEPARTMENT_ID")
	private Integer departmentId;
}
