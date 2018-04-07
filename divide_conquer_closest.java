package plus_3_29;

import java.util.*;

public class divide_conquer_closest {
	static int distance=0;
	public static void main(String[] args) {
		int n;
		double result;
		Scanner input = new Scanner(System.in);
		n=input.nextInt();
		int[][] arr=new int[n][2];
		for(int i=0;i<n;i++) {
			arr[i][0]=input.nextInt();
			arr[i][1]=input.nextInt();
			}
		result = closePoint(arr);
		//for(int i=0;i<n;i++)System.out.printf("%d %d\n",arr[i][0],arr[i][1]);
		System.out.printf("%.2f",result);
	}
	
	private static double closePoint(int[][] arr) {
		double min=Double.POSITIVE_INFINITY;
		double now;
		if(arr.length<=10) {
			for(int i=0;i<arr.length;i++) {
				for(int j=i+1;j<arr.length;j++) {
					now=Math.sqrt(Math.pow(arr[i][0]-arr[j][0], 2)+Math.pow(arr[i][1]-arr[j][1], 2));
					if(min>now)
						min=now;
				}
			}
			return min;
		}
		
		mergesort(arr, new int[arr.length][3], 0, arr.length - 1,0);
		int mid=arr.length/2;
		int[][] arr1=new int[mid][2];
		int[][] arr2=new int[arr.length-mid][2];
		for(int i=0;i<arr1.length;i++)
			arr1[i]=arr[i];
		for(int i=0;i<arr2.length;i++)
			arr2[i]=arr[arr1.length+i];
		double min1=closePoint(arr1);
		double min2=closePoint(arr2);
		
		//for(int i=0;i<arr2.length;i++)System.out.printf("*%d %d*\n",arr2[i][0],arr2[i][1]);
		//System.out.printf("%.2f %.2f %d\n",min1,min2,arr1.length);
		if(min>min1)min=min1;
		if(min>min2)min=min2;
		
		ArrayList a3=new ArrayList();
		ArrayList a4=new ArrayList();
		for(int i = 0; i < arr1.length; i++){  
            if((mid-arr1[i][0]) < min)  
                a3.add(arr1[i]);
		}
		for(int i = 0; i < arr2.length; i++){  
            if((arr2[i][0]-mid) < min)  
                a3.add(arr1[i]);
		}
		int[][] arr3=new int[a3.size()][2];
		int[][] arr4=new int[a4.size()][2];
		a3.toArray(arr3);
		a4.toArray(arr4);
		
		double min_y = Double.POSITIVE_INFINITY;
		for(int i=0;i<arr3.length;i++)
			for(int j=0;j<arr4.length;j++) {
				if(Math.abs(arr3[i][1]-arr4[j][1])<min) {
					min_y = Math.sqrt(Math.pow(arr3[i][0]-arr4[j][0], 2)+Math.pow(arr3[i][1]-arr4[j][1], 2));
					if(min>min_y)min=min_y;
				}
			}
		return min;
    }
	
	private static void mergesort(int[][] arr, int[][] temp, int left, int right, int flag) {
        if (left < right) {
            int center = (left + right) / 2;
            mergesort(arr, temp, left, center, flag); 
            mergesort(arr, temp, center + 1, right, flag); 
            merge(arr, temp, left, center + 1, right, flag); 
        }
	}
	
	private static void merge(int[][] arr, int[][] temp, int leftPos, int rightPos, int rightEnd, int flag) {
        int leftEnd = rightPos - 1;
        int tempPos = leftPos; 
        int numEle = rightEnd - leftPos + 1; 
        int flag_other;
        if(flag==0)
        	flag_other=1;
        else 
        	flag_other=0;
        //for(int i=0;i<5;i++)System.out.printf("%d+%d ",arr[i][0],arr[i][1]);System.out.printf("\n");
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (arr[leftPos][flag] <= arr[rightPos][flag]) {
            	temp[tempPos][flag] = arr[leftPos][flag];
            	temp[tempPos++][flag_other] = arr[leftPos++][flag_other];
            }
            else {
            	temp[tempPos][flag] = arr[rightPos][flag];
            	temp[tempPos++][flag_other] = arr[rightPos++][flag_other];
            	}
        }
        while (leftPos <= leftEnd) { 
            temp[tempPos][flag] = arr[leftPos][flag];
            temp[tempPos++][flag_other] = arr[leftPos++][flag_other];
        }
        while (rightPos <= rightEnd) {
            temp[tempPos][flag] = arr[rightPos][flag];
            temp[tempPos++][flag_other] = arr[rightPos++][flag_other];
        }
        for (int i = 0; i < numEle; i++) {
            arr[rightEnd][flag] = temp[rightEnd][flag];
            arr[rightEnd][flag_other] = temp[rightEnd][flag_other];
            rightEnd--;
        }
    }
	
}