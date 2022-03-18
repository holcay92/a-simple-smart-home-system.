package hw2;

public class SmartCamera extends SmartObject implements MotionControl, Comparable<SmartCamera>  {
	private static boolean status;
	private int batteryLife;
	private boolean nightVision;
	
	public SmartCamera(String alias, String macId, boolean nightVision, int batteryLife) {
		super();
		setAlias(alias);
		setMacId(macId);
		this.nightVision=nightVision;
		this.batteryLife=batteryLife;
	
	}
	public void turnOn() {
		if(isConnectionStatus()==true) {
		if(SmartCamera.status == false) {	
		System.out.println("Smart Camera - "+ this.getAlias()+
				" is turned on now");
		status = true;
		}
		else System.out.println("Smart Camera - "+this.getAlias()+
				" has been already turned on");
		}
	}
	public  void turnOff() {
		if(isConnectionStatus()==true) {
		if(SmartCamera.status==true) {		
		System.out.println("Smart Camera - "+ this.getAlias()+
				" is turned off now ");
		status = false;
		}
		else {System.out.println("Smart Camera - "+
		this.getAlias()+" has been already turned off");}
	}
	}
	public void recordOn(boolean isDay) {
		if(SmartCamera.isConnectionStatus()==true) {
		if(status == false) {		
			if((isDay == true && nightVision == false )  || (isDay == false && nightVision == true)) {
				System.out.println("Smart Camera - " + this.getAlias()+ " is turned on now");
				status=true;
			}
				else if(isDay== false&& nightVision==false)
				System.out.println("Sorry! Smart Camera - "+ this.getAlias()+ " does not have night vision feature");		
		}
		else System.out.println("Smart Camera - "+getAlias()+" has been already turned on");
			
		}else
			System.out.println("Sorry! Your device is not connected");		
	}
	public void recordOff() {
		if(SmartCamera.isConnectionStatus()==true) {
			if(status==true) {
			status=false;
			System.out.println("Smart Camera - "+
					this.getAlias()+ " is turned off now");
			}
			else
				System.out.println("Smart Camera - "+
						this.getAlias()+" has been already turned off");
		}
		else
			System.out.println("Sorry! Your device is not connected");
	}
	
	@Override
	public boolean testObject() {
		if(SmartCamera.isConnectionStatus()==true) {
			System.out.println("Test is starting for SmartCamera");
			SmartObjectToString();
			System.out.println("Test is starting for SmartCamera day time");
			recordOn(true);
			turnOn();
			turnOff();
			System.out.println("Test is starting for SmartCamera night time");
			recordOn(false);
			turnOff();
			System.out.println("Test completed for SmartCamera");
			return true;
		}
		else
			return false;
	}
	
	@Override
	public boolean shutDownObject() {
		if(SmartCamera.isConnectionStatus()==true) {
			if(status==true) {				
				SmartObjectToString();
				status=false;
			}
			else System.out.println("Already turned off!!");
			return true;
		}
		else
		return false;
	}
	
	@Override
	public boolean controlMotion(boolean hasMotion, boolean isDay) {
// ????????????????????????????????????????????????????????????????????????????????????????????????????????????????
		return false;
	}
		
	@Override
	public int compareTo(SmartCamera smartCamera) {
		if (this.getBatteryLife() > smartCamera.getBatteryLife())
			return 1;
		else if (this.getBatteryLife() < smartCamera.getBatteryLife())
			return -1;
		else
			return 0;
	}

	public String toString() {
		return "SmartCamera -> "+ getAlias()+
				" 's battery life is "+ this.getBatteryLife()+ " status is recording";
	}
	
	
//GETTERS AND SETTERS	
	public boolean isStatus() {
		return SmartCamera.status;
	}
	public void setStatus(boolean status) {
		SmartCamera.status = status;
	}
	public int getBatteryLife() {
		return this.batteryLife;
	}
	public void setBatteryLife(int batteryLife) {
		this.batteryLife = batteryLife;
	}
	public boolean isNightVision() {
		return this.nightVision;
	}
	public void setNightVision(boolean nightVision) {
		this.nightVision = nightVision;
	}
}
