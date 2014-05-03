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
 * 项目名称：SignUpSystem
 * 类名称：TestService
 * 类描述:
 * 创建人：姚洪肖   
 * 创建时间：2014-5-2 下午5:10:25   
 * 修改人：姚洪肖  
 * 修改时间：2014-5-2 下午5:10:25    
 * 修改备注：   
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
