package com.toy.common.config.context;

import com.toy.common.mapper.SqlSessionMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import javax.sql.DataSource;


@Configuration
public class MapperConfig {

    private static final String DEFAULT_SQL_MAPPER_LOCATION = "/mapper/**/*.xml";

    @Bean
    public SqlSessionFactory sqlSessionFactory(ApplicationContext context, DataSource dataSource){
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
            configuration.setCacheEnabled(false);
            configuration.setLazyLoadingEnabled(true);
            configuration.setMapUnderscoreToCamelCase(true);
//            defaultStatementTimeout = App.getConfig("mapper.sql.timout", "${DEFAULT_SQL_MAPPER_TIMEOUT}").toInt()
            //--------------------------------------------------------------------------------
//        configuration.addInterceptor(LoggingInterceptor())
        //--------------------------------------------------------------------------------
        try {
            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
            factoryBean.setDataSource(dataSource);
            factoryBean.setConfiguration(configuration);
            factoryBean.setMapperLocations(context.getResources(ResourceUtils.CLASSPATH_URL_PREFIX + DEFAULT_SQL_MAPPER_LOCATION));
            //--------------------------------------------------------------------------------
            return factoryBean.getObject();
        }
        catch (Exception ex) {
            throw new RuntimeException("SQLMapper initialize fail.", ex);
        }
    }


    @Bean
    public SqlSessionMapper sqlSessionMapper(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionMapper(sqlSessionFactory);
    }

}
