package org.example.mysql;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionProvider {

    Connection provideConnection() throws SQLException;
}
