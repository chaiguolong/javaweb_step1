package com.itheima.transfer.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.itheima.transfer.dao.TransferDao;
import com.itheima.utils.DataSourceUtils;
import com.itheima.utils.MyDataSourceUtils;


public class TransferService_001 {
	public boolean transfer(String out,String in,double money) {
		
		TransferDao dao = new TransferDao();

		boolean isTranferSuccess = true;
		Connection conn = null;

		try {

			//开启事务
			// conn = DataSourceUtils.getConnection();
			// conn.setAutoCommit(false);
			
			//开启事务
			MyDataSourceUtils.startTransaction();

			//转出钱的方法
			dao.out(out,money);

			//转入钱的方法
			dao.in(in,money);
			
		} catch(Exception e){
			isTranferSuccess = false;
			//回滚事务
			try {
				MyDataSourceUtils.rollback();
			} catch(Exception e1){
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				MyDataSourceUtils.commit();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return isTranferSuccess;
	}

}
