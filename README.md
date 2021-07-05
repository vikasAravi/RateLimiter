# RateLimiter

Problem : Rate Limiter

1. Used Spring Boot Framework to solve the problem. 
2. Used Scheduler annotation to run the job to run the job.
3. Used H2 DB wrapper to store the details.
4. Enable Swagger Documentation for testing the endpoints


API EndPoints: 
1. /saveEmployee - API endpoint which saves employee record
2. /getEmployees - API endpoint which retrieves all the employee records
3. /{apiId}/getEmployee/{empId} - API endpoint which retreive the employee information with the given empId 
and apiId is the unique userKey used for rate limiting ( acts as tenant)


For Example, the incoming request is "localhost:8080/100/getEmployee/1" then the API returns the employee information
with given empId and registers the apiId and the count( no of times user hits the API for employee information). 
If the number of requests lets say X exceeds more then the limit per hour, user can't get the information from the API

