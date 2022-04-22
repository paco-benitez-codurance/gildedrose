package com.gildedrose.product

abstract class Product(val sellIn: Int, val quality: Int) {
    open fun updateSellIn(): Int {
        return sellIn - 1
    }
    abstract fun updateQuality(): Int


    fun degradeBy(quality: Int, sellIn: Int, quantityToDegrade: Int): Int {
        var res = quality
        if (res > 0) {
            res = res - quantityToDegrade
        }
        if (sellIn <= 0) {
            if (res > 0) {
                res = res - quantityToDegrade
            }
        }
        return res
    }
}
