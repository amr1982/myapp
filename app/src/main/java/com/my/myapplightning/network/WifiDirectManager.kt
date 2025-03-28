package com.my.myapplightning.network

import android.content.Context
import android.net.wifi.p2p.WifiP2pManager
import android.util.Log

class WifiDirectManager(private val context: Context) {
    private val manager = context.getSystemService(Context.WIFI_P2P_SERVICE) as WifiP2pManager
    private val channel = manager.initialize(context, context.mainLooper, null)

    fun discoverPeers() {
        manager.discoverPeers(channel, object : WifiP2pManager.ActionListener {
            override fun onSuccess() = Log.d("WifiDirect", "Discovery started")
            override fun onFailure(reason: Int) = Log.e("WifiDirect", "Failed: $reason")
        })
    }
}