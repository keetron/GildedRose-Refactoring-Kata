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
            } else if (item.name.startsWith("Conjured")) {
                updateConjured(item);
            } else {
                updateCommonItem(item);
            }
        }
    }

    private void updateAgedBrie(Item brie) {
        if (brie.sellIn >= 0) {
            brie.quality++;
        } else {
            brie.quality = brie.quality + 2;
        }
        if (brie.quality > 50) {
            brie.quality = 50;
        }
        brie.sellIn--;
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
        sulfuras.sellIn--;
    }

    private void updateConjured(Item item) {
        item.sellIn--;
        if (item.sellIn >= 0 && item.quality > 1) {
            item.quality = item.quality - 2;
        } else if (item.sellIn < 0 && item.quality > 3) {
            item.quality = item.quality - 4;
        } else {
            item.quality = 0;
        }
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