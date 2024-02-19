#!/bin/bash

echo "Available AVDs:"
emulators=$(emulator -list-avds)
echo "$emulators"


if [ "$(echo "$emulators" | wc -l)" -eq 1 ]; then
    avd_name=$emulators
else
    echo "Select the AVD you want to launch:"
    for ((i=0; i<${#emulators[@]}; i++)); do
        echo "$i: ${emulators[i]}"
    done
    printf "Enter the number of the AVD you want to launch: "
    read -r avd_index
    avd_name=${emulators[avd_index]}
fi

emulator -avd "$avd_name"

