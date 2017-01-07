package com.zzx;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;

@SpringBootApplication
public class WeixinXcxApplication extends SpringBootServletInitializer implements EnvironmentAware {

    private RelaxedPropertyResolver propertyResolver;

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WeixinXcxApplication.class);
    }
    
    @Override
    public void setEnvironment(Environment env) {
        this.propertyResolver = new RelaxedPropertyResolver(env, "spring.datasource.");
    }
    
    @Bean(destroyMethod = "close", initMethod = "init")
    public DataSource writeDataSource() {
        System.out.println("注入druid！！！");
        
       
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(propertyResolver.getProperty("url"));
        dataSource.setUsername(propertyResolver.getProperty("username"));//用户名
        dataSource.setPassword(propertyResolver.getProperty("password"));//密码
        dataSource.setDriverClassName(propertyResolver.getProperty("driver-class-name"));
        dataSource.setInitialSize(2);
        dataSource.setMaxActive(20);
        dataSource.setMinIdle(0);
        dataSource.setMaxWait(60000);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(false);
        dataSource.setTestWhileIdle(true);
        dataSource.setPoolPreparedStatements(false);
        return dataSource;
    }
    
    /**
     * Main Start
     */
    public static void main(String[] args) {
        SpringApplication.run(WeixinXcxApplication.class, args);
    }
}
