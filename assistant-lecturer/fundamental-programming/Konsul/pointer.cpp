#include <iostream>
using namespace std;

void add(int* x){
    *x += 1;
}
int main(){
    int x = 5;
    add(&x);
    cout<<x<<endl;
    return 0;
}