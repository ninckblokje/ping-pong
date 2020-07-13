# ping-pong

A simple ping pong service written in multiple languages with Docker containers.

The ping pong service has been implemented in the following languages:

## Requirements

1. The URL <http://localhost:8080/ping> (GET) must return the following:
   1. HTTP 200
   1. The body text: At the pong it is [CURRENT_DATE_TIME_UTC_ISO_FORMAT] on [HOSTNAME] (running [OPERATING_SYSTEM]/[ARCHITECTURE])
1. The following must be logged for each request: [CURRENT_DATE_TIME_UTC_ISO_FORMAT]  request from [SOURCE_IP_ADDRESS]
1. A health endpoint should be available at <http://localhost:8080/health>
  1. Must return a JSON document:

````
{
   "status": "UP"
}
````

UTC_ISO_FORMAT example: 2020-05-26T07:39:47+00:00 or 2020-05-26T07:39:47Z

## Docker images