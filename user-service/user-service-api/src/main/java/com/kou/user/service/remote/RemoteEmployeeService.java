package com.kou.user.service.remote;

import com.kou.common.util.constant.ServiceProvider;
import com.kou.common.util.vo.IdVO;
import com.kou.common.util.vo.Page;
import com.kou.common.util.vo.Pageable;
import com.kou.user.service.vo.request.employee.EmployeeModifyVO;
import com.kou.user.service.vo.request.employee.EmployeePageableVO;
import com.kou.user.service.vo.response.employee.EmployeeVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = ServiceProvider.USER_SERVICE)
public interface RemoteEmployeeService {

    @PostMapping("/employee/page")
    Page<EmployeeVO> page(@RequestBody Pageable pageable);

    @PostMapping("/employee/get")
    EmployeeVO getOne(@RequestBody IdVO vo);

    @PostMapping("/employee/add")
    Long add(@RequestBody EmployeeModifyVO vo);

    @PostMapping("/employee/update")
    void update(@RequestBody EmployeeModifyVO employeeVO);

    @PostMapping("/employee/delete")
    void delete(@RequestBody IdVO vo);

    @PostMapping("/employee/pageByCondition")
    Page<EmployeeVO> pageByCondition(EmployeePageableVO employeePageableVO);
}
