package com.tzh.controller;

import com.tzh.entity.App;
import com.tzh.entity.AppVersion;
import com.tzh.service.AppService;
import com.tzh.util.MyResult.ResultMap;
import com.tzh.util.file.FileUpload;
import com.tzh.vo.AppVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * @author TangZongHua
 * @date 2020/10/15
 * @description: App管理控制器
 */
@RestController
@RequestMapping("app")
@Api
public class AppController {

    @Autowired
    private AppService appService;

    /**
     * 上传应用
     * @param appVO 前端传入的appVO
     * @param file app资源
     * @param request HttpServletRequest
     * @return 将上传成功的app信息保存到"savaData"返回
     */
    @PostMapping()
    @ApiOperation(value = "上传应用")
    public ResultMap saveApp(AppVO appVO, MultipartFile file, HttpServletRequest request){
        App sava = appService.sava(appVO, file, request);
        return ResultMap.ok().message("上传应用").data("savaData", sava);
    }

    /**
     * 删除"应用"及其对应的"版本"信息
     * @param id "应用id"
     * @return 返回类型
     */
    @DeleteMapping("{id}")
    @ApiOperation(value = "下架应用")
    public ResultMap deleteApp(@PathVariable Long id){
        appService.delete(id);
        return ResultMap.ok().message("下架应用");
    }
    /**
     * 根据"应用"id查找"应用"以及对应的"版本"
     * @param id "应用"id
     * @return 返回用以及对应的"版本"
     */
    @GetMapping("{id}")
    @ApiOperation(value = "查找应用")
    public ResultMap findAppById(@PathVariable Long id){
        Optional<App> appOptional = appService.findById(id);

        // 如果存在该值，返回值， 否则返回 other。appOptional.orElse(null);
        if (appOptional.isPresent()){
            return ResultMap.ok().message("查找成功").data("app", appOptional.get());
        }else {
            return ResultMap.ok().message("没有结果");
        }
    }

    /**
     * 审核应用
     * @param versionId "版本"id
     * @return 返回审核成功的"版本"
     */
    @GetMapping("check/{id}")
    public ResultMap checkApp(@PathVariable Long versionId){
        AppVersion appVersion = appService.checkApp(versionId);
        return ResultMap.ok().message("该版本审核成功").data("appVersion", appVersion);
    }
}
