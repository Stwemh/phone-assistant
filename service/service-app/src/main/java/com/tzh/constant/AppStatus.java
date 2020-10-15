package com.tzh.constant;

/**
 * @author TangZongHua
 * @date 2020/10/14
 * @description: App的状态常量
 */
public interface AppStatus {
    /**
     * 上传后,没通过审核
     */
    public static String UNCHECK = "0";
    /**
     * 通过审核,没上架
     */
    public static String CHECK = "1";
    /**
     * 上架
     */
    public static String PUBLISH = "2";
}
