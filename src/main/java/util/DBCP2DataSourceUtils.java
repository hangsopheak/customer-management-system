package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;



public class DBCP2DataSourceUtils {
    private static BasicDataSource ds = null;
    
    static {
        String propsFile = "db.properties";
        Properties props = new Properties();
        try {
            props.load(Thread.currentThread().getContextClassLoader().getResource(propsFile).openStream());
            System.out.println(props);
            ds = BasicDataSourceFactory.createDataSource(props);
           
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
            props = null;
        }
    }
    /**get connection from pool*/
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    
    public static DataSource getDataSource() {
        return ds;
    }
    public static void printDataSourceState() {
        System.out.println("NumActive: " + ds.getNumActive());
        System.out.println("NumIdle: " + ds.getNumIdle());
    }
  
}
