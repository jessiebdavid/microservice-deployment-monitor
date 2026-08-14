package com.deploymentmonitor.deployment;

public class DeploymentStage {

    private final String name;
    private final int order;
    private StageStatus status;

    public DeploymentStage(String name, int order) {
        this.name = name;
        this.order = order;
        this.status = StageStatus.PENDING;
    }

    public String getName() {
        return name;
    }

    public int getOrder() {
        return order;
    }

    public StageStatus getStatus() {
        return status;
    }

    public void start() {
        status = StageStatus.RUNNING;
    }

    public void complete() {
        status = StageStatus.SUCCESS;
    }

    public void fail() {
        status = StageStatus.FAILED;
    }

    public void skip() {
        status = StageStatus.SKIPPED;
    }
}