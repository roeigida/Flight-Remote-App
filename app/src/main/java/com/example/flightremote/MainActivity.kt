package com.example.flightremote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {
    private var viewModel: ViewModel = ViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val throttleSlide = findViewById<SeekBar>(R.id.throttle)
        throttleSlide?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
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
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
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

        if(ip.isEmpty() || port.isEmpty()){

        }

        viewModel.connect(ip,port)

    }

}