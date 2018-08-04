package cn.itheima.jdbc.test;

import java.sql.SQLException;

import org.junit.Test;

import cn.itheima.jdbc.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;

/**
 * 测试DBUtils工具类的增删改查操作
 */
public class TestDBUtils1_001{

    /**
     * 添加新用户的方法
     */
    @Test
    public void testAddUser(){
        try{
            //1.创建核心类QueryRunner
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            //2.创建sql语句
            String sql = "insert into tbl_user values(null,?,?)";
            //3.设置参数
            Object[] params = {"小青","旺财"};
            //4.执行语句
            int rows = qr.update(sql,params);
            if(rows > 0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }






    /**
     * 根据id修改用户方法
     */
    @Test
    public void testUpdateUserById(){
        try{
            //1.创建核心类QueryRunner
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            //2.创建sql语句
            String sql = "update tbl_user set upassword = ? where uid = ?";
            //3.设置参数
            Object[] params = {"xxx",15};
            //4.执行修改操作
            int rows = qr.update(sql,params);
            if(rows > 0){
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }
            }catch(SQLException e){
                e.printStackTrace();
            }
    }

    /**
     * 根据id删除用户方法
     */
    @Test
    public void testDeleteUserById(){
        try{
            //1.创建核心类QueryRunner
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            //2.编写sql语句
            String sql = "delete from tbl_user where uid = ?";
            //3.为占位符设置值
            Object[] params = {10};
            //4.执行添加操作
            int rows = qr.update(sql,params);
            if(rows > 0){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
