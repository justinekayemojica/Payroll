package simplePayroll;

import java.math.BigDecimal;

/**
* Java Course 3 Module 1
*
* @author Justine Kaye Mojica
* @Description: Java program that extends Employee class. This Salaried class implements the salaried type of employee.
* Created Date: 5/31/2022
*
*/

public class Salaried extends Employee{

	//Instance Variables
	protected BigDecimal weeklySalary;

	//Initialize the weekly salary of the employee.
	public Salaried load() {			
		super.load();		
		weeklySalary = (BigDecimal) inputAndValidate("Salary ==> ", "BigDecimal", "Salary");		
		return this;
	}
	
	//This getEarnings methods computes the earning of the hourly type of employee.
	@Override
	public Salaried getEarnings(){
		payCheckSalary = weeklySalary;
		return this;
	}
}
