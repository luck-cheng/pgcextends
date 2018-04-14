package com.ponloo.extend.repository;

import com.ponloo.extend.model.T_S_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/7/17.
 */
@Repository
public interface UserRepository extends JpaRepository<T_S_User, Long>, JpaSpecificationExecutor {
    @Query("select u from T_S_User u where u.username=?1")
    T_S_User findUserByUName(String username);
}
