package com.kou.user.service.service;


import com.kou.common.base.BaseService;
import com.kou.common.util.vo.Page;
import com.kou.common.util.vo.Pageable;
import com.kou.user.service.model.Employee;
import com.kou.user.service.vo.request.employee.EmployeePageableVO;
import com.kou.user.service.vo.response.employee.EmployeeVO;

/**
 * 员工 service接口
 */
public interface EmployeeService extends BaseService<Employee> {


    Page<EmployeeVO> page(Pageable pageable);

    Page<EmployeeVO> pageByCondition(EmployeePageableVO employeePageableVO);
}