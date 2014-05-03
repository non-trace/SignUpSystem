/**
 * 
 */
package cn.edu.tstc.dao;

import java.text.ParseException;

import cn.edu.tstc.entity.User;

/**
 * 项目名称：SignUpSystem
 * 类名称：IUserDap
 * 类描述:
 * 创建人：姚洪肖   
 * 创建时间：2014-5-3 下午3:46:12   
 * 修改人：姚洪肖  
 * 修改时间：2014-5-3 下午3:46:12    
 * 修改备注：   
 * @version
 */

public interface IUserDao {
	public User findUserByUserCode(String user_code) throws ParseException ;
	public void insertUser(User user);
	public void updateUser(User user);
}
