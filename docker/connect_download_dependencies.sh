#!/usr/bin/env bash

# Define the repository domain
REPO_DOMAIN="https://repo.maven.apache.org/maven2"
CONFLUENT_VERSION="7.6.0"
JACKSON_VERSION="2.14.2"
LOGREDACTOR_VERSION="1.0.12"
GUAVA_VERSION="31.0.1"
GUAVA_FAILUREACCESS_VERSION="1.0.1"
APACHE_AVRO_VERSION="1.11.3"
COMMONS_COMPRESS_VERSION="1.21"
APACURIO_VERSION="1.3.5.Final"

download_jar() {
    local repository="$1"
    local path="$2"

    if [ $repository == "confluent" ]; then
        REPO_DOMAIN="https://packages.confluent.io/maven"
    elif [ $repository == "maven" ]; then
        REPO_DOMAIN="https://repo.maven.apache.org/maven2"

    fi
    echo "Downloading $REPO_DOMAIN$path"
    if ! curl -O -f -s "$REPO_DOMAIN$path"; then
        echo -e "\e[91mERROR: Failed to download $path \e[0m"
    fi
}

# Download JAR files using the function
download_jar "maven" "/org/apache/avro/avro/$APACHE_AVRO_VERSION/avro-$APACHE_AVRO_VERSION.jar"

download_jar "maven" "/com/google/guava/failureaccess/$GUAVA_FAILUREACCESS_VERSION/failureaccess-$GUAVA_FAILUREACCESS_VERSION.jar"
download_jar "maven" "/com/google/guava/guava/$GUAVA_VERSION-jre/guava-$GUAVA_VERSION-jre.jar"

download_jar "maven" "/com/fasterxml/jackson/core/jackson-databind/$JACKSON_VERSION/jackson-databind-$JACKSON_VERSION.jar"
download_jar "maven" "/com/fasterxml/jackson/core/jackson-core/$JACKSON_VERSION/jackson-core-$JACKSON_VERSION.jar"
download_jar "maven" "/com/fasterxml/jackson/core/jackson-annotations/$JACKSON_VERSION/jackson-annotations-$JACKSON_VERSION.jar"
download_jar "maven" "/com/fasterxml/jackson/dataformat/jackson-dataformat-csv/$JACKSON_VERSION/jackson-dataformat-csv-$JACKSON_VERSION.jar"

download_jar "maven" "/io/confluent/logredactor/$LOGREDACTOR_VERSION/logredactor-$LOGREDACTOR_VERSION.jar"
download_jar "maven" "/io/confluent/logredactor-metrics/$LOGREDACTOR_VERSION/logredactor-metrics-$LOGREDACTOR_VERSION.jar"

download_jar "maven" "/org/apache/commons/commons-compress/$COMMONS_COMPRESS_VERSION/commons-compress-$COMMONS_COMPRESS_VERSION.jar"
download_jar "maven" "/io/apicurio/apicurio-maven-plugin/$APACURIO_VERSION/apicurio-maven-plugin-$APACURIO_VERSION.jar"

download_jar "confluent" "/io/confluent/kafka-connect-avro-converter/$CONFLUENT_VERSION/kafka-connect-avro-converter-$CONFLUENT_VERSION.jar"
download_jar "confluent" "/io/confluent/kafka-connect-avro-data/$CONFLUENT_VERSION/kafka-connect-avro-data-$CONFLUENT_VERSION.jar"
download_jar "confluent" "/io/confluent/kafka-avro-serializer/$CONFLUENT_VERSION/kafka-avro-serializer-$CONFLUENT_VERSION.jar"
download_jar "confluent" "/io/confluent/kafka-schema-registry-client/$CONFLUENT_VERSION/kafka-schema-registry-client-$CONFLUENT_VERSION.jar"
download_jar "confluent" "/io/confluent/kafka-schema-serializer/$CONFLUENT_VERSION/kafka-schema-serializer-$CONFLUENT_VERSION.jar"
download_jar "confluent" "/io/confluent/kafka-schema-converter/$CONFLUENT_VERSION/kafka-schema-converter-$CONFLUENT_VERSION.jar"
