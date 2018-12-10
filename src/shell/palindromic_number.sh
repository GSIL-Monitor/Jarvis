#!/usr/bin/env bash
#判断是否是回文数

num=$1

echo ${num:0:1}
echo ${num:1:1}
echo ${num:2:1}

num=10
echo ${#num}