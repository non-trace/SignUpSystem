/**
 * 
 */
package cn.edu.tstc.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.edu.tstc.common.dao.BaseDao;
import cn.edu.tstc.entity.User;

/**
 * 项目名称：SignUpSystem
 * 类名称：UserDao
 * 类描述:
 * 创建人：姚洪肖   
 * 创建时间：2014-5-3 下午3:51:32   
 * 修改人：姚洪肖  
 * 修改时间：2014-5-3 下午3:51:32    
 * 修改备注：   
 * @version
 */
@Repository
public class UserDao extends BaseDao implements IUserDao {
	@Override
	public User findUserByUserCode(String user_code) throws ParseException {
		StringBuffer sqlbBuffer = new StringBuffer();
		sqlbBuffer.append("select * from t_user u where u.user_code ='").append(user_code).append("'");
		List<Map<String, Object>> l = this.queryForList(sqlbBuffer.toString());
		if (l!=null&&!l.isEmpty()) {
			Map<String, Object> userMap = l.get(0);
			User user = new User();
			user.setAge(userMap.get("age")==null?0:Integer.parseInt(userMap.get("age").toString()));
			user.setBirthday(userMap.get("birthday")!=null?new SimpleDateFormat("yyyy-MM-dd").parse(userMap.get("birthday").toString()):new Date());
			user.setIdcard(userMap.get("idcard")==null?"":userMap.get("idcard").toString());
			user.setMd5Password(userMap.get("user_password").toString());
			user.setMobile(userMap.get("mobile")==null?"":userMap.get("mobile").toString());
			user.setSex(userMap.get("sex")==null?"":userMap.get("sex").toString());
			user.setTel(userMap.get("tel")==null?"":userMap.get("tel").toString());
			user.setUser_code(userMap.get("user_code")==null?"":userMap.get("user_code").toString());
			user.setUser_name(userMap.get("user_name")==null?"":userMap.get("user_name").toString());
			user.setEmail(userMap.get("Email")==null?"":userMap.get("Email").toString());
			return user;
		}
		return null;
	}
	@Override
	public void insertUser(User user) {
		StringBuffer sqlbBuffer = new StringBuffer();
		sqlbBuffer.append(" insert into t_user ( user_name , user_code , user_password , sex , birthday , Email , idcard , mobile , age ) values ('")
		.append(user.getUser_name()).append("','")
		.append(user.getUser_code()).append("','")
		.append(user.getPassword()).append("','")
		.append(user.getSex()).append("','")
		.append(new SimpleDateFormat("yyyy-MM-dd").format(user.getBirthday())).append("','")
		.append(user.getEmail()).append("','")
		.append(user.getIdcard()).append("','")
		.append(user.getMobile()).append("','")
		.append(user.getAge()).append("')");
		this.execute(sqlbBuffer.toString());
	}
	/* (non-Javadoc)
	 * @see cn.edu.tstc.dao.IUserDao#updateUser(cn.edu.tstc.entity.User)
	 */
	@Override
	public void updateUser(User user) {
		StringBuffer sqlbBuffer = new StringBuffer();
		sqlbBuffer.append("update t_user set ");
		sqlbBuffer.append("user_code = '").append(user.getUser_code()).append("',");
		if (user.getUser_name()!=null&&!"".equals(user.getUser_name())) {
			sqlbBuffer.append("user_name = '").append(user.getUser_name()).append("',");
		}
		if (user.getUser_name()!=null&&!"".equals(user.getUser_name())) {
			sqlbBuffer.append("user_name = '").append(user.getUser_name()).append("',");
		}
	}
}
