package exception;

import java.util.InputMismatchException;

public class MyInputMismatchException extends InputMismatchException{

	public MyInputMismatchException(String message) {
		super(message);
	}
	public MyInputMismatchException(){
	}

	@Override
	public String getMessage() {
		return "Niste uneli validan podatak";
	}
	
}
