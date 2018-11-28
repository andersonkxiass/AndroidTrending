package com.anderson.androidtrend.utlis

import org.junit.Assert.*
import org.junit.Test

class TestUtilsTest{

    @Test
    fun testLoad(){
        val data = TestUtils.getJson("/json/test.json")
        assertEquals("{\"name\":\"Anderson\"}", data)
    }
}