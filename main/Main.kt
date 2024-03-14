package com.example.kiosk.main

import com.example.kiosk.menuchoice.classdirectory.Menu
import com.example.kiosk.menuchoice.filedirectory.menuChoice
import com.example.kiosk.price.classdirectory.WaitingNumber
import kotlinx.coroutines.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.system.exitProcess

var menuList = mutableListOf<Menu.TopMenu>()    // 메뉴객체를 담을 리스트

fun init() {    // init이 실행되면 객체를 생성해 리스트화 한다
    var bul = Menu.BugersMenu("햄버거", "불고기버거", 6, 1)
    var shrimp = Menu.BugersMenu("햄버거", "새우버거", 7, 2)
    var chicken = Menu.BugersMenu("햄버거", "치킨버거", 7, 3)
    var coke = Menu.Dispenser("음료수", "콜라", 2, 4)
    var soda = Menu.Dispenser("음료수", "사이다", 2, 5)
    var water = Menu.Dispenser("음료수", "물", 1, 6)
    var fry = Menu.SideMenu("사이드 메뉴", "감자튀김", 3, 7)
    var cheeze = Menu.SideMenu("사이드 메뉴", "치즈스틱", 4, 8)
    menuList.add(bul)
    menuList.add(shrimp)
    menuList.add(chicken)
    menuList.add(coke)
    menuList.add(soda)
    menuList.add(water)
    menuList.add(fry)
    menuList.add(cheeze)
}

fun main() {
    var mainJob = GlobalScope.launch {                              // 메인 코루틴
        init()
        println("안녕하세요 Bong버거입니다. 왼쪽의 번호를 입력하시면 진행됩니다.")
        println("0을 입력시 프로그램이 종료됩니다.")
        println("1.회원가입 및 로그인")
        println("2.메뉴선택")

        while (true) {
            try {
                when (readLine()!!.toInt()) {
                    0 -> System.exit(0)
                    1 -> println("구현X")
                    2 -> menuChoice()
                    else -> print("잘못된 숫자 입력 : ")
                }
            } catch (e: java.lang.NumberFormatException) {
                print("숫자를 입력하세요 : ")
            }
        }
    }

    var ckTimeJob = CoroutineScope(Dispatchers.Default).launch {    // 시간 체크 코루틴
        var currentTime = LocalDateTime.now()
        var formatter = DateTimeFormatter.ofPattern("HH")
        var formatted = currentTime.format(formatter)                               // 현재 시간을 "13" 과 같은 형식으로 출력해서 foramtted에 초기화

        while (14 <= formatted.toInt() && formatted.toInt() < 15){                  // 14~15시에는 안내 후 시스템 종료
            println("14시부터 15시까지는 점검 시간입니다. 지금은 사용하실수 없습니다.")
            delay(5000)
            System.exit(0)
        }
    }

    if (WaitingNumber.waitingNum == 0){                                             // 대기번호가 0일때만 시작
        var coroutineJob = CoroutineScope(Dispatchers.Default).launch {
            while (true) {
                delay(8000)
                println()
                println("현재 주문 대기수 : ${WaitingNumber.numOfPeopleWaiting}")
                print(" 대기번호 : ")
                for (i in 0..WaitingNumber.numOfPeopleWaiting - 1) {          // 대기번호 : 1번 2번... 식으로 출력
                    print("${WaitingNumber.waitingNumList.get(i)}번 ")

                }
                println()
            }
        }
        runBlocking {
            coroutineJob.join()
        }
    }

    runBlocking {
        mainJob.join()
        ckTimeJob.join()
    }
}