/**
 * 
 */
package cn.edu.tstc.service;

import cn.edu.tstc.entity.User;

/**
 * 项目名称：SignUpSystem
 * 类名称：IUserService
 * 类描述:
 * 创建人：姚洪肖   
 * 创建时间：2014-5-3 下午3:44:32   
 * 修改人：姚洪肖  
 * 修改时间：2014-5-3 下午3:44:32    
 * 修改备注：   
 * @version
 */

public interface IUserService {
	public User login(User user) throws Exception ;
	public void regist(User user);
	public User getUserByCode(String userCode) throws Exception;
	public void update(User user);
}
