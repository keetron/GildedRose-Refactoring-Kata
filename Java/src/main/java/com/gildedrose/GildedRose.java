package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Aged Brie")) {
                updateAgedBrie(item);
            } else if (item.name.startsWith("Backstage passes")) {
                updateBackstagePasses(item);
            } else if (item.name.startsWith("Sulfuras")) {
                updateSulfuras(item);
            } else {
                updateCommonItem(item);
            }
        }
    }

    private void updateAgedBrie(Item brie) {
        brie.sellIn--;
        if (brie.quality < 50) {
            brie.quality++;
        }
    }

    private void updateBackstagePasses(Item pass) {
        pass.sellIn--;
        if (pass.sellIn < 0) {
            pass.quality = 0;
        } else if (pass.sellIn <= 5) {
            pass.quality = pass.quality + 3;
        } else if (pass.sellIn <= 10) {
            pass.quality = pass.quality + 2;
        } else {
            pass.quality = pass.quality + 1;
        }
    }

    private void updateSulfuras(Item sulfuras) {
        //sulfuras does not need to be updated or sold, setting sellIn to 0
        sulfuras.sellIn = 0;
    }

    private void updateCommonItem(Item item) {
        item.sellIn--;
        if (item.sellIn >= 0 && item.quality > 0) {
            item.quality--;
        } else if (item.sellIn < 0 && item.quality > 1) {
            item.quality = item.quality - 2;
        } else {
            item.quality = 0;
        }
    }
}