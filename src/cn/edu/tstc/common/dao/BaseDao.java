package cn.edu.tstc.common.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
@Repository
public class BaseDao extends JdbcDaoSupport implements IBaseDao{
	public List<Map<String, Object>> queryForList(String sql){
		return this.getJdbcTemplate().queryForList(sql);
	}
	public void execute(String sql){
		this.getJdbcTemplate().execute(sql);
	}
}