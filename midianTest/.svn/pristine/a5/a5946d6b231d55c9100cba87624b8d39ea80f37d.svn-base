@echo off
echo 开始重建......
mvn clean package
copy /y %cd%\target\*.jar %cd%\target\lib\
echo 重建完成！