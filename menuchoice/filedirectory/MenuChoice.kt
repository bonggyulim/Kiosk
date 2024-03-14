package com.example.kiosk.menuchoice.filedirectory

import com.example.kiosk.main.main

fun menuChoice() {  // 메뉴 종류 선택
    println()
    println("종류 선택")
    println("1. 햄버거")
    println("2. 음료수")
    println("3. 사이드 메뉴")
    println("-1. 뒤로 가기")
    while(true){
        try{
            when (readLine()!!.toInt()) {
                1 -> burgers()
                2 -> dispenser()
                3 -> sideMenu()
                -1 -> main()
                else -> print("잘못된 숫자 입력 : ")
            }
        } catch (e:java.lang.NumberFormatException){
            print("숫자를 입력하세요 : ")
        }
    }
}
