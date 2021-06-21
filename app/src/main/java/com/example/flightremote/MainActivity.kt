package com.example.flightremote

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View import android.widget.EditText
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), JoystickView.JoystickListener {
    private var viewModel: ViewModel = ViewModel()

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

    }

    fun onConnect(view: View) {
        val ip = findViewById<EditText>(R.id.IP).text.toString()
        val port = findViewById<EditText>(R.id.port).text.toString()

        if (ip.isEmpty() || port.isEmpty()) {
            Toast.makeText(
                this@MainActivity,
                "Didn't enter IP or Port",
                Toast.LENGTH_SHORT
            ).show()
        }else {
            viewModel.connect(ip, port)
        }
    }

    override fun onJoystickMoved(xPercent: Float, yPercent: Float, id: Int) {
        viewModel.setAileron(xPercent)
        viewModel.setElevator(yPercent)
    }

}