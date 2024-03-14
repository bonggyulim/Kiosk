package com.example.kiosk.price.classdirectory

import com.example.kiosk.main.menuList
import com.example.kiosk.menuchoice.classdirectory.Menu

class WaitingNumber {
    companion object{
        var waitingNum = 0
        var waitingNumList = mutableListOf<Int>()
        var waitingNumMenuList = mutableListOf<List<Menu.TopMenu>>()
        var numOfPeopleWaiting = 0
    }
}
