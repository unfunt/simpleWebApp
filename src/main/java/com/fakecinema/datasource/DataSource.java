package com.fakecinema.datasource;

import com.mchange.v2.c3p0.*;
import com.fakecinema.helper.PropertiesSingleton;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Vova on 01.04.2019.
 */
public class DataSource {

    private static DataSource dataSource = null;
    private ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

    private DataSource () {
        initializePool();
    }

    public static DataSource getInstance () {
        if (dataSource == null) {
            dataSource = new DataSource();
        }
        return dataSource;
    }

    private void initializePool() {
        PropertiesSingleton propertiesSingleton = PropertiesSingleton.getInstance();
        try {
            comboPooledDataSource.setDriverClass(propertiesSingleton.getDriver());
            comboPooledDataSource.setJdbcUrl(propertiesSingleton.getJdbcUrl());
            comboPooledDataSource.setUser(propertiesSingleton.getUser());
            comboPooledDataSource.setPassword(propertiesSingleton.getPassword());
            comboPooledDataSource.setMaxStatements(180);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection () {
        Connection connection = null;
        try {
            connection = comboPooledDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
