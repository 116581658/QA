
import time
from page_objects import PageObject, PageElement
from selenium import webdriver


class ElAl_1983 (PageObject):
    def __init__(self, driver):
        self.driver = driver

    def click_to_LogoCredit(self):
        element = self.driver.find_element_by_xpath("id(\"pm_label_cc_card\")")
        element.click()


    def CCType(self):
        return self.driver.find_element_by_xpath("id(\"dk_container_dummy_debit_type\")/a[1]/span[1]")

    def Isracard(self):
        return self.driver.find_element_by_xpath("id(\"dk_container_dummy_debit_type\")/div[1]/ul[1]/li[3]/a[1]")

    def CVV(self):
        return self.driver.find_element_by_id("cc_cvv2")

    def MonthDrop(self):
        return self.driver.find_element_by_xpath("id(\"dk_container_cc_exp_month\")/a[1]/span[1]")

    def Month3(self):
        return self.driver.find_element_by_xpath("id(\"dk_container_cc_exp_month\")/div[1]/ul[1]/li[4]/a[1]")

    def YearDrop(self):
        return self.driver.find_element_by_xpath("id(\"dk_container_cc_exp_year\")/a[1]")

    def Year2019(self):
        return self.driver.find_element_by_xpath("id(\"dk_container_cc_exp_year\")/div[1]/ul[1]/li[5]/a[1]")

    def nr1(self):
        return self.driver.find_element_by_id("israeli_card_holder_id_visible0")

    def nr2(self):
        return self.driver.find_element_by_id("israeli_card_holder_id_visible1")

    def nr3(self):
        return self.driver.find_element_by_id("israeli_card_holder_id_visible2")

    def nr4(self):
        return self.driver.find_element_by_id("israeli_card_holder_id_visible3")

    def nr5(self):
        return self.driver.find_element_by_id("israeli_card_holder_id_visible4")

    def nr6(self):
        return self.driver.find_element_by_id("israeli_card_holder_id_visible5")

    def nr7(self):
        return self.driver.find_element_by_id("israeli_card_holder_id_visible6")

    def nr8(self):
        return self.driver.find_element_by_id("israeli_card_holder_id_visible7")

    def nr9(self):
        return self.driver.find_element_by_id("israeli_card_holder_id_visible8")

    def Zip(self):
        return self.driver.find_element_by_id("zip")

    def Email(self):
        return self.driver.find_element_by_id("email")

    def ContinueBTN(self):
        return self.driver.find_element_by_id("sub_continueButton")


options = webdriver.ChromeOptions()
options.binary_location = "C:/Program Files/Opera/44.0.2510.1218/opera.exe"
driver=webdriver.Opera(executable_path="C:/02_QA/Selenium/WebDriver/operadriver_2.27.exe",opera_options=options)
driver.get("http://en.wikipedia.org")
page = ElAl_1983(options)
page.LogoCredit()

print(driver.title)
time.sleep(2)
driver.quit()






