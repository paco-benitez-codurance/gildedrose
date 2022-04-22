package com.gildedrose.product

class AgedBrie(sellIn: Int, quality: Int) : Product(sellIn, quality) {

    override fun updateQuality(): Int {
        if (quality >= 50) {
            return quality
        }
        if (sellIn > 0) {
           return quality + 1
        }
        return quality + 2
    }
}