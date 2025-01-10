#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric>  // untuk std::accumulate
using namespace std;

int main() {
    int N, M;
    cin >> N >> M;
    
    vector<int> barang(N), uang(M);
    
    for(int i = 0; i < N; i++) {
        cin >> barang[i];
    }
    
    for(int i = 0; i < M; i++) {
        cin >> uang[i];
    }

    int min_barang = *min_element(barang.begin(), barang.end());
    int max_barang = *max_element(barang.begin(), barang.end());
    int min_uang = *min_element(uang.begin(), uang.end());
    int max_uang = *max_element(uang.begin(), uang.end());

    int hutang = 0;

    // Kasus Pertama Barang (+), Uang (+)
    if(min_barang > 0 && max_barang > 0 && min_uang > 0 && max_uang > 0) {
        hutang = min_uang - accumulate(barang.begin(), barang.end(), 0);
    }
    // Kasus Pertama Barang (-), Uang (-)
    else if(min_barang < 0 && max_barang < 0 && min_uang < 0 && max_uang < 0) {
        hutang = accumulate(uang.begin(), uang.end(), 0) - max_barang;
    }
    // Kasus Barang (-), Uang (+)
    else if(min_barang < 0 && max_barang < 0 && min_uang > 0 && max_uang > 0) {
        hutang = 0;
    }
    // Kasus lainnya
    else {
        int belanja = 0, bayar = 0;
        for(int ambil_barang : barang) {
            if(ambil_barang > 0) {
                belanja += ambil_barang;
            }
        }
        for(int ambil_uang : uang) {
            if(ambil_uang < 0) {
                bayar += ambil_uang;
            }
        }
        hutang = bayar - belanja;
    }

    cout << hutang << endl;

    return 0;
}
