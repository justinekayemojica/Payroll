package simplePayroll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
* Java Course 3 Module 1
*
* @author Justine Kaye Mojica
* @Description: Java program that prompts for the user input and then validate the value.
* Created Date: 5/31/2022
*
*/

public class UserInputAndValidation{
	
	//Working Variables
	private Boolean isValidValue;	
	final String INVALID_INPUT_MSG = "Invalid input. Please enter a valid value for ";
	
	Scanner input = new Scanner(System.in);
	
	
	/*This inputAndValidate method prompts the user for an input and then validate the given value.
	The method arguments define as display text , data type of the input value to be validated and the variable name 
	to be appended to the catch message. If the given value is valid the method will return the value as an Object
	else the program will prompt the user again for an input until a valid value is given*/
	public Object inputAndValidate(String displayText, String dataType , String expVarName) {
		
		Object inputValue = null;
		
		//Input and Validation for String variables
		if(dataType.equals("String")) {
			do {
				try{
					System.out.print(displayText);
					inputValue = input.nextLine();
					isValidValue = true;
					if(expVarName.contains("Social Security Number")) {
						if(!isValidSSN((String) inputValue)) throw new IllegalArgumentException();
					}
				} catch (Exception e) {
					input.nextLine();
					isValidValue = false;
					System.out.println(INVALID_INPUT_MSG + expVarName);
				}			
			} while (isValidValue == false);
		}
		
		//Input and Validation for Integer variables
		if(dataType.equals("Integer")) {
			do {
				try{					
					System.out.print(displayText);
					inputValue = input.nextInt();
					isValidValue = true;
					if(expVarName.contains("Birthday month")) {
						if(!isMonth((Integer) inputValue)) throw new IllegalArgumentException();
					} else if (expVarName.contains("Birthday week")){
						if(!isWeek((Integer) inputValue)) throw new IllegalArgumentException();
					} else if (expVarName.contains("Employee Type")){
						if(!isEmployeeType((Integer) inputValue)) throw new IllegalArgumentException();
					} else 
						if(isNegativeValue((Integer) inputValue)) throw new IllegalArgumentException();
				} catch (Exception e) {
					input.nextLine();
					isValidValue = false;
					System.out.println(INVALID_INPUT_MSG + expVarName );
				}			
			} while (isValidValue == false);
		}
		
		//Input and Validation for BigDecimal variables
		if(dataType.equals("BigDecimal")) {
			do {
				try{
					System.out.print(displayText);
					inputValue = input.nextBigDecimal();
					isValidValue = true;
				} catch (Exception e) {
					input.nextLine();
					isValidValue = false;
					System.out.println(INVALID_INPUT_MSG + expVarName);
				}			
			} while (isValidValue == false);
		}
		
		return inputValue;
	}
	
	//Method that checks if input value is a negative value
	private Boolean isNegativeValue(Integer inputValue) {
		if(inputValue < 0) {
			return true;
		}
		return false;
	}
	
	//Method that checks if input value is a Month
	private Boolean isMonth(Integer inputValue) {
		List<String> monthList = new ArrayList<>(Arrays.asList("1,2,3,4,5,6,7,8,9,10,11,12".split(",")));
		if(monthList.contains(inputValue.toString())) {
			return true;
		}
		return false;		
	}
	
	
	//Method that checks if input value is a Week of a Month
	private Boolean isWeek(Integer inputValue) {
		List<String> weekList = new ArrayList<>(Arrays.asList("1,2,3,4".split(",")));
		if(weekList.contains(inputValue.toString())) {
			return true;
		}
		return false;
	}
	
	//Method that checks if input value is a valid employee type
	private Boolean isEmployeeType(Integer inputValue) {
		List<String> empTypeList = new ArrayList<>(Arrays.asList("1,2,3".split(",")));
		if(empTypeList.contains(inputValue.toString())) {
			return true;
		}
		return false;
	}
	
	//Method that checks if input value is a valid SSN
	private Boolean isValidSSN(String inputValue) {
		char[] charInputValue = inputValue.toCharArray();
		for (int count = 0; count < charInputValue.length; count++) {			
			if (count == 3 && charInputValue[count] != '-') return false;
	        if (count == 6 && charInputValue[count] != '-') return false;
	        if (count != 6 && count != 3 && !Character.isDigit(charInputValue[count])) return false;
	     }
	    return true;
	}
}
