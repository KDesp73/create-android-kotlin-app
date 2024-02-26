#!/bin/bash

module=$(find . -iname 'MainActivity.kt' | cut -d "/" -f2)

printf "Install to emulator or device [e/d]: "
read -r device

if [ "$device" != 'd' ] && [ "$device" != 'e' ]; then
    echo "Incorrect device. Try 'e' or 'd'"
    exit 1
fi

file="$module/build/output/apk/debug/$module-debug.apk"

if [ ! -f "$file" ]; then
    echo "Run './gradlew build' first"
    exit 1
fi

if [ "$device" == 'd' ]; then
    adb -d install "$file" 
    exit 0
fi

adb install "$file"

exit 0
