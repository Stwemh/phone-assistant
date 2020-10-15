package com.tzh.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author TangZongHua
 * @date 2020/10/15
 * @description: App实体类
 */
@Entity
@Data
public class App {
    /**
     * app的id
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * app名称
     */
    @Column(nullable = false,unique = true)
    private String name;

    /**
     * app的信息
     */
    @Column(nullable = false)
    private String info;

    /**
     * app对应的版本
     */
    @OneToMany(mappedBy = "app", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AppVersion> appVersionList;

}
