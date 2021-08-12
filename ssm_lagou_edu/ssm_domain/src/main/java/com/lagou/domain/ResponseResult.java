package com.lagou.domain;

/**
 * @ClassName: ResponseResult
 * @Author: CYJ
 * @Date: 2021-08-07 14:38:44
 * @Description:
 */
public class ResponseResult {
    private Boolean success;
    private Integer state;
    private String message;
    private Object content;
    public ResponseResult() {
    }
    public ResponseResult(Boolean success, Integer state, String message, Object
            content) {
        this.success = success;
        this.state = state;
        this.message = message;
        this.content = content;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "success=" + success +
                ", state=" + state +
                ", message='" + message + '\'' +
                ", content=" + content +
                '}';
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public static ResponseResult success(String message, Object content){
        return new ResponseResult(true,200,message,content);
    }
    public static ResponseResult success(){
        return new ResponseResult(true,200,"响应成功",null);
    }
    public static ResponseResult success(Object content){
        return new ResponseResult(true,200,"响应成功",content);
    }

    public static ResponseResult fail(String message, Object content){
        return new ResponseResult(false,400,"响应失败",null);
    }

}