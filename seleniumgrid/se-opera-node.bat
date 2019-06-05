::Beginning of hub batch file
set SERVER_VERSION=3.141.0
set TASK_NAME=SeleniumServerNode3
set NODE_PORT=5558
set HUB-PORT=4444
set REGISTER_IP=localhost
set OPERA_DRIVER=C:\Users\Yuliya_Eibatava\.m2\repository\webdriver\operadriver\win32\2.45\operadriver.exe
java -Dwebdriver.opera.driver=%OPERA_DRIVER% -jar selenium-server-standalone-%SERVER_VERSION%.jar -role webdriver -hub http://%REGISTER_IP%:%HUB-PORT%/grid/register -browser browserName=operablink -port %NODE_PORT% 
::End of hub batchfile
pause