package com.gildedrose.product

class Common(sellIn: Int, quality: Int) : Product(sellIn, quality) {
    override fun updateQuality(): Int {
        return degradeBy(1)
    }
}