package cn.edu.tstc.common.log;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.xml.DOMConfigurator;

import cn.edu.tstc.common.util.OSSystemUtil;
import cn.edu.tstc.common.util.PropertyWrapper;
import cn.edu.tstc.common.util.WebContextUtils;

public class Log4jManager implements ServletContextListener {
	
	public void contextDestroyed(ServletContextEvent arg0) {}

	public void contextInitialized(ServletContextEvent sce) {
		try {
			WebContextUtils.setWebApplicationContext(sce.getServletContext());
			String log4jConfigDir = sce.getServletContext().getInitParameter("log4jConfigDir");
			if (log4jConfigDir.indexOf("classpath:") == 0) {
				log4jConfigDir = WebContextUtils.getResourcesAbsolutePath("classes") + File.separatorChar + log4jConfigDir.split(":")[1];
			}
			PropertyWrapper.loadProperty(log4jConfigDir,"log4jConfig.properties");
			createLog4jPath();
			DOMConfigurator.configure(log4jConfigDir + "/log4j.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void createLog4jPath() throws Exception {
		// 设置系统中的日志文件的路径如果操作系统是Windows则
		String logRootDir = "";
		if (OSSystemUtil.isWindows()) {
			logRootDir = PropertyWrapper.readValue("WIN");
			// 指定目录加上IP地址和服务器的节点名称创建目录
			File file1 = new File(logRootDir);
			if (!file1.exists()) {
				file1.mkdirs();
			}
		} else {
			logRootDir = PropertyWrapper.readValue("LINUX");
			// 指定目录加上IP地址和服务器的节点名称创建目录
			File file1 = new File(logRootDir);
			if (!file1.exists()) {
				file1.mkdirs();
			}
		}
		File file2 = new File(logRootDir);
		// 如果目录创建失败 启用临时工作目录
		if (!file2.exists()) {
			logRootDir = System.getProperty("user.dir");
			File file = new File(logRootDir);
			file.mkdirs();
		}
		String value = PropertyWrapper.readValue("SUBDIR");
		mkDir(logRootDir, value);
		String direnv = PropertyWrapper.readValue("LOGENV");
		System.setProperty(direnv, logRootDir + File.separatorChar + value);
	}

	/**
	 * 创建子系统的框架日志文件目录
	 * 
	 * @param srcPath
	 *            系统存在目录
	 * @param descPath
	 *            系统目录下子系统目录
	 */
	private static String mkDir(String srcPath, String descPath) {
		// 构建文件路径，并定义文件
		try {
			File file = new File(srcPath);
			if (!file.exists()) {
				return srcPath;
			}
			srcPath = srcPath + File.separatorChar + descPath;
			File file1 = new File(srcPath);
			if (!file1.exists()) {
				file1.mkdirs();
			}
			return srcPath;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}
}
