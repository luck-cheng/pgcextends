package com.ponloo.extend.repository;

import com.ponloo.extend.model.T_D_YKeyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/7/16.
 */
@Repository
public interface YKeyDataRepository extends JpaRepository<T_D_YKeyData, Long>, JpaSpecificationExecutor {
}
