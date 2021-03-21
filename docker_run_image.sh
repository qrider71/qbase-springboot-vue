#!/bin/bash

IMAGE_ID=$(docker image ls | grep qbiker/qbase-spb | awk -F " " '{print $3}')
if [ -z "$IMAGE_ID" ]
then
  echo "Image does not exist"
else
    echo "docker image id is $IMAGE_ID"

    docker ps -a|grep $IMAGE_ID | \
    while read line; do \
      CONTAINER_ID=`echo $line | awk -F " " '{print $1}'`;\
      echo "Stop conainer with ID=$CONTAINER_ID"; \
      docker container stop $CONTAINER_ID; \
      echo "Delete conainer with ID=$CONTAINER_ID"; \
      docker container rm $CONTAINER_ID; \
    done

    echo "Run docker image with ID=$IMAGE_ID"
    docker run -p 8098:8098 $IMAGE_ID
fi
