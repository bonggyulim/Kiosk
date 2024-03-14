package com.example.kiosk.price.classdirectory

import com.example.kiosk.menuchoice.classdirectory.Menu

class Initialization {
    companion object {
        fun initialization(menuList: List<Menu.TopMenu>) {
            for(i in 0..7){
                menuList.get(i).count = 0
            }
        }
    }
}