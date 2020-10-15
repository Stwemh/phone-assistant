package com.tzh.Dao;


import com.tzh.entity.App;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author TangZongHua
 * @date 2020/10/15
 * @description:
 */
public interface AppDao extends JpaRepository<App, Long> {
}
