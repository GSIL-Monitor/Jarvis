#!/usr/bin/env bash
#
#funPalindromicEgg(){
#    word=$1
#    echo $word
#    let a=num%2
#    let b=num/2
#
#    for((i=0;i<b;i++))
#    do
#	    pattern=$pattern'\(.\)'
#    done
#
#    if [ $a -ne 0 ];
#    then
#        pattern=$pattern'.'
#    fi
#
#    for((i=b;i>0;i--))
#    do
#        pattern=$pattern"\\$i"
#    done
#
#    pattern='/'$pattern'/p'
#    echo $word | sed -n "$pattern"
#}
#
#funPalindromicEgg 123test123

echo condition 1 "2asdf"


function palindromic(){
    if [[ !(-z "$1") && $(rev <<< "$1") == "$1" ]]; then
        echo yes
    else
        echo no
    fi
}

function palindromic1(){
    if [[ !(-z "$1") && $(rev <<< "$1") == "$1" ]]; then
        echo yes
    else
        echo no
    fi
}

palindromic ""
palindromic "123"
palindromic "121"
palindromic 123321
palindromic 123123
