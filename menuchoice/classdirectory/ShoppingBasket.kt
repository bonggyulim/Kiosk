package com.example.kiosk.menuchoice.classdirectory

import com.example.kiosk.main.menuList

class ShoppingBasket() {
    companion object {
        fun list(menuList: List<Menu.TopMenu>): String {
            var str: String = ""
            var menuList = menuList
            for (i in 0..7) {
                if (menuList.get(i).count != 0){
                    str = str + "${menuList.get(i).name} ${menuList.get(i).count}개 "
                }
            }
            return str.toString()
        }

        fun price(): Int {
            var sum: Int = 0
            for (i in 0..7) {
                sum = sum + menuList.get(i).price * menuList.get(i).count
            }
            return sum
        }
    }
}