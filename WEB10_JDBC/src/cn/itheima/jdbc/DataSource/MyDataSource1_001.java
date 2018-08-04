package cn.itheima.jdbc.DataSource;

import cn.itheima.jdbc.utils.JDBCUtils_V3;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;
import javax.sql.DataSource;

public class MyDataSource1_001 implements DataSource{
    //创建1个容器用于存储Connection对象
    private static LinkedList<Connection> pool = new LinkedList<Connection>();

    //2.创建5个连接放到容器中欧去
    static{
        for(int i = 0 ; i < 5; i++){
            Connection conn = JDBCUtils_V3.getConnection();
            //放入池子中的Connection对象已经改造过了
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Connection getConnection(String string1, String string2) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isWrapperFor(Class<?> inter) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setLoginTimeout(int i) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setLogWriter(PrintWriter printWriter) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T unwrap(Class<T> inter) throws SQLException {
        throw new UnsupportedOperationException();
    }
}
