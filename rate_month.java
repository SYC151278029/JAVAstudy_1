package plus_3_10;

import java.util.Scanner;

public class rate_month {
	public static void main(String []args) {
		Scanner input = new Scanner(System.in);
		
		double loan=input.nextDouble();
		
		double year_rate= input.nextDouble();
		double month_rate= year_rate/12;
		
		int number_of_year=input.nextInt();
		
		input.close();
		
		double pay=loan*month_rate/(1-
				1/Math.pow(1+month_rate,number_of_year*12));
		
		System.out.println("pay is "+pay);
	    }
}
