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
            updateConjured(item, currentSellIn)
            return
        }

        updateCommonItem(item, currentSellIn)
    }

    private fun updateCommonItem(item: Item, currentSellIn: Int) {
        degradeBy(item, currentSellIn, 1)
    }

    private fun updateConjured(item: Item, currentSellIn: Int) {
        degradeBy(item, currentSellIn, 2)
    }

    private fun degradeBy(item: Item, currentSellIn: Int, quantityToDegrade: Int) {
        if (item.quality > 0) {
            item.quality = item.quality - quantityToDegrade
        }
        if (currentSellIn <= 0) {
            if (item.quality > 0) {
                item.quality = item.quality - quantityToDegrade
            }
        }
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

