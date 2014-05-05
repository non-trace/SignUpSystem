package cn.edu.tstc.service;

import java.util.List;

import cn.edu.tstc.entity.MyClass;
import cn.edu.tstc.entity.User;
public interface IClassService {
	public List<MyClass> getSelectClass(User user)throws Exception ;
	public List<MyClass> getSelectableClass(User user)throws Exception ;
	public void selectClass(User user,String[] classes) throws Exception ;
}
