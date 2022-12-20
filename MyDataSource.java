package LeetCode.ywf.JavaCourseDesign;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;




public class MyDataSource implements DataSource {

    private LinkedList<Connection> dataSources = new LinkedList<Connection>();

    public MyDataSource() {
        // 一次性创建10个连接
        for (int i = 0; i < 10; i++) {
            try {
                Connection connection = SqlUtil.getConnection();
                // 将连接加入到连接池中
                dataSources.add(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }


    public void releaseConnection(Connection conn) {
        dataSources.add(conn);
        System.out.println("将连放回到连接池中，数量" + dataSources.size());
    }

    @Override
    public Connection getConnection() throws SQLException {
        // 取出连接池中的一个连接
        final Connection connection = dataSources.removeFirst();// 删除第一个连接并返回
        System.out.println("取出一个连接，剩余" + dataSources.size() + "个连接");
        // 将目标connection对象进行增强
        Connection connProxy = (Connection) Proxy.newProxyInstance(connection
                .getClass().getClassLoader(), connection.getClass()
                .getInterfaces(), new InvocationHandler() {

            //执行代理对象的任何方法都将执行invoke方法
            @Override
            public Object invoke(Object proxy, Method method, Object[] args)
                    throws Throwable {
                //只需要增强close方法
                if(method.getName().equals("close")){
                    //需要增强的方法
                    //不将连接真正关闭，将连接放回连接池
                    releaseConnection(connection);
                    return null;
                }else{
                    //不需要增强的方法，保持方法原有的功能即可
                    return method.invoke(connection, args);
                }
            }
        });
        return connProxy;
    }

    @Override
    public Connection getConnection(String username, String password)
            throws SQLException {
        return null;
    }
}