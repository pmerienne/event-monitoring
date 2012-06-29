#!/bin/sh

JETTY_HOST="localhost"
JETTY_PORT=8080
JETTY_MINTHREADS=10
JETTY_MAXTHREADS=250
JETTY_MAXIDLETIME=30000
JETTY_HOME="."

JETTY_OPTS="-Djetty.host=${JETTY_HOST} -Djetty.port=${JETTY_PORT} -Djetty.minThreads=${JETTY_MINTHREADS} -Djetty.maxThreads=${JETTY_MAXTHREADS} -Djetty.maxIdleTime=${JETTY_MAXIDLETIME} -Djetty.home=${JETTY_HOME}"
JAVA_OPTS="-server -Xms512M -Xmx1024M ${JAVA_OPTS}"

JETTY_LIB="lib/jetty-start-7.4.5.v20110725.jar"
JETTY_CONFIG="resources/jetty.xml"

echo "Launching application on ${JETTY_HOST} port ${JETTY_PORT}"

java ${JETTY_OPTS} ${JAVA_OPTS} -jar $JETTY_LIB $JETTY_CONFIG 