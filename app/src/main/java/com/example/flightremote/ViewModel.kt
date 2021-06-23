package com.example.flightremote

import android.view.Display

class ViewModel {
    private var model: Model = Model()

    fun connect(ip: String, port: String) {

        Thread {
            model.createSock(ip, port)
        }.start()
    }

    fun setThrottle(throttle: Int) {
        var value = throttle.toDouble()
        value /= 100
        Thread {
            model.sendToServer("/engines/current-engine/throttle ${value}\r\n")
        }.start()

    }

    fun setRudder(rudder: Int) {
        var value = rudder.toDouble() - 50
        value /= 50

        Thread {
            model.sendToServer("/flight/rudder $value\r\n")
        }.start()
    }


    fun setAileron(aileron: Float) {
        Thread {
            model.sendToServer("/flight/aileron $aileron\r\n")
        }.start()
    }

    fun setElevator(elevator: Float) {
        Thread {
            model.sendToServer("/flight/elevator ${-1*elevator}\r\n")
        }.start()
    }

    fun startEngine(){
        Thread{
           model.startEngine()
        }.start()
    }
}