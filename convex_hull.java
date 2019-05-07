import java.util.*;

public class convex_hull {
	static int distance=0;
	public static void main(String[] args) {
		int n;
		n=input.nextInt();
		int[][] arr=new int[n][3];
		int[][] result=new int[n][3];
		for(int i=0;i<n;i++) {
			arr[i][0]=input.nextInt();
			arr[i][1]=input.nextInt();
			arr[i][2]=0;
			}
		result = create_hull(arr,n);
		for(int i=0; (i<=result.length) && (result[i][2]==1);i++)
		System.out.printf("%d %d \n",result[i][0],result[i][1]);
	}
	
	private static int[][] create_hull(int[][] arr,int n) {
		int now=0;
		int firstpoint,nextpoint,lastpoint;
		int[][] result=new int[n][3];
		sort_x_y(arr);
		firstpoint=0;
		nextpoint=0;
		lastpoint=0;
		do{
			firstpoint=nextpoint;
			nextpoint=lastpoint;
			arr[nextpoint][2]=1;
			result[now]=arr[nextpoint];
			result[now][2]=1;
			now++;
			double angle=Double.POSITIVE_INFINITY;
			int[] initial_point=new int[2];
			initial_point[0]=arr[0][0];initial_point[1]=0;
			//System.out.printf("%d\n",now);
			for(int i=0;i<n;i++){
					if(nextpoint==0) {
						if(arr[i][2]==0) {
						if(angle>angle(initial_point,arr[nextpoint],arr[i])) {
							angle=angle(initial_point,arr[nextpoint],arr[i]);
							lastpoint=i;
						}
						}
					}
					else {
						if(angle>angle(arr[firstpoint],arr[nextpoint],arr[i])) {
							//System.out.printf("%d %d %d %d %f %f*\n",firstpoint,nextpoint,i,arr[nextpoint][2],angle,angle(arr[firstpoint],arr[nextpoint],arr[i]));
							angle=angle(arr[firstpoint],arr[nextpoint],arr[i]);
							lastpoint=i;
						}
				}
			}
		}while(arr[lastpoint][2]==0);
		return result;
    }
	
	private static void sort_x_y(int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i][0]>arr[j][0]){
					int x,y;
					x=arr[i][0];y=arr[i][1];
					arr[i][0]=arr[j][0];arr[i][1]=arr[j][1];
					arr[j][0]=x;arr[j][1]=y;
				}
				if(arr[i][0]==arr[j][0]) {
					if(arr[i][1]>arr[j][1]) {
						int x,y;
						x=arr[i][0];y=arr[i][1];
						arr[i][0]=arr[j][0];arr[i][1]=arr[j][1];
						arr[j][0]=x;arr[j][1]=y;
					}
				}
			}
		}
	}
	private static double angle(int[] x,int[] y,int[] z) {
		double x1=y[0]-x[0];double y1=y[1]-x[1];
		double x2=z[0]-y[0];double y2=z[1]-y[1];
		//System.out.printf("%f %f %f %f $\n",x1,y1,x2,y2);
		double sin=Math.abs(y1*x2-x1*y2)/(Math.abs(Math.sqrt(x1*x1+y1*y1))*Math.abs(Math.sqrt(x2*x2+y2*y2)));
		double cos=(x1*x2+y1*y2)/(Math.abs(Math.sqrt(x1*x1+y1*y1))*Math.abs(Math.sqrt(x2*x2+y2*y2)));
		//System.out.printf("%f %f \n",sin,cos);
		if(cos>=0)
			return sin;
		else
			return 2-sin;
	}
}