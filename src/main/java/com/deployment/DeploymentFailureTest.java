package com.deploymentmonitor.deployment;

import java.util.List;

public class DeploymentFailureTest {

    public static void main(String[] args) {

        DeploymentService service = new DeploymentService();

        List<DeploymentStage> stages = List.of(
                new DeploymentStage("Build", 1),
                new DeploymentStage("Test", 2),
                new DeploymentStage("Deploy", 3)
        );

        Deployment deployment =
                service.createDeployment(
                        "sample-service",
                        "development",
                        stages
                );

        service.startDeployment(deployment);

        System.out.println("Before failure: " + deployment.getStatus());

        service.failCurrentStage(deployment);

        System.out.println("Failed stage: " + stages.get(0).getStatus());
        System.out.println("Stage 2: " + stages.get(1).getStatus());
        System.out.println("Stage 3: " + stages.get(2).getStatus());

        System.out.println("Final: " + deployment.getStatus());
    }
}