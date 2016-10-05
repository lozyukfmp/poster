package com.lozyukartem.poster.pool;


import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import org.apache.commons.dbcp.cpdsadapter.DriverAdapterCPDS;
import org.apache.commons.dbcp.datasources.SharedPoolDataSource;

public class ConnectionPool {
    private static final String URL = "jdbc:mysql://localhost:3306/poster";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final int MAX_TOTAL = 10;
    private static DataSource dataSource;

    static {
        DriverAdapterCPDS cpds = new DriverAdapterCPDS();
        try {
            cpds.setDriver(DRIVER);
            cpds.setUrl(URL);
            cpds.setUser(USERNAME);
            cpds.setPassword(PASSWORD);

            SharedPoolDataSource pool = new SharedPoolDataSource();
            pool.setConnectionPoolDataSource(cpds);
            pool.setMaxActive(MAX_TOTAL);
            dataSource = pool;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
