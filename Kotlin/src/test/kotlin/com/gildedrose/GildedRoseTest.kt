package com.gildedrose

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class GildedRoseTest {

    @Test
    fun commonItemPositiveSellDatePositiveQuality_QualityDegradesOne() {
        val items = arrayOf(Item("Common Pants", 5, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Common Pants", app.items[0].name)
        assertEquals(4, app.items[0].sellIn)
        assertEquals(9, app.items[0].quality)
    }

    @Test
    fun commonItemNegativeSellDatePositiveQuality_QualityDegradesTwo() {
        val items = arrayOf(Item("Common Pants", -2, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Common Pants", app.items[0].name)
        assertEquals(-3, app.items[0].sellIn)
        assertEquals(8, app.items[0].quality)
    }

    @Test
    fun commonItemSellDateTodayPositiveQuality_QualityDegradesTwo() {
        val items = arrayOf(Item("Common Pants", 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Common Pants", app.items[0].name)
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(8, app.items[0].quality)
    }

    @Test
    fun commonItemSellDateTodayZeroQuality_notBelowZero() {
        val items = arrayOf(Item("Common Pants", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Common Pants", app.items[0].name)
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun commonItemNegativeSellDateZeroQuality_NoQualityDegrades() {
        val items = arrayOf(Item("Common Pants", -3, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Common Pants", app.items[0].name)
        assertEquals(-4, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun commonItemPositiveSellDateZeroQuality_NoQualityDegrades() {
        val items = arrayOf(Item("Common Pants", 3, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Common Pants", app.items[0].name)
        assertEquals(2, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun agedBriePositiveSellDatePositiveQuality_QualityIncreaseByOne() {
        val items = arrayOf(Item("Aged Brie", 3, 5))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Aged Brie", app.items[0].name)
        assertEquals(2, app.items[0].sellIn)
        assertEquals(6, app.items[0].quality)
    }

    @Test
    fun agedBrieNegativeSellDatePositiveQuality_QualityIncreaseByTwo() {
        val items = arrayOf(Item("Aged Brie", -3, 5))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Aged Brie", app.items[0].name)
        assertEquals(-4, app.items[0].sellIn)
        assertEquals(7, app.items[0].quality)
    }

    @Test
    fun agedBriePositiveSellDateQuality50_QualityNotIncrease() {
        val items = arrayOf(Item("Aged Brie", 3, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Aged Brie", app.items[0].name)
        assertEquals(2, app.items[0].sellIn)
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun agedBrieNegativeSellDateQuality50_QualityNotIncrease() {
        val items = arrayOf(Item("Aged Brie", -3, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Aged Brie", app.items[0].name)
        assertEquals(-4, app.items[0].sellIn)
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun sulfurasNegativeSellBy_noQualityDecrease() {
        val items = arrayOf(Item("Sulfuras, Hand of Ragnaros", -3, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name)
        assertEquals(-4, app.items[0].sellIn)
        assertEquals(80, app.items[0].quality)
    }

    @Test
    fun sulfurasPositiveSellBy_noQualityDecrease() {
        val items = arrayOf(Item("Sulfuras, Hand of Ragnaros", 3, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name)
        assertEquals(2, app.items[0].sellIn)
        assertEquals(80, app.items[0].quality)
    }

    @Test
    fun backstagePassesSellByOver10Quality10_Quality10() {
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 15, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name)
        assertEquals(14, app.items[0].sellIn)
        assertEquals(11, app.items[0].quality)
    }

    @Test
    fun backstagePassesSellBy10Quality10_Quality12() {
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 10, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name)
        assertEquals(9, app.items[0].sellIn)
        assertEquals(12, app.items[0].quality)
    }

    @Test
    fun backstagePassesSellBy5Quality10_Quality13() {
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 5, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name)
        assertEquals(4, app.items[0].sellIn)
        assertEquals(13, app.items[0].quality)
    }

    @Test
    fun backstagePassesSellBy0Quality10_Quality0() {
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name)
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun conjuredItemSellByPositiveQuality10_Quality8() {
        val items = arrayOf(Item("Conjured Mana Brownie", 5, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Conjured Mana Brownie", app.items[0].name)
        assertEquals(4, app.items[0].sellIn)
        assertEquals(8, app.items[0].quality)
    }

    @Test
    fun conjuredItemSellByNegativeQuality10_Quality6() {
        val items = arrayOf(Item("Conjured Mana Cake", -5, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Conjured Mana Cake", app.items[0].name)
        assertEquals(-6, app.items[0].sellIn)
        assertEquals(6, app.items[0].quality)
    }

    @Test
    fun conjuredItemSellByNegativeQuality0_Quality0() {
        val items = arrayOf(Item("Conjured Sourdough", -5, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Conjured Sourdough", app.items[0].name)
        assertEquals(-6, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun conjuredItemSellByPositiveQuality0_Quality0() {
        val items = arrayOf(Item("Conjured Muffin", 5, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Conjured Muffin", app.items[0].name)
        assertEquals(4, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun multipleItemsHandledCorrectly(){
        val items = arrayOf(
            Item("Conjured Muffin", 5, 10),
            Item("Backstage passes to a Rammstein concert", 5, 10),
            Item("Sulfuras, the Extinguished Hand", 5, 80),
            Item("Aged Brie", 5, 10),
            Item("plain cloth pants", 5, 10),
        )
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Conjured Muffin", app.items[0].name)
        assertEquals(4, app.items[0].sellIn)
        assertEquals(8, app.items[0].quality)
        assertEquals("Backstage passes to a Rammstein concert", app.items[1].name)
        assertEquals(4, app.items[1].sellIn)
        assertEquals(13, app.items[1].quality)
        assertEquals("Sulfuras, the Extinguished Hand", app.items[2].name)
        assertEquals(4, app.items[2].sellIn)
        assertEquals(80, app.items[2].quality)
        assertEquals("plain cloth pants", app.items[4].name)
        assertEquals(4, app.items[4].sellIn)
        assertEquals(9, app.items[4].quality)
        assertEquals("Aged Brie", app.items[3].name)
        assertEquals(4, app.items[3].sellIn)
        assertEquals(11, app.items[3].quality)
    }
}


