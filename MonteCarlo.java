package plus_3_19;

public class MonteCarlo {
	public static void main(String[] args) {
		final int NUMBER_OF_TRIALS = 10000000;
		int numberOFHits = 0;
		
		for(int i=0;i<NUMBER_OF_TRIALS;i++) {
			double x=Math.random()*2.0-1;
			double y=Math.random()*2.0-1;
			if(x*x+y*y<=1)
				numberOFHits++;
		}
		double pi =4.0*numberOFHits/NUMBER_OF_TRIALS;
		System.out.println("PI is "+pi);
	}
}
