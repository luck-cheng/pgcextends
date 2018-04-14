package com.ponloo.extend.repository;

import com.ponloo.extend.model.T_D_OverView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/7/14.
 */
@Repository
public interface OverViewRepository extends JpaRepository<T_D_OverView, Long>, JpaSpecificationExecutor {
}
