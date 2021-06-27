package com.ldhmusic.music.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Result {
    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private String  code;

    @ApiModelProperty(value = "返回数据")
    private Map<String,Object> data = new HashMap<>();

    public String getCode() {
        return code;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public static Result ok(){
        Result result = new Result();
        result.setSuccess(true);
        result.setCode("登录成功！");
//        result.setData();
        return result;
    }
    public static Result err(){
        Result result = new Result();
        result.setSuccess(false);
//        result.setCode(200);
//        result.setData();
        return result;
    }

    public Result code(Boolean success){
        this.setCode(code);
        return this;
    }
    public Result data(Map<String,Object> map){
        this.setData(map);
        return this;
    }
}
