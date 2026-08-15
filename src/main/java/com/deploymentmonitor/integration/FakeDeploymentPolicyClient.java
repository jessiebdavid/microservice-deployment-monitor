package com.deploymentmonitor.integration;

public class FakeDeploymentPolicyClient
        implements DeploymentPolicyClient {

    private final String verdict;

    public FakeDeploymentPolicyClient(String verdict) {
        this.verdict = verdict;
    }

    @Override
    public PolicyDecision validate(
            String serviceName,
            String environment) {

        return new PolicyDecision(
                verdict,
                "Fake policy response for testing"
        );
    }
}