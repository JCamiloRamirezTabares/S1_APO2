package model;

public class SafeBox {
	
	private static int password;
	private static String safe;
	
	public SafeBox() {
		safe = "";
		password = 4321;
	}
	

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		SafeBox.password = password;
	}
	
	public static String getSafe() {
		return safe;
	}

	public static void setSafe(String safe) {
		SafeBox.safe = safe;
	}
	
	public boolean evaluatePassword(int value) {
		
		if(password == value) {
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}

	
}
