# ping-pong

A simple ping pong service written in multiple languages with Docker containers.

The ping pong service has been implemented in the following languages:

## Requirements

The URL <http://localhost:8080/ping> (GET) must return the following:

- HTTP 200
- The body text: At the pong it is [CURRENT_DATE_TIME_UTC_ISO_FORMAT] on [HOSTNAME]

Also, the following must be logged for each request: [CURRENT_DATE_TIME_UTC_ISO_FORMAT]  request from [SOURCE_IP_ADDRESS]

## Docker images