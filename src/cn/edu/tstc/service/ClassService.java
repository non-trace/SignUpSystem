/**
 * 
 */
package cn.edu.tstc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.tstc.common.service.BaseService;
import cn.edu.tstc.dao.IClassDao;
import cn.edu.tstc.entity.MyClass;
import cn.edu.tstc.entity.User;
@Service
public class ClassService extends BaseService implements IClassService{
	@Resource
	private IClassDao dao;
	@Override
	public List<MyClass> getSelectClass(User user) throws Exception {
		return dao.getSelectedClass(user);
	}
	@Override
	public List<MyClass> getSelectableClass(User user) throws Exception {
		return dao.getSelectableClass(user);
	}
	@Override
	public void selectClass(User user,String[] classes) throws Exception {
		dao.selectClass(user, classes);
	}
}
