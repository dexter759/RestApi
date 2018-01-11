package com.damir.restapi;


import com.damir.restapi.dao.MySqlTaskDaoImpl;
import com.damir.restapi.service.ApplicationUserService;
import com.damir.restapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Autowired
    private Environment env;

    @Bean
    public static TaskService taskService(){
        return new TaskService();
    }

    @Bean public static MySqlTaskDaoImpl taskDao(){
        return new MySqlTaskDaoImpl();
    }

    @Bean public static ApplicationUserService applicationUserService(){return new ApplicationUserService();}

//    @Bean public static UserDaoImpl userDao(){
//        return new UserDaoImpl();
//    }

}
