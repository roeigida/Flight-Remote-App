package com.example.flightremote

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.EditText
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt


class MainActivity : AppCompatActivity() , JoystickView.JoystickListener {
    private var viewModel: ViewModel = ViewModel()

    //    private var joystick = Joystick(this)
    private var xCoOrdinate = 0f
    private var yCoOrdinate: kotlin.Float = 0f

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val throttleSlide = findViewById<SeekBar>(R.id.throttle)
        throttleSlide?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                seek: SeekBar,
                progress: Int, fromUser: Boolean
            ) {
//                Toast.makeText(this@MainActivity,
//                    "Progress is: " + seek.progress + "%",
//                    Toast.LENGTH_SHORT).show()
                viewModel.setThrottle(seek.progress)
            }

            override fun onStartTrackingTouch(seek: SeekBar?) {
                if (seek != null) {
                    viewModel.setThrottle(seek.progress)
                }
            }

            override fun onStopTrackingTouch(seek: SeekBar?) {
                if (seek != null) {
                    viewModel.setThrottle(seek.progress)
                }
            }

        })

        val rudderSlide = findViewById<SeekBar>(R.id.rudder)
        rudderSlide?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                seek: SeekBar,
                progress: Int, fromUser: Boolean
            ) {
                viewModel.setRudder(seek.progress)
            }

            override fun onStartTrackingTouch(seek: SeekBar?) {
            }

            override fun onStopTrackingTouch(seek: SeekBar?) {
                if (seek != null) {
                    viewModel.setRudder(seek.progress)
                }
            }

        })
        /*val joystickCenter = findViewById<View>(R.id.joystick_center)
        joystickCenter.setOnTouchListener(OnTouchListener { view, event ->
                Toast.makeText(this@MainActivity,
                    "xCor is: $xCoOrdinate%",
                    Toast.LENGTH_SHORT).show()
            if (isInBounds()) {
                when (event.actionMasked) {

                    MotionEvent.ACTION_DOWN -> {
                        Log.v("tomer", "yView is: ${view.y},xView is: ${view.x}, rawX:${event.rawX}, rawY:${event.rawY}")
                        xCoOrdinate = view.x - event.rawX
                        yCoOrdinate = view.y - event.rawY
                    }

                    MotionEvent.ACTION_MOVE -> view.animate().x(event.rawX + xCoOrdinate).y(event.rawY + yCoOrdinate)
                        .setDuration(0).start()
                    else -> return@OnTouchListener false
                }



                }
            }
            true
        })*/

    }

    private var lastX: kotlin.Float = 0f
    private var lastY: kotlin.Float = 0f

   /* private fun isInBounds(x:Float,y:Float): Boolean {

      val joystickBackground = findViewById<View>(R.id.joystick_base)
        Log.v(
            "joysbase",
            "x: ${joystickBackground.x}, Y:${joystickBackground.y} width: ${joystickBackground.width}, Y:${joystickBackground.height}"
        )

        val centerX = 811*//*joystickBackground.x + joystickBackground.width / 2*//*
        val centerY = 1187*//*joystickBackground.y + joystickBackground.height / 2*//*
        val joystick = findViewById<View>(R.id.joystick_center)
        val joyCenterX = joystick.x + joystickBackground.width / 2
        val joCenterY = joystick.y + joystickBackground.height / 2
        Log.v("centers", "xCent is: $joyCenterX, centY:${joCenterY}")
        val distance =
            sqrt((((joyCenterX - centerX).toDouble()).pow(2.0) + ((joCenterY - centerY).toDouble()).pow(2.0)))
        Log.v("centers", "dist is:$distance")
        lastX = joystick.x
        lastY = joystick.y

        return distance < 305
    }
*/
    fun onConnect(view: View) {
        val ip = findViewById<EditText>(R.id.IP).text.toString()
        val port = findViewById<EditText>(R.id.port).text.toString()

        if (ip.isEmpty() || port.isEmpty()) {

        }


        viewModel.connect(ip, port)

    }

    override fun onJoystickMoved(xPercent: Float, yPercent: Float, id: Int) {
        viewModel.setAileron(xPercent)
        viewModel.setElevator(yPercent)
    }

}