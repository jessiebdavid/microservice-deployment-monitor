package com.deploymentmonitor.deployment;

import java.util.List;

public class DeploymentService {

    public Deployment createDeployment(
            String serviceName,
            String environment,
            List<DeploymentStage> stages) {

        return new Deployment(serviceName, environment, stages);
    }

    public void startDeployment(Deployment deployment) {
        deployment.start();

        if (!deployment.getStages().isEmpty()) {
            deployment.getStages().get(0).start();
        }
    }

    public void completeCurrentStage(Deployment deployment) {
        int index = deployment.getCurrentStage();

        if (index >= deployment.getStages().size()) {
            return;
        }

        deployment.getStages().get(index).complete();
        deployment.moveToNextStage();

        if (deployment.getCurrentStage() >= deployment.getStages().size()) {
            deployment.complete();
        } else {
            deployment.getStages()
                    .get(deployment.getCurrentStage())
                    .start();
        }
    }

    public void failCurrentStage(Deployment deployment) {
        int index = deployment.getCurrentStage();

        if (index >= deployment.getStages().size()) {
            return;
        }

        deployment.getStages().get(index).fail();
        deployment.fail();

        skipRemainingStages(deployment);
    }

    private void skipRemainingStages(Deployment deployment) {
        int current = deployment.getCurrentStage();

        for (int i = current + 1; i < deployment.getStages().size(); i++) {
            deployment.getStages().get(i).skip();
        }
    }
}