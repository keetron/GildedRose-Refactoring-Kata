package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        items.forEach {
            when {
                it.name == "Aged Brie" -> {
                    handleAgedBrie(it)
                }
                it.name.startsWith("Backstage passes") -> {
                    handleBackStagePasses(it)
                }
                it.name.startsWith("Sulfuras") -> {
                    it.sellIn--
                }
                it.name.startsWith("Conjured") -> {
                    handleConjuredItem(it)
                }
                else -> {
                    handleOther(it)
                }
            }
        }
    }

    private fun handleConjuredItem(item: Item) {
        item.quality = if (item.sellIn <= 0) item.quality - 4 else item.quality - 2
        if (item.quality < 0) item.quality = 0
        item.sellIn--
    }

    private fun handleOther(item: Item) {
        item.quality = if (item.sellIn <= 0) item.quality - 2 else item.quality - 1
        if (item.quality < 0) item.quality = 0
        item.sellIn--
    }

    private fun handleBackStagePasses(item: Item) {
        when {
            item.sellIn <= 0 -> {
                item.quality = 0
            }
            item.sellIn <= 5 -> {
                item.quality = item.quality + 3
            }
            item.sellIn <= 10 -> {
                item.quality = item.quality + 2
            }
            else -> {
                item.quality++
            }
        }
        if (item.quality > 50) item.quality = 50
        item.sellIn--
    }

    private fun handleAgedBrie(item: Item) {
        item.quality = if (item.sellIn < 0) item.quality + 2 else item.quality + 1
        if (item.quality > 50) item.quality = 50
        item.sellIn--
    }
}
