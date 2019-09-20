
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

	public static boolean reboo(String input) {
		boolean negitive = false;
		if (input.charAt(0) == '1') {
			negitive = true;
		}

		return negitive;
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
			System.out.println(bcount);
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
			System.out.println(str);
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
		int count = 0;
		int scratch = Math.abs(decimalNum);// use positve number for calculations
		
		//remove after testing
		System.out.println(scratch);

		for (int i = 0; i <= 7; i++) {
			arr[count] = scratch % 2;
			scratch = scratch / 2;
			count++;
		}
		for (int j = 7; j >= 0; j--) {
			System.out.print(arr[j]);
		}
		System.out.println(scratch);
		//stop remove

		if (decimalNum < 0) {
			int bcount = 7;
			boolean done = false;
			// Start: for carry in binary addition
			int carry = 0;
			// add one
			if (arr[bcount] == 1) {
				arr[bcount] = 0;
				carry = 1;
			} else {
				arr[bcount] = 1;
			}
			bcount--;
			 //System.out.println(bcount);
			while (!done) {
				if (carry == 1) {
					// System.out.println("carry part");
					switch (arr[bcount]) {
					case 0:
						arr[bcount] = 1;

						carry = 0;
						done = true;
						break;
					case 1:
						arr[bcount] = 0;
						carry = 1;

					}

				} else {
					done = true;
				}
				bcount--;
			}
			// End add one

			for (int q = 0; q <= 7; q++) {
				System.out.print(arr[q]);
			}
		} else {
			for (int j = 7; j >= 0; j--) {
				System.out.print(arr[j]);
			}
		}
		System.out.println();
	}

	public static void convertTodecimal() {
		System.out.println("Enter the binary number to be converted to decimal");
		Scanner stdIn = new Scanner(System.in);
		String input = stdIn.nextLine();
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
			System.out.println("The converted number is: -" + count);
		} else {
			System.out.println("The converted number is: " + count);
		}
	}

	public static void menu() {
		System.out.println("Main Menu");
		System.out.println("Please enter a choice \n 1: Convert decimal to binary\n 2: Convert binary to decimal");
		int choice = readIntInput();
		boolean done = false;
		while (done != true) {
			switch (choice) {
			case 1:
				convertTobinary();
				done = true;
				break;

			case 2:
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
		if (choice == 1) {
			menu();
		} else
			System.exit(0);
	}

	public static void main(String[] args) {
		menu();
	}
}
