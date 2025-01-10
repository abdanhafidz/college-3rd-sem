N, M = map(int, input().split())
matrix = []
for _ in range(M):
    matrix.extend(map(int, input().split()))
matrix.sort()


def binary_search(arr, x):
    left, right = 0, len(arr)
    while left < right:
        mid = (left + right) // 2
        if arr[mid] < x:
            left = mid + 1
        else:
            right = mid
    return left

_ = input()
tc = list(map(int, input().split()))
print(" ".join(str(binary_search(matrix, x)) for x in tc))