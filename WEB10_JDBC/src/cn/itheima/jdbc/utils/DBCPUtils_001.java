package cn.itheima.jdbc.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBCPUtils_001{
    private static DataSource dataSource;
    static{
        try{
            //1.加载找properties文件输入流
            InputStream is = DBCPUtils_001.class.getClassLoader().getResourceAsStream("db.properties");
            //2.加载输入流
            Properties pro = new Properties();
            pro.load(is);
            //3.创建数据源
            dataSource = BasicDataSourceFactory.createDataSource(pro);
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
