package com.tzh.service;

import com.tzh.entity.App;
import com.tzh.entity.AppVersion;
import com.tzh.vo.AppVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * @author TangZongHua
 * @date 2020/10/15
 * @description: App服务接口
 */
public interface AppService {
    /**
     * 保存"应用"信息到数据库
     * @param appVO 前端传入的appVO
     * @param file app资源
     * @param request HttpServletRequest
     * @return 返回上传成功的"应用"信息
     */
    App sava(AppVO appVO, MultipartFile file, HttpServletRequest request);
    /**
     * 根据"应用"id查找"应用"以及对应的"版本"
     * @param id "应用"id
     * @return 返回"应用"以及对应的"版本"
     */
    Optional<App> findById(Long id);
    /**
     * 修改"版本"的状态
     * @param versionId 版本id
     * @return
     */
    AppVersion checkApp(Long versionId);
}
