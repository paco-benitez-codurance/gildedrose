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
            updateAgedBrie(item, currentSellIn)
            return
        }
        if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
            updateConcert(item, currentSellIn)
            return
        }

        if(item.name.contains("Conjured") && !item.name.equals("Conjured Mana Cake")) {
            item.quality = updateConjured(item.quality, currentSellIn)
            return
        }

        item.quality = updateCommonItem(item.quality, currentSellIn)
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

    private fun updateConcert(item: Item, currentSellIn: Int) {
        if (item.quality < 50) {
            item.quality = item.quality + 1
        }
        if (currentSellIn < 11) {
            if (item.quality < 50) {
                item.quality = item.quality + 1
            }
        }

        if (currentSellIn < 6) {
            if (item.quality < 50) {
                item.quality = item.quality + 1
            }
        }

        if (currentSellIn <= 0) {
            item.quality = item.quality - item.quality
        }
    }

    private fun updateAgedBrie(item: Item, currentSellIn: Int) {
        if (item.quality < 50) {
            item.quality = item.quality + 1
        }
        if (currentSellIn <= 0) {
            if (item.quality < 50) {
                item.quality = item.quality + 1
            }
        }
    }


    private fun updateSellIn(item: Item) {
        item.sellIn = item.sellIn - 1
    }


}

