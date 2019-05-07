package plus_3_15;

import java.util.Scanner;

public class Des_order {
	public static void main(String[] args) {
		int n,m;
		Scanner input = new Scanner(System.in);
		n=input.nextInt();
		m=input.nextInt();
		int[] arr=new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=input.nextInt();
		}

		int num;
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if(arr[i]<arr[j]) {
					num=arr[i];
					arr[i]=arr[j];
					arr[j]=num;
				}
			}
		}
		
		System.out.print(arr[m-1]);
	}
}
