package plus_3_8;

public class Time {
	public static void main(String []args) {
	long totalMilliseconds = System.currentTimeMillis();
	long totalSeconds = totalMilliseconds/1000;
	long currentSecond = totalSeconds % 60;
	long totalMinutes = totalSeconds / 60;
	long currentMinute = totalMinutes % 60;
	long totalHours = totalMinutes /60;
	long currentHour = totalHours % 24;
	long BJHour = currentHour +8;
	System.out.println("time is "+currentHour+":"
	+ currentMinute +":"+currentSecond+"GMT");
	System.out.println("BJ time is "+ BJHour +":"
	+ currentMinute +":"+currentSecond+"GMT");
	}
}
