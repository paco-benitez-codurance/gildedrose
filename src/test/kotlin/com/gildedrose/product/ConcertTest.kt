package com.gildedrose.product

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ConcertTest {
    @Test
    fun updateQuality_should_no_change_with_more_50_and_positive_sellIn() {
        val product = Concert(3, 60)
        assertEquals(60, product.updateQuality())
    }

    @Test
    fun updateQuality_should_increase_by_1_with_less_50_and_sellIn_more_11() {
        val product = Concert(30, 49)
        assertEquals(49 + 1, product.updateQuality())
    }

    @Test
    fun updateQuality_should_increase_by_1_with_less_50_and_sellIn_less_11() {
        val product = Concert(10, 49)
        assertEquals(49 + 1, product.updateQuality())
    }

    @Test
    fun updateQuality_should_increase_by_2_with_less_49_and_sellIn_less_6() {
        val product = Concert(5, 48)
        assertEquals(48 + 2, product.updateQuality())
    }

}