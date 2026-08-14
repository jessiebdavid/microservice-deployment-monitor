package com.deploymentmonitor.deployment;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Deployment {

    private final UUID deploymentId;
    private final String serviceName;
    private final String environment;

    private DeploymentStatus status;
    private int currentStage;
    private final List<DeploymentStage> stages;

    private final Instant createdAt;
    private Instant startedAt;
    private Instant completedAt;

    public Deployment(
            String serviceName,
            String environment,
            List<DeploymentStage> stages) {

        this.deploymentId = UUID.randomUUID();
        this.serviceName = serviceName;
        this.environment = environment;
        this.status = DeploymentStatus.PENDING;
        this.currentStage = 0;
        this.stages = new ArrayList<>(stages);
        this.createdAt = Instant.now();
    }

    public UUID getDeploymentId() {
        return deploymentId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getEnvironment() {
        return environment;
    }

    public DeploymentStatus getStatus() {
        return status;
    }

    public int getCurrentStage() {
        return currentStage;
    }

    public List<DeploymentStage> getStages() {
        return stages;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getStartedAt() {
        return startedAt;
    }

    public Instant getCompletedAt() {
        return completedAt;
    }

    public void start() {
        status = DeploymentStatus.RUNNING;
        startedAt = Instant.now();
    }

    public void complete() {
        status = DeploymentStatus.SUCCESS;
        completedAt = Instant.now();
    }

    public void fail() {
        status = DeploymentStatus.FAILED;
        completedAt = Instant.now();
    }

    public void cancel() {
        status = DeploymentStatus.CANCELLED;
        completedAt = Instant.now();
    }

    public void moveToNextStage() {
        currentStage++;
    }
}