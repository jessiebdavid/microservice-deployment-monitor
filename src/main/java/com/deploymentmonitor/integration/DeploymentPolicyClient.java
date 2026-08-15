package com.deploymentmonitor.integration;

public interface DeploymentPolicyClient {

    PolicyDecision validate(
            String serviceName,
            String environment
    );
}