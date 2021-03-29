aws dynamodb create-table --endpoint-url http://dynamodb-local:8000 \
	--table-name recordings \
	--attribute-definitions AttributeName=id,AttributeType=S \
	--key-schema AttributeName=id,KeyType=HASH \
	--provisioned-throughput ReadCapacityUnits=1,WriteCapacityUnits=1

aws dynamodb put-item --endpoint-url http://dynamodb-local:8000 \
  --table-name recordings \
  --item file:///docker-entrypoint-initdb.d/blue-monday.json \
  --return-consumed-capacity TOTAL

aws dynamodb put-item --endpoint-url http://dynamodb-local:8000 \
  --table-name recordings \
  --item file:///docker-entrypoint-initdb.d/tubular-bells.json \
  --return-consumed-capacity TOTAL

aws dynamodb put-item --endpoint-url http://dynamodb-local:8000 \
  --table-name recordings \
  --item file:///docker-entrypoint-initdb.d/fear-of-a-blank-planet.json \
  --return-consumed-capacity TOTAL