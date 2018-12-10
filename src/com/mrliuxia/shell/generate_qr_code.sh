#!/usr/bin/env bash

#若没有brew环境，安装brew
if ! which brew > /dev/null ; then
    echo "Brew not installed, install brew first..."
    ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
fi

#若没有qrencode库，安装qrencode
if ! which qrencode > /dev/null ; then
    echo "QREncode not installed, install QREncode first..."
    brew install qrencode
fi

#处理参数，获取要生成二维码的信息
if [ $# == 0 ]; then
    read -p "Enter message here: " message
elif [[ $1 == "help" ]] || [[ $1 == "--help" ]]; then
    echo "A tool for generating qr code."
    echo "Example usage:"
    echo "  qrcode \"http://www.163.com\""
    echo "  qrcode \"n 55!W\""
    echo "Further help:"
    echo "  qrcode help"
    echo "  qrcode --help"
    exit
elif [ $1 ]; then
    message=$1
fi

#打印二维码
echo $message | qrencode -o - -t UTF8