#!/usr/bin/env bash

# 新闻提交前reset一些修改：
# android7.0抓包、 fabric、 云捕、 LeakCanary、 哨兵（内存占用浮层）

git reset --soft HEAD news/src/main/res/xml/network_security_config.xml
git reset --soft HEAD news/src/main/AndroidManifest.xml
git reset --soft HEAD news/src/main/java/com/netease/nr/base/config/ConfigDebug.java
git reset --soft HEAD news/src/main/java/com/netease/thirdsdk/SDKManager.java
