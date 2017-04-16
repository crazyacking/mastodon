#include <iostream>
#include<cstdlib>
#include<string>
#include<cstdio>
#include<cstring>
#include<vector>
#include<iostream>
#include<algorithm>
using namespace std;

int auto_commit() {
    vector<string> cmds;
    cmds.push_back("echo `date \"+%Y-%m-%d %H:%M:%S\"` >>  exe_history");
    cmds.push_back("git add .");
    cmds.push_back("git commit -m \"impl ApnsPooledConnection.java\"");
    cmds.push_back("git push");

    vector<string>::iterator iter=cmds.begin();
    for(; iter!=cmds.end(); iter++) {
        string s=*iter;
        cout<<s<<endl;
        system(s.c_str());
    }
}

int main() {
    auto_commit();
    return 0;
}

