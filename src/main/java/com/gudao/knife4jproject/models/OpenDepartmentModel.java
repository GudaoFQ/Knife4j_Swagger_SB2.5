package com.gudao.knife4jproject.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: Gudao
 * @Date: 2021/06/02
 * @Description:
 */
@ApiModel("部门信息实体")
@Data
public class OpenDepartmentModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门id
     */
    @ApiModelProperty(value="部门id", name="id",dataType="String")
    private String id;
    /**
     * 部门名称
     */
    @ApiModelProperty(value="部门名称", name="departmentName",dataType="String")
    private String departmentName;
    /**
     * 本部门编码
     */
    @ApiModelProperty(value="本部门编码", name="departmentCode",dataType="String")
    private String departmentCode;

}
