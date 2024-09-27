import requests
import pandas as pd
from bs4 import BeautifulSoup

url = 'https://www.dicoding.com/academies/list'
response = requests.get(url)

if response.status_code == 200:
    html = response.content
# beautiful soup
soup = BeautifulSoup(html, 'html.parser')

courses = []
# BeautifulSoup will find the CSS class that contain product container
for course in soup.find_all('div', class_='col-md-6 mb-3'):
    course_name = course.find('h5', class_='course-card__name').text
    course_hour = course.find_all('span', {'class':'mr-2'})[0].text
    course_summary = course.select('div.course-card__summary p')[0].text
    course_total_module = course.find_all('div', class_= 'course-card__info-item')[0].find_all('span')[0].contents[0]
    course_level = course.find('span', attrs={'class': None}).text
    # Not all courses in the list has rating, so we should manage it. 
    # If it has rating, get the text. If none, set it to empty string.
    try:
        course_rating = course.find_all('span', {'class':'mr-2'})[1].text
        
    except IndexError:
        # Handle the case when no span elements with the specified class are found
        course_rating = ''

    # Not all courses in the list has total students, so we should manage it. 
    # If it has total students, get the text. If none, set it to empty string.
    try:
        course_total_students = course.find_all('span', {'class':'mr-3'})[1].get_text()
    except:
        course_total_students = ''
    courses.append(
            {
                'Course Name': course_name,
                'Learning Hour': course_hour,
                'Rating': course_rating,
                'Level': course_level,
                'Summary': course_summary,
                'Total Modules': course_total_module,
                'Total Students': course_total_students
            }
        )

print(pd.DataFrame(courses))