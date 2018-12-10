#!/usr/bin/env bash

#url="https://g.hz.netease.com/ita/newsapp-android/merge_requests/4194"
#num=`$url | cut -d \/ -f 7`
#echo $num
#num=`echo $url | cut -d \/ -f 7`
#echo $num

#echo 'hello world' | mail -s "Subject" -t  cxyliuxiao@163.com    -a From:bjliuxiao3@corp.netease.com
#mail -s test cxyliuxiao@163.com < /Users/netease/Workspace/IdeaProjects/Poker_Java/src/com.mrliuxia.jarvis.js/git_lab_cli/index.com.mrliuxia.jarvis.js
#echo "mail content"|mail -s test cxyliuxiao@163.com -f bjliuxiao3@corp.netease.com

#echo "git user.name is empty， please exe git config --add user.name " >&2
#echo "hello hello"
#echo "hello hello"
#echo "hello hello"
#echo "hello hello"
#echo -e "\033[44;37m hello hello \033[0m"
#echo -e "\033[44;37m hello hello \33[2J"
#echo -e "\33[2J"
#echo "\033[36m 蓝色字 \033[0m"
#echo "\n\033[34m git-lab-cli has been updated, please run ./reviewp again : ) \033[0m"

#mergeId='  iid: 5405,'
#mergeId=$(cd /Users/netease/Workspace/AndroidProjects/newsapp-android;git config branch.beta/47.0.merge)
mergeId=$(cd /Users/netease/Workspace/AndroidProjects/newsapp-android;git branch | grep beta)
#mergeId='refs/heads/beta/47.0'
echo $mergeId
#echo $mergeId | grep iid
#echo $mergeId | grep iid | grep -Eo '[0-9]+'
#echo $mergeId | sed -n '/iid: /s/,//p'
#echo $mergeId | sed -n '/refs\/heads\//s///p'
