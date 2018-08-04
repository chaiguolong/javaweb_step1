package cn.itheima.jdbc.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.itheima.domain.User;
import cn.itheima.jdbc.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 * 测试dbutils查询操作
 */
public class TestDBUtils2_002{

   /*
    * 查询所有用户方法
    */
   @Test
   public void testQueryAll(){
       try{
           //1.获取核心类QueryRunner
           QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
           //2.编写sql语句
           String sql = "select * from tbl_user";
           //3.执行查询操作
           List<User> users = qr.query(sql,new BeanListHandler<User>(User.class));
           //4.对结果集进行遍历
           for(User user : users){
               System.out.println(user.getUname() + ":" + user.getUpassword());
           }
       }catch(SQLException e){
           throw new RuntimeException(e);
       }
   } 


    /*
     * 根据id查询用户方法
     */
    @Test
    public void testQueryUserById(){
        try{
            //1.获取核心类QueryRunner
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            //2.编写sql语句
            String sql = "select * from tbl_user where uid = ?";
            //3.设置占位符参数
            Object[] params = {12};
            //4.执行查询操作
            User user = qr.query(sql,new BeanHandler<User>(User.class),params);
            System.out.println(user.getUname() + ":" + user.getUpassword());
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    /*
     * 查询所有用的的总个数
     */
    public void testQueryCount(){
        try{
            //1.获取核心类QueryRunner
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            //2.编写sql语句
            String sql = "select count(*) from tbl_user";
            //3.执行查询操作
            Long count = (Long)qr.query(sql,new ScalarHandler());
            System.out.println(count);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }


    /*
     * 查询所有用户方法
     */
    public void testQueryAll1(){
        try{
            //1.获取核心类QueryRunner
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            //2.编写sql语句
            String sql = "select * from tbl_user";
            //3.执行查询操作
            List<Map<String,Object>> list = qr.query(sql,new MapListHandler());
            //4.对结果集集合进行遍历
            for(Map<String,Object> map : list){
                System.out.println(map);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    /*
     * 查询所有用户方法
     */
    @Test
    public void testQueryAll2(){
        try{
            //1.获取核心类QueryRunner
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            //2.编写sql语句
            String sql = "select * from tbl_user";
            //3.执行查询操作
            List<Object> list = qr.query(sql,new ColumnListHandler("uname"));
            //4.对结果集进行遍历
            for(Object obj : list){
                System.out.println(obj);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    


}
