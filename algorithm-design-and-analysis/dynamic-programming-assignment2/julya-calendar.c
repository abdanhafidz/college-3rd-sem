#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <limits.h>
#include <stdbool.h>

typedef struct {
    long long key;
    int value;
    bool is_set;
} HashNode;

#define HASH_MAP_SIZE 1000003 

HashNode hash_map[HASH_MAP_SIZE];

long long hash(long long key) {
    return (key % HASH_MAP_SIZE + HASH_MAP_SIZE) % HASH_MAP_SIZE;
}

void set_hash(long long key, int value) {
    long long idx = hash(key);
    while (hash_map[idx].is_set && hash_map[idx].key != key) {
        idx = (idx + 1) % HASH_MAP_SIZE;
    }
    hash_map[idx].key = key;
    hash_map[idx].value = value;
    hash_map[idx].is_set = true;
}

bool get_hash(long long key, int* value) {
    long long idx = hash(key);
    while (hash_map[idx].is_set) {
        if (hash_map[idx].key == key) {
            *value = hash_map[idx].value;
            return true;
        }
        idx = (idx + 1) % HASH_MAP_SIZE;
    }
    return false;
}

int dp(long long n) {
    int memo_value;
    if (get_hash(n, &memo_value)) {
        return memo_value;
    }

    if (n <= 0) return 0;
    if (n < 10) return 1;

    int min_value = INT_MAX;
    long long temp = n;
    while (temp > 0) {
        int digit = temp % 10;
        temp /= 10;
        if (digit != 0) {
            min_value = (min_value < dp(n - digit)) ? min_value : dp(n - digit);
        }
    }
    int result = min_value + 1;

    set_hash(n, result);
    return result;
}

int main() {
    memset(hash_map, 0, sizeof(hash_map));
    long long N;
    scanf("%lld", &N);
    printf("%d\n", dp(N));
    return 0;
}
