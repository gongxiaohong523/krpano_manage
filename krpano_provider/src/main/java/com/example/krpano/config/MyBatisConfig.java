package com.example.krpano.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

/**
 * 配置MyBatis
 *
 * @author luohao
 * @date 2019/3/8 11:24
 */
@Configuration
@AutoConfigureAfter(DruidDBConfig.class)
@MapperScan("com.example.krpano.mapper")
public class MyBatisConfig {

    @Value("classpath:mybatis/mybatis-config.xml")
    private Resource mybatisConfig;
    @Value("classpath:mapper/*/*.xml")
    private Resource[] mapperLocations;

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource mysqlDataSource){
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(mysqlDataSource);
        sessionFactoryBean.setConfigLocation(mybatisConfig);
        sessionFactoryBean.setMapperLocations(mapperLocations);
        return sessionFactoryBean;
    }

}
