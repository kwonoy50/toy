package com.toy.common.mapper;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class SqlSessionMapper extends SqlSessionDaoSupport {

    public SqlSessionMapper(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public <P> int insert(String mapperId, P param) {
        return getSqlSession().insert(mapperId, param);
    }

    public <P> int update(String mapperId, P param) {
        return getSqlSession().update(mapperId, param);
    }

    public <P> int delete(String mapperId, P param) {
        return getSqlSession().delete(mapperId, param);
    }

    public <R> R select(String mapperId) {
        return this.select(mapperId, null);
    }

    public <R, P> R select(String mapperId , P param) {
        return this.getSqlSession().selectOne(mapperId, param);
    }

    public <R> List<R> selectList(String mapperId) {
        return this.selectList(mapperId, null);
    }

    public <R, P> List<R> selectList(String mapperId, P param) {
        return this.getSqlSession().selectList(mapperId, param);
    }

}
