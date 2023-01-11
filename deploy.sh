#!/bin/bash
 echo "> now ing app pid find!"
 CURRENT_PID=$(pgrep -f Toyp_WebChat)
 echo "$CURRENT_PID"
 if [ -z "$CURRENT_PID" ]; then
         echo "> no ing app."
 else
         echo "> kill -9 $CURRENT_PID"
         kill -9 "$CURRENT_PID"
         sleep 3
 fi
 echo "> new app deploy"

 # shellcheck disable=SC2164
 cd /home/opc/
 rm -R ./nohup
 mkdir nohup
 # shellcheck disable=SC2010
 JAR_NAME=$(ls | grep 'Toyp_WebChat' | tail -n 1)
 echo "> JAR Name: $JAR_NAME"

 # shellcheck disable=SC2086
 nohup java -jar -Duser.timezone=Asia/Seoul $JAR_NAME 1>nohup/stdout.txt 2>nohup/stderr.txt &
 sleep 2