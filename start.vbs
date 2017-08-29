Set oWmg = GetObject("winmgmts:") 

strWndprs = "select * from Win32_Process where name='cmd.exe'" 
Set objQResult = oWmg.Execquery(strWndprs) 
For Each objProcess In objQResult 
	intReturn = objProcess.Terminate(1) 
Next

Set oShell = CreateObject ("WScript.Shell") 
oShell.run "cmd.exe /k adb connect 127.0.0.1:62001"
oShell.run "java -jar KingsRaid.jar --c:14 --w:145"
Set oShell = Nothing
