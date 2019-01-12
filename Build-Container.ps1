.\mvnw.cmd clean package
docker build -t ninckblokje/ping-pong:latest .
docker push ninckblokje/ping-pong:latest