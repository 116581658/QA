
from selenium import webdriver
from tkinter import messagebox
import time
import tkinter


from selenium.webdriver.chrome.options import Options

mobile_emulation = {
    "deviceMetrics": {"width": 360, "height": 640, "pixelRatio": 3.0},
    "userAgent": "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19"}
chrome_options = Options()
chrome_options.add_experimental_option("mobileEmulation", mobile_emulation)
chrome_options.binary_location = "C:\Program Files (x86)\Google\Chrome\Application\chrome.exe"
driver = webdriver.Chrome(executable_path="C:/02_QA/Selenium/WebDriver/Chrome65-66/chromedriver.exe", chrome_options=chrome_options)

test_case_link = "http://localhost:8080/ppptest/TCrun?TSuite=\\SC_BackLog"
test_case_name = "BACKLOG-2769_trunk-tag-HOT_ICE_WD.tst"
link = "https://srv-bsf-devppptag.gw-4u.com/ppp/withdrawal/withdraw.do"
merchant_site_id = 26907


driver.get(test_case_link)
driver.find_element_by_link_text(test_case_name).click()
driver.find_element_by_xpath(
    "//select[@name='pppurl']/option[text()='" + link + "']").click()
driver.find_element_by_xpath(
    "//select[@name='merchant_site_id']/option[text()='" + str(merchant_site_id) + "']").click()
driver.find_element_by_xpath("//*[@id='btnSubmit']").click()

chrome_options = Options()
chrome_options.add_experimental_option("mobileEmulation", mobile_emulation)
driver = webdriver.Chrome(
    executable_path="C:/02_QA/Selenium/WebDriver/chromedriver.exe", chrome_options=chrome_options)


def message_function(title, text_of_message):
    # hide main window
    root = tkinter.Tk()
    root.withdraw()
    messagebox.showinfo(title, text_of_message)


for index in ['ar_AA', 'bg_BG', 'da_DK', 'de_DE', 'en_UK', 'en_US', 'es_ES', 'fr_FR', 'hr_HR', 'it_IT', 'iw_IL', 'ja_JP', 'lt_LT', 'nl_NL', 'pl_PL', 'pt_BR', 'ro_RO', 'ru_RU', 'sl_SI', 'sr_RS', 'sv_SE', 'tr_TR', 'zh_CN', 'sk_SK', 'cs_CZ', 'hu_HU', 'ko_KR', 'en_CA', 'en_AU', 'in_ID', 'pt_PT', 'fi_FI', 'vi_VN', 'el_GR', 'no_NO', 'gr_GR', 'zh_TW', 'en_EN', 'sq_AL', 'cs_CS', 'aa_AR', 'fl_FI']:

    driver.get(open_web_page1 + index + open_web_page2)

    # driver.find_element_by_xpath("//select[@name='merchantLocale']/option[contains(text(), '"+index+"')]").click()
    # driver.find_element_by_xpath('//input[@type=\'submit\']').click()

    # placeholders
    # thePlaceholder = driver.find_element_by_xpath('//*[@class="wd_mb_email"]').get_attribute("placeholder")

    # print("{0}\t".format(thePlaceholder), end="")

    # titles
    theTitle = driver.find_element_by_xpath(
        '//*[@class="wd_mb_email"]').get_attribute("title")
    print("{0}\t".format(theTitle), end="")

    # Shows a message box window
    # the_text = str(index) + " :"+theTitle
    # message_function("window", the_text)

print(driver.title)
time.sleep(2)
driver.quit()
