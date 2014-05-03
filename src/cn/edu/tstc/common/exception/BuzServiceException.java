package cn.edu.tstc.common.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
public class BuzServiceException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	//异常的消息
	private String gMessage = "";
	//异常的编号
	private String commonCode = "";
	/**
	 * 
	 * @param sendObj
	 * @return
	 */
	private static String getExceptionMsg(Throwable sendObj) {
		String msg = "";
		try {
			Throwable ex = (Throwable)sendObj;
			StringWriter wout = new StringWriter();
			PrintWriter pout = new PrintWriter(wout);
			ex.printStackTrace(pout);	
			pout.flush();
			wout.flush();
			msg = wout.getBuffer().toString();
			wout.close();
			pout.close();
		} catch(Exception ex) {
			
		}
		return msg;				
	}
	public BuzServiceException() {
		super();
	}
    public BuzServiceException(String message, Throwable cause,String _code) {
        super(message, cause);
		gMessage = getExceptionMsg(cause);
		commonCode = _code;
    }
    
    public BuzServiceException(String message, Exception ex,String _code) {
        super(message, ex);
		gMessage = message  + getExceptionMsg(ex);
		commonCode = _code;
    }
    
    public BuzServiceException(Throwable cause,String _code) {
        super(cause);
		gMessage = getExceptionMsg(cause);
		commonCode = _code;
    }
    
    public BuzServiceException(Exception ex,String _code) {
        super(ex);
		gMessage = getExceptionMsg(ex);
		commonCode = _code;
    }
    /**
     * 
     * @param message
     * @param _code
     */
	public BuzServiceException(String message, String _code) {
		super(message);
		gMessage = message;
		commonCode = _code;
	}
	/**
	 * 错误信息
	 */
    public String getMessage() {
    	if (this.gMessage == null) {
    		return "";
    	}
   	 	return this.gMessage;
    }
    /**
     * 异常编码
     * @param _code
     */
    public void setCommonCode(String _code) {
    	this.commonCode = _code;
    }
    /**
     * 异常编码
     * @return
     */
    public String getCommonCode() {
    	if (this.commonCode == null) {
    		return "";
    	}
    	return this.commonCode;
    }
    public String toString(){
    	if (this.gMessage == null) {
    		return "";
    	}
    	return gMessage;
    }
}