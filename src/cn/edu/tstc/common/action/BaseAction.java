package cn.edu.tstc.common.action;

import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {
	protected Logger aLogger  = LogManager.getLogger("ACTION");
	protected Logger exceptionLogger  = LogManager.getLogger("EXCEPTION");
	private static final long serialVersionUID = 1L;
	protected HttpServletRequest _request;
	protected HttpServletResponse _response;

	public void setServletResponse(HttpServletResponse response) {
		this._response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this._request = request;
	}

	/**
	 * 将页面提交或请求对象中对应的数据属性转换到相关的数据映射集合Map中
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map parseRequst2Map(HttpServletRequest request) {
		Map hashMap = new HashMap();
		Enumeration enumParameter = request.getParameterNames();
		String strParameterName = null;
		while (enumParameter.hasMoreElements()) {
			strParameterName = (String) enumParameter.nextElement();
			hashMap.put(strParameterName,request.getParameter(strParameterName));
		}

		Enumeration enumAAttribute = request.getAttributeNames();
		String strAttributeName = null;
		while (enumAAttribute.hasMoreElements()) {
			strAttributeName = (String) enumAAttribute.nextElement();
			hashMap.put(strAttributeName,request.getAttribute(strAttributeName));
		}
		return hashMap;
	}
	
	public void setOutResponse(String outContent) throws Exception {
		String contentType = "text/plain; charset=UTF-8";
		_response.setContentType(contentType);
		try {
			if (outContent != null) {
				OutputStream out = _response.getOutputStream();
				try {
					out.write(outContent.getBytes("UTF-8"));
					out.flush();
				} finally {
					if (out != null) {
						out.close();
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
	}
}
