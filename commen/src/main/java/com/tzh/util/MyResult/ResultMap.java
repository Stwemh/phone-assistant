package com.tzh.util.MyResult;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ResultMap {
    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<>();

    private ResultMap(){}

    public static ResultMap ok(){
        ResultMap resultMap = new ResultMap();
        resultMap.setSuccess(true);
        resultMap.setCode(ResultCode.SUCCESS);
        resultMap.setMessage("成功");
        return resultMap;
    }

    public static ResultMap error(){
        ResultMap resultMap = new ResultMap();
        resultMap.setSuccess(false);
        resultMap.setCode(ResultCode.ERROR);
        resultMap.setMessage("失败");
        return resultMap;
    }

    public ResultMap success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public ResultMap message(String message){
        this.setMessage(message);
        return this;
    }

    public ResultMap code(Integer code){
        this.setCode(code);
        return this;
    }

    public ResultMap data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public ResultMap data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}
