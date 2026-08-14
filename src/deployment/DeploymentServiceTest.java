package com.deploymentmonitor.deployment;

import java.util.List;

public class DeploymentServiceTest {

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

        System.out.println("Initial: " + deployment.getStatus());

        service.startDeployment(deployment);

        System.out.println(
                "After start: " + deployment.getStatus()
        );

        service.completeCurrentStage(deployment);

        System.out.println(
                "Stage 1: " + stages.get(0).getStatus()
        );

        service.completeCurrentStage(deployment);

        System.out.println(
                "Stage 2: " + stages.get(1).getStatus()
        );

        service.completeCurrentStage(deployment);

        System.out.println(
                "Stage 3: " + stages.get(2).getStatus()
        );

        System.out.println(
                "Final: " + deployment.getStatus()
        );
    }
}