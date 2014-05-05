/**
 * 
 */
package cn.edu.tstc.action;

import javax.annotation.Resource;

import cn.edu.tstc.common.action.BaseAction;
import cn.edu.tstc.common.constants.IComonConst;
import cn.edu.tstc.entity.User;
import cn.edu.tstc.service.IUserService;

/**
 * 项目名称：SignUpSystem
 * 类名称：RegistAction
 * 类描述:
 * 创建人：姚洪肖   
 * 创建时间：2014-5-3 下午3:00:57   
 * 修改人：姚洪肖  
 * 修改时间：2014-5-3 下午3:00:57    
 * 修改备注：   
 * @version
 */
public class UserAction extends BaseAction {
	private User user;
	@Resource
	private IUserService service;
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	public String regist() throws Exception{
		if (user!=null) {
			service.regist(user);
			this.setOutResponse(SUCCESS);
		}
		return null;
	}
	
	public String login() throws Exception{
		if (user!=null) {
			User u = service.login(user);
			if (u!=null) {
				this._request.getSession().setAttribute(IComonConst.LOGIN_USER,u);
				this.setOutResponse(SUCCESS);
				return null;
			}
		}
		this.setOutResponse("登录失败，用户名或密码不正确！！！");
		return null;
	}
	
	public String logout() throws Exception{
		this._request.getSession().removeAttribute(IComonConst.LOGIN_USER);
		this.setOutResponse(SUCCESS);
		return null;
	}
	
	public String checkUserCode() throws Exception{
		User u = service.getUserByCode(user.getUser_code());
		if (u!=null) {
			this.setOutResponse("false");
		}else{
			this.setOutResponse("true");
		}
		return null;
	}

	public String update(){
		return null;
	}
}
