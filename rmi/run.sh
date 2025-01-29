#!/bin/bash

# Run the JAR file and specify the main class
java -cp target/rmi-1.0-SNAPSHOT.jar com.aerweka.playground.App

# Alternatively with additional memory settings
#java -Xms512m -Xmx1024m -cp target/rmi-1.0-SNAPSHOT.jar com.aerweka.playground.App

# If you need to pass arguments
#java -cp target/rmi-1.0-SNAPSHOT.jar com.aerweka.playground.App arg1 arg2
