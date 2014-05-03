/**
 * 
 */
package cn.edu.tstc.test.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.tstc.common.service.BaseService;
import cn.edu.tstc.test.dao.ITestDao;

/**
 * ��Ŀ���ƣ�SignUpSystem
 * �����ƣ�TestService
 * ������:
 * �����ˣ�Ҧ��Ф   
 * ����ʱ�䣺2014-5-2 ����5:10:25   
 * �޸��ˣ�Ҧ��Ф  
 * �޸�ʱ�䣺2014-5-2 ����5:10:25    
 * �޸ı�ע��   
 * @version
 */
@Service
public class TestService extends BaseService implements ITestService{
	@Resource
	private ITestDao dao;
	public List<Map<String,Object>> testService(){
		return dao.testDao();
	}
}
