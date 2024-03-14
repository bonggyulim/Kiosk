@file:Suppress("UNREACHABLE_CODE")

package com.example.kiosk.price.filedirectory

import com.example.kiosk.main.main
import com.example.kiosk.main.menuList
import com.example.kiosk.menuchoice.classdirectory.ShoppingBasket
import com.example.kiosk.price.classdirectory.Initialization.Companion.initialization
import com.example.kiosk.price.classdirectory.WaitingNumber
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun totalPrice() {

    var amountReceived = 0  // 받은 금액
    var sub = 0 // 총 금액 - 받은금액
    var currentTime = LocalDateTime.now()
    var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    var formatted = currentTime.format(formatter)

    println()
    println("결제하실 금액은 ${ShoppingBasket.price()}$ 입니다.")
    print("금액을 입력해주세요 : ")

    while (true) {  // try가 true를 반환하는줄 알았는데, 그냥 무한으로 try한다는 거였다.
        try {       // 예외시의 처리를 하고, break로 빠져나가는게 중요
            amountReceived = readLine()!!.toInt()
            sub = amountReceived - ShoppingBasket.price()
            if (sub < 0) {
                throw Exception()
            } else break
        } catch (e:java.lang.NumberFormatException) {
            print("숫자를 입력해주세요 : ")
        } catch (e: Exception) {
            print("금액이 부족합니다 : ")
        }
    }

    println("\n\n\n\n\n")

    waitFun()

    print("결제하실 금액은 ${ShoppingBasket.price()}$, 받은금액은 ${amountReceived}\$입니다. 거스름돈은 ${sub}\$ 입니다.")
    println("대기번호는 ${WaitingNumber.waitingNum}입니다. 대기인원은 ${WaitingNumber.numOfPeopleWaiting}명 입니다.")
    println("결제를 완료했습니다. $formatted")

    println("\n\n\n\n")
    var job = CoroutineScope(Dispatchers.Default).launch {
        delay(4000)

        println("\n\n\n\n")
        initialization(menuList)
        main()
    }
    runBlocking {
        job.join()
    }
    job.cancel()

    // 쓰레드를 잘못쓰면 오류가 남, 메인쓰레드에서 메인을 호출 해서 그런지 겹치는 듯한 오류가 난다.
}

fun waitFun() {
    var List = menuList
    WaitingNumber.waitingNum ++
    WaitingNumber.waitingNumList.add(WaitingNumber.waitingNum)
    WaitingNumber.waitingNumMenuList.add(List)
    WaitingNumber.numOfPeopleWaiting ++

}