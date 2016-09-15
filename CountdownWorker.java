package com.abc.countdown;


public class CountdownWorker {
    private final int totalSeconds;
    private final MinuteSecondDisplay display;
    private long msElapsed=0, StartTime, NormalSlpTime,ExpTime, Difference,NxtSlpTime;
    public CountdownWorker(int totalSeconds, MinuteSecondDisplay display) {
        this.totalSeconds = totalSeconds;
        this.display = display;

        // do the self-run pattern to spawn a thread to do the counting down...
        // ...
 
        Runnable r = new Runnable(){
        	public void run(){
        		runWork();
        	}
        };
        Thread t = new Thread(r);
        t.start();
        		
        	}
       

    // TODO - add methods to do the counting down and time correction....
    //        call: display.setSeconds(...

          private void runWork(){
        	  try{
        		   StartTime = System.currentTimeMillis();
        		   NormalSlpTime = 10*1000000L;
        		  
        	  for (int i = totalSeconds; i>=0; i--){
        		   ExpTime = StartTime + i*NormalSlpTime;
        		   Difference = System.currentTimeMillis() - ExpTime;
        		   NxtSlpTime = NormalSlpTime - Difference; 
        		  System.out.println("Next sleep Time: "+NxtSlpTime + "ms");
        		  display.setSeconds(i);
        		  if (i> 0){
        		  Thread.sleep(946);
        	  }
        		 
        		  msElapsed=System.currentTimeMillis()-StartTime;
        	  }
        	  System.out.println("Elapsed=" + msElapsed +"ms");
        	  }catch (Exception e)
        	  {
        		  System.out.println("Exception:" +e);
        	  }
          }

}