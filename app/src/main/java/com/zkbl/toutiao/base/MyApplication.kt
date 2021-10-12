package com.zkbl.toutiao.base

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import javax.net.ssl.SSLContext


/**
 * Create by StoneBang at 2021/9/12
 */
class MyApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        val formatStrategy: FormatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(false) // (Optional) Whether to show thread info or not. Default true
            .methodCount(0) // (Optional) How many method line to show. Default 2
            .methodOffset(3) // (Optional) Skips some method invokes in stack trace. Default 5
            //        .logStrategy(customLog) // (Optional) Changes the log strategy to print out. Default LogCat
            .tag("hbb") // (Optional) Custom tag for each log. Default PRETTY_LOGGER
            .build()
        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
    }
}