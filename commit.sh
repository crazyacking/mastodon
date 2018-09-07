#! /bin/bash

echo "---------------------------------------------------"
echo "begin commit"

sleep 30

cd /Users/shanbiao.jsb/code/github/mastodon

date "+%Y-%m-%d %H:%M:%S" >> exe_history

git add .
git commit -m "impl ApnsPooledConnection.java"
git push

echo "end commit"
echo "---------------------------------------------------"
