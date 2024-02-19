#!/bin/bash

cd ~/Android/Sdk/emulator || exit 1

echo "Available AVDs:"
./emulator -list-avds

printf "Enter the name of the AVD you want to launch: "
read -r avd_name

./emulator -avd "$avd_name"
