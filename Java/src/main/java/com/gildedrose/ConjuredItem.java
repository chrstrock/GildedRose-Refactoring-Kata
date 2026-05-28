package com.gildedrose;

public class ConjuredItem extends UpdatableItem{


    protected ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        sellIn--;
        quality-=2;
    }
}
