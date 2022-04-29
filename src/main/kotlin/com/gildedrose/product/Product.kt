package com.gildedrose.product

abstract class Product(val sellIn: Int, val quality: Int) {
    open fun updateSellIn(): Int {
        return sellIn - 1
    }

    abstract fun updateQuality(): Int


    fun degradeBy(quantityToDegrade: Int): Int {
        return if(sellIn > 0) {
            degradeNotSellIn(quantityToDegrade)
        } else {
            degradeSellIn(quantityToDegrade)
        }
    }

    private fun degradeSellIn(quantityToDegrade: Int): Int {
        return if (quality > quantityToDegrade ) {
            quality - 2 * quantityToDegrade
        } else if (quality in 1..quantityToDegrade) {
            quality - quantityToDegrade
        } else if (quality <= 0) {
            quality
        } else {
            throw java.lang.RuntimeException("BAD")
        }
    }

    private fun degradeNotSellIn(quantityToDegrade: Int): Int {
        return if (quality > 0) {
            quality - quantityToDegrade
        } else {
            quality
        }
    }
}
