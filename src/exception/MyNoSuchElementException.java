package exception;

public class MyNoSuchElementException extends Exception{
	
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Ne postoji takav element";
	}
	
}
