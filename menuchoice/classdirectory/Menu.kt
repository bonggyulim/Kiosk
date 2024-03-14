package com.example.kiosk.menuchoice.classdirectory

class Menu {

    open class TopMenu(kind: String, name: String, price: Int, number: Int) {
        val kind = kind
        val name = name
        val price = price
        val number = number
        var count = 0

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