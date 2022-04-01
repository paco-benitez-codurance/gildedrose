package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun foo() {
        val items = arrayOf<Item>(Item("XXXXX", 5, 7))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(4, app.items[0].sellIn)

    }

}


