# buyogo-assignment

# BuyoGo Training Center API

## Overview

These APIs allow users to manage training centers, including creating and retrieving training center details.

## Endpoints

### 1. Save Training Center Details

**Endpoint:**  
`POST /training-center`

**Request Example:**
```sh
curl --location 'http://localhost:8080/training-center' \
--header 'Content-Type: application/json' \
--data-raw '{
    "centerName": "Tech Minds Institute",
    "centerCode": "TMI9876",
    "address": {
        "city": "Mumbai",
        "state": "Maharashtra",
        "pincode": 400001
    },
    "studentCapacity": 200,
    "coursesOffered": ["Python Basics", "Cybersecurity", "Cloud Computing"],
    "contactEmail": "support@techminds.in",
    "contactPhone": 9823456789
}'
```

### 2. GET All Training Center Details

**Endpoint:**  
`GET /training-center`
**Request Example:**
```sh
curl --location 'http://localhost:8080/training-center'
```

### 3. GET Single Training Center Details By Id

**Endpoint:**  
`GET /training-center/{trainingCenterId}`
**Request Example:**
```sh
curl --location 'http://localhost:8080/training-center/67af31f549e1e247d3e2b9c6'
```

