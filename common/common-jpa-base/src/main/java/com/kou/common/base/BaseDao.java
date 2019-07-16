package com.kou.common.base;

import com.kou.common.util.vo.Page;
import com.kou.common.util.vo.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Map;

@NoRepositoryBean
public interface BaseDao<T> extends JpaRepository<T,Long> {

    /**
     *  SQL 计数
     */
    long nativeCount(String sql, Map<String, Object> params);

    /**
     * SQL 查询全部
     */
    <E> List<E> nativeFindAll(String sql, Map<String, Object> params, Class<E> domainClazz);

    /**
     * SQL 查询单个
     */
    <E> E nativeFindOne(String sql, Map<String, Object> params, Class<E> domainClazz);


    /**
     * SQL 查询分页
     */
    <E> Page<E> nativeFindPage(String sql, Map<String, Object> params, Class<E> domainClazz, Pageable pageable);

    /**
     *  只保存非空字段
     */
    T saveNotNull(T t);

    /**
     * Returns a reference to the entity with the given identifier.
     *
     * @param id must not be {@literal null}.
     * @return a reference to the entity with the given identifier.
     */
    @Override
    T getOne(Long id);
}
