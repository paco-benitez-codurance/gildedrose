package com.gildedrose.product

class Conjured(sellIn: Int, quality: Int) : Product(sellIn, quality) {
    override fun updateQuality(): Int {
        return degradeBy(quality, sellIn, 2)
    }
}