/** IMPORTANT POINT: EXECUTION OF A METHOD/TRY BLOCK STOPS AFTER AN EXEPTION IS THROWN AUTOMATICALLY/USING THROW KEYWORD
 * + EVEN FROM OTHER FUNCTION WHICH IS CALLED FROM A TRY BLOCK**/

// Exeception Classes
class InvalidInitialTemperatureException extends Exception {
 private int temp;
 InvalidInitialTemperatureException(int temp) {
  this.temp = temp;
 }
 public String toString() {
  return "InvalidInitialTemperatureException : " + this.temp;
 }
}
/************************************************************************************/

class HighTemperatureException extends Exception {

 HighTemperatureException() {}
 public String toString() {
  return "\nHigh Temperature Exception : Cooling down\n";
 }
}
/************************************************************************************/

class LowTemperatureException extends Exception {
 LowTemperatureException() {}
 public String toString() {
  return "\nLow Temperature Exception : Heating\n";
 }
}
/************************************************************************************/


// Class Thermostat
class Thermostat {
 private int temperature;
 static final int LOWER_LIM = 50;
 static final int UPPER_LIM = 100;

 Thermostat(int initTemp) throws InvalidInitialTemperatureException {
  if ((initTemp >= LOWER_LIM) && (initTemp <= UPPER_LIM)) {
   this.temperature = initTemp;
   System.out.println("Thermostat Starting. With Initial Temprature:" + temperature);
  }
  else {
   throw new InvalidInitialTemperatureException(initTemp);
  }
 }

 public void startThermostat() throws HighTemperatureException {
  System.out.println("*****************Thermostat Started*************************");
  while(true){	  
	  System.out.println(temperature);
	  if(temperature!=UPPER_LIM){
		  temperature++;	
		  try{
			  Thread.sleep(1000);
		  }
		  catch(InterruptedException e){System.out.println("Thread Interrupted");}
	  }
	  else{
		  throw new HighTemperatureException(); //If I write anything below this, that is unreachable because the program will stop the function execution if an exception is thrown as the exception is caught remotely
	  }
	  
  }
  /*
  This method increments (+1) and displays the temperature of the Thermostat after every
  1000 ms. When the temperature reaches the UPPER_LIM it raises
  HighTemperatureException.
  */

 }
 public void stopThermostat() throws LowTemperatureException {
   System.out.println("*****************Thermostat Stopping*************************");
   while(true){	  
		  System.out.println(temperature);
		  if(temperature!=LOWER_LIM){
			  temperature--;	
			  try{
				  Thread.sleep(1000);
			  }
			  catch(InterruptedException e){System.out.println("Thread Interrupted");}
		  }
		  else{
			  throw new LowTemperatureException();	//If I write anything below this, that is unreachable because the program will stop the function execution if an exception is thrown as the exception is caught remotely		  
		  }
	 }
   /*
   This method decrements (-1) and displays the temperature of the Thermostat after every
   1000 ms. When the temperature reaches the LOWER_LIM it raises
   LowTemperatureException.
   */
   
  }
}
  /************************************************************************************/


public class ThermostatDriver {
  public static void main(String[] args) throws InvalidInitialTemperatureException {
   Thermostat t = new Thermostat(55); 
   boolean flag=true;
   int z=0;		   
   //Setting the initial temperature of the thermostat as 55.
   
   while (flag) {
	   
    try {
     t.startThermostat();
    } catch (HighTemperatureException e) {
     System.out.println(e);
    }
    
    try {
     t.stopThermostat();
    } catch (LowTemperatureException ex) {
     System.out.println(ex);
    }
    z++;
    if(z==2){
    	return;
    }
   }
   
  }// End of main()
} // End of ThermostatDriver
 