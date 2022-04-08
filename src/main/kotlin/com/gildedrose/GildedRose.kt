package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            updateItem(items[i])
        }
    }

    private fun updateItem(item: Item) {
        if (item.name == "Sulfuras, Hand of Ragnaros") {
            return
        }
        val currentSellIn = item.sellIn
        updateSellIn(item)
        if (item.name == "Aged Brie") {
            item.quality = updateAgedBrie(item.quality, currentSellIn)
            return
        } else if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
            item.quality = updateConcert(item.quality, currentSellIn)
            return
        } else if(item.name.contains("Conjured") && !item.name.equals("Conjured Mana Cake")) {
            item.quality = updateConjured(item.quality, currentSellIn)
            return
        } else {
            item.quality = updateCommonItem(item.quality, currentSellIn)
        }
    }

    private fun updateCommonItem(quality: Int, currentSellIn: Int): Int {
        return degradeBy(quality, currentSellIn, 1)
    }

    private fun updateConjured(quality: Int, currentSellIn: Int): Int {
        return degradeBy(quality, currentSellIn, 2)
    }

    private fun degradeBy(quality: Int, currentSellIn: Int, quantityToDegrade: Int): Int {
        var res = quality
        if (res > 0) {
            res = res - quantityToDegrade
        }
        if (currentSellIn <= 0) {
            if (res > 0) {
                res = res - quantityToDegrade
            }
        }
        return res
    }

    private fun updateConcert(quality: Int, currentSellIn: Int): Int {
        var res = quality
        if (res < 50) {
            res = res + 1
        }
        if (currentSellIn < 11) {
            if (res < 50) {
                res = res + 1
            }
        }

        if (currentSellIn < 6) {
            if (res < 50) {
                res = res + 1
            }
        }

        if (currentSellIn <= 0) {
            res = res - res
        }
        return res
    }

    private fun updateAgedBrie(quality: Int, currentSellIn: Int): Int {
        var res = quality
        if (res < 50) {
            res = res + 1
        }
        if (currentSellIn <= 0) {
            if (res < 50) {
                res = res + 1
            }
        }
        return res
    }


    private fun updateSellIn(item: Item) {
        item.sellIn = item.sellIn - 1
    }


}

