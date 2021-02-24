aws dynamodb create-table --endpoint-url http://localhost:8000 \
	--table-name recordings \
	--attribute-definitions AttributeName=id,AttributeType=S \
	--key-schema AttributeName=id,KeyType=HASH \
	--provisioned-throughput ReadCapacityUnits=1,WriteCapacityUnits=1

aws dynamodb create-table --endpoint-url http://localhost:8000 \
    --table-name vehicles \
    --attribute-definitions AttributeName=make,AttributeType=S AttributeName=model,AttributeType=S \
    --key-schema AttributeName=make,KeyType=HASH AttributeName=model,KeyType=RANGE \
    --provisioned-throughput ReadCapacityUnits=1,WriteCapacityUnits=1
