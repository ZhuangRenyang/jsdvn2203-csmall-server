package cn.tedu.jsdvn2203.csmall.server;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@Slf4j
@SpringBootTest
public class DatabaseConnectionTests {
    @Autowired
    DataSource dataSource;
    @Test
    public void testConnection() throws SQLException {
        dataSource.getConnection();
        log.info("当你看到这句话时,表示application.properties中的配置连接参数是没有问题的");
    }
}
