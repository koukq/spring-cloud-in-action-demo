package com.kou.user.service.service.impl;

import com.kou.common.base.BaseDao;
import com.kou.common.base.impl.BaseServiceImpl;
import com.kou.common.util.vo.Page;
import com.kou.common.util.vo.Pageable;
import com.kou.user.service.dao.EmployeeDao;
import com.kou.user.service.model.Employee;
import com.kou.user.service.service.EmployeeService;
import com.kou.user.service.vo.request.employee.EmployeePageableVO;
import com.kou.user.service.vo.response.employee.EmployeeVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 员工 service接口实现类
 */
@Service("employeeService")
public class EmployeeServiceImpl extends BaseServiceImpl<Employee> implements EmployeeService {


    private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Resource(name="employeeDao") 
    private EmployeeDao employeeDao;

    @Override
    protected BaseDao<Employee> getDao(){
        return employeeDao;
    }

    @Override
    public Page<EmployeeVO> page(Pageable pageable) {
        return employeeDao.nativeFindPage("select id,employeeCode,employeeName," +
                "phoneNumber,userImage,deleteStatus,creator,modifier,createTime,modifyTime,workEmail  from basic_employee", null, EmployeeVO.class, pageable);
    }

    @Override
    public Page<EmployeeVO> pageByCondition(EmployeePageableVO vo) {

        StringBuilder sb = new StringBuilder();
        Map<String, Object> map = new HashMap<>();

        sb.append("select id,employeeCode,employeeName,phoneNumber,userImage,deleteStatus,creator,modifier,createTime,modifyTime,workEmail from basic_employee where 1=1 ");

        if (StringUtils.isNotBlank(vo.getEmployeeName())){
            sb.append(" and employeeName like :employeeName ");
            map.put("employeeName", vo.getEmployeeName() + "%");
        }

        if (StringUtils.isNotBlank(vo.getPhoneNumber())){
            sb.append(" and phoneNumber like :phoneNumber ");
            map.put("phoneNumber", vo.getPhoneNumber() + "%");
        }
        return employeeDao.nativeFindPage(sb.toString(), map, EmployeeVO.class, vo);
    }
}