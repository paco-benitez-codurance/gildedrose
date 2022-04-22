package com.gildedrose

import com.gildedrose.product.*

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            items[i] = updateItem(items[i])
        }
    }

    private fun updateItem(item: Item): Item {

        val newSellIn: Int
        val newQuality: Int

        if (item.name == "Sulfuras, Hand of Ragnaros") {
            val product: Product = SulfurasHandOfRgnaros(item.sellIn, item.quality)
            newSellIn = product.updateSellIn()
            newQuality = product.updateQuality()
        } else if (item.name == "Aged Brie") {
            val product: Product = AgedBrie(item.sellIn, item.quality)
            newSellIn = product.updateSellIn()
            newQuality = product.updateQuality()
        } else if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
            val product: Product = Concert(item.sellIn, item.quality)
            newSellIn = product.updateSellIn()
            newQuality = product.updateQuality()
        } else if(item.name.contains("Conjured") && !item.name.equals("Conjured Mana Cake")) {
            val product: Product = Conjured(item.sellIn, item.quality)
            newSellIn = product.updateSellIn()
            newQuality = product.updateQuality()
        } else {
            val product: Product = Common(item.sellIn, item.quality)
            newSellIn = product.updateSellIn()
            newQuality = product.updateQuality()
        }
        return Item(item.name, newSellIn, newQuality)
    }


}

