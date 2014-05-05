/**
 * 
 */
package cn.edu.tstc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.edu.tstc.common.dao.BaseDao;
import cn.edu.tstc.entity.MyClass;
import cn.edu.tstc.entity.User;
@Repository
public class ClassDao extends BaseDao implements IClassDao {
	@Override
	public List<MyClass> getSelectedClass(User user) throws Exception {
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append(" select c.* from t_class c , t_user_class_rel r where r.class_id = c.class_id and r.user_id = '").append(user.getUser_id()).append("' ");
		List<Map<String, Object>> l = this.queryForList(sqlBuffer.toString());
		if (l!=null&&l.size()>0) {
			List<MyClass> myClasses = new ArrayList<MyClass>();
			for (Map<String, Object> map : l) {
				MyClass c = new MyClass();
				c.setClassID(Integer.parseInt(map.get("class_id").toString()));
				c.setClassName(map.get("class_name").toString());
				c.setTeacher(map.get("teacher").toString());
				c.setClass_hour(Integer.parseInt(map.get("class_hour").toString()));
				myClasses.add(c);
			}
			return myClasses;
		}
		return null;
	}
	@Override
	public List<MyClass> getSelectableClass (User user) throws Exception {
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append(" select * from t_class c where c.class_id not in (select class_id from t_user_class_rel r where r.user_id = '").append(user.getUser_id()).append("') ");
		List<Map<String, Object>> l = this.queryForList(sqlBuffer.toString());
		if (l!=null&&l.size()>0) {
			List<MyClass> myClasses = new ArrayList<MyClass>();
			for (Map<String, Object> map : l) {
				MyClass c = new MyClass();
				c.setClassID(Integer.parseInt(map.get("class_id").toString()));
				c.setClassName(map.get("class_name").toString());
				c.setTeacher(map.get("teacher").toString());
				c.setClass_hour(Integer.parseInt(map.get("class_hour").toString()));
				myClasses.add(c);
			}
			return myClasses;
		}
		return null;
	}
	
	public void selectClass(User user,String[] classes) throws Exception {
		StringBuffer sqlBuffer = new StringBuffer();
		for (int i = 0; i < classes.length; i++) {
			String class_id = classes[i];
			if (class_id!=null&&!"".equals(class_id)) {
				sqlBuffer.setLength(0);
				sqlBuffer.append("INSERT INTO t_user_class_rel ( user_id , class_id ) VALUES (").append(user.getUser_id()).append(", ").append(class_id).append(")");
				this.execute(sqlBuffer.toString());
			}
		}
	}
}
