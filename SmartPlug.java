package hw2;
import java.util.Calendar;
import java.util.Date;

public class SmartPlug extends SmartObject implements Programmable {
	private static boolean status;
	private Calendar programTime = Calendar.getInstance();
	String time = programTime.get(Calendar.HOUR_OF_DAY)+":"+programTime.get(Calendar.MINUTE)+":"+programTime.get(Calendar.SECOND);
	private boolean programAction=!status;
	
	public SmartPlug(String alias, String macId) {	
		super();
		setAlias(alias);
		setMacId(macId);
	}
	public void turnOn() {
		if(isConnectionStatus()==true) {
		SmartPlug.status= true;	
		System.out.println("Smart Plug - "+getAlias()+ " is turned on now (Current Time: "+time+" )");
		}
		else System.out.println("Smart Plug - "+getAlias()+
				" has been already turned on");
	}
	
	public  void turnOff() {
		if(isConnectionStatus()==true) {
		status=false;	
		System.out.println("Smart Plug - "+ this.getAlias()+
				" is turned off now (Current Time: "+time+" )");
		}
		else System.out.println("Smart Plug - "+
		this.getAlias()+" has been already turned off");
	}
	
	@Override
	public boolean testObject() {
		if(isConnectionStatus()==true) {
			System.out.println("Test is starting for SmartPlug");
			SmartObjectToString();
			turnOn();
			turnOff();
			System.out.println("Test completed for SmartPlug");
			return true;
		}
		else
			return false;				
	}
	
	@Override
	public boolean shutDownObject() {
		if(isConnectionStatus()==true) {			
				SmartObjectToString();
				SmartPlug.status=false;						
		return true;
		}
		else
			return false;
	}

	@Override
	public void setTimer(int seconds) {
		if(isConnectionStatus()==true) {
			
			if(status==false) {
				System.out.println("Smart Plug - "+getAlias()+
						" will be turned on "+ seconds +" seconds later! (Current time: "+time+" )");
			}
			else
				System.out.println("Smart Plug - "+getAlias()+
						" will be turned off "+ seconds +" seconds later! (Current time: "+time+" )");

		}else
			System.out.println("Check connection status!");
	}

	@Override
	public void cancelTimer() {
		if(isConnectionStatus()==true) {
			programTime=null;
		}		
	}

	@Override
	public void runProgram() {
		if(isConnectionStatus()==true) {
			if(programAction==true) {
				System.out.println("RunProgram -> Smart Plug - "+getAlias());
				turnOn();
				programTime=null;
			}else {
				System.out.println("RunProgram -> Smart Plug - "+getAlias());
				turnOff();
				programTime=null;
			}		
		}
		
//GETTERS AND SETTERS		
	}public static boolean isStatus() {
		return status;
	}
	public static void setStatus(boolean status) {
		SmartPlug.status = status;
	}
	public Calendar getProgramTime() {
		return programTime;
	}
	public void setProgramTime(Calendar programTime) {
		this.programTime = programTime;
	}
	public boolean isProgramAction() {
		return programAction;
	}
	public void setProgramAction(boolean programAction) {
		this.programAction = programAction;
	}
}
