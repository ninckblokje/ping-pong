# ping-pong

A simple ping pong service written in multiple languages with Docker containers.

The ping pong service has been implemented in the following languages:

## Requirements

1. The URL <http://localhost:8080/ping> (GET) must return the following:
   1. HTTP 200
   1. The body text: At the pong it is [CURRENT_DATE_TIME_UTC_ISO_FORMAT] on [HOSTNAME]
2. The following must be logged for each request: [CURRENT_DATE_TIME_UTC_ISO_FORMAT]  request from [SOURCE_IP_ADDRESS]
3. A health endpoint should be available at <http://localhost:8080/health>

## Docker images