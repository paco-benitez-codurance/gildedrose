package com.gildedrose.product

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class AgedBrieTest {
    @Test
    fun updateQuality_should_work_with_quality_less_than_50_and_selling_not_0() {
        val product = AgedBrie(3, 5)
        assertEquals(6, product.updateQuality())
    }

    @Test
    fun updateQuality_should_work_with_quality_more_than_50_and_selling_not_0() {
        val product = AgedBrie(3, 50)
        assertEquals(50, product.updateQuality())
    }

    @Test
    fun updateQuality_should_work_with_quality_more_than_50_and_selling_0() {
        val product = AgedBrie(0, 5)
        assertEquals(7, product.updateQuality())
    }
}