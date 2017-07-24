#! /bin/bash

echo "begin commit"


date "+%Y-%m-%d %H:%M:%S" >> exe_history

git add .
git commit -m "update"
git push

echo "end commit"
