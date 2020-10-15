package com.tzh;

import com.tzh.service.AppService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppManagerApplicationTests {

    @Autowired
    private AppService appService;

    @Test
    void test() {
//        App app = new App();
//        app.setName("testOneTomany");
//        AppVersion appVersion1 = new AppVersion();
//        AppVersion appVersion2 = new AppVersion();
//        appVersion1.setVersionNumber("1.1");
//        appVersion1.setDescription("appVersion1.setDescription");
//        appVersion2.setVersionNumber("2.1");
//        appVersion2.setDescription("appVersion2.setDescription");
//
//        List<AppVersion> appVersions = new ArrayList<>();
//        appVersions.add(appVersion1);
//        appVersions.add(appVersion2);
//        app.setAppVersion(appVersions);
//        app.setInfo("app描述");
//        appUploadService.sava(app);
    }
}
