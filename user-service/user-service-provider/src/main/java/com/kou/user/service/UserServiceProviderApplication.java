package com.kou.user.service;

import com.kou.common.base.impl.BaseJpaRepositoryImpl;
import com.kou.common.spring.advice.CommonExceptionAdviceCtrl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(repositoryBaseClass = BaseJpaRepositoryImpl.class)
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackageClasses = {UserServiceProviderApplication.class, CommonExceptionAdviceCtrl.class})
public class UserServiceProviderApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceProviderApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(UserServiceProviderApplication.class);
    }

}
