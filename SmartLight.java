package hw2;
import java.util.Calendar;
public class SmartLight extends SmartObject implements LocationControl,Programmable{
	private boolean hasLightTurned;
	private Calendar programTime = Calendar.getInstance();
	String time = programTime.get(Calendar.HOUR_OF_DAY)+":"+programTime.get(Calendar.MINUTE)+":"+programTime.get(Calendar.SECOND);
	private boolean programAction =! hasLightTurned;
		
	public SmartLight(String alias, String macId) {	
		super();
		setAlias(alias);
		setMacId(macId);
	}
	public void turnOnLight() {
		if(SmartLight.isConnectionStatus()==true) {
			if(hasLightTurned==true) {				
				System.out.println("Smart Light - "+getAlias()+" has been already turned on (Current Time: "+ 
				time+" )");
			}else {
				hasLightTurned=true;						
				System.out.println("Smart Light - "+getAlias()+ 
						" is turned on now (Current Time: "+time+" )");
			}
			}
	}
	public void turnOffLight() {
		if(SmartObject.isConnectionStatus()==true) {
			if(hasLightTurned==false) {
				System.out.println("Smart Light - "+ this.getAlias()+ 
						" has been already turned off ( Current Time: "+time+" )");
			}
			else {
				hasLightTurned=false;
				System.out.println("Smart Light - "+ this.getAlias()+ 
						" is turned off now (Current Time: "+time+" )");
			}			
		}
	}
	@Override
	public boolean testObject() {
		if(SmartLight.isConnectionStatus()==true) {
			System.out.println("Test is starting for SmartLight");
			SmartObjectToString();
			turnOnLight();
			turnOffLight();
			System.out.println("Test completed for SmartLight");
			return true;
		}else
		return false;
	}
	@Override
	public boolean shutDownObject() {
		if(SmartLight.isConnectionStatus()==true) {			
			if(hasLightTurned=false) {
				System.out.println("Lights are already closed");
			}else {
					SmartObjectToString();
					hasLightTurned=false;				
				}	
		}
		return false;
	}
	@Override
	public void onLeave() {
		if(SmartLight.isConnectionStatus()==true) {
			turnOffLight();
			hasLightTurned=false;			
			System.out.println("On Leave -> Smart Light - "+this.getAlias()+"\nSmart Light - "+ getAlias()
			+" is turned off now (Current time: " + time+" )");
		}		
	}
	@Override
	public void onCome() {
		if(SmartObject.isConnectionStatus()==true) {		
			System.out.println("On Come -> Smart Light - "+this.getAlias()+"\nSmart Light - "+ this.getAlias()
			+" is turned on now (Current time: "+time+" )");
			turnOnLight();
			hasLightTurned=true;
		}
	}
	@Override
	public void setTimer(int seconds) {
		if(SmartObject.isConnectionStatus()==true) {	
			int time1 = programTime.get(Calendar.SECOND) + seconds;
			String timeSet = programTime.get(Calendar.HOUR_OF_DAY)+":"+programTime.get(Calendar.MINUTE)+":"+time1;
			System.out.println("Smart Light - "+this.getAlias()+
			" will be turned off "+ seconds + " seconds later! (Current time: "+timeSet+" )");
		}		
	}
	@Override
	public void cancelTimer() {
		if(SmartLight.isConnectionStatus()==true) {
		programTime = null;
		}	
	}
	@Override
	public void runProgram() {
		if(SmartLight.isConnectionStatus() == true) {
			if(programAction==false) {
				turnOffLight();
			}
			else turnOnLight();
		}		
	}

//GETTERS AND SETTERS
	public boolean isHasLightTurned() {
		return this.hasLightTurned;
	}
	public void setHasLightTurned(boolean hasLightTurned) {
		this.hasLightTurned = hasLightTurned;
	}
	public Calendar getProgramTime() {
		return this.programTime;
	}
	public void setProgramTime(Calendar programTime) {
		this.programTime = programTime;
	}
	public boolean isProgramAction() {
		return this.programAction;
	}
	public void setProgramAction(boolean programAction) {
		this.programAction = programAction;
	}
	
}
