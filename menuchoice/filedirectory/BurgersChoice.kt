package com.example.kiosk.menuchoice.filedirectory

import com.example.kiosk.main.menuList
import com.example.kiosk.menuchoice.classdirectory.ShoppingBasket
import com.example.kiosk.price.filedirectory.payMain

fun burgers() { // 버거 종류 선택
    println()
    menuList.get(0).printInfo()                      // TopMenu 클래스의 printInfo()함수 사용
    menuList.get(1).printInfo()                      // menuList의 엘리먼트들은 TopMenu를 상속받는 객체들이기에 사용가능
    menuList.get(2).printInfo()
    println("9. 결제하기")
    println("-1. 뒤로가기")
    print(ShoppingBasket.list(menuList))             // 현재까지 상품리스트 출력
    println("${ShoppingBasket.price()} $ ")          // 현재까지 합계금액 출력
    while(true) {
        try {
            when (readLine()!!.toInt()) {
                1 -> {
                    menuList.get(0).count++          // 장바구니에서 해당 제품 카운트를 ++ 함
                    burgers()                        // 뒤로가기 or 계산 버튼 누르지 않으면 재귀함수 호출
                }
                2 -> {
                    menuList.get(1).count++
                    burgers()
                }
                3 -> {
                    menuList.get(2).count++
                    burgers()
                }
                9 -> {
                    if (ShoppingBasket.price() == 0) throw Exception()
                    payMain()                         // 총 가격이 0원이면 예외, 아니면 결제메인 화면으로 이동
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