grade = input("Enter desired grade >")
min_grade = float(input("Enter minimum average required >"))
current_average = float(input("Enter current average in course >"))
weight_final = float(input("Enter how much the final counts as a percentage of the course grade >"))
weight_final /= 100
final_grade = float(abs(((current_average - min_grade ) / weight_final) - current_average))
final_grade = "{:.2f}".format(final_grade)
print(f"You need a score of {final_grade} on the final to get {grade}")
