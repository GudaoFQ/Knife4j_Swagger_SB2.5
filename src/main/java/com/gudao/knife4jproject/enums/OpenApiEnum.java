package com.gudao.knife4jproject.enums;

/**
 * @Auther: Gudao
 * @Date: 2021/06/03
 * @Description:
 */
public enum OpenApiEnum {

    SUCCESS(0, "正常"),
    FAILURE(1, "失败"),
    PARAM_NULL(1, "参数信息不匹配"),
    MEMBER_NULL(1, "用户信息不存在"),
    AUTHORITY_DOWN(1, "用户无权查询此信息");


    private final int code;
    private final String msg;


    OpenApiEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
