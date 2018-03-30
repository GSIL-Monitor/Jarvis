#!/usr/bin/env bash

##
# 参数为倒数第n次提交
##

# 判断参数是否合法
if [ $# == 0 ] ;then
    echo "there should be an args"
    exit
fi

if [ $1 == "help" ] ;then
    echo "将现有修改提交到n次提交之前"
    echo "比如commit1<-commit2<-commit3,提交到commit1,则参数为2"
    exit
fi

if [ $1 -gt 0 ] 2>/dev/null  ;then
    echo "git add to commit HEAD~$a"
else
    echo "$1 should be a number"
    exit
fi


# 正题
n=$1
# 将现有修改添加到stash
git add .
git stash
# 将中间n次提交打patch
git format-patch HEAD~$n --numbered-files -o ~/patchtemp
# 将git强制reset到n次提交之前
git reset --hard HEAD~$n
# 将stash应用,并添加到目标提交
git stash apply stash@{0}
git add .
git commit --amend
# 将各个patch恢复
declare -i i=1
while((i<=$n))
do
    git am -s < ~/patchtemp/$i
    let ++i
done
# 删除patch
rm -r ~/patchtemp
