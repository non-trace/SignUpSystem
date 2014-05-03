/**
 * 
 */
package cn.edu.tstc.test.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.edu.tstc.common.dao.BaseDao;

/**
 * ��Ŀ���ƣ�SignUpSystem
 * �����ƣ�TestDao
 * ������:
 * �����ˣ�Ҧ��Ф   
 * ����ʱ�䣺2014-5-2 ����5:14:01   
 * �޸��ˣ�Ҧ��Ф  
 * �޸�ʱ�䣺2014-5-2 ����5:14:01    
 * �޸ı�ע��   
 * @version
 */
@Repository
public class TestDao extends BaseDao implements ITestDao {
	public List<Map<String,Object>>testDao(){
		StringBuffer sqlbBuffer = new StringBuffer();
		sqlbBuffer.append("select * from t_user");
		return this.queryForList(sqlbBuffer.toString());
	}
}
