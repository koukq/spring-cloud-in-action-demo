package com.kou.user.service.vo.request.employee;

import com.kou.common.util.vo.Pageable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "EmployeePageableVO",description = "员工分页条件信息")
public class EmployeePageableVO extends Pageable {

    @ApiModelProperty("员工姓名")
    private String employeeName;

    @ApiModelProperty(value = "手机号")
    private String phoneNumber;
}
