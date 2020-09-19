package com.toy.common.config.context;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        //----------------------------------------------------------------------------------------------------
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setJdbcUrl("jdbc:h2:mem:testdb;DB_CLOSE_ON_EXIT=FALSE;");
        dataSource.setUsername("sa");
        dataSource.setPassword("sa");
        dataSource.setMinimumIdle(2);
        dataSource.setMaximumPoolSize(4);
        dataSource.setAutoCommit(false);
        //--------------------------------------------------------------------------------
        // init script
        //--------------------------------------------------------------------------------
//        dataSource.setSchema("database/schema.sql");
        String initSchemaFile = "database/schema.sql";
//        String initDataFile = "database/data.sql";
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        //----------------------------------------------------------------------------------------------------
        databasePopulator.addScript(new ClassPathResource(initSchemaFile));
        databasePopulator.execute(dataSource);
        //----------------------------------------------------------------------------------------------------
//        databasePopulator.addScript(new ClassPathResource(initDataFile));
//        databasePopulator.execute(dataSource);
        //----------------------------------------------------------------------------------------------------
        return dataSource;
    }

}
