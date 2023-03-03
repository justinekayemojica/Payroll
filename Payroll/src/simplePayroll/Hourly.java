package simplePayroll;

import java.math.BigDecimal;

/**
* Java Course 3 Module 1
*
* @author Justine Kaye Mojica
* @Description: Java program that extends Employee class. This Hourly class implements the hourly type of employee.
* Created Date: 5/31/2022
*
*/

public class Hourly extends Employee{
	
	//Instance Variables
	private BigDecimal hourlyPay;
	private Integer hoursWorkThePastWeek;
	
	
	//Initialize the Hourly Pay and Hours Worked of the employee.
	public Hourly load() {
		super.load(); //load method from super class 
		hourlyPay = (BigDecimal) inputAndValidate("Hourly Pay ==> ", "BigDecimal", "Hourly Pay");
		hoursWorkThePastWeek = (Integer) inputAndValidate("Hours work this past week ==> ", "Integer", "Hours Worked");
		return this;
	}
	
	//Computes the earning of the hourly type of employee.
	@Override
	public Hourly getEarnings() {
		
		//Working Variables
		BigDecimal earnings = BigDecimal.ZERO;
		BigDecimal otPay;
		int otHours;
		
		/*Checks if the hours worked of the employee exceeds in 40 hours. 
		 * If exceeds in 40 overtime pay will be computed for their overtime work. */
		if( hoursWorkThePastWeek > 40) {
			otHours = 40 - hoursWorkThePastWeek;
			//Overtime pay = one and a half times the normal hourly pay
			otPay = hourlyPay.multiply(new BigDecimal(1.5)).multiply(new BigDecimal(otHours)).setScale(0);
			earnings = hourlyPay.multiply(new BigDecimal(40)).add(otPay);
		} else {
			earnings = hourlyPay.multiply(new BigDecimal(hoursWorkThePastWeek));
		}
		
		payCheckSalary = earnings;
		return this;
	}	

}
