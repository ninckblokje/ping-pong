#!/bin/bash

python3 -m venv venv
source ./venv/bin/activate

python3 setup.py install

export FLASK_APP="ping_pong.py"
export FLASK_RUN_HOST=localhost
export FLASK_RUN_PORT=8080
