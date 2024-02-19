#!/bin/bash


project_dir=$(cd "$(dirname "$0")" && pwd)


if [ -z "$1" ]; then
    printf "Enter name of apk to launch: "
    read -r apk
fi

if [ -z "$2" ]; then
    printf "Release or Debug [r/d]: "
    read -r mode
else
    mode="$2"
fi

if [ "$mode" != 'r' ] && [ "$mode" != "release" ] && [ "$mode" != 'd' ] && [ "$mode" != "debug" ]; then
    echo "Invalid build mode. Try 'release' or 'debug'"
    exit 1
fi

if [ "$mode" == 'r' ]; then
    mode="release"
fi

if [ "$mode" == 'd' ]; then
    mode="debug"
fi

file="$project_dir/app/build/outputs/apk/$mode/$apk-$mode.apk"

if [ ! -f "$file" ]; then
    file="$project_dir/$apk/build/outputs/apk/$mode/$apk-$mode-unsigned.apk"
fi

adb install "$file" 
exit 0
