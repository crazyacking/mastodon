#include <iostream>
#include <cstdlib>
#include <vector>
#include <iostream>
#include <algorithm>
#include <unistd.h>
#include <sstream>
#include <string>
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
        system(s.c_str());
    }
}

int main() {
    while(true) {
        auto_commit();

        /* gap 6 hours */
        for(int i=1; i<4320; ++i) {
            /* print keep-alive log */
            std::ostringstream ss;
            ss << i;
            string cmd="echo ";
            cmd+=ss.str();
            cmd+=" >>  keep_thread_alive.log";
            system(cmd.c_str());
            sleep(5);
        }
    }
    return 0;
}



