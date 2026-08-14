package com.deploymentmonitor.deployment;

import java.util.List;

public class Deployment {

    private final String serviceName;
    private final String environment;
    private final List<DeploymentStage> stages;

    private DeploymentStatus status;
    private int currentStage;

    public Deployment(
            String serviceName,
            String environment,
            List<DeploymentStage> stages) {

        this.serviceName = serviceName;
        this.environment = environment;
        this.stages = stages;
        this.status = DeploymentStatus.PENDING;
        this.currentStage = 0;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getEnvironment() {
        return environment;
    }

    public List<DeploymentStage> getStages() {
        return stages;
    }

    public DeploymentStatus getStatus() {
        return status;
    }

    public int getCurrentStage() {
        return currentStage;
    }

    public void start() {
        status = DeploymentStatus.RUNNING;
    }

    public void moveToNextStage() {
        currentStage++;
    }

    public void complete() {
        status = DeploymentStatus.SUCCESS;
    }

    public void fail() {
        status = DeploymentStatus.FAILED;
    }
}