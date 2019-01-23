package com.whiteDream.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.whiteDream.entity.MessageInfo;
import com.whiteDream.utils.DataSourceUtils;

public class MessageBoardDao {
	public int addMessage(MessageInfo m) throws SQLException{
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into MessageInfo (message)values (?)";
		int update = runner.update(sql,m.getMessage());
		return update;
	}

	public List<MessageInfo> findListNewMessage() throws SQLException{
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "SELECT message,DATE_FORMAT(mtime,'%Y-%m-%d') as mtime FROM MessageInfo ORDER BY mtime desc limit 0,10";
		List<MessageInfo> messagelist = runner.query(sql,new BeanListHandler<MessageInfo>(MessageInfo.class));
		return messagelist;
	}
}
