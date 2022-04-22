package com.gildedrose.product

class Concert(sellIn: Int, quality: Int) : Product(sellIn, quality) {
    override fun updateQuality(): Int {
        var res = quality
        if (res < 50) {
            res = res + 1
        }
        if (sellIn < 11) {
            if (res < 50) {
                res = res + 1
            }
        }

        if (sellIn < 6) {
            if (res < 50) {
                res = res + 1
            }
        }

        if (sellIn <= 0) {
            res = res - res
        }
        return res
    }
}