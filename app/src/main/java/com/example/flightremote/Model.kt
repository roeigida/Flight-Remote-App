package com.example.flightremote

import java.io.PrintWriter
import java.net.InetSocketAddress
import java.net.Socket
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue

class Model {
    private var isConnected: Boolean = false
    private val dispatchQueue: BlockingQueue<Runnable> = LinkedBlockingQueue<Runnable>()
    private lateinit var client: Socket
    private lateinit var out: PrintWriter




    fun createSock(ip: String, port: String): Boolean {

        return try {
            client = Socket()
            client.connect(InetSocketAddress(ip, port.toInt()))
            out = PrintWriter(client.getOutputStream(), true)
            isConnected = true
            Thread {
                while (true) {
                    try {
                        dispatchQueue.take().run()
                    } catch (e: InterruptedException) {
                        //Nothing in queue.
                    }
                }
            }.start()
            isConnected

        } catch (e: Exception) {
            e.printStackTrace()
            isConnected = false
            isConnected

        }
    }


    fun sendToServer(value: String) {
        dispatchQueue.put(
            Runnable {
                if (isConnected) {
                    out.print("set /controls$value")
                    out.flush()
                }
            }
        )
    }


    fun startEngine() {
        dispatchQueue.put(
            Runnable {
                if (isConnected) {
                    out.print("set /consumables/fuel/tank[0]/selected 1 \r\n")
                    out.flush()

                    out.print("set /consumables/fuel/tank[1]/selected 1 \r\n")
                    out.flush()

                    out.print("set /consumables/fuel/tank[2]/selected 0 \r\n")
                    out.flush()

                    out.print("set /consumables/fuel/tank[3]/selected 0 \r\n")
                    out.flush()

                    out.print("set /controls/engines/current-engine/mixture 1 \r\n")
                    out.flush()

                    out.print("set /engines/active-engine/carb_ice 0.0 \r\n")
                    out.flush()

                    out.print("set /engines/active-engine/carb_icing_rate 0.0 \r\n")
                    out.flush()

                    out.print("set /controls/engines/current-engine/carb-heat 1 \r\n")
                    out.flush()

                    out.print("set /engines/active-engine/running 1 \r\n")
                    out.flush()

                    out.print("set /engines/active-engine/auto-start 1 \r\n")
                    out.flush()

                    out.print("set /engines/active-engine/cranking 1 \r\n")
                    out.flush()

                    out.print("set /controls/engines/engine[0]/primer 3 \r\n")
                    out.flush()

                    out.print("set /controls/engines/engine[0]/primer-lever 0 \r\n")
                    out.flush()

                    out.print("set /controls/engines/current-engine/throttle 0.2 \r\n")
                    out.flush()

                    out.print("set /controls/flight/elevator-trim -0.03 \r\n")
                    out.flush()

                    out.print("set /controls/switches/dome-red 0 \r\n")
                    out.flush()

                    out.print("set /controls/switches/dome-white 0 \r\n")
                    out.flush()

                    out.print("set /controls/switches/magnetos 3 \r\n")
                    out.flush()

                    out.print("set /controls/switches/master-bat 1 \r\n")
                    out.flush()

                    out.print("set /controls/switches/master-alt 1 \r\n")
                    out.flush()

                    out.print("set /controls/switches/master-avionics 1 \r\n")
                    out.flush()

                    out.print("set /controls/switches/starter 1 \r\n")
                    out.flush()

                    out.print("set /controls/lighting/beacon 1 \r\n")
                    out.flush()

                    out.print("set /controls/lighting/taxi-light 0 \r\n")
                    out.flush()

                    out.print("set /fdm/jsbsim/running 0 \r\n")
                    out.flush()

                    out.print("set /fdm/jsbsim/inertia/pointmass-weight-lbs[0] 170 \r\n")
                    out.flush()

                    out.print("set /fdm/jsbsim/inertia/pointmass-weight-lbs[1] 0 \r\n")
                    out.flush()

                    out.print("set /sim/model/c172p/securing/tiedownL-visible 0 \r\n")
                    out.flush()

                    out.print("set /sim/model/c172p/securing/tiedownR-visible 0 \r\n")
                    out.flush()

                    out.print("set /sim/model/c172p/securing/tiedownT-visible 0 \r\n")
                    out.flush()

                    out.print("set /sim/model/c172p/securing/pitot-cover-visible 0 \r\n")
                    out.flush()

                    out.print("set /sim/model/c172p/securing/chock 0 \r\n")
                    out.flush()

                    out.print("set /sim/model/c172p/securing/cowl-plugs-visible 0 \r\n")
                    out.flush()

                    out.print("set /sim/model/c172p/cockpit/control-lock-placed 0 \r\n")
                    out.flush()

                    out.print("set /controls/gear/gear-down-command 1 \r\n")
                    out.flush()

                    out.print("set /sim/model/c172p/brake-parking 0 \r\n")
                    out.flush()
                }

            }
        )
    }




}