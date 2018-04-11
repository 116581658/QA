
from selenium import webdriver
from tkinter import messagebox
import time
import tkinter

options = webdriver.ChromeOptions()
options.binary_location = "C:/Program Files/Opera/47.0.2631.80/opera.exe"
driver=webdriver.Opera(executable_path="C:/02_QA/Selenium/WebDriver/operadriver_2.27.exe", opera_options=options)

test_case_name = "Test-Yanko-trunk-tag-Betfair_DEP.tst"

link = "https://srv-bsf-devppptag.gw-4u.com/ppp/purchase.do"
merchant_site_id = 23207

open_web_page1 = link+"?checksum=b41752c679bcae5fc21cc5c38406ece8a151819bc179c310f6123920ea49868d&item_open_amount_1=true&numberofitems=1&country=DE&merchantLocale="
open_web_page2="&merchant_unique_id=MUID&customField1=CF1&theme_id=&item_name_1=money&merchant_id=7567344427081642651&userid=UID&item_max_amount_1=9999999.0&currency=AUD&user_token=auto&time_stamp=2017-09-13.10%3A09%3A45&merchant_site_id="+str(merchant_site_id)+"&item_min_amount_1=1&version=3.0.0&user_token_id=99988000000023&total_amount=10&item_quantity_1=1&item_amount_1=10"

# driver.get("http://localhost:8080/ppptest/TCrun?TSuite=\\BetFair_PaddyPower")
# driver.find_element_by_link_text(test_case_name).click()
# driver.find_element_by_xpath("//select[@name='pppurl']/option[text()='https://srv-bsf-devppptag.gw-4u.com/ppp/purchase.do']").click()
# driver.find_element_by_xpath("//select[@name='merchant_site_id']/option[text()='23207']").click()


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
    # thePlaceholder = driver.find_element_by_xpath('//*[@id="wd_mb_email"]').get_attribute("placeholder")
    # print("{0}\t".format(thePlaceholder), end="")

    # titles
    time.sleep(0.5)
    theTitle = driver.find_element_by_xpath('//*[@id="wd_mb_email"]').get_attribute("title")
    print("{0}\t".format(theTitle), end="")

    # Shows a message box window
    #the_text = str(index) + " :"+theTitle
    #message_function("window", the_text)

print("\n" + driver.title)
driver.quit()
