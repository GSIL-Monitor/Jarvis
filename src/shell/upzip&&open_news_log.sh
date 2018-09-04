#!/bin/bash

if [ $1 ];
	then
	ZipPath=$1
else
	read -p "Drag file to here:" ZipPath	
fi

ZipName=${ZipPath##*/}
ZipPathPart1=${ZipPath%/*}
ZipName=${ZipName:0:$((${#ZipName}-4))}
#echo $ZipPathPart1 $ZipName
unzip ${ZipPath} -d $ZipPathPart1 
UnZipPath=${ZipPathPart1}/${ZipName}_log.txt
mv ${ZipPathPart1}/data/data/com.netease.newsreader.activity/files/netease_log_now.txt $UnZipPath
rm -rf ${ZipPathPart1}/data
echo "UnZipPath:"$UnZipPath
open -a "/Applications/Sublime Text.app" $UnZipPath


