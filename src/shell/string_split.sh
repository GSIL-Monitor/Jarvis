#!/usr/bin/env bash
# 判断版本号小于1.0.2
cd /Users/netease/Workspace/AndroidProjects/newsapp-android

#source="1.1.1"

#read -r -a versions <<< $(echo "$source" | tr "." " ")
read -r -a labVersion <<< $(echo `lab --version` | tr "." " ")
if [[ (${labVersion[0]} -le 1) &&  (${labVersion[1]} -le 0) && (${labVersion[2]} -lt 2) ]]; then
    echo "need update"
fi

s="hello"
if [[ ${#s} -gt 5 ]]; then
    echo "ok"
fi

#mails=$(echo "$source" | tr ";" " ")
##mails=(${source//,/ })
#read -r -a Words <<< "$mails"
#
#echo "$Words"
#echo "\n"
#echo "${Words[2]}"
#
#
#
#echo ${Words[1]}
#1.0.2