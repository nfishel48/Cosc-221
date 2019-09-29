package inclass;

/**
 * @author Nathaniel Fishel E01584460
 * @course Cosc 221
 * @date September 12 2019
 * @lab project 3
 * 
 * @description This program will prompt the user for two binary numbers and add or subtract them, as well as 
 * 				displaying the all the binary numbers as decimals
 * 
 *
 */
import java.util.*;
import java.lang.Math;

public class project3 {
	
	static String p3Input() {
		System.out.print("Enter a Binary Number: ");
		Scanner stdIn = new Scanner(System.in);
		String input = stdIn.nextLine();
		return input;
		
	}
	
	public static boolean reboo(String input) {
		boolean negitive = false;
		if (input.charAt(0) == '1') {//checks the sign of the number
			negitive = true;
		}

		return negitive; //returns if the number is positive or negitive
	}

	public static String checkSign(String biNum) {
		int count = 0;
		int bcount = 7;
		int forw[] = new int[8];
		int back[] = new int[8];
		boolean done = false;
		int total = 0;

		if (biNum.charAt(0) == '1') {// if number starts with 1 flip the bits and add 1
			// start: moves String to an array
			while (count <= 7) {

				if (biNum.charAt(count) == '1') {
					forw[count] = 1;
				} else {
					forw[count] = 0;
				}
				count++;
			}

			// End: move string to array
			count = 0;// reset counter

			// Start :flip the bits
			while (count < 8) {
				if (forw[count] == 1) {
					back[count] = 0;
				} else {
					back[count] = 1;
				}
				// System.out.print(forw[count]);
				count++;
			}
			count = 0;// reset counter
			// End: Flip the bits
			// Start: for carry in binary addition
			int carry = 0;
			// add one
			if (back[bcount] == 1) {
				back[bcount] = 0;
				carry = 1;
			} else {
				back[bcount] = 1;
			}
			bcount--;
			while (!done) {
				if (carry == 1) {
					// System.out.println("carry part");
					switch (back[bcount]) {
					case 0:
						back[bcount] = 1;

						carry = 0;
						done = true;
						break;
					case 1:
						back[bcount] = 0;
						carry = 1;

					}

				} else {
					done = true;
				}
				bcount--;
			}
			// End add one
			// FOR SELF CONVERT TO STRING AND RETURN
			count = 0;
			String str = "";
			while (count <= 7) {
				if (back[count] == 1) {
					str = str + '1';
					count++;
				} else {
					str = str + '0';
					count++;
				}
			}

			return str;
		} else {
			return biNum;
		}

	}

	String readStringInput() {
		Scanner stdIn = new Scanner(System.in);
		String input = stdIn.nextLine();

		input = checkSign(input);
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
		int arr[] = new int[8];
		int back[] = new int[8];
		int count = 0;
		int extreme = Math.abs(decimalNum);
		int scratch = Math.abs(decimalNum);// use positive number for calculations
		for (int i = 0; i <= 7; i++) {// Divide by base 2 and keep the remainder
			arr[i] = scratch % 2;
			scratch = scratch / 2;
		}
		if (decimalNum < 0) {// flip the number then subtract 1
			while (count < 8) {
				if (arr[count] == 1) {
					back[count] = 0;
					count++;
				} else {
					back[count] = 1;
					count++;
				}
			}//back[] now holds the reverse of the binary number if the number is negitive.
			if(extreme == 128) {
			System.out.println("The Binary version of "+decimalNum+" is:");
			for (int j = 7; j >= 0; j--) { //prints
				System.out.print(arr[j]);
			}
			}
			else {
			System.out.println();
			count = 0;
			int bcount = 0;
			int carry = 0;
			// while(count < 8) {
			switch (back[bcount]) {// if the first number is zero add one 
			case 0:
				back[bcount] = 1;
				carry = 1;
				break;
			case 1:
				// System.out.println();
				// System.out.println(back[bcount]);
				back[bcount] = 0;
				bcount++;
				// System.out.println(back[bcount]);
				back[bcount] = 1;

				break;
			}
			// }
			if (carry == 1) { // does the carry operation
				while (count < 7) {
					if (back[bcount] == 0) {
						back[bcount] = 1;
						bcount--;
					} else {
						back[bcount] = 1;
						count = 7;
					}
					count++;
				}
				System.out.println("The Binary version of "+decimalNum+" is:");
			for (int j = 7; j >= 0; j--) { //prints
				System.out.print(back[j]);
			}
			}
			}
		}

		 else {
			 System.out.println("The Binary version of "+decimalNum+" is:");

			for (int j = 7; j >= 0; j--) {//prints
				System.out.print(arr[j]);
			}
		}
		
		

		System.out.println();
		
	
	}
	

	public static void convertTodecimal(String input) {// this takes a binary number and converts the decimal
		
		boolean negitive = reboo(input);
		input = checkSign(input);
		String biNum = input;
		int count = 0;
		int place = 0;
		for (int i = 7; i >= 0; i--) {
			int digit = biNum.charAt(place) - 48;
			// System.out.print(biNum.charAt(place));
			place++;
			// System.out.println(digit);
			if (digit == 1) {
				count = count + (1 * (int) Math.pow(2, i));
			}

		}
		if (negitive == true) {
			System.out.println("The decimal form of this number is : -" + count);
		} else {
			System.out.println("The decimal form of this number is : " + count);
		}
	}

	public static void menu() {
		System.out.println("Main Menu");//This prints the main menu
		System.out.println("Please enter a choice \n 1: Add two binary numbers\n 2: Convert binary to decimal");
		int choice = readIntInput();
		boolean done = false;
		while (done != true) {
			switch (choice) {
			case 1:
				add();
				done = true;
				break;

			case 2:
				//convertTodecimal();
				done = true;
				break;
			}

		}
		again();
	}

	public static void again() {//This calls the main menu again or exits the program
		System.out.println("Press 1 if you would to return to the menu\n any other int will exit");
		int choice = readIntInput();
		if (choice == 1) {
			menu();
		} else
			System.exit(0);
	}
	
	static void add () {
		String b1 = p3Input();
		convertTodecimal(b1);
		String b2 = p3Input();//Get both numbers from the user
		convertTodecimal(b2);
		int arr1[] = new int[8];
		int arr2[] = new int[8];//arrays to store Binary numbers in
		int arr3[] = new int[8];
		
		
		for(int i = 0; i<=7; i++) {
			arr1[i] = b1.charAt(i) - 48;
			arr2[i] = b2.charAt(i) - 48;//Read through the the number placing single numbers into spots in arrays
		}
		//loop through array to do binary additon with single digits
		for(int j = 0; j<=7; j++) {//flip so does not overwrite
			//System.out.println("arr1: "+arr1[j]+" arr2: "+arr2[j]);
			// 1+1= 0 when no remainder
			if(arr1[j] == 1 && arr2[j] == 1) {
				arr3[j] = 0;
				if(j-1 > 0) {
				arr3[j-1] = 1;
				}
			}
			// 1+0 = 1 with no remainder
			else if(arr1[j] == 1 && arr2[j] == 0) {
				arr3[j] = 1;
				
			}
			// 0+1 = 1 with no remainder
			else if(arr1[j] == 0 && arr2[j] == 1) {
				arr3[j] = 1;
			}
			// 0+0 = 0
			else {
				arr3[j] = 0;
			}
				
		}
		//for two negative
		if(arr1[0] == 1 && arr2[0] == 1) {
			arr3[0] = 1;
		}
		StringBuffer sb = new StringBuffer();
		for(int c = 0; c<=7; c++) {
			sb.append(arr3[c]);
		}
		String fin = sb.toString();
		System.out.println("The sum is "+fin);
		convertTodecimal(fin);
	}
	
	
	public static void main(String[] args) {
		menu();
	}
}
/**
**/