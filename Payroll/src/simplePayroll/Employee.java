package simplePayroll;

import java.math.BigDecimal;
import java.util.Calendar;

/**
* Java Course 3 Module 1
*
* @author Justine Kaye Mojica
* @Description: Java program that calculate and print the weekly payroll for a company. 
* Created Date: 5/31/2022
*
*/


abstract class Employee extends UserInputAndValidation{
	
	//Instance Variables
	private String name;
	private String socialSecurityNumber;
	private Integer birthdayMonth;
	private Integer birthdayWeek;
	protected BigDecimal payCheckSalary;
	
	//Initialize the employee name, social security number and salary.
	public Employee load() {
		
		name = inputAndValidate("Name ==> ", "String", "Name").toString();		
		socialSecurityNumber = inputAndValidate("Social Security Number ==> ", "String", "Social Security Number").toString();
		birthdayMonth = (Integer) inputAndValidate("Birthday month (1-12) ==> ", "Integer",  "Birthday month");		
		birthdayWeek = (Integer) inputAndValidate("Birthday week (1-4) ==> " , "Integer",  "Birthday week");
		
		return this;
	}
	
	//Returns a string that shows the employee's name, social security number, and paycheck
	public String toString() {		
		String payCheckReport = String.format("employee: %s %nsocial security number: %s %npaycheck: %s", 
				name, socialSecurityNumber, payCheckSalary); 		
		return payCheckReport;		
	}
	
	//Checks if the employee is eligible for Birthday bonus.
	public void getBonus() {
		
		//Retrieved the current month and current week through Calendar class.
		int currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
		int currentWeek = Calendar.getInstance().get(Calendar.WEEK_OF_MONTH);
		
		/*Compare the birthDay month and week of the Employee to the current month and week. 
		If match employee is eligible for birthday bonus of $100*/
		if((birthdayMonth.equals(currentMonth)) && (birthdayWeek.equals(currentWeek))) {
			payCheckSalary = payCheckSalary.add(new BigDecimal(100));
		}
		
	}
	
	//Abstract getEarnings method.
	abstract Employee getEarnings();
	
	
}
