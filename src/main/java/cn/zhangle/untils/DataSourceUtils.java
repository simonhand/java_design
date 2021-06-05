package cn.zhangle.untils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Classname DataSourceUtils
 * @Description TODO
 * @Date 2020/12/15 0:00
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
public class DataSourceUtils {
    // 1.	声明静态数据源成员变量
    private static DataSource ds;
    private static ThreadLocal<Connection> threadLocal;

    // 2. 创建连接池对象
    static {
        // 加载配置文件中的数据
        InputStream is = DataSourceUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties pp = new Properties();
        try {
            pp.load(is);
            // 创建连接池，使用配置文件中的参数
            ds = DruidDataSourceFactory.createDataSource(pp);
            threadLocal = new ThreadLocal<>();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3. 定义公有的得到数据源的方法
    public static DataSource getDataSource() {
        return ds;
    }

    // 4. 定义得到连接对象的方法
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    // 5.定义关闭资源的方法
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {}
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {}
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {}
        }
    }

    // 6.重载关闭方法
    public static void close(Connection conn, Statement stmt) {
        close(conn, stmt, null);
    }

    public static Connection getConnect() throws Exception{
        Connection conn = threadLocal.get();
        if (conn == null){
            conn = getDataSource().getConnection();
            threadLocal.set(conn);
        }
        return conn;
    }
    public static void startThreadLocal() throws Exception{
        Connection conn = getConnection();
        conn.setAutoCommit(false);
    }

    public static void rollback() throws Exception{
        Connection conn  =getConnect();
        conn.rollback();
    }

    public static void commit() throws Exception{
        Connection conn = getConnect();
        conn.commit();
    }
    public static void close() throws Exception{
        Connection conn = getConnect();
        conn.close();
        threadLocal.remove();
    }
}
