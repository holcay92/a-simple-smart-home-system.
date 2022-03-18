package hw2;

public abstract class SmartObject {
	private  String alias;
	private  String macId;
	private  String IP;
	private static boolean connectionStatus;
	
	public SmartObject() {
		
	}
	public boolean connect( String IP) {
		this.setIP(IP);
		System.out.println(getAlias()+" connection established");		
		return SmartObject.connectionStatus = true;
	}
	
	public boolean disconnect() {
		this.setIP(IP);
		System.out.println(getAlias()+ " disconnection established");
		return SmartObject.connectionStatus = false;
	}
	
	public void SmartObjectToString() {
		System.out.println("This is "+ getClass().getSimpleName()+" device "+getAlias()+
				"\n\t MacId : "+this.getMacId()+"\n\t IP : "+this.getIP());		
	}
	
	public boolean controlConnection() {
		if(SmartObject.connectionStatus=false) {
			System.out.println(" This device is not connected. "
		+ getClass().getSimpleName()+" -> "+ getAlias());
		return false;
		}
		else return true;
	}
	
//ABSTRACT METHODS	
	public abstract boolean testObject();
	public abstract boolean shutDownObject();
	
//GETTERS AND SETTERS	
	public  String getAlias() {
		return this.alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getMacId() {
		return this.macId;
	}
	public void setMacId(String macId) {
		this.macId = macId;
	}
	public String getIP() {
		return this.IP;
	}
	public void setIP(String iP) {
		this.IP = iP;
	}
	public static boolean isConnectionStatus() {
		return connectionStatus;
	}
	public void setConnectionStatus(boolean connectionStatus) {
		SmartObject.connectionStatus = connectionStatus;
	}
}
