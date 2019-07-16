package com.kou.hr.system;

import com.kou.common.spring.advice.CommonExceptionAdviceCtrl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication(scanBasePackageClasses = {
        HrSystemApplication.class, CommonExceptionAdviceCtrl.class})
public class HrSystemApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(HrSystemApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HrSystemApplication.class);
    }
}
