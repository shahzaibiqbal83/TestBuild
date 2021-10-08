package src.TestBuild;

// Importing the LocalTime class
import java.time.*;
//import java.util.concurrent.TimeUnit;

// Importing the ChronoUnit class
import java.time.temporal.ChronoUnit;

class TimeState{

	/*
	public static void main(String[] args)
	{
		stamp("Build Success !!!!",1000,2); //Stamp(String msg,int delay_mSec, int cutoff_in_hrs )
	
	}
*/
	//Stamp(String msg,int delay_mSec, int cutoff_in_hrs )
	public static void stamp(String msg, int delay, int cutoff){
	
		LocalTime startTime = LocalTime.now();	
		LocalTime currentTime = LocalTime.now();
		long seconds;
		long hours;
		String lt;
		String ld;
		long cTime = cutoff * 60;

		do {
			currentTime = LocalTime.now();
			lt = LocalTime.now().toString();
			ld = LocalDate.now().toString();
			
			System.out.println("<" + ld +" "+ lt.subSequence(0, 8) +"> : " + msg + "(cutoff in :" + cTime + "Mins)");
			// Calculating the difference in Hours
			hours = ChronoUnit.HOURS.between(startTime, currentTime);
			//System.out.println("Elapsed hours :" + hours);
		
			//  Calculating the difference in Minutes
				long minutes = ChronoUnit.MINUTES.between(startTime, startTime) % 60;

			//  Calculating the difference in Seconds
			seconds = ChronoUnit.SECONDS.between(startTime, currentTime) % 60; 
			//System.out.println("Elapsed Seconds :" + seconds);
			cTime = cutoff*60 - (currentTime.getMinute()-startTime.getMinute());
			wait(delay);

		}while(!(hours == cutoff));

}



	public static void wait(int ms){
  		try{
       		 Thread.sleep(ms); 
		}
    	catch(InterruptedException ex){
        Thread.currentThread().interrupt();
 	   }
	}

}

