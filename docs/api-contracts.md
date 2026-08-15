# API Contracts

## 1. Deployment API

### Create Deployment
POST /deployments

Request:
{
  "serviceName": "order-service",
  "environment": "production"
}

Response:
{
  "deploymentId": "UUID",
  "status": "PENDING"
}

### Get Deployment
GET /deployments/{id}

Response:
{
  "deploymentId": "UUID",
  "serviceName": "order-service",
  "environment": "production",
  "status": "RUNNING"
}

---

## 2. Policy Engine

### Evaluate Deployment
POST /api/v1/decisions

Request:
{
  "document": {},
  "format": "cdm",
  "environment": "production",
  "phase": "runtime"
}

Response:
{
  "verdict": "PASS"
}

Possible verdicts:
- PASS
- FAIL
- ERROR

---

## 3. Database

Pending confirmation from Member 3.

Required operations:
- Save deployment
- Update deployment status
- Save stage status
- Save policy result
- Retrieve deployment
- Retrieve deployment history

---

## 4. Dashboard

Pending confirmation from Member 4.

Required backend operations:
- Get current deployment
- Get deployment stages
- Get policy result
- Get deployment history