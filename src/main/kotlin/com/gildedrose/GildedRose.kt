package com.gildedrose

import com.gildedrose.product.Product
import com.gildedrose.product.SulfurasHandOfRgnaros

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            items[i] = updateItem(items[i])
        }
    }

    private fun updateItem(item: Item): Item {

        val currentSellIn = item.sellIn
        val newSellIn: Int
        val newQuality: Int

        if (item.name == "Sulfuras, Hand of Ragnaros") {
            val product: Product = SulfurasHandOfRgnaros(item.sellIn, item.quality)
            newSellIn = product.sellIn
            newQuality = product.quality
        } else if (item.name == "Aged Brie") {
            newSellIn = updateSellIn(item.sellIn)
            newQuality = updateAgedBrie(item.quality, currentSellIn)
        } else if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
            newSellIn = updateSellIn(item.sellIn)
            newQuality = updateConcert(item.quality, currentSellIn)
        } else if(item.name.contains("Conjured") && !item.name.equals("Conjured Mana Cake")) {
            newSellIn = updateSellIn(item.sellIn)
            newQuality = updateConjured(item.quality, currentSellIn)
        } else {
            newSellIn = updateSellIn(item.sellIn)
            newQuality = updateCommonItem(item.quality, currentSellIn)
        }
        return Item(item.name, newSellIn, newQuality)
    }

    private fun updateCommonItem(quality: Int, sellIn: Int): Int {
        return degradeBy(quality, sellIn, 1)
    }

    private fun updateConjured(quality: Int, sellIn: Int): Int {
        return degradeBy(quality, sellIn, 2)
    }

    private fun degradeBy(quality: Int, sellIn: Int, quantityToDegrade: Int): Int {
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

    private fun updateConcert(quality: Int, sellIn: Int): Int {
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

    private fun updateAgedBrie(quality: Int, sellIn: Int): Int {
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


    private fun updateSellIn(sellIn: Int): Int {
        return sellIn - 1
    }


}

