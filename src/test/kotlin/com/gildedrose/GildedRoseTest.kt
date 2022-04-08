package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun conjured() {
        val items = arrayOf(Item("Conjured", 5, 7))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(5, app.items[0].quality)
    }

}


