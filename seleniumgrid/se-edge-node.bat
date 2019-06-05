::Beginning of hub batch file
set SERVER_VERSION=3.141.0
set TASK_NAME=SeleniumServerNode3
set NODE_PORT=5559
set HUB-PORT=4444
set REGISTER_IP=localhost
set EDGE_DRIVER=C:\WINDOWS\System32\MicrosoftWebDriver.exe
java -Dwebdriver.edge.driver=%EDGE_DRIVER% -jar selenium-server-standalone-%SERVER_VERSION%.jar -role webdriver -hub http://%REGISTER_IP%:%HUB-PORT%/grid/register -browser browserName=MicrosoftEdge -port %NODE_PORT% 
::End of hub batchfile
pause