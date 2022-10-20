package cn.tedu.jsdvn2203.csmall.server;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
public class DatabaseConnectionTests {
    @Autowired
    DataSource dataSource;
    @Test
    public void testConnection() throws SQLException {
        dataSource.getConnection();
        System.out.println("当你看到这句话时,表示application.properties中的配置连接参数是没有问题的");
    }
}
