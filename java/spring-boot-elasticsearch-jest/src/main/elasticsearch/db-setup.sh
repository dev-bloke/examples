#!/bin/bash

ES_HOST=$1

if [ -z $ES_HOST ]; then
  ES_HOST="http://localhost:9200"
fi

# Create an index using mapping.json

echo "Creating 'location-discovery' index..."
curl -s -XPUT "$ES_HOST/location-discovery" --data "@./mapping.json"

echo "Creating 'sandbox' index..."
curl -s -XPUT "$ES_HOST/sandbox" --data "@./sandbox-mapping.json"


