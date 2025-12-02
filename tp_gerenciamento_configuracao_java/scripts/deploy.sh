#!/usr/bin/env bash
set -e
mvn -B package
docker-compose build --no-cache
docker-compose up -d
