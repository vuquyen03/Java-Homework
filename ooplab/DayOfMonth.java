package ooplab;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class DayOfMonth {
	
	static boolean isInteger(String input) {
	    try {
	      Integer.parseInt(input);
	      return true;
	    } catch (NumberFormatException e) {
	      return false;
	    }
	}
	
	static boolean checkInputMonth(String month, String[] arr) {
		List<String> list = Arrays.asList(arr);
		return list.contains(month)?true:false;
	}
	
	static boolean leapYear(int year) {
		if(year%100 == 0 && year%400 != 0) {
			return false;
		}
		else if(year%4 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	static void printAns(String month, int year, String[] arr) {
		for(int i = 0; i<arr.length; i++) {
			if(arr[i].equals(month)) {
				int temp = i / 3;
				if(temp ==0 || temp == 2 || temp == 4 || temp ==6 || temp ==7 || temp ==9 || temp ==11) {
					System.out.println("This month have: 31 days");
				}
				else if (temp == 1 && leapYear(year)) {
					System.out.println("This month have: 29 days");
				}
				else if(temp == 1) {
					System.out.println("This month have: 28 days");
				}
				else {
					System.out.println("This month have: 30 days");
				}
				break;
			}
		}
	}
	static void inputClient(String[] arr) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input month you want: ");
		String month = sc.nextLine();
		while (!checkInputMonth(month,arr)) {
			System.out.print("Input month you want again: ");
			month = sc.nextLine();
		}
		System.out.print("Input year you want: ");
		String year = sc.nextLine();
		while(true) {
			if(isInteger(year)){
				int num = Integer.parseInt(year);
				if(num > 0) {
					System.out.println("Year: "+year);
					printAns(month,num,arr);
					break;
				}
				else {
					System.out.print("Input year you want again: ");
					year = sc.nextLine();
				}
			}
			else{
				System.out.print("Input year you want again: ");
				year = sc.nextLine();
			}
		}
	}
	
	public static void main(String[] args) {
		String[] months = {"Jan.","Jan", "1",
						   "Feb.","Feb", "2",
						   "Mar.","Mar","3",
						   "Apr.", "Apr", "4",
						   "May","May","5",
						   "June","Jun","6",
						   "July","Jul","7",
						   "Aug.","Aug","8",
						   "Sept.","Sep","9",
						   "Oct.","Oct","10",
						   "Nov.", "Nov","11",
						   "Dec.","Dec","12"};
		inputClient(months);
	}
}
