package cn.edu.tstc.common.util;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
public class ToolUtil {
	/**
	 * 替换字符串中的字符
	 * @param src 源字符串
	 * @param regex 需要被替换的字符串
	 * @param repment  替换的字符串
	 * @return 返回替换的字符串
	 */
	public static String StringReplaceAll(String src, String regex, String repment) {
		StringBuffer srcBuf = new StringBuffer(src);
		StringBuffer descBuf = new StringBuffer();
		while(true) {
			int idx = srcBuf.indexOf(regex);
			if (idx == -1) {
				break;
			}
			descBuf.append(srcBuf.substring(0,idx));
			descBuf.append(repment);
			srcBuf.delete(0, idx + regex.length());
		}
		descBuf.append(srcBuf);
		return descBuf.toString();
	}
	/**
	 * 
	 * @param sendObj
	 * @return
	 */
	public static String getExceptionMsg(Throwable sendObj) {
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
	public  static ClassLoader getDefaultClassLoader() {
		ClassLoader cl = null;
		try {
			cl = Thread.currentThread().getContextClassLoader();
		}
		catch (Throwable ex) {
		}
		if (cl == null) {
			// No thread context class loader -> use class loader of this class.
			cl = ToolUtil.class.getClassLoader();
		}
		return cl;
	}
	public static void main(String args[]) {
		System.out.println(StringReplaceAll("com.ibm.web'sphere.'ce.cm.ConnectionWai'tTimeoutExc'eption: Co", "'", "\""));
	}
	public static String getMapValue(Map map, String key) {
		if (map == null) {
			return "";
		}
		if (map.get(key) == null) {
			return "";
		}
		if (map.get(key) instanceof String) {
			return (String)map.get(key);
		} else {
			return map.get(key).toString();
		}
	}
}
