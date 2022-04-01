package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            updateQualityOfItem(items[i])
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

    private fun updateQualityOfItem(item: Item) {
        if (item.name == "Sulfuras, Hand of Ragnaros") {
            return
        }
        val currentSellIn = item.sellIn
        updateSellIn(item)

        if (item.name == "Aged Brie") {
            updateAgedBrie(item, currentSellIn)
            return
        }

        if (item.name != "Backstage passes to a TAFKAL80ETC concert") {
            if (item.quality > 0) {
                item.quality = item.quality - 1
            }
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1

                if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
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
                }
            }
        }


        if (currentSellIn <= 0) {
            if (item.name != "Backstage passes to a TAFKAL80ETC concert") {
                if (item.quality > 0) {
                    item.quality = item.quality - 1
                }
            } else {
                item.quality = item.quality - item.quality
            }
        }
    }


    private fun updateSellIn(item: Item) {
        item.sellIn = item.sellIn - 1
    }


}

