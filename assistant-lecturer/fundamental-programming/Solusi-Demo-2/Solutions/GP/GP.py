n, dist_a_b , dist_b_c, dist_c_d, dist_d_e, = map(int, input().split())
if(dist_a_b <= n and dist_b_c <= n and dist_c_d <= n and dist_d_e <= n):
    print("YES HE CAN")
else:
    print("NO HE CAN'T")