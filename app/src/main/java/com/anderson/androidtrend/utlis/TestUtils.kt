package com.anderson.androidtrend.utlis

import java.io.*

object TestUtils {

    private const val ASSET_BASE_PATH = "../app/src/main/assets/"

    fun getJson(filename : String): String? {
        val br = BufferedReader(InputStreamReader(FileInputStream(ASSET_BASE_PATH + filename)))
        val sb = StringBuilder()
        var line = br.readLine()
        while (line != null) {
            sb.append(line)
            line = br.readLine()
        }

        return sb.toString()
    }

    fun readTextStream(inputStream: InputStream): String {

        val br = BufferedReader(InputStreamReader(inputStream))
        val sb = StringBuilder()
        var line = br.readLine()

        while (line != null) {
            sb.append(line)
            line = br.readLine()
        }

        return sb.toString()
    }
}
