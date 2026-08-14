package com.deploymentmonitor.api;

import com.deploymentmonitor.deployment.Deployment;
import com.deploymentmonitor.deployment.DeploymentManager;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/deployments")
public class DeploymentController {

    private final DeploymentManager manager =
            new DeploymentManager();

    @PostMapping
    public UUID createDeployment(
            @RequestParam String serviceName,
            @RequestParam String environment) {

        return manager.createDeployment(
                serviceName,
                environment
        );
    }

    @PostMapping("/{id}/start")
    public Deployment startDeployment(
            @PathVariable UUID id) {

        manager.startDeployment(id);

        return manager.getDeployment(id);
    }

    @PostMapping("/{id}/complete")
    public Deployment completeStage(
            @PathVariable UUID id) {

        manager.completeStage(id);

        return manager.getDeployment(id);
    }

    @PostMapping("/{id}/fail")
    public Deployment failStage(
            @PathVariable UUID id) {

        manager.failStage(id);

        return manager.getDeployment(id);
    }

    @GetMapping("/{id}")
    public Deployment getDeployment(
            @PathVariable UUID id) {

        return manager.getDeployment(id);
    }
}