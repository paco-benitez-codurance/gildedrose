package com.gildedrose.product

class Concert(sellIn: Int, quality: Int) : Product(sellIn, quality) {
    override fun updateQuality(): Int {
        if(sellIn >= 11) {
            return increaseQualityIfLessThan50(quality, 1)
        } else if (sellIn in 6..10) {
            return increaseQualityIfLessThan50(quality, 2)
        } else if (sellIn in 1..5) {
            return increaseQualityIfLessThan50(quality, 3)
        } else if (sellIn <= 0) {
            return 0
        }
        throw java.lang.RuntimeException("NEVER")
    }

    private fun increaseQualityIfLessThan50(quality: Int, times: Int): Int {
        if(times == 0) {
            return quality
        }
        var res = quality
        if (res < 50) {
            res += 1
        }
        return increaseQualityIfLessThan50(res, times - 1)
    }
}