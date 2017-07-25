#! /bin/bash

echo "begin commit"

sleep 30

date "+%Y-%m-%d %H:%M:%S" >> exe_history

git add .
git commit -m "impl ApnsPooledConnection.java"
git push

echo "end commit"
