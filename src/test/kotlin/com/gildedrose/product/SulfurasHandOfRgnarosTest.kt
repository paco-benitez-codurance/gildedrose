package com.gildedrose.product

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

private const val SELL_IN: Int = 3
private const val QUALITY: Int = 4

internal class SulfurasHandOfRgnarosTest {

    private val product = SulfurasHandOfRgnaros(SELL_IN, QUALITY)

    @Test
    fun quality_should_not_be_degraded() {
        assertEquals(QUALITY, product.updateQuality())
    }

    @Test
    fun shellIn_should_not_be_degraded() {
        assertEquals(SELL_IN, product.updateSellIn())
    }


}