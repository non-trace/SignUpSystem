/**
 * 
 */
package cn.edu.tstc.common.dao;

import java.util.List;
import java.util.Map;
public interface IBaseDao {
	public List<Map<String,Object>> queryForList(String sql);
	public void execute(String sql);
}
