#!/bin/bash
if [ $1 ];
	then
	filePath=$1
else
	read -p "Drag file to here:" filePath	
fi
ServerIp="10.234.121.253"
APIUrl="http://"$ServerIp":8082/api/"
QRUrl="http://qr.liantu.com/api.php?text="
#设置权限，以支持nginx发布（不设777有些时候打不开）
chmod 777 $filePath
#以/分隔，截取最后一段
fileName=${filePath##*/}
#上传到服务器
scp $filePath netease@$ServerIp:"/Users/netease/Applications/api"
#scp /Users/heq/backup/ShellScript/com.mrliuxia.jarvis.shell.docx netease@10.234.121.253:/Users/netease/Applications/api
if [ $? == 0 ];
	then
    url=$APIUrl$fileName
    #echo -n "Press Enter to QRCode:$url"
    open -a "/Applications/Safari.app" $QRUrl$url
else
	echo "upload to server "$ServerIp" failed !！"
fi


