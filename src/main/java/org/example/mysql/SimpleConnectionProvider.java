package org.example.mysql;

import org.example.reader.PropertyReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionProvider implements ConnectionProvider {

    private final String userName;
    private final String password;
    private final String url;


    public SimpleConnectionProvider(String propertyFileName) {
        PropertyReader propertyReader = new PropertyReader(propertyFileName);
        this.userName = propertyReader.getProperty("db.user.name");
        this.password = propertyReader.getProperty("db.user.password");
        this.url = propertyReader.getProperty("db.url");
    }

    @Override
    public Connection provideConnection() throws SQLException {
        return DriverManager.getConnection(url, userName, password);
    }
}
