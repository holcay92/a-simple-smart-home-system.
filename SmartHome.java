package hw2;
import java.util.ArrayList;
import java.util.Arrays;

import week5.ComparableRectangle;
import week5.Rectangle;
public class SmartHome {
	
	private ArrayList<SmartObject> smartObjectList= new ArrayList<>();
	public static int NumberIp=0;
	public SmartHome() {		
	}	
	public boolean addSmartObject(SmartObject smartObject) {
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Adding new SmartObject");
		System.out.println("------------------------------------------------------------------------------");		 
		smartObject.connect("10.0.0."+(int)(100+NumberIp));
		NumberIp++;
		smartObjectList.add(smartObject);	
		smartObject.testObject();
		System.out.println();
		return true;
	}
	public boolean removeSmartObject(SmartObject smartObject) {
		smartObjectList.remove(smartObject);
		return true;		
	}
	
	public void controlLocation( boolean onCome) {
		System.out.println("----------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("LocationControl : OnCome");
		System.out.println("----------------------------------------------------------------------");
		for(SmartObject smartObject:smartObjectList) {
			if(smartObject instanceof LocationControl) {
				if(onCome==true) {				
					((LocationControl)smartObject).onCome();					
				}
				else
					((LocationControl)smartObject).onLeave();		
			}
		}		
	}
	public void controlMotion(boolean hasMotion, boolean isDay) {
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("MotionControl : HasMotion, isDay");
		System.out.println("-----------------------------------------------------------------------");
		for(SmartObject smartObject:smartObjectList) {
			if(smartObject instanceof MotionControl) {				
				((MotionControl) smartObject).controlMotion(hasMotion, isDay);				
			}
		}
		
	}
	public void controlProgrammable() {
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("Programmable : runProgram");
		System.out.println("-----------------------------------------------------------------------");
		for(SmartObject smartObject:smartObjectList) {
			if(smartObject instanceof Programmable) {
				((Programmable) smartObject).runProgram();				
			}
		}		
	}
	public void controlTimer(int seconds) {
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("Programmable : Timer = "+seconds+" seconds");
		System.out.println("-----------------------------------------------------------------------");
		for(SmartObject smartObject:smartObjectList) {
			if(smartObject instanceof Programmable) {
				if(seconds>0) {
				((Programmable) smartObject).setTimer(seconds);
				
				}else ((Programmable) smartObject).cancelTimer();				
			}
		}	
	}
	public void controlTimerRandomly() {
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("Programmable : Timer = 0, 5 or 10 seconds randomly");
		System.out.println("-----------------------------------------------------------------------");
		for(SmartObject smartObject:smartObjectList) {
			if(smartObject instanceof Programmable) {
				int seconds=5*(int)(Math.random()*2);
				if(seconds>0) {
					((Programmable) smartObject).setTimer(seconds);
				}else {
					((Programmable) smartObject).cancelTimer();		}	
			}
		}		
	}
	public void sortCameras() {	 
		System.out.println("Sort Smart Cameras\n");
		int Count = 0;
		
			for(SmartObject smartCamera:smartObjectList) {	
				if(smartCamera instanceof Comparable)
				Count++;				
			}
			
			SmartObject[] array = new SmartObject[Count];
			
				int i = 0;
			for(SmartObject smartCamera: smartObjectList) {					
				if(smartCamera instanceof Comparable) {					
					array[i] = smartCamera;
					i++;
				}
			}
			Arrays.sort(array);
							
				for(int j = 0; j < array.length ; j++) {
				System.out.println(array[j]+"'s battery life is "+array[j]+" status is ") ;
				}
	}
		
//GETTER AND SETTER	
	public ArrayList<SmartObject> getSmartObjectList() {
		return smartObjectList;
	}
	public void setSmartObjectList(ArrayList<SmartObject> smartObjectList) {
		this.smartObjectList = smartObjectList;
	}
}
