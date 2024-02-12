```shell
# Start the topology as defined in https://debezium.io/documentation/reference/stable/tutorial.html
export DEBEZIUM_VERSION=2.1
docker-compose -f docker-compose-mysql-karapace.yaml up

# Start MySQL connector
curl -i -X POST -H "Accept:application/json" -H  "Content-Type:application/json" http://localhost:8083/connectors/ -d @register-mysql.json

# Consume messages from a Debezium topic
docker-compose -f docker-compose-mysql-karapace.yaml exec kafka /kafka/bin/kafka-console-consumer.sh \
    --bootstrap-server kafka:29094 \
    --from-beginning \
    --property print.key=true \
    --topic dbserver1.inventory.customers
	
```


To register a schema:
```shell
$ curl -X POST -H "Content-Type: application/vnd.schemaregistry.v1+json" \
  --data '{"schemaType": "JSON", "schema": "{\"type\": \"object\",\"properties\":{\"age\":{\"type\": \"number\"}},\"additionalProperties\":true}"}' \
  http://localhost:8081/subjects/test-key-json-schema/versions
```
This should return ```{"id":1}```

To list all subjects:
```shell
$ curl -X GET http://localhost:8081/subjects
```
This should return ```["test-key"]```

To get the latest schema for a subject with name test-key:
```shell
curl -X GET http://localhost:8081/subjects/test-key/versions/latest
```

To get the schema for a subject with name test-key and version 1:
```shell
curl -X GET http://localhost:8081/subjects/test-key/versions/1
```


### Kafka UI
A Kafka ui has been add to the setup and can be reached on http://localhost:8080
