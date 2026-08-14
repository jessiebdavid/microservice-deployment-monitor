package com.deploymentmonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeploymentMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(
                DeploymentMonitorApplication.class,
                args
        );
    }
}