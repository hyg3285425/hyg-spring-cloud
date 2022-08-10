package com.yunnk.springcloudproject.dao;

import com.yunnk.springcloudproject.entity.SpringDataTest;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author huangyigang
 */
public interface TestDao extends JpaRepository<SpringDataTest,Integer> {

}
