package model;

public class SafeBox {
	
	public static boolean openBox(int password, int value) {
		
		if(password == value) {
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}

}
