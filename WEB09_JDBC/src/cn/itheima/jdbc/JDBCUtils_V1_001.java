package cn.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * 提供获取连接和释放资源的方法
 */
public class JDBCUtils_V1_001{
    public static void main(String[] args){
        Connection con = JDBCUtils_V1_001.getConnection();
        System.out.println(1111);
    }

    /**
     *
     * 获取连接的方法
     */
    public static Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web08","root","mysql");
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public static void release(Connection conn,PreparedStatement pstmt, ResultSet rs){
        if(rs != null){
            try{
                rs.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        if (pstmt != null){
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

