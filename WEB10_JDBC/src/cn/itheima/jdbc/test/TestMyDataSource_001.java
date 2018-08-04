package cn.itheima.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import cn.itheima.jdbc.DataSource.MyDataSource;

public class TestMyDataSource_001{

    /**
     * 添加用户
     * 使用未造过的connection
     */
    @Test
    public void testAddUser(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        //1.创建自定义连接池对象
        MyDataSource dataSource = new MyDataSource();
        try{
            //2.从池子中获取连接
            conn = dataSource.getConnection();
            String sql = "insert into tbl_user values(null,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"吕布");
            pstmt.setString(2,"貂蝉");
            int rows = pstmt.executeUpdate();
            if(rows > 0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            dataSource.backConnection(conn);
        }
    }

}
