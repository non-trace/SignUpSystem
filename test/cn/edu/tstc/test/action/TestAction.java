/**
 * 
 */
package cn.edu.tstc.test.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.sun.tools.internal.ws.processor.model.Request;

import cn.edu.tstc.common.action.BaseAction;
import cn.edu.tstc.common.constants.IComonConst;
import cn.edu.tstc.test.service.ITestService;
@Namespace("/")
@Results({@Result(name="success",location = "/pages/test/test.jsp")})
public class TestAction extends BaseAction{
	@Resource
	private ITestService testService;
	public String test() throws Exception{
		System.out.println(testService.testService());
		String json = "[{\"id\":1,\"text\":\"EasyUI Demo\",\"children\":[{\"id\":11,\"text\":\"test\",\"state\":\"closed\",\"children\":[{\"id\":111,\"text\":\"test1\"},{\"id\":112,\"text\":\"test2\"},{\"id\":113,\"text\":\"test3\"}]},{\"id\":14,\"text\":\"�˵�\",\"attributes\":{\"url\":\"/test/EasyUI/Menu.jsp\"}},{\"id\":15,\"text\":\"�?\",\"attributes\":{\"url\":\"/test/EasyUI/Form.jsp\"}},{\"id\":16,\"text\":\"�����ϴ�\",\"attributes\":{\"url\":\"/test/fileUpload/testFileUpload.jsp\"}},{\"id\":17,\"text\":\"��ݱ��\",\"attributes\":{\"url\":\"/test/EasyUI/dataGrid.jsp\"}}]}]";
		this.setOutResponse(json);
		return null;
	}
	
	public String login(){
		System.out.println("login");
		this._request.getSession().setAttribute(IComonConst.LOGIN_USER,"asdfadsf");
		return null;
	}
	
	public String logout(){
		System.out.println("logout");
		this._request.getSession().removeAttribute(IComonConst.LOGIN_USER);
		return null;
	}
}
