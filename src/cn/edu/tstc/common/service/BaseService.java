package cn.edu.tstc.common.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class BaseService implements IBaseService{
	protected Logger aLogger  = LogManager.getLogger("SERVICE");
	protected Logger exceptionLogger  = LogManager.getLogger("EXCEPTION");
}
