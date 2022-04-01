package com.gildedrose

import org.approvaltests.Approvals
import org.approvaltests.ReporterFactory
import org.approvaltests.namer.NamedEnvironment
import org.approvaltests.namer.NamerFactory
import org.approvaltests.reporters.DiffReporter
import org.approvaltests.reporters.QuietReporter
import org.approvaltests.reporters.UseReporter
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.RepetitionInfo
import java.util.*


class GoldenMasterTest {

    @RepeatedTest(20)
    fun testRandom(repetitionInfo: RepetitionInfo) {
        val items = arrayOf(randomItem())
        val init = stringRep(items)
        val app = GildedRose(items)
        app.updateQuality()
        val final = stringRep(items)

        val parameter = repetitionInfo.currentRepetition
        ReporterFactory.get()
        var nc: NamedEnvironment? = null
        try {
            nc = NamerFactory.withParameters(parameter)
            Approvals.verify(init + "\n" + final)
        } finally {
            nc?.close()
        }

    }

    companion object {

        private val ITEM_NAMES = arrayOf(
            "Aged Brie",
            "Elixir of the Mongoose",
            "Sulfuras, Hand of Ragnaros",
            "Sulfuras, Hand of Ragnaros",
            "Backstage passes to a TAFKAL80ETC concert",
            "Backstage passes to a TAFKAL80ETC concert",
            "Backstage passes to a TAFKAL80ETC concert",
            "Conjured Mana Cake"
        )

        fun stringRep(items: Array<Item>): String {
            return items.joinToString("\n") { it.toString() }
        }

        fun randomItem(): Item = Item(randomItemName(), randomSellin(), randomQuality())

        val randomSellin = Random(123456)
        private fun randomSellin(): Int {
            return randomSellin.nextInt(10 + 1)
        }

        val randomQuality = Random(654321)
        private fun randomQuality(): Int {
            return randomQuality.nextInt(50 + 1)
        }

        val randomItem = Random(654321)
        private fun randomItemName(): String {
            return ITEM_NAMES[randomItem.nextInt(ITEM_NAMES.size)]
        }


    }
}