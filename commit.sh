#! /bin/bash

echo "---------------------------------------------------"
echo ">>> begin commit"

cd /Users/shanbiao.jsb/code/github/mastodon

#date "+%Y-%m-%d %H:%M:%S" >> exe_history
echo " " >> exe_history

git add .
git commit -m "impl ApnsPooledConnection.java"
git push

echo ">>> end commit"
echo "---------------------------------------------------"
