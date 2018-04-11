import time
from selenium import webdriver
from selenium.webdriver.chrome import service




# webdriver_service = service.Service('C:/Program Files/Opera/51.0.2830.55/opera.exe')
# webdriver_service.start()
# driver = webdriver.Remote(webdriver_service.service_url, webdriver.DesiredCapabilities.OPERA)

options = webdriver.ChromeOptions()
options.binary_location = "C:/Program Files/Opera/51.0.2830.55/opera.exe"


driver=webdriver.Opera( executable_path="C:/02_QA/Selenium/WebDriver/operadriver_2.27.exe", desired_capabilities.options)
driver.get("http://en.wikipedia.org")
print(driver.title)
time.sleep(2)
driver.quit()










