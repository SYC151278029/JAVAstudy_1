package plus_3_8;

import java.util.Scanner;

	public static void main(String []args) {
		final double PI = 3.14159;
		System.out.print("Enter a number for radious:");
		Scanner input = new Scanner(System.in);
		double radius1=input.nextDouble();
		double radius2=input.nextDouble();
		double radius3=input.nextDouble();
		input.close();
		
		double average;
		average = (radius1+radius2+radius3)/3;
		System.out.println("average is "+average);
		System.out.println("PI is "+PI);
    }
}
