package com.deploymentmonitor.deployment;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class DeploymentManager {

    private final DeploymentService service = new DeploymentService();

    private final Map<UUID, Deployment> deployments =
            new ConcurrentHashMap<>();

    public UUID createDeployment(
            String serviceName,
            String environment) {

        Deployment deployment = service.createDeployment(
                serviceName,
                environment,
                java.util.List.of(
                        new DeploymentStage("Build", 1),
                        new DeploymentStage("Test", 2),
                        new DeploymentStage("Deploy", 3)
                )
        );

        UUID id = UUID.randomUUID();
        deployments.put(id, deployment);

        return id;
    }

    public Deployment getDeployment(UUID id) {
        return deployments.get(id);
    }

    public void startDeployment(UUID id) {
        Deployment deployment = deployments.get(id);

        if (deployment != null) {
            service.startDeployment(deployment);
        }
    }

    public void completeStage(UUID id) {
        Deployment deployment = deployments.get(id);

        if (deployment != null) {
            service.completeCurrentStage(deployment);
        }
    }

    public void failStage(UUID id) {
        Deployment deployment = deployments.get(id);

        if (deployment != null) {
            service.failCurrentStage(deployment);
        }
    }
}