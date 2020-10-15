package com.tzh.vo;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author TangZongHua
 * @date 2020/10/14
 * @description 前端传递的"版本"
 */
@Data
public class AppVersionVO {
    private Long id;

    private String versionNumber;

    private String description;

}
