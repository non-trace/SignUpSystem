/**
 * 
 */
package cn.edu.tstc.common.interceptor;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import cn.edu.tstc.common.exception.BuzServiceException;
import cn.edu.tstc.common.util.ToolUtil;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
public class ManagerActionInterceptor implements Interceptor {
	private static final long serialVersionUID = 1L;
	protected Logger actionLogger = LogManager.getLogger("ACTION");
	protected Logger exceptionLogger = LogManager.getLogger("EXCEPTION");

	public void destroy() {
	}

	public void init() {
	}

	public String intercept(ActionInvocation arg0) throws Exception {
		String result = "";
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		beforeProcess(request, response, arg0);
		try {
			result = arg0.invoke();
		} catch (Throwable ex) {
			return exceptionProcess(request, response, arg0, ex);
		} finally {
			afterProcess(request, response, arg0);
		}
		return result;
	}

	private void beforeProcess(HttpServletRequest request,
			HttpServletResponse response, ActionInvocation arg0) {
		try {
			// 记录请求日志
			actionLogger.debug(request.getQueryString());
			actionLogger.debug(request.getServletPath());
			actionLogger.debug(request.getRequestURL().toString());
			Map map = request.getParameterMap();
			actionLogger.info(map);
			Set set = map.keySet();
			Iterator iter = set.iterator();
			while (iter.hasNext()) {
				String key = (String) iter.next();
				actionLogger.debug(key + " : " + getString(map.get(key)));
			}
		} catch (Exception ex) {
			exceptionLogger.error(ex.getMessage(), ex);
		}
	}

	private void afterProcess(HttpServletRequest request,HttpServletResponse response, ActionInvocation arg0) {
		
	}

	private String exceptionProcess(HttpServletRequest request,HttpServletResponse response, ActionInvocation arg0, Throwable ex) {
		outRequestParam(request);
		String requestPath = request.getServletPath();
		request.setAttribute("REQ_BIZ_PATH", requestPath);
		request.setAttribute("SYSTEM_ERROR_MSG", ex.getMessage());
		request.setAttribute("SYSTEM_EXCEPTION_MSG", ToolUtil.getExceptionMsg(ex));
		exceptionLogger.fatal(ex.getMessage(), ex);
		throw new BuzServiceException(ex.getMessage(), ex, "Error01");
	}

	/**
	 * 
	 * @param request
	 */
	private void outRequestParam(HttpServletRequest request) {
		exceptionLogger.fatal(request.getQueryString());
		exceptionLogger.fatal(request.getServletPath());
		exceptionLogger.fatal(request.getRequestURL().toString());
		Map map = request.getParameterMap();
		exceptionLogger.info(map);
		Set set = map.keySet();
		Iterator iter = set.iterator();
		while (iter.hasNext()) {
			String key = (String) iter.next();
			exceptionLogger.fatal(key);
			exceptionLogger.fatal(getString(map.get(key)));
		}
	}

	/**
	 * 获取相应数据字符
	 * 
	 * @param obj
	 * @return
	 */
	private static String getString(Object obj) {
		if (obj == null) {
			return null;
		}
		if (obj instanceof String) {
			return ((String) obj).trim();
		}
		if (obj instanceof String[]) {
			StringBuffer buf = new StringBuffer();
			for (int i = 0; i < ((String[]) obj).length; i++) {
				buf.append(((String[]) obj)[i].trim()).append(" ");
			}
			return buf.toString();
		}
		return null;
	}
}
