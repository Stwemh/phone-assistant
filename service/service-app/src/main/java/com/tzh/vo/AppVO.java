package com.tzh.vo;

import com.tzh.entity.AppVersion;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author TangZongHua
 * @Date: 2020/10/14
 * @Description: 前端传递的"应用"
 */
@Data
public class AppVO {
    private Long id;

    private String name;

    private String info;

    private AppVersionVO appVersionVO;

}
