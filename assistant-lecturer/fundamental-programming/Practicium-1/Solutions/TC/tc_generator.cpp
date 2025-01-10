#include <fstream>
#include <iostream>
#include <random>
#include <vector>
#include <string>
using namespace std;

void GenerateInput() {
    random_device rd;
    mt19937 gen(rd());
    
    for (int k = 0; k < 24; ++k) {
        ofstream f("secret_" + to_string(k) + ".in");
        uniform_int_distribution<int> N_dist(pow(10, k), pow(10, k+1) - 1);
        int N = N_dist(gen);
        
        uniform_int_distribution<int> B_dist(1, 4);
        vector<string> B;
        for (int i = 0; i < N; ++i) {
            B.push_back(to_string(B_dist(gen)));
        }
        
        f << N << "\n";
        if (B.size() > 1) {
            for (size_t i = 0; i < B.size(); ++i) {
                f << B[i];
                if (i != B.size() - 1) f << " ";
            }
        } else {
            f << B[0];
        }
        f.close();
    }
}
