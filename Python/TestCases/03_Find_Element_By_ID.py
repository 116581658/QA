import time
import re
#import ctypes  # An included library with Python install.
from selenium import webdriver
import tkinter

# options = webdriver.ChromeOptions()
# options.binary_location = "C:/Program Files/Opera/44.0.2510.1218/opera.exe"
# driver = webdriver.Opera(executable_path="C:/02_QA/Selenium/WebDriver/operadriver_2.27.exe", opera_options=options)
# # driver = webdriver.Chrome("C:/02_QA/Selenium/WebDriver/chromedriver.exe")
#
#
# driver.get("http://192.168.103.237:8080/pppadmin/admin/")
#
# try:
#     user_name = driver.find_element_by_name("j_username")
#     print("Element name found")
#     user_name.send_keys("pppadmin")
#
#     password = driver.find_element_by_name("j_password")
#     password.send_keys("pppadmin")
#
#     login = driver.find_element_by_xpath(".//*[@id='loginContent']/p[4]/input")
#     login.click()
#
#     merchant_site = driver.find_element_by_link_text("Search Merchantsite")
#     merchant_site.click()
#
#
# except Exception as e:
#     print("Exception",format(e))

def mbox(title, text, style):
    ctypes.windll.user32.MessageBoxW(0, text, title, style)
exitc = mbox('Your title', 'Your text', 1)
"""
##  Styles:
##  0 : OK
##  1 : OK | Cancel
##  2 : Abort | Retry | Ignore
##  3 : Yes | No | Cancel
##  4 : Yes | No
##  5 : Retry | No 
##  6 : Cancel | Try Again | Continue
"""
print(exitc)

if win32ui.MessageBox("Message", "Title", win32con.MB_YESNOCANCEL) == win32con.IDYES:
    win32ui.MessageBox("You pressed 'Yes'")