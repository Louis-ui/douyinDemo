package com.qxy.douyinDemo.ui.PerformanceMonitor

import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.util.Log

open class LogMonitor{
    private val mIoHandler: Handler

    //开始计时
    fun startMonitor() {
        mIoHandler.postDelayed(LogMonitor.Companion.mLogRunnable, LogMonitor.Companion.TIME_BLOCK)
    }


    //停止计时
    fun removeMonitor() {
        mIoHandler.removeCallbacks(LogMonitor.Companion.mLogRunnable)
    }

    companion object {
        private const val TAG = "LogMonitor"
        private val sInstance = LogMonitor()

        //设置方法耗时的卡口,300毫秒
        private const val TIME_BLOCK = 300L
        private val mLogRunnable = Runnable { //打印出执行的耗时方法的栈消息
            val sb = StringBuilder()
            val stackTrace = Looper.getMainLooper().thread.stackTrace
            for (s in stackTrace) {
                sb.append(s.toString())
                sb.append("\n")
            }
            Log.e(LogMonitor.Companion.TAG, sb.toString())
        }
        val instance: LogMonitor
            get() = LogMonitor.Companion.sInstance
    }

    init {
        val logThread = HandlerThread("log")
        logThread.start()
        mIoHandler = Handler(logThread.looper)
    }
}