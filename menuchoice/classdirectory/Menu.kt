package com.example.kiosk.menuchoice.classdirectory

class Menu {

    open class TopMenu(kind: String, name: String, price: Int, number: Int) {
        val kind = kind
        val name = name
        val price = price
        val number = number
        var count = 0
        // 메뉴를 객체화 메뉴는 종류, 이름, 가격, 고유번호, 메뉴를 담은 횟수

        open fun printInfo(){
            println("$number. 종류 : $kind | $name | $price $")
        }
    }
    class BugersMenu(kind: String, name: String, price: Int, number: Int):
        TopMenu(kind, name, price, number) {
    }

    class Dispenser(kind: String, name: String, price: Int, number: Int):
        TopMenu(kind, name, price, number) {
    }

    class SideMenu(kind: String, name: String, price: Int, number: Int):
        TopMenu(kind, name, price, number) {
    }

}