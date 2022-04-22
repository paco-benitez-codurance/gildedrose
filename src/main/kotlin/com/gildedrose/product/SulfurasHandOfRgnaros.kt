package com.gildedrose.product

class SulfurasHandOfRgnaros(sellIn: Int, quality: Int) : Product(sellIn, quality) {
    override fun updateSellIn(): Int = sellIn

    override fun updateQuality(): Int = quality
}