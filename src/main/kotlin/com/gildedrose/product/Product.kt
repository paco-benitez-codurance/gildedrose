package com.gildedrose.product

abstract class Product(sellIn: Int, quantity: Int) {
    abstract fun updateSellIn(): Int
    abstract fun updateQuality(): Int
}
