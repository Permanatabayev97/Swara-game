package com.example.swaragame

import kotlinx.coroutines.*

object TimerManager {
    private var job: Job? = null

    fun startTimer(seconds: Int, onTimeUp: () -> Unit) {
        job?.cancel()
        job = CoroutineScope(Dispatchers.Default).launch {
            for (i in seconds downTo 1) {
                println("⏳ $i sekunt galdy...")
                delay(1000)
            }
            println("⏰ Wagt gutardy!")
            onTimeUp()
        }
    }

    fun stopTimer() {
        job?.cancel()
        println("⏹️ Timer duruzuldy.")
    }
}
