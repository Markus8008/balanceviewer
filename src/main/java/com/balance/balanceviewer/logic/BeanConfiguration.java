package com.balance.balanceviewer.logic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class BeanConfiguration {

    public static final String EXECUTOR_SERVICE = "EXECUTOR_SERVICE";

    @Bean(name = EXECUTOR_SERVICE)
    public ExecutorService getExecutorService() {
        return Executors.newSingleThreadExecutor();
    }
}
