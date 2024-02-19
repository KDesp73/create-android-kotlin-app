#!/bin/bash

cd ~/Android/Sdk/platform-tools || exit 1

if [ -z "$1" ]; then
    printf "Enter apk to launch: "
    read -r apk
    ./adb install "$apk"
else
    ./adb install "$1"
fi


