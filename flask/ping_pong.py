from datetime import datetime, timezone
from flask import Flask, request, Response
import logging
import platform
import socket

app = Flask(__name__)

logging.basicConfig(level=logging.INFO)


@app.route('/ping')
def hello_world():
    currentDateTime = datetime.utcnow().replace(tzinfo=timezone.utc).isoformat()
    responseText = 'At the pong it is {} on {} (running {}/{})'.format(currentDateTime, socket.gethostname(), platform.system(), platform.machine())

    app.logger.info('{} request from {}'.format(
        currentDateTime, request.remote_addr))
    return Response(responseText, mimetype="text/plain")


@app.route('/health')
def health():
    return {
        "status": "UP"
    }


if __name__ == '__main__':
    app.run(port = 8080)
