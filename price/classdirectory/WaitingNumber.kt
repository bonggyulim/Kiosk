package com.example.kiosk.price.classdirectory

import com.example.kiosk.main.menuList
import com.example.kiosk.menuchoice.classdirectory.Menu

class WaitingNumber {
    companion object{
        var waitingNum = 0                                              // 대기번호
        var waitingNumList = mutableListOf<Int>()                       // 대기번호 리스트
        var waitingNumMenuList = mutableListOf<List<Menu.TopMenu>>()    // 해당 대기번호의 메뉴리스트
        var numOfPeopleWaiting = 0                                      // 대기인원
    }
}
