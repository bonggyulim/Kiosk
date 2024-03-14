package com.example.kiosk.price.classdirectory

import com.example.kiosk.menuchoice.classdirectory.Menu

class Initialization {  // 장부구니를 초기화하는 클래스, 그냥 함수로 만들어도 될것같다
    companion object {
        fun initialization(menuList: List<Menu.TopMenu>) {
            for(i in 0..7){
                menuList.get(i).count = 0
            }
        }
    }
}