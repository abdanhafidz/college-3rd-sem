import random
import os

# Fungsi untuk menghasilkan test case dengan barang dan uang
def generate_testcase(P_condition, C_condition, N, M):
    # Generate barang berdasarkan kondisi P
    if P_condition == "P>0":
        barang = [random.randint(1, 10**6) for _ in range(N)]
    elif P_condition == "P<0":
        barang = [random.randint(-10**6, -1) for _ in range(N)]
    elif P_condition == "P mixed":
        barang = [random.randint(-10**6, 10**6) for _ in range(N)]

    # Generate uang berdasarkan kondisi C
    if C_condition == "C>0":
        uang = [random.randint(1, 10**6) for _ in range(M)]
    elif C_condition == "C<0":
        uang = [random.randint(-10**6, -1) for _ in range(M)]
    elif C_condition == "C mixed":
        uang = [random.randint(-10**6, 10**6) for _ in range(M)]

    return barang, uang

# Fungsi untuk menghitung hasil (jawaban)
def calculate_hutang(barang, uang):
    min_barang = min(barang)
    max_barang = max(barang)
    min_uang = min(uang)
    max_uang = max(uang)

    all_barang_positif = (min_barang > 0 and max_barang > 0)
    all_uang_positif = (min_uang > 0 and max_uang > 0)
    all_barang_negatif = (min_barang < 0 and max_barang < 0)
    all_uang_negatif = (min_uang < 0 and max_uang < 0)

    if all_barang_negatif and all_uang_positif:
        return 0
    elif all_uang_positif:
        return min_uang - sum(list(filter(lambda x: x > 0, barang)))
    elif all_barang_negatif:
        return sum(list(filter(lambda x: x < 0, uang))) - max(barang)
    else:
        belanja = 0
        bayar = 0
        for ambil_barang in barang:
            if ambil_barang > 0:
                belanja += ambil_barang
        for ambil_uang in uang:
            if ambil_uang < 0:
                bayar += ambil_uang
        return bayar - belanja

# Fungsi untuk menyimpan testcase ke file
def save_testcase_to_file(tc_num, N, M, barang, uang):
    input_filename = f"testcase_{tc_num}.in"
    output_filename = f"testcase_{tc_num}.ans"
    
    # Menulis input file
    with open(input_filename, 'w') as f_in:
        f_in.write(f"{N} {M}\n")
        f_in.write(" ".join(map(str, barang)) + "\n")
        f_in.write(" ".join(map(str, uang)) + "\n")
    
    # Menulis output file (jawaban)
    hutang = calculate_hutang(barang, uang)
    with open(output_filename, 'w') as f_out:
        f_out.write(f"{hutang}\n")

# Fungsi utama untuk menghasilkan 5 testcase per kondisi
def generate_all_testcases():
    tc_num = 1
    
    # TC 1: ∀_i (P_i>0 ∧ C_i<0)
    for _ in range(5):
        N, M = random.randint(1, 10**4), random.randint(1, 10**4)
        barang, uang = generate_testcase("P>0", "C<0", N, M)
        save_testcase_to_file(tc_num, N, M, barang, uang)
        tc_num += 1

    # TC 2: ∀_i (P_i<0 ∧ C_i<0)
    for _ in range(5):
        N, M = random.randint(1, 10**4), random.randint(1, 10**4)
        barang, uang = generate_testcase("P<0", "C<0", N, M)
        save_testcase_to_file(tc_num, N, M, barang, uang)
        tc_num += 1

    # TC 3: ∃_(i,j) (P_i<0 ∨ P_j>0) ∧ C_i<0
    for _ in range(5):
        N, M = random.randint(1, 10**4), random.randint(1, 10**4)
        barang, uang = generate_testcase("P mixed", "C<0", N, M)
        save_testcase_to_file(tc_num, N, M, barang, uang)
        tc_num += 1

    # TC 4: ∀_i (P_i>0 ∧ C_i>0)
    for _ in range(5):
        N, M = random.randint(1, 10**4), random.randint(1, 10**4)
        barang, uang = generate_testcase("P>0", "C>0", N, M)
        save_testcase_to_file(tc_num, N, M, barang, uang)
        tc_num += 1

    # TC 5: ∀_i (P_i<0 ∧ C_i>0): Out = 0
    for _ in range(5):
        N, M = random.randint(1, 10**4), random.randint(1, 10**4)
        barang, uang = generate_testcase("P<0", "C>0", N, M)
        save_testcase_to_file(tc_num, N, M, barang, uang)
        tc_num += 1

    # TC 6: ∃_(i,j) (P_i<0 ∨ P_j>0) ∧ C_i>0
    for _ in range(5):
        N, M = random.randint(1, 10**4), random.randint(1, 10**4)
        barang, uang = generate_testcase("P mixed", "C>0", N, M)
        save_testcase_to_file(tc_num, N, M, barang, uang)
        tc_num += 1

    # TC 7: ∀_i (P_i<0) ∧ ∃_(i,j) (C_i<0 ∨ C_j>0)
    for _ in range(5):
        N, M = random.randint(1, 10**4), random.randint(1, 10**4)
        barang, uang = generate_testcase("P<0", "C mixed", N, M)
        save_testcase_to_file(tc_num, N, M, barang, uang)
        tc_num += 1

    # TC 8: ∀_i (P_i>0) ∧ ∃_(i,j) (C_i<0 ∨ C_j>0)
    for _ in range(5):
        N, M = random.randint(1, 10**4), random.randint(1, 10**4)
        barang, uang = generate_testcase("P>0", "C mixed", N, M)
        save_testcase_to_file(tc_num, N, M, barang, uang)
        tc_num += 1

# Menjalankan fungsi utama untuk menghasilkan semua test case
generate_all_testcases()
