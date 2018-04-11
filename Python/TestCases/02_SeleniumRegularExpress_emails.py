import time
import re
from selenium import webdriver


options = webdriver.ChromeOptions()
options.binary_location = "C:/Program Files/Opera/47.0.2631.80/opera.exe"
driver = webdriver.Opera(executable_path="C:/02_QA/Selenium/WebDriver/operadriver_2.27.exe", opera_options=options)
# driver = webdriver.Chrome("C:/02_QA/Selenium/WebDriver/chromedriver.exe")


driver.get("http://www.airindia.in/contact-details.htm")
doc = driver.page_source

emails = re.findall(r'>[\w.-]+@[\w.-]+', doc)
# emails = [1,2,3,4]
for email in emails:
    the_string = email[1:]
    print(the_string)

time.sleep(2)
driver.quit()










