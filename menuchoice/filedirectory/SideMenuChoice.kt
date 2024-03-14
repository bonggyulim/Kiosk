package com.example.kiosk.menuchoice.filedirectory

import com.example.kiosk.main.menuList
import com.example.kiosk.menuchoice.classdirectory.ShoppingBasket
import com.example.kiosk.price.filedirectory.payMain

fun sideMenu() {
    println()
    menuList.get(6).printInfo()
    menuList.get(7).printInfo()
    println("9. 결제하기")
    println("-1. 뒤로가기")
    print(ShoppingBasket.list(menuList))                 // 현재까지 상품리스트 출력
    println("${ShoppingBasket.price()} $ ")      // 현재까지 합계금액 출력
    while (true) {
        try {
            when (readLine()!!.toInt()) {
                7 -> {
                    menuList.get(6).count++
                    sideMenu()
                }
                8 -> {
                    menuList.get(7).count++
                    sideMenu()
                }
                9 -> {
                    if (ShoppingBasket.price() == 0) throw Exception()
                    payMain()
                }
                -1 -> menuChoice()
                else -> println("잘못된 숫자 입력")
            }
        } catch (e: java.lang.NumberFormatException) {
            print("숫자를 입력하세요 : ")
        } catch (e: Exception){
            print("상품을 한 개 이상 골라주세요 : ")
        }
    }
}