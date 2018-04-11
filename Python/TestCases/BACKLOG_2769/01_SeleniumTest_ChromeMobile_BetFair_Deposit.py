
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
chrome_options.binary_location = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"
driver = webdriver.Chrome(executable_path="C:\\02_QA\\Selenium\\WebDriver\\Chrome65-66\\chromedriver.exe", chrome_options=chrome_options)

test_case_name = "Test-Yanko-trunk-tag-Betfair_DEP.tst"

link = "https://srv-bsf-devppptag.gw-4u.com/ppp/purchase.do"
merchant_site_id = 23207

open_web_page1 = link + "?checksum=64ac35f525213da7ff07a0b212b3a94e7b1dd0e733aae05cd93998ecceb82892&item_open_amount_1=true&numberofitems=1&country=DE&merchantLocale="


open_web_page2 = "&merchant_unique_id=MUID&customField1=CF1&theme_id=&item_name_1=money&merchant_id=7567344427081642651&userid=UID&item_max_amount_1=9999999.0&currency=EUR&user_token=auto&time_stamp=2017-09-14.09%3A09%3A18&merchant_site_id=" + str(merchant_site_id) + "&item_min_amount_1=1&version=3.0.0&user_token_id=999880000003&total_amount=10&item_quantity_1=1&item_amount_1=10"


def message_function(title, text_of_message):
    # hide main window
    root = tkinter.Tk()
    root.withdraw()
    messagebox.showinfo(title, text_of_message)


for index in ['ar_AA', 'bg_BG', 'da_DK', 'de_DE', 'en_UK', 'en_US', 'es_ES', 'fr_FR', 'hr_HR', 'it_IT', 'iw_IL', 'ja_JP', 'lt_LT', 'nl_NL', 'pl_PL', 'pt_BR', 'ro_RO', 'ru_RU', 'sl_SI', 'sr_RS', 'sv_SE', 'tr_TR', 'zh_CN', 'sk_SK', 'cs_CZ', 'hu_HU', 'ko_KR', 'en_CA', 'en_AU', 'in_ID', 'pt_PT', 'fi_FI', 'vi_VN', 'el_GR', 'no_NO', 'gr_GR', 'zh_TW', 'en_EN', 'sq_AL', 'cs_CS', 'aa_AR', 'fl_FI']:

    driver.get(open_web_page1 + index + open_web_page2)
    time.sleep(0.5)
    # driver.find_element_by_xpath("//select[@name='merchantLocale']/option[contains(text(), '"+index+"')]").click()
    # driver.find_element_by_xpath('//input[@type=\'submit\']').click()

    # placeholders
    thePlaceholder = driver.find_element_by_xpath("//*[@id='wd_mb_email']").get_attribute('placeholder')

    print("{0}\t".format(thePlaceholder), end="")

    # titles
    # theTitle = driver.find_element_by_xpath('//*[@id="wd_mb_email"]').get_attribute("title")
    # print("{0}\t".format(theTitle), end="")

    # Shows a message box window
    # the_text = str(index) + " :"+theTitle
    # message_function("window", the_text)

print("\n" + driver.title)
driver.quit()
