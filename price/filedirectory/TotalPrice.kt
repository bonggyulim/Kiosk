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

    var amountReceived: Int                                                 // 입력받은 금액
    var sub: Int                                                            // 총 금액 - 받은금액

    var currentTime = LocalDateTime.now()
    var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    var formatted = currentTime.format(formatter)                           // 위의 패턴으로 시간 출력

    println()
    println("결제하실 금액은 ${ShoppingBasket.price()}$ 입니다.")
    print("금액을 입력해주세요 : ")

    while (true) {  // try가 true를 반환하는줄 알았는데, 그냥 무한으로 try한다는 거였다.
        try {       // 예외시의 처리를 하고, break로 빠져나가는게 중요
            amountReceived = readLine()!!.toInt()
            sub = amountReceived - ShoppingBasket.price()
            if (sub < 0) {                                                  // sub가 0보다 작으면 예외
                throw Exception()
            } else break                                                    // else면 반복문 탈출
        } catch (e:java.lang.NumberFormatException) {
            print("숫자를 입력해주세요 : ")
        } catch (e: Exception) {
            print("금액이 부족합니다 : ")
        }
    }

    println("\n\n\n\n\n")

    waitFun()   // 복잡한게 싫어서 함수로 뺐다

    print("결제하실 금액은 ${ShoppingBasket.price()}$, 받은금액은 ${amountReceived}\$입니다. 거스름돈은 ${sub}\$ 입니다.")
    println("대기번호는 ${WaitingNumber.waitingNum}입니다. 대기인원은 ${WaitingNumber.numOfPeopleWaiting}명 입니다.")
    println("결제를 완료했습니다. $formatted")

    println("\n\n\n\n")

    var job = CoroutineScope(Dispatchers.Default).launch {  // 결제 완료 후 4초 딜레이
        delay(4000)

        println("\n\n\n\n")
        initialization(menuList)                                            // 장바구니를 초기화
        main()                                                              // 다시 메인으로
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
    WaitingNumber.waitingNumList.add(WaitingNumber.waitingNum)              // 대기번호 리스트에 대기번호 추가
    WaitingNumber.waitingNumMenuList.add(List)                              // 대기번호 메뉴리스트이다. 구현하고 싶은 기능을 시간부족으로 구현X
    WaitingNumber.numOfPeopleWaiting ++

}