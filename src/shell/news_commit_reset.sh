#!/usr/bin/env bash

##
# 新闻提交前reset一些修改
# alias newsreset='${path}/shell/./news_commit_reset.sh'
##

# Android 7.0抓包
git reset HEAD news/src/main/res/xml/network_security_config.xml
git reset HEAD news/src/main/AndroidManifest.xml
# LeakCanary
git reset HEAD news/src/main/java/com/netease/nr/base/config/ConfigDebug.java
# fabric、云捕、哨兵
git reset HEAD news/src/main/java/com/netease/thirdsdk/SDKManager.java
# 内存占用浮层
git reset HEAD news/src/main/java/com/netease/thirdsdk/sentry/SentrySendService.java