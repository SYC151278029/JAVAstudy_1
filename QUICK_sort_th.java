package plus_3_22;

import java.util.*;

public class QUICK_sort_th {
	public static void main(String[] args) {
	int n,th;
	Scanner input = new Scanner(System.in);
	n=input.nextInt();
	th=input.nextInt();
	int[] arr=new int[n+1];
	for(int i=0;i<n;i++) {
		arr[i]=input.nextInt();
		}
	
	//List<Integer> list = new ArrayList<Integer>(); 
	//for(int i=0;i<n;i++) {
	//	list.add(arr[i]);
	//}
	//Collections.shuffle(list); 
	
	//Object[] arr2 = list.toArray();
	//System.out.println(list);
	//System.out.println(arr2[0]+" "+arr2[1]+" "+arr2[2]);

	sort(arr);
	System.out.print(arr[th-1]+" ");
	}
	
	public static void sort(int[] a)
	{
		int N = a.length;
		sort(a,0,N-1);
	}
	
	public static void sort(int[] a,int lo,int hi) {
		if(hi<=lo)return;
		int j=partition(a,lo,hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}
	
	public static int partition(int[] a,int lo,int hi) {
		int i=lo,j=hi+1;
		while(true) {
			while(a[++i]>a[lo])
				if(i==hi)break;
			while(a[lo]>a[--j])
				if(j==lo)break;
			if(i>=j)break;
			exchange(a,i,j);
		}
		exchange(a,lo,j);
		return j;
	}
	
	public static void exchange(int[] a,int lo,int hi) {
		int num=a[lo];
		a[lo]=a[hi];
		a[hi]=num;
	}
}