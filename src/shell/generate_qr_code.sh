#!/usr/bin/env bash

if [ $# == 0 ]; then
    read -p "Enter message here:" message

elif [[ $1 == "help" ]] || [[ $1 == "--help" ]]; then
    echo "A tool for generating qr code."
    echo "Example usage:"
    echo "  qrcode \"http://www.163.com\""
    echo "  qrcode \"n 55iw\""
    echo "Further help:"
    echo "  qrcode help"
    echo "  qrcode --help"
    exit

elif [ $1 ]; then
    message=$1
fi

echo $message | qrencode -o - -t UTF8