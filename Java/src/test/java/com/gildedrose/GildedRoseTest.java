package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void plainItemWithPositiveSellInDate_normalDegradation() {
        Item[] items = new Item[]{new Item("plain cloth pants", 1, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("plain cloth pants", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }

    @Test
    void plainItemWithNegativeSellInDate_doubleDegradation() {
        Item[] items = new Item[]{new Item("plain cloth pants", -1, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("plain cloth pants", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void plainItemWithZeroSellInDate_doubleDegradation() {
        Item[] items = new Item[]{new Item("plain cloth pants", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("plain cloth pants", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void plainItemWithPositiveSellInDateZeroQuality_noDegradation() {
        Item[] items = new Item[]{new Item("plain cloth pants", 5, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("plain cloth pants", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void agedBrieWithPositiveSellInDate_increasedQuality() {
        Item[] items = new Item[]{new Item("Aged Brie", 5, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void agedBrieWithPositiveSellInDateQuality50_noIncreasedQuality() {
        Item[] items = new Item[]{new Item("Aged Brie", 5, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void sulfurasPositiveSellInDate_noDecreasedQuality() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 5, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(5, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void sulfurasNegativeSellInDate_noDecreasedQuality() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", -5, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(-5, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void backstage15DaysToSellInDate_qualityIncrease1() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(14, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void backstage10DaysToSellInDate_qualityIncrease2() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }

    @Test
    void backstage5DaysToSellInDate_qualityIncrease3() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }

    @Test
    void backstagePastSellInDate_qualityTo0() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

}
