package com.deploymentmonitor.deployment;

import java.util.UUID;

public class DeploymentManagerTest {

    public static void main(String[] args) {

        DeploymentManager manager = new DeploymentManager();

        UUID deployment1 =
                manager.createDeployment("order-service", "development");

        UUID deployment2 =
                manager.createDeployment("payment-service", "production");

        System.out.println("Deployment 1: " + deployment1);
        System.out.println("Deployment 2: " + deployment2);

        manager.startDeployment(deployment1);
        manager.startDeployment(deployment2);

        System.out.println(
                "Order status: " +
                manager.getDeployment(deployment1).getStatus()
        );

        System.out.println(
                "Payment status: " +
                manager.getDeployment(deployment2).getStatus()
        );

        manager.completeStage(deployment1);
        manager.completeStage(deployment1);
        manager.completeStage(deployment1);

        manager.failStage(deployment2);

        System.out.println(
                "Order final: " +
                manager.getDeployment(deployment1).getStatus()
        );

        System.out.println(
                "Payment final: " +
                manager.getDeployment(deployment2).getStatus()
        );
    }
}