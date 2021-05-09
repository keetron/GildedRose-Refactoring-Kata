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
    void plainItemWithPositiveSellInDate_notBelowZero() {
        Item[] items = new Item[]{new Item("plain cloth pants", 1, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("plain cloth pants", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
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
    void plainItemWithNegativeSellInDate_notBelowZero() {
        Item[] items = new Item[]{new Item("plain cloth pants", -1, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("plain cloth pants", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
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
    void plainItemWithZeroSellInDate_notBelowZero() {
        Item[] items = new Item[]{new Item("plain cloth pants", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("plain cloth pants", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void agedBrieWithPositiveSellInDate_increasedQualityBy1() {
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
    void agedBrieWithNegativeSellInDateQuality50_noIncreasedQuality() {
        Item[] items = new Item[]{new Item("Aged Brie", -5, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-6, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void agedBrieWithNegativeSellInDate_increasedQualityBy2() {
        Item[] items = new Item[]{new Item("Aged Brie", -1, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(32, app.items[0].quality);
    }

    @Test
    void sulfurasPositiveSellInDate_noDecreasedQuality() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 5, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void sulfurasNegativeSellInDate_noDecreasedQuality() {
        Item[] items = new Item[]{new Item("Sulfuras, the Extinguished Hand", -5, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, the Extinguished Hand", app.items[0].name);
        assertEquals(-6, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void backstage15DaysToSellInDate_qualityIncrease0() {
        Item[] items = new Item[]{new Item("Backstage passes to a Foo Fighters concert", 15, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a Foo Fighters concert", app.items[0].name);
        assertEquals(14, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void backstage10DaysToSellInDate_qualityIncrease2() {
        Item[] items = new Item[]{new Item("Backstage passes to a Green Day concert", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a Green Day concert", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }

    @Test
    void backstage5DaysToSellInDate_qualityIncrease3() {
        Item[] items = new Item[]{new Item("Backstage passes to a System of a Down concert", 5, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a System of a Down concert", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }

    @Test
    void backstagePastSellInDate_qualityTo0() {
        Item[] items = new Item[]{new Item("Backstage passes to a Rammstein concert", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a Rammstein concert", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void conjuredItemPositiveSellInDate_degradesBy2() {
        Item[] items = new Item[]{new Item("Conjured Muffin", 4, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured Muffin", app.items[0].name);
        assertEquals(3, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void conjuredItemPositiveSellInDate_QualityNotBelowZero() {
        Item[] items = new Item[]{new Item("Conjured Sourdough", 4, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured Sourdough", app.items[0].name);
        assertEquals(3, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void conjuredItemNegativeSellInDate_degradesBy4() {
        Item[] items = new Item[]{new Item("Conjured Croissant", -3, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured Croissant", app.items[0].name);
        assertEquals(-4, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }

    @Test
    void conjuredItemNegativeSellInDate_notBelowZero() {
        Item[] items = new Item[]{new Item("Conjured Sweet Roll", -3, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured Sweet Roll", app.items[0].name);
        assertEquals(-4, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void multipleItemsHandledCorrectly() {
        Item[] items = new Item[]{
                new Item("Conjured Sweet Roll", -3, 2),
                new Item("Backstage passes to a Rammstein concert", 0, 10),
                new Item("Sulfuras, the Extinguished Hand", -5, 80),
                new Item("Aged Brie", -1, 30),
                new Item("plain cloth pants", 0, 0)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured Sweet Roll", app.items[0].name);
        assertEquals(-4, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
        assertEquals("Backstage passes to a Rammstein concert", app.items[1].name);
        assertEquals(-1, app.items[1].sellIn);
        assertEquals(0, app.items[1].quality);
        assertEquals("Sulfuras, the Extinguished Hand", app.items[2].name);
        assertEquals(-6, app.items[2].sellIn);
        assertEquals(80, app.items[2].quality);
        assertEquals("Aged Brie", app.items[3].name);
        assertEquals(-2, app.items[3].sellIn);
        assertEquals(32, app.items[3].quality);
        assertEquals("plain cloth pants", app.items[4].name);
        assertEquals(-1, app.items[4].sellIn);
        assertEquals(0, app.items[4].quality);
    }
}
