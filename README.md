# ThAmCo Order Retrieval Microservice

This project is part of the ThAmCo Order subsystem.
This project is a microservice for the retrieval of orders for any purpose.

> Originally developed as part of the Cloud Computing DevOps module in the Computer Science course.

This project is part of the ThAmCo Order subsystem.
It fulfils the job as a microservice for retrieving orders.

> ***Note:*** This is purely a backend API microservice, no pages are served.

# Controller
## `/orders/{order_id}` - Get
Get mapping which returns the order of the given ID in the form of an order object.

## `/orders/{order_id}/items` - Get
Get mapping which returns an Iterable of order items that are related to an order

# Environment Variables
## Retrieval Specific:
### Circuit Breaker (resilience4j):
`RETRIEVAL_CIRCUIT_BREAKER_HEALTH_INDICATOR` Used to determine if the circuit breaker health indicator should be enabled. Fallback = `true`.<br>
`RETRIEVAL_CIRCUIT_BREAKER_FAIL_RATE_THRESHOLD` Used to determine the fail rate threshold for the circuit breaker. Fallback = `50`.<br>
`RETRIEVAL_CIRCUIT_BREAKER_SLIDING_WINDOW_SIZE` Used to determine the sliding window size for the circuit breaker. Fallback = `100`.<br>
`RETRIEVAL_CIRCUIT_BREAKER_WAIT_DURATION_IN_OPEN_STATE` Used to determine the wait duration in open state for the circuit breaker. Fallback = `10000`.<br>


## Other:
### Testing:
NOTE: These are only used for testing purposes and should not be used in a production environment as they are not defined in the production `application.properties` file.<br>
`TEST_VAR` Used to test if the application is correctly reading environment variables. Should read as anything but "fallback" since fallback means failure. Fallback = `fallback`<br>
`RETRIEVAL_PORT` Used for testing on a local machine. Fallback = `58001`<br>
Fallback means the default value should the environment variable not be set. If there is no mention of a fallback variable, there is no fallback value, and it could cause issues.
