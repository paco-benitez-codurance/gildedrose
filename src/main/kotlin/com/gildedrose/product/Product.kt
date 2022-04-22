package com.gildedrose.product

abstract class Product(val sellIn: Int, val quality: Int) {
    abstract fun updateSellIn(): Int
    abstract fun updateQuality(): Int
}
