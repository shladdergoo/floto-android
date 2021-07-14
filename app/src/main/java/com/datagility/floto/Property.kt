package com.datagility.floto

import android.content.Context
import java.util.*

object Property {

    fun getProperty(key: String, context: Context): String {

        val properties = Properties()
        val assetManager = context.assets;
        val inputStream = assetManager.open("app.properties");
        properties.load(inputStream);

        return properties.getProperty(key);
    }
}
