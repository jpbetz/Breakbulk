#!/bin/bash
cd openanzo-maven
mvn package javadoc:javadoc
cp target/*.tar.gz ../.
cd ..
