package com.tzh.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tzh.constant.AppStatus;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.util.StringUtils;

import javax.persistence.*;

/**
 * @author TangZongHua
 * @date 2020/10/15
 * @description: 版本实体类
 */
@Entity
@Data
public class AppVersion {
    @Id
    @GeneratedValue
    private Long id;

    /**
     * app的版本号
     */
    @Column
    private String versionNumber;

    /**
     * 该版本的描述
     */
    @Column
    private String description;

    /**
     * app的状态(上传,审核,上架)
     */
    @Column
    private String status = AppStatus.UNCHECK;

    /**
     * 资源路径
     */
    @Column
    private String path;

    /**
     * 该版本对应的app
     */
    @ManyToOne
    @JsonBackReference
    private App app;
}
