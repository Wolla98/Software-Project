::@echo off
javac Main.java View.java Controller.java Model.java
if %errorlevel% neq 0 (
	echo Error Compiling	
) else (
	echo Compiled correctly
	java Main
)

