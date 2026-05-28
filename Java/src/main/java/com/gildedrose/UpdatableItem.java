package com.gildedrose;

public class UpdatableItem extends Item{

    public UpdatableItem(String name, int sellIn, int quality){
        super(name, sellIn, quality);
    }

    static void updateItemQuality(Item item) {
        boolean isAgedBrie = item.name.equals("Aged Brie");
        boolean isBackStagePass = item.name.equals("Backstage passes to a TAFKAL80ETC concert");
        if (isAgedBrie) {
            if (item.quality < 50) {
                item.quality++;

            }

            item.sellIn--;

            if (item.sellIn < 0) {
                if (item.quality < 50) {
                    item.quality++;
                }
            }
        }
        else{
            if (isBackStagePass) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }

                item.sellIn = item.sellIn - 1;

                if (item.sellIn < 0) {
                    item.quality = 0;
                }
            }
            else{
                    if (item.quality > 0) {
                        item.quality = item.quality - 1;
                    }

                    item.sellIn = item.sellIn - 1;

                    if (item.sellIn < 0) {
                        if (item.quality > 0) {
                            item.quality = item.quality - 1;
                        }
                    }

            }
        }
    }

}
