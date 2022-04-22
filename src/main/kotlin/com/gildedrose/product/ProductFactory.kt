package com.gildedrose.product

import com.gildedrose.Item

object ProductFactory {
    fun product(item: Item): Product {
        return if (item.name == "Sulfuras, Hand of Ragnaros") {
            SulfurasHandOfRgnaros(item.sellIn, item.quality)
        } else if (item.name == "Aged Brie") {
            AgedBrie(item.sellIn, item.quality)
        } else if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
            Concert(item.sellIn, item.quality)
        } else if(item.name.contains("Conjured") && item.name != "Conjured Mana Cake") {
            Conjured(item.sellIn, item.quality)
        } else {
            Common(item.sellIn, item.quality)
        }
    }
}