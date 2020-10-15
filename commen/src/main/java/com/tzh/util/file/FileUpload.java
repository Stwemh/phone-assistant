package com.tzh.util.file;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;

/**
 * @author TangZongHua
 * @date 2020/10/15
 * @description
 */
public class FileUpload {
    /**
     * 存放文件的的路径
     */
    static private String PATH = "appResource/";
    /**
     *
     * @param file 上传的文件
     * @param request HttpServletRequest
     * @param fileName 设置文件上传的名字,若为null,则为默认名字.
     * @return 返回文件上传后的地址.
     */
    public static String upload(MultipartFile file, HttpServletRequest request, String fileName) {
        String contentType = file.getContentType();
        if (StringUtils.isEmpty(fileName)) {
            fileName= file.getOriginalFilename();
        }
        String suffix = getSuffix(file.getOriginalFilename());
        fileName += suffix;
        String filePath = request.getSession().getServletContext().getRealPath(PATH);
        try {
            uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath + fileName;
    }

    /**
     *
     * @param file 文件
     * @param filePath 文件路径
     * @param fileName 文件名
     * @throws Exception
     */
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    /**
     * 根据文件名获取文件后缀名
     * @param filename 文件名
     * @return 返回后缀
     */
    public static String getSuffix(String filename){
        String suffix= null;
        if(filename.contains(".")){
            suffix = filename.substring(filename.lastIndexOf("."));
        }else{
            suffix = "";
        }
        return suffix;
    }
}
