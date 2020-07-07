package com.example.krpano.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

@Configuration
public class DruidDBConfig {

    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.maxActive}")
    private int maxActive;
    @Value("${spring.datasource.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.maxIdle}")
    private int maxIdle;

    @Value("${spring.datasource.minIdle}")
    private int minIdle;

    @Value("${spring.datasource.maxWait}")
    private int maxWait;

    @Value("${spring.datasource.logAbandoned}")
    private Boolean logAbandoned;

    @Value("${spring.datasource.removeAbandoned}")
    private boolean removeAbandoned;

    @Value("${spring.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${spring.datasource.removeAbandonedTimeout}")
    private int removeAbandonedTimeout;

    @Value("${spring.datasource.numTestsPerEvictionRun}")
    private int numTestsPerEvictionRun;

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private long timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private long minEvictableIdleTimeMillis;


    @Bean
    @Primary
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();

        datasource.setUrl(dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        //<!-- 获取连接最大等待时间 -->
        datasource.setMaxWait(maxWait);
        //<!--maxActive: 最大连接数量 -->
        datasource.setMaxActive(maxActive);
        //<!--initialSize: 初始化连接 -->
        datasource.setInitialSize(initialSize);
        ArrayList<String> connectionInitSqls = new ArrayList<>();
        connectionInitSqls.add("SET SESSION TRANSACTION ISOLATION LEVEL READ COMMITTED");
        datasource.setConnectionInitSqls(connectionInitSqls);
        datasource.setMinIdle(minIdle);
        //<!-- 配置一个连接在池中最小生存的时间，单位是毫秒 -->
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        //<!-- 开启池的prepared statement 池功能 -->
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        //<!-- 超过removeAbandonedTimeout时间后，是否进行没用连接（废弃）的回收（默认为false) -->
        datasource.setRemoveAbandoned(removeAbandoned);
        //<!-- 超过时间限制，回收没有用(废弃)的连接（单位秒，默认为 300秒，5分钟） -->
        datasource.setRemoveAbandonedTimeout(removeAbandonedTimeout);
        //<!--每次检查链接的数量，建议设置和maxActive一样大，这样每次可以有效检查所有的链接.(默认为3个) -->
        datasource.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
        //<!--关闭abanded连接时输出错误日志-- >
        datasource.setLogAbandoned(logAbandoned);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        return datasource;
    }

    /**
     * 避免项目启动即终止
     *
     * @return
     */
    @Bean
    public CountDownLatch closeLatch() {
        return new CountDownLatch(1);
    }

}