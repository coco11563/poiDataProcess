package dataProcess;

import java.io.IOException;

class TimeNotExistException extends IOException{

	/**
	 * 在出现查询不到该时间的poiStatus时可以被throw
	 */
	private static final long serialVersionUID = -6303997166814540246L;
	public TimeNotExistException(){}
	public TimeNotExistException(String gripe){
		super(gripe);
	}
	

}
