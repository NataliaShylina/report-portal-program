package org.example.base.mysql;

import dev.failsafe.internal.util.Assert;
import org.example.mysql.ConnectionProvider;
import org.example.mysql.SimpleConnectionProvider;
import org.example.mysql.dao.LaunchDao;
import org.example.mysql.dao.LaunchDaoImpl;
import org.example.mysql.entity.Launch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class DatabaseTest {
    ConnectionProvider connectionProvider = new SimpleConnectionProvider("database.properties");

    LaunchDao launchDao = new LaunchDaoImpl(connectionProvider);


    @Test
    void testFindById() {
        Launch actualLaunch = launchDao.findById(1).get();
        Launch expectedLaunch = Launch.builder()
                .id(1)
                .name("Demo Api Tests#1")
                .total(10)
                .passed(1)
                .skipped(0)
                .failed(9)
                .build();
        Assertions.assertEquals(actualLaunch, expectedLaunch);
    }
    @Test
    void testFindAll(){
        List<Launch> launches = launchDao.findAll();

        Assertions.assertEquals(3, launches.size());
    }
}
