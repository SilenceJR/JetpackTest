package com.silence.core.kotlin.app

import android.content.Context

object Core {

    fun init(context: Context) = getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name, context.applicationContext)

    fun getConfigurations() = Configurator.getInstance().getConfigs()

    fun getApplication() = getConfigurations().get(ConfigType.APPLICATION_CONTEXT.name)

}