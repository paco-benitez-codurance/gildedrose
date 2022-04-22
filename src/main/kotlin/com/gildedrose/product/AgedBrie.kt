package com.gildedrose.product

class AgedBrie(sellIn: Int, quality: Int) : Product(sellIn, quality) {

    override fun updateQuality(): Int {
        var res = quality
        if (res < 50) {
            res = res + 1
        }
        if (sellIn <= 0) {
            if (res < 50) {
                res = res + 1
            }
        }
        return res
    }
}