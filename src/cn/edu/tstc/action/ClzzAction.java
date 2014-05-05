/**
 * 
 */
package cn.edu.tstc.action;

import javax.annotation.Resource;

import cn.edu.tstc.common.action.BaseAction;
import cn.edu.tstc.common.constants.IComonConst;
import cn.edu.tstc.entity.User;
import cn.edu.tstc.service.IClassService;

/**
 * 项目名称：SignUpSystem
 * 类名称：TestTestAction
 * 类描述:
 * 创建人：姚洪肖   
 * 创建时间：2014-5-5 下午11:09:21   
 * 修改人：姚洪肖  
 * 修改时间：2014-5-5 下午11:09:21    
 * 修改备注：   
 * @version
 */

public class ClzzAction extends BaseAction{
	@Resource
	private IClassService service;
	private String classes;
	
	/**
	 * @param classes the classes to set
	 */
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public String getSelectedClass() throws Exception{
		setOutGridJson(service.getSelectClass((User)this._request.getSession().getAttribute(IComonConst.LOGIN_USER)));
		return null;
	}
	public String getSelectableClass() throws Exception{
		setOutGridJson(service.getSelectableClass((User)this._request.getSession().getAttribute(IComonConst.LOGIN_USER)));
		return null;
	}
	
	public String selectClass() throws Exception{
		String[] carr = classes.split(",");
		service.selectClass((User)this._request.getSession().getAttribute(IComonConst.LOGIN_USER), carr);
		this.setOutResponse("success");
		return null;
	}
}
