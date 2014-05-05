/**
 * 
 */
package cn.edu.tstc.dao;

import java.util.List;

import cn.edu.tstc.entity.MyClass;
import cn.edu.tstc.entity.User;
public interface IClassDao {
	public List<MyClass> getSelectedClass(User user) throws Exception;
	public List<MyClass> getSelectableClass(User user) throws Exception;
	public void selectClass(User user,String[] classes) throws Exception;
}
