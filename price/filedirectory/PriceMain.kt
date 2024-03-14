package com.example.kiosk.price.filedirectory

import com.example.kiosk.main.menuList
import com.example.kiosk.menuchoice.classdirectory.ShoppingBasket
import com.example.kiosk.menuchoice.filedirectory.menuChoice
import com.example.kiosk.price.classdirectory.Initialization

fun payMain() {
    println()
    println("결제 내역은 : ${ShoppingBasket.list(menuList)}")
    println("결제 금액은 : ${ShoppingBasket.price()} $")
    println("1. 결제하기")
    println("2. 초기화 후 재선택")

    while (true) {
        try {
            when (readLine()!!.toInt()){
                1 -> totalPrice()
                2 -> {
                    Initialization.initialization(menuList)
                    menuChoice()
                }
                else -> println("잘못된 숫자 입력")
            }
        } catch (e:java.lang.NumberFormatException) {
            println("숫자를 입력하세요")
        }
    }

}