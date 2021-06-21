package com.example.flightremote

import java.io.PrintWriter
import java.net.InetSocketAddress
import java.net.Socket

class Model {
    private var isConnected: Boolean = false

    private lateinit var client: Socket
    private lateinit var out: PrintWriter

    fun createSock(ip: String, port: String):Boolean {
        return try {
            client = Socket()
            client.connect(InetSocketAddress(ip, port.toInt()))
            out = PrintWriter(client.getOutputStream(), true)
            isConnected = true
            isConnected
        } catch (e: Exception) {
            e.printStackTrace()
            isConnected = false
            isConnected

        }

    }

    fun sendToServer(value: String) {
        if (isConnected) {
            out.print("set /controls$value")
            out.flush()
        }
    }


}