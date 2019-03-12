@echo off
call create-custom-jdk.bat
rmdir timeline /s/q 
mkdir timeline
move jre timeline\jre
copy src\main\cmd\ timeline
mkdir timeline\resources
xcopy resources timeline\resources /s/e/h
