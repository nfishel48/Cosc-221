
/**
 * @author Nathaniel Fishel E01584460
 * @course Cosc 221
 * @date September 12 2019
 * 
 * @description This program will convert unsigned binary numbers to decimal and decimal to binary
 *
 */
import java.util.*;
import java.lang.Math;

public class project1 {

	static String readStringInput() {
		Scanner stdIn = new Scanner(System.in);
		String input = stdIn.nextLine();
		return input;
	}
	
	static int readIntInput() {
		Scanner stdIn = new Scanner(System.in);
		int input = stdIn.nextInt();
		return input;
	}
	
	public static void convertTobinary() {
		System.out.println("Enter the decimal number to be converted to binary");
		int decimalNum = readIntInput();
		int arr[] = new int [8];
		int count = 0;
		
		for(int i = 0; i <= 7; i++){
			arr[count]= decimalNum%2;
			decimalNum = decimalNum/2;
			count++;
		}
		for(int j = 7; j >= 0; j--) {
			System.out.print(arr[j]);
		}
		System.out.println();
	}
	
	public static void convertTodecimal() {
		System.out.println("Enter the binary number to be converted to decimal");
		String biNum = readStringInput();
		int arr[] = new int[8];
		int count = 0;
		int place = 0;
		for(int i = 7; i>= 0; i--) {
				int digit = biNum.charAt(place)-48;
				place++;
				//System.out.println(digit);
				if(digit == 1) {
					count = count +( 1 * (int) Math.pow(2, i));
				}
			
		}
		System.out.println("The converted number is: "+count);
	}
	
	public static void menu() {
		System.out.println("Main Menu");
		System.out.println("Please enter a choice \n 1: Convert decimal to binary\n 2: Convert binary to decimal");
		int choice = readIntInput();
		boolean done = false;
		while(done != true) {
			switch(choice) {
			case 1 :
				convertTobinary();
				done = true;
				break;
				
			case 2 :
				convertTodecimal();
				done = true;
				break;
				
			}
			
		}
		again();
	}
	
	public static void again() {
		System.out.println("Press 1 if you would to return to the menu\n any other int will exit");
		int choice = readIntInput();
		if (choice == 1){
			menu();
		}else
			System.exit(0);
		}
	
	
	public static void main(String[] args) {
	menu();
	}
}


