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
    fun sulfurasNegativeSellDateQuality80_SellBy0Quality80() {
        val items = arrayOf(Item("Sulfuras, Hand of Ragnaros", -3, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name)
        assertEquals(-3, app.items[0].sellIn)
        assertEquals(80, app.items[0].quality)
    }

    @Test
    fun sulfurasPositiveSellDateQuality80_SellBy0Quality80() {
        val items = arrayOf(Item("Sulfuras, Hand of Ragnaros", 3, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name)
        assertEquals(3, app.items[0].sellIn)
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




}


