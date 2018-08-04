package cn.itheima.jdbc.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBCPUtils_002{
    private static DataSource dataSource;
    
    static{
        try{
            //1.加载properties文件输入流
            InputStream is  = DBCPUtils.class.getClassLoader().getResourceAsStream("db.Properties");
            //2.加载输入流
            Properties props = new Properties();
            props.load(is);
            //创建数据源
            dataSource = BasicDataSourceFactory.createDataSource(props);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public static DataSource getDataSource(){
        return dataSource;
    }

    public static Connection getConnection(){
        try{
            return dataSource.getConnection();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

}
