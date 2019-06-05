::Beginning of hub batch file
set SERVER_VERSION=3.141.0
set TASK_NAME=SeleniumServerNode3
set NODE_PORT=5557
set HUB-PORT=4444
set REGISTER_IP=localhost
set CHROME_DRIVER=C:\Users\Yuliya_Eibatava\.m2\repository\webdriver\chromedriver\win32\74.0.3729.6\chromedriver.exe
java -Dwebdriver.chrome.driver=%CHROME_DRIVER% -jar selenium-server-standalone-%SERVER_VERSION%.jar -role webdriver -hub http://%REGISTER_IP%:%HUB-PORT%/wb/hub -browser "browserName=chrome,platform=WINDOWS" -port %NODE_PORT% 
::End of hub batchfile
pause