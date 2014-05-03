/**
 * 
 */
package cn.edu.tstc.service;

import java.text.ParseException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.tstc.common.service.BaseService;
import cn.edu.tstc.dao.IUserDao;
import cn.edu.tstc.entity.User;

/**
 * 项目名称：SignUpSystem
 * 类名称：UserService
 * 类描述:
 * 创建人：姚洪肖   
 * 创建时间：2014-5-3 下午3:45:25   
 * 修改人：姚洪肖  
 * 修改时间：2014-5-3 下午3:45:25    
 * 修改备注：   
 * @version
 */
@Service
public class UserService extends BaseService implements IUserService{
	@Resource
	private IUserDao dao;
	@Override
	public User login(User user) throws Exception {
		User u = dao.findUserByUserCode(user.getUser_code());
		if(u!=null){
			if (u.getPassword().equals(user.getPassword())) {
				return u;
			}
		}
		return null;
	}
	
	@Override
	public void regist(User user) {
		dao.insertUser(user);
	}
	
	@Override
	public User getUserByCode(String userCode) throws Exception {
		return dao.findUserByUserCode(userCode);
	}

	@Override
	public void update(User user) {
		
	}
}
