package com.ssgl.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatasourceConfig {
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DruidDataSource dataSource() {
        return new DruidDataSource();
    }
}
