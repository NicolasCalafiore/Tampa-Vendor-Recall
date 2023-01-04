@echo on
if not DEFINED IS_MINIMIZED set IS_MINIMIZED=1 && start "" /min "%~dpnx0" %* && exit
start  /min java -jar VendorServer.jar
timeout 2
start  /min java -jar Vendor_Managment.jar
exit