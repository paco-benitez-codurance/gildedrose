package com.gildedrose.product

abstract class Product(val sellIn: Int, val quality: Int) {
    open fun updateSellIn(): Int {
        return sellIn - 1
    }
    abstract fun updateQuality(): Int
}
