::@echo off 

set CURR_DIR_WITH_BSLH=%~dp0
set CURR_DIR_WOUT_BSLH=%CURR_DIR_WITH_BSLH:~0,-1%
for %%f in ("%CURR_DIR_WOUT_BSLH%") do set PRJ_NAME=%%~nxf

set DOMAIN_NAME=ru
set COMPANY_NAME=rudikov_bn

set DCP_NAMES=%DOMAIN_NAME%\%COMPANY_NAME%\%PRJ_NAME%
set BUILD_DIR=%CURR_DIR_WOUT_BSLH%\build

echo start building project %PRJ_NAME%... && echo:

if exist "%BUILD_DIR%" (
    rmdir /s /q "%BUILD_DIR%" 2>&1 1>nul
    echo previous build directory removed successfully! && echo:
)

set GEN_DIR=%BUILD_DIR%\%DCP_NAMES%\gen
set OBJ_DIR=%BUILD_DIR%\%DCP_NAMES%\obj
set APK_DIR=%BUILD_DIR%\%DCP_NAMES%\apk

mkdir "%GEN_DIR%" "%OBJ_DIR%" "%APK_DIR%"
echo new build directory created successfully! && echo:
                                                   
set ANDROID_MANIFEST_XML=%CURR_DIR_WOUT_BSLH%\src\main\AndroidManifest.xml
set ANDROID_JAR=%CURR_DIR_WOUT_BSLH%
:: При необходимости, перед вызовом скрипта "setvars.bat", изменить в нем
:: значения переменных JAVA_HOME, JRE_HOME, ANDROID_HOME на актуальные
if exist "setvars.bat" call "setvars.bat"

aapt package -f -m -J "%GEN_DIR%" -S src\main\res ^
    -M "%ANDROID_MANIFEST_XML%" -I "%ANDROID_JAR%"
if %ERRORLEVEL% neq 0 (
    echo: && echo project build failed! && echo:
    pause & exit /b 1
)

echo resource compilation completed successfully! && echo:

set JAVA_VERSION=17
javac -source "%JAVA_VERSION%" -target "%JAVA_VERSION%" -encoding UTF-8 ^
    -bootclasspath "%JAVA_HOME%\jre\lib\rt.jar" -classpath "%ANDROID_JAR%" ^
    -sourcepath src\main\java ^
    -d "%OBJ_DIR%" ^
    "%GEN_DIR%\%DCP_NAMES%\R.java" ^
    "src\main\java\%DCP_NAMES%\MainActivity.java"
if %ERRORLEVEL% neq 0 (
    echo: && echo project build failed! && echo:
    pause & exit /b 2
)

echo project compilation completed successfully! && echo:

call dx --dex --output="%APK_DIR%\classes.dex" "%OBJ_DIR%"
if not exist "%APK_DIR%\classes.dex" (
    echo dx: classes.dx not found! && echo:
    echo project build failed! && echo:
    pause & exit /b 3
)

aapt package -f -M "%ANDROID_MANIFEST_XML%" -S src\main ^
    -I "%ANDROID_JAR%" ^
    -F "%BUILD_DIR%\%DCP_NAMES%\%PRJ_NAME%.unaligned.unsigned.apk" "%APK_DIR%"
if %ERRORLEVEL% neq 0 (
    echo: && echo project build failed! && echo:
    pause & exit /b 4
)

echo %PRJ_NAME%.unaligned.unsigned.apk created successfully! && echo:

zipalign -f 4 "%BUILD_DIR%\%DCP_NAMES%\%PRJ_NAME%.unaligned.unsigned.apk" ^
    "%BUILD_DIR%\%DCP_NAMES%\%PRJ_NAME%.aligned.unsigned.apk"
if %ERRORLEVEL% neq 0 (
    echo: && echo project build failed! && echo:
    pause & exit /b 5
)

echo %PRJ_NAME%.aligned.unsigned.apk created successfully! && echo:

set KEY_STORE_JKS=%TEMP%\keystore.jks
if not exist "%KEY_STORE_JKS%" (
    keytool -genkeypair -keystore "%KEY_STORE_JKS%" -alias androidkey ^
        -validity 10000 -keyalg RSA -keysize 2048 -storepass android ^
        -keypass android
    if %ERRORLEVEL% neq 0 (
        echo: && echo project build failed! && echo:
        pause & exit /b 6
    )

    echo %KEY_STORE_JKS% created successfully! && echo:
)

call apksigner sign --ks "%KEY_STORE_JKS%" --ks-key-alias androidkey ^
    --ks-pass pass:android --key-pass pass:android ^
    --out "%BUILD_DIR%\%DCP_NAMES%\%PRJ_NAME%.aligned.signed.apk" ^
    "%BUILD_DIR%\%DCP_NAMES%\%PRJ_NAME%.aligned.unsigned.apk"
if not exist "%BUILD_DIR%\%DCP_NAMES%\%PRJ_NAME%.aligned.signed.apk" (
    echo apksigner: "%PRJ_NAME%.aligned.signed.apk" not found! && echo:
    echo project build failed! && echo:
    pause & exit /b 7
)

echo %PRJ_NAME%.aligned.signed.apk created successfully! && echo:

move "%BUILD_DIR%\%DCP_NAMES%\%PRJ_NAME%.aligned.signed.apk" ^
    "%BUILD_DIR%\%DCP_NAMES%\%PRJ_NAME%.apk" 2>&1 1>nul
if %ERRORLEVEL% neq 0 (
    echo: && echo project build failed! && echo:
    pause & exit /b 8
)

echo %PRJ_NAME%.aligned.signed.apk to ^
%PRJ_NAME%.apk renamed successfully! && echo:

echo project build completed successfully! && echo:

::set /p answer=use adb to install %PRJ_NAME%.apk on android's device [y/n]?: 
::if %answer% == y (
    ::set EMULATOR_IP_ADDR=192.168.56.101
    ::adb connect %EMULATOR_IP_ADDR%
    ::adb install %BUILD_DIR%\%DCP_NAMES%\%PRJ_NAME%.apk
::    echo 123
::)

pause & exit /b 0
