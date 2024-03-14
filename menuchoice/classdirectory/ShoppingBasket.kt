package com.example.kiosk.menuchoice.classdirectory

import com.example.kiosk.main.menuList

class ShoppingBasket() {
    companion object {  // 싱글톤을 사용하여 어디서든 접근 가능
        fun list(menuList: List<Menu.TopMenu>): String {    // 지금까지 담은 메뉴를 출력하는 함수
            var str: String = ""
            var menuList = menuList
            for (i in 0..7) {
                if (menuList.get(i).count != 0){
                    str = str + "${menuList.get(i).name} ${menuList.get(i).count}개 "
                }
            }
            return str.toString()
        }

        fun price(): Int {  // 장바구니에 담은 메뉴의 총 가격을 출력하는 함수
            var sum: Int = 0
            for (i in 0..7) {
                sum = sum + menuList.get(i).price * menuList.get(i).count
            }
            return sum
        }
    }
}