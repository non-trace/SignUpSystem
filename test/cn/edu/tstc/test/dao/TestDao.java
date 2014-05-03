/**
 * 
 */
package cn.edu.tstc.test.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.edu.tstc.common.dao.BaseDao;

/**
 * 项目名称：SignUpSystem
 * 类名称：TestDao
 * 类描述:
 * 创建人：姚洪肖   
 * 创建时间：2014-5-2 下午5:14:01   
 * 修改人：姚洪肖  
 * 修改时间：2014-5-2 下午5:14:01    
 * 修改备注：   
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
