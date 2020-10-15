package com.tzh.service.impl;

import com.tzh.Dao.AppDao;
import com.tzh.Dao.AppVersionDao;
import com.tzh.constant.AppStatus;
import com.tzh.entity.App;
import com.tzh.entity.AppVersion;
import com.tzh.service.AppService;
import com.tzh.util.file.FileUpload;
import com.tzh.vo.AppVO;
import com.tzh.vo.AppVersionVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;

/**
 * @author TangZongHua
 * @date 2020/10/15
 * @description: App服务实现类
 */
@Service
public class AppServiceImpl implements AppService {
    @Autowired
    private AppDao appDao;

    @Autowired
    private AppVersionDao appVersionDao;

    /**
     * 保存"应用"信息到数据库
     * @param appVO 前端传入的appVO
     * @param file app资源
     * @param request HttpServletRequest
     * @return 返回上传成功的"应用"信息
     */
    @Override
    public App sava(AppVO appVO, MultipartFile file, HttpServletRequest request) {
        // copy app中appVersionVO的信息到entity(appVersion)
        AppVersion appVersion = new AppVersion();
        AppVersionVO appVersionVO = appVO.getAppVersionVO();
        BeanUtils.copyProperties(appVersionVO, appVersion);

        // copy app的信息到entity
        App app = new App();
        BeanUtils.copyProperties(appVO,app);

        // 上传文件,将上传后的文件路径赋给版本.上传后的文件名为app名称
        String path = FileUpload.upload(file, request, app.getName());
        appVersion.setPath(path);

        // 加关系实体对象，否在关联字段为nul
        appVersion.setApp(app);
        app.setAppVersionList(Arrays.asList(appVersion));

        return appDao.save(app);
    }

    /**
     * 根据"应用"id查找"应用"以及对应的"版本"
     * @param id "应用"id
     * @return 返回"应用"以及对应的"版本"
     */
    @Override
    public Optional<App> findById(Long id) {
        return appDao.findById(id);
    }

    /**
     * 修改"版本"的状态
     * @param versionId 版本id
     * @return
     */
    @Override
    public AppVersion checkApp(Long versionId) {
        Optional<AppVersion> appVersionOptional = appVersionDao.findById(versionId);
        AppVersion appVersion = appVersionOptional.orElse(null);
        appVersion.setStatus(AppStatus.CHECK);
        return appVersionDao.save(appVersion);
    }
}
