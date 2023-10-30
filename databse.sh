#!/bin/bash
docker build -t mall-database ./database
docker run -d --name mall-database-container -p 3306:3306 mall-database