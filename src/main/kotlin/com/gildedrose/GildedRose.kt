package com.gildedrose

import com.gildedrose.product.*

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            items[i] = updateItem(items[i])
        }
    }

    private fun updateItem(item: Item): Item {
        val product: Product = ProductFactory.product(item)

        return Item(item.name, product.updateSellIn(), product.updateQuality())
    }


}

