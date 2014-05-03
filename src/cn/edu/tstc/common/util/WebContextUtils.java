/*
 * WebServiceContextUtils.java
 * 创建日期： 2008/10/12
 */
package cn.edu.tstc.common.util;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
public final class WebContextUtils extends WebApplicationContextUtils {
	//SPRING框架的上下文关系
	private static ApplicationContext  applContext= null;
	//系统容器的Servlet的上下文关系
	private static ServletContext servletContext = null;
	/**
	 * 设置SPRING上下文关系以及设置容器的上下文关系
	 * @param sc 容器上下文
	 */
	public static final void setWebApplicationContext(ServletContext sc) {
		try {
			servletContext = sc;
			applContext = getWebApplicationContext(sc);
		} catch(Exception ex) {
			
		}
		
	}
	public static final void setWebApplicationContext(ApplicationContext _param) {
		applContext = _param;
	}
	/**
	 * 获取SPRING上下文关系
	 * @returnv SPRING上下文关系
	 */
	public static final synchronized ApplicationContext getWebApplicationContext(){
		return applContext;
	}
	/**
	 * 容器上下文关系
	 * @return
	 */
	public static final synchronized ServletContext getServletContext() {
		return servletContext;
	}
	/**
	 * 获取SPRING的组件类
	 * @param beanId 组件标识
	 * @return 组件类
	 */
	public static final synchronized Object getBean(String beanId) {
		if (null == applContext) {
			return null;
		}
		return applContext.getBean(beanId);
	}
	/**
	 * 生成相应的实例
	 * @param _clzStr
	 * @return
	 * @throws Exception
	 */
	public static Object getClazzInstance(String _clzStr) throws Exception{
			ClassLoader classLoader = null;
			try {
				classLoader = Thread.currentThread().getContextClassLoader();
			}
			catch (Throwable ex) {
				throw new Exception(ex);
			}
			try {
				//建立业务逻辑类
				Class<?> logicClazz = Class.forName(_clzStr, true, classLoader);								
				//创建业务逻辑处理类实例
				return logicClazz.newInstance();
			} catch(Exception ex) {
				throw ex;
			}

	}
	/**
	 * 
	 * @return
	 */
	public  static String getClassResPath(){
		String path = getResourcesAbsolutePath("classes/");
		String aba_path = path.replaceAll("%20"," ");
		return aba_path;
	}

	/**
	 * 这个返回的路径标识是
	 * XXXXXX/WEB-INF/(relationPath) 路径表示
	 * @param relationPath
	 * @return
	 */
	public static String getResourcesAbsolutePath(String relationPath){
		String web_inf_Path = null;
		if (servletContext != null) {
			web_inf_Path = servletContext.getRealPath("WEB-INF");
		} else {
			web_inf_Path = new File(WebContextUtils.class.getResource("/").getPath()).getParent();
		}
		String path = web_inf_Path;
		//如果传入的是空的相对的路径时的处理
		if (relationPath == null || relationPath.trim().length() ==0) {
			path = path + File.separator + relationPath;
		} else {
			//在相对路径中头个字符后"/"的处理
			if (relationPath.substring(0,1).equals("/")){
				path = path  + relationPath;
			} else {
				path = path + File.separator + relationPath;
			}
		}
		String aba_path = path.replaceAll("%20"," ");
		return aba_path;
	}
}
