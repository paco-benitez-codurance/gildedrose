package com.gildedrose.product

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ConjuredTest {
    @Test
    fun updateQuality_should_work_with_quality_more_than_0() {
        val product = Conjured(3, 5)
        assertEquals(3, product.updateQuality())
    }

    @Test
    fun updateQuality_should_work_with_quality_more_than_0_and_sellin_should_degraded_twice() {
        val product = Conjured(0, 5)
        assertEquals(1, product.updateQuality())
    }

    @Test
    fun updateQuality_should_work_with_lower_quality_and_sellin_should_degraded_twice() {
        val product = Conjured(0, 1)
        assertEquals(-1, product.updateQuality())
    }
}