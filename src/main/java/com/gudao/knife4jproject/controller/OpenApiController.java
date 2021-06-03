package com.gudao.knife4jproject.controller;

import com.gudao.knife4jproject.responses.OpenApiResponse;
import com.gudao.knife4jproject.models.OpenDepartmentModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Gudao
 * @Date: 2021/06/03
 * @Description:
 */
@Api(tags = "Gudao对外开放接口")
@RestController
@RequestMapping("/gudao/webInterface")
public class OpenApiController {


    /**
     * 查询部门
     *
     * @param auth 身份标识
     * @return {@link OpenApiResponse<OpenDepartmentModel>}
     */
    @ApiOperation(value = "查询部门", notes = "调用这个接口可以查询所有得部门")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "auth", value = "身份标识", required = true)
    })
    @PostMapping(value = "/queryDepartment", consumes = "application/x-www-form-urlencoded")
    public OpenApiResponse<OpenDepartmentModel> queryDepartment(@RequestParam("auth") String auth){
        return OpenApiResponse.success();
    }

}
