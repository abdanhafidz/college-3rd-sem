#include <iostream>
#include <string>
#include "testlib.h"
 
using namespace std;
 
int main(int argc, char *argv[]) {
    registerValidation(argc, argv);
    string line1 = inf.readString();
    inf.readEoln();
    string line2 = inf.readString();
    inf.readEoln();
    inf.readEof();
}