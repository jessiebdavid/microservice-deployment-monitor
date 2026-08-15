package com.deploymentmonitor.integration;

public record PolicyDecision(
        String verdict,
        String message
) {}