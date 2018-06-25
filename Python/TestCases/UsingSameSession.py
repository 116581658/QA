from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import Select
from selenium.webdriver.common.action_chains import ActionChains


options = webdriver.ChromeOptions()
options.binary_location = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"
browser=webdriver.Chrome(executable_path="C:\\02_QA\\Selenium\\WebDriver\\Chrome65-66\\chromedriver.exe")

wait = WebDriverWait(browser, 10)


#browser.get('https://automatetheboringstuff.com')
browser.get('https://srv-bsf-devcpatrunk.gw-4u.com/login?lang=en_us')
# browser.get('https://srv-bsf-devcpatag.gw-4u.com/')
browser.maximize_window()

# userName = "yanko_multi"
# userPass = "PAss1234"
# nameManagingComany = "G2S"


userName = "yanko_cP_tr_03_test-wdr"
userPass = "PAss1234"
nameManagingComany = "SC"


# "C:\02_QA\Selenium\WebDriver\Chrome65-66\chromedriver.exe"

# geckodriver_v0_21_0_Firefox_57_Selenium_3_11

pathUserName          = "//*[@id='login_name']"
pathUserPass          = "//*[@id='login_pass']"
nameManagingCompCheck = "managingCompanyIgnoreDomain"
pathLogIn             = "//input[@value='Log in']"
loginLogOutMenu       = "//*[@id='my_profile_main_menu']" # CPanel element from the next page

element_userName_wait = wait.until(EC.visibility_of_element_located((By.XPATH,pathUserName)))

element_userName = browser.find_element(By.XPATH,pathUserName)
element_userName.send_keys(userName)

element_userPass = browser.find_element(By.XPATH,pathUserPass)
element_userPass.send_keys(userPass)

select = Select(browser.find_element_by_name('managingCompanyNumberTest'))
if (nameManagingComany!=""):
    select.select_by_visible_text(nameManagingComany)
else:
    pass

element_Login = browser.find_element(By.XPATH,pathLogIn)
element_Login.click()


element_Login_wait = wait.until(EC.invisibility_of_element_located((By.XPATH,pathLogIn)))

# Navigating in Main menu:
section       = "Reports"
subSection    = "Operational Reports"
subSubSection = "Transaction Search"

subReports_Menu = "//*[@id='reports_menu']"
menuReports_by_text        = "//a[text()[normalize-space(.)='" + section + "']]"
dropDown_SubMenu_by_text   = subReports_Menu + "//a[text()[normalize-space(.)='" + subSection + "']]"
dropDown_FinalMenu_by_text = subReports_Menu + "//a[text()[normalize-space(.)='" + subSubSection + "']]"
reportTable                = "//*[@id='reportAccordion']/li[1]"

reportsHeader = browser.find_element(By.XPATH,menuReports_by_text)
subMenu1_DropDown = browser.find_element(By.XPATH,dropDown_SubMenu_by_text)
subMenu_Final = browser.find_element(By.XPATH,dropDown_FinalMenu_by_text)

actions = ActionChains(browser)
actions.click(reportsHeader)
actions.click(subMenu1_DropDown)
actions.click_and_hold(subMenu_Final).release()
actions.perform()

wait.until(EC.visibility_of_element_located((By.XPATH,reportTable)))
