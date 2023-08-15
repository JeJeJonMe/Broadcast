package com.example.broadcastalarm

import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.provider.SyncStateContract.Constants
import com.example.broadcastalarm.broadcast.MyBroadcastReciver
import com.example.broadcastalarm.util.Constants.ACTION_CONNECTION
import com.example.broadcastalarm.util.NetworkUtils

class MainActivity : AppCompatActivity() {

    private lateinit var myBroadcastReciver: MyBroadcastReciver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myBroadcastReciver = MyBroadcastReciver()

        val instentFilter = IntentFilter(NetworkUtils.Constants.oACTION_CONNECTION)
        object : CountDownTimer(1000, 1000) {
            override fun onTick(p0: Long) {}

            override fun onFinish() {
                registerReceiver(myBroadcastReciver, instentFilter)
            }
        }.start()
    }
    //override fun Pause(){
    //super.onPause()
    //unregisterReceiver(myBroadcastReciver)
    // }
    //
}