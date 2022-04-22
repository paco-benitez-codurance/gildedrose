package com.gildedrose.product

import com.gildedrose.Item

object ProductFactory {
    fun product(item: Item): Product {
        if (item.name == "Sulfuras, Hand of Ragnaros") {
            return SulfurasHandOfRgnaros(item.sellIn, item.quality)
        } else if (item.name == "Aged Brie") {
            return AgedBrie(item.sellIn, item.quality)
        } else if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
            return Concert(item.sellIn, item.quality)
        } else if(item.name.contains("Conjured") && !item.name.equals("Conjured Mana Cake")) {
            return Conjured(item.sellIn, item.quality)
        } else {
            return Common(item.sellIn, item.quality)
        }
    }
}