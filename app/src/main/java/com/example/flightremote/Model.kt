package com.example.flightremote

import java.io.PrintWriter
import java.net.InetSocketAddress
import java.net.Socket

class Model {

    private lateinit var client: Socket
    private lateinit var out: PrintWriter

    fun createSock(ip: String, port: String) {

        client = Socket()
        client.connect(InetSocketAddress(ip, port.toInt()))
        out = PrintWriter(client.getOutputStream(), true)

    }

    fun sendToServer(value: String) {
        out.print("set /controls$value")
        out.flush()
    }


}