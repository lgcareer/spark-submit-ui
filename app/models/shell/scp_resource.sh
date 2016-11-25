#!/bin/bash

#arg1=$1
#exec rm -rf /Users/manbu/IdeaProjects/ficusspark/public/download/aaa
#for ip in {hadoop01,hadoop02,hadoop03};do scp /usr/local/aaa $ip:/usr/local/;done
for ip in 10.77.25.{44..57};do scp -P 26387 -r /usr/local/common/hadoop/conf/yarn-site.xml $ip:/usr/local/common/hadoop/conf/;done


