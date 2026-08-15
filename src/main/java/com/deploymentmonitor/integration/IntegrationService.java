package com.deploymentmonitor.integration;

import com.deploymentmonitor.deployment.Deployment;

public interface IntegrationService {

    void persistDeployment(Deployment deployment);

    void persistStage(Deployment deployment);

    void persistPolicyResult(
            String deploymentId,
            PolicyDecision decision
    );

    void persistViolation(
            String deploymentId,
            String policyName,
            String message
    );
}