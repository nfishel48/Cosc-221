package test;
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

public class project2 {
	
	static void checkSign(String biNum) {
		int count = 0;
		int bcount = 7;
		int forw[] = new int [8];
		int back[] = new int [8];
		
		if (biNum.charAt(0) == '1') {// if number starts with 1 flip the bits and add 1
			while (count <= 7) {// start: moves String to an array

				if (biNum.charAt(count) == '1') {
					forw[count] = 1;
				}
				else {
					forw[count] = 0;
				}
					count++;
			}//End: move string to array
			count = 0;//reset counter
			
			while (count < back.length) {// flip the bits
				if (forw[count] == 1) {
					back[count] = 0;
				}
			  count++;
			}
			count = 0;//reset counter
			int carry = 0;// for carry in binary addition 
			while (count < back.length) {// add one
				if (back[bcount] == 1) {
					back[bcount] = 0;
					carry = 1;
				}
				else {
					back[bcount] = 1;
				}
				
				if(carry == 1) {
					System.out.println("carry part");
					switch(back[bcount]) 
					{ 
					case 0:
						back[bcount] = 1;
						System.out.println(back[bcount]);
						carry = 0;
						break;
					case 1:
						back[bcount] = 0;
						carry = 1;
					
					}
				}
				count++;
				bcount--;
			}
			
		}
		//testing
		System.out.println("Fliped bit: ");
		for(int i = 0; i < back.length; i++) {
			System.out.print(back[i]);
		}
		
		
	}

 	static String readStringInput() {
		Scanner stdIn = new Scanner(System.in);
		String input = stdIn.nextLine();
		//checkSign(input);
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
		System.out.println("enter binary digit");
		Scanner stdIn = new Scanner(System.in);
		String input = stdIn.nextLine();
		checkSign(input);
		//menu();
	}
}

