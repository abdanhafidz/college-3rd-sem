#include <bits/stdc++.h>
#define REP(i,o,n) for(long long i=o;i<n;i++)
using namespace std;


int main(){
    long long n,m;
    cin>>n>>m;
    long long x=0;
    long long mx=-2e9;
    REP(i,0,n){
        long long t;cin>>t;
        if(t>0)x+=t;
        mx=max(mx,t);
    }
    if(!x)x=mx;
     mx=2e9;
    long long y=0;
    REP(j,0,m){
        long long t;cin>>t;
        if(t<0)y-=t;
        mx=min(mx,t);
    }
    if(!y)y=-mx;
    cout<<min(-(x+y),0LL)<<'\n';
}