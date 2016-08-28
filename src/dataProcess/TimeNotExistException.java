package dataProcess;

import java.io.IOException;

class TimeNotExistException extends IOException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6303997166814540246L;
	public TimeNotExistException(){}
	public TimeNotExistException(String gripe){
		super(gripe);
	}
	

}
