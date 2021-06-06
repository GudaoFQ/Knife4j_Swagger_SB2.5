package com.gudao.knife4jproject.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gudao.knife4jproject.enums.OpenApiEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Auther: zhangxiayu
 * @Date: 2021/04/25
 * @Description:
 */
@ApiModel(value = "开发接口统一返回信息实体")
@Setter
@Getter
public class OpenApiResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 请求返回状态码
     */
    @ApiModelProperty(value="请求返回状态码：0 正常，1 失败", name="code",dataType="Integer")
    private int code;

    /**
     * 请求返回信息
     */
    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    @ApiModelProperty(value="请求返回信息", name="msg",dataType="String",required=true)
    private String msg;

    /**
     * 请求返回数据
     */
    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    @ApiModelProperty(value="请求返回数据", name="result",dataType="Object",required=true)
    private T result;

    private OpenApiResponse(int code, String msg, T result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    private OpenApiResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 成功
     * 成功相应
     *
     * @return {@link OpenApiResponse<T>}
     */
    public static <T> OpenApiResponse<T> success() {
        return new OpenApiResponse<T>(OpenApiEnum.SUCCESS.getCode(), OpenApiEnum.SUCCESS.getMsg());
    }

    /**
     * 成功
     * 成功相应
     *
     * @param result 结果
     * @return {@link OpenApiResponse<T>}
     */
    public static <T> OpenApiResponse<T> success(T result) {
        return new OpenApiResponse<T>(OpenApiEnum.SUCCESS.getCode(), null,result);
    }

    /**
     * 失败
     * 失败的响应
     *
     * @param msg 错误信息
     * @return {@link OpenApiResponse<String>}
     */
    public static OpenApiResponse<String> failure(String msg) {
        return new OpenApiResponse<>(OpenApiEnum.FAILURE.getCode(), msg);
    }

    /**
     * 失败
     * 失败的响应
     *
     * @param openApiEnum 枚举信息
     * @return {@link OpenApiResponse<T>}
     */
    public static<T> OpenApiResponse<T> failure(OpenApiEnum openApiEnum) {
        return new OpenApiResponse<>(openApiEnum.getCode(), openApiEnum.getMsg());
    }

    /**
     * 响应
     * 其他的响应
     *
     * @param r      枚举常量
     * @param result 结果
     * @return {@link OpenApiResponse<T>}
     */
    public static <T> OpenApiResponse<T> response(OpenApiEnum r, T result) {
        return new OpenApiResponse<T>(r.getCode(), r.getMsg(), result);
    }

    /**
     * 构建
     * 自定义异常信息
     *
     * @param code    代码
     * @param message 消息
     * @return {@link OpenApiResponse<T>}
     */
    public static <T> OpenApiResponse<T> build(int code, String message) {
        return new OpenApiResponse<T>(code, message);
    }
}
