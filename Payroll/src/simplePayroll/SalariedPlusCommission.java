package simplePayroll;

import java.math.BigDecimal;

/**
* Java Course 3 Module 1
*
* @author Justine Kaye Mojica
* @Description: Java program that extends SalariedPlusCommission class. This Salaried class implements the salaried plus commission type of employee.
* Created Date: 5/31/2022
*
*/

public class SalariedPlusCommission extends Salaried {

	//Instance Variables
	private Integer pastWeekSales;
	private BigDecimal commissionRate;
	
	//Initialize the past week sales and sales commission rate of the employee.
	public SalariedPlusCommission load() {		
		super.load(); //load method from super class 			
		pastWeekSales = (Integer) inputAndValidate("Sales for this past week ==> ", "Integer",  "Sales for this past week");
		commissionRate = (BigDecimal) inputAndValidate("Sales commision rate ==> ", "BigDecimal", "Sales commision rate");
		return this;
	}
	
	//Computes the earning of the hourly type of employee.
	@Override
	public SalariedPlusCommission getEarnings(){
		BigDecimal earnings;
		earnings = commissionRate.multiply(new BigDecimal(pastWeekSales)).add(weeklySalary);
		payCheckSalary = earnings;
		return this;
	}	
}
