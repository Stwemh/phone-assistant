package com.tzh.Dao;

import com.tzh.entity.AppVersion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author TangZongHua
 * @date 2020/10/14
 * @description
 */
public interface AppVersionDao extends JpaRepository<AppVersion, Long> {
}
