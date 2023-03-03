package simplePayroll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
* Java Course 3 Module 2
*
* @author Justine Kaye Mojica
* @Description: This is a driver class of Payroll program.
* Created Date: 5/31/2022
* 
*/

public class PayrollDriver{

	public static void main(String[] args) {
		
		//Working Variables
		Integer numOfEmployee;
		Integer employeeType;
		List<String> payCheckReport = new ArrayList<>();
		
		Scanner input = new Scanner(System.in);
		UserInputAndValidation inputVal = new UserInputAndValidation();
		
		numOfEmployee = (Integer)inputVal.inputAndValidate("Number of Employee: ","Integer", "Number of Employee");
		
		Employee[] employee = new Employee[numOfEmployee];				
		
		//loop for number of employee 
		for(int employeeCount = 0 ; employeeCount <= numOfEmployee - 1 ; employeeCount++) {					
			System.out.println("\nPROFILE  FOR EMPLOYEE #" + (employeeCount + 1));
			System.out.println("type Hourly(1), Salaried(2), Salaried plus Commission(3)");
			employeeType = (Integer)inputVal.inputAndValidate("Enter 1, 2, 3 ==> ","Integer", "Employee Type");
			
			//switch to check if the employee type is Hourly(1), Salaried(2) or Salaried plus Commission(3)
			switch(employeeType) {
			
				case 1: 	
					employee[employeeCount] = new Hourly();
					employee[employeeCount].load().getEarnings().getBonus();
					payCheckReport.add(employee[employeeCount].toString());
					break;				
				
				case 2: 
					employee[employeeCount] = new Salaried();
					employee[employeeCount].load().getEarnings().getBonus();
					payCheckReport.add(employee[employeeCount].toString());
					break;
					
				case 3: 
					employee[employeeCount] = new SalariedPlusCommission();
					employee[employeeCount].load().getEarnings().getBonus();
					payCheckReport.add(employee[employeeCount].toString());
					break;					
			}			
		}

		//loop that prints the payCheckReport
		for(String record : payCheckReport) {
			System.out.println();
			System.out.println(record);
		}
		
		input.close();

	}
	

}
