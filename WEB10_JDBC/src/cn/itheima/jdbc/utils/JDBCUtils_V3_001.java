package cn.itheima.jdbc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * 提供获取连接和释放连接的放啊
 */
public class JDBCUtils_V3_001{
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    /**
     * 静态代码块加载配置文件信息
     */
    static{
        try{
            //1.通过当前类获取类加载器
            ClassLoader classLoader = JDBCUtils_V3_001.class.getClassLoader();
            //2.通过类加载器的方法获得一个输入流
            InputStream is = classLoader.getResourceAsStream("db.Properties");
            //3.创建一个properties对象
            Properties pro = new Properties();
            //4.加载输入流
            pro.load(is);
            //5.获取相关参数设置
            driver = pro.getProperty("driver");
            url = pro.getProperty("url");
            username = pro.getProperty("username");
            password = pro.getProperty("password");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 获取连接方法
     */
    public static Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 释放资源方法
     */
    public static void release(Connection conn, PreparedStatement pstmt, ResultSet rs){
        if(rs != null){
            try{
                rs.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }

        if(pstmt != null){
            try{
                pstmt.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }

        if(conn != null){
            try{
                conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }


}
