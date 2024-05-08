### Validation with Spring Boot - the Complete Guide

[Implementation tutorial from: https://reflectoring.io/bean-validation-with-spring-boot](https://reflectoring.io/bean-validation-with-spring-boot)


InputDto example:
entrypoint:

    post: http://127.0.0.1:8080/validateBody
    get: http://127.0.0.1:8080/validatePathVariable/6
    get: http://127.0.0.1:8080/validateRequestParameter?param=1
    
validateBody JSON request example:

    {
        "numberBetweenOneAndTen": 8,
        "ipAddress": "300.0.0.1"
    }


