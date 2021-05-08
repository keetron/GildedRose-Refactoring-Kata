package com.gildedrose

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class GildedRoseTest {

    @Test
    fun foo() {
        val items = arrayOf(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("fixme", app.items[0].name)

    }

}


