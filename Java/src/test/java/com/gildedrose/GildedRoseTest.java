package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void sellInQualityDecreaseTest(){
        Item testItem = new Item("testItem", 3, 3);
        GildedRose app = new GildedRose(new Item[]{testItem});
        app.updateQuality();
        assertEquals(2, testItem.sellIn);
        assertEquals(2, testItem.quality);
    }

    @Test
    void qualityDecreasesTwiceAsFast() {
        Item testItem = new Item("testItem", 5, 20);
        GildedRose app = new GildedRose(new Item[]{testItem});
        for(int i = 0; i<6; i++){
            app.updateQuality();
        }
        assertEquals(-1, testItem.sellIn);
        assertEquals(13, testItem.quality);

    }

    @Test
    void qualityNeverNegativeTest() {
        Item testItem = new Item("testItem", 4, 3);
        GildedRose app = new GildedRose(new Item[]{testItem});
        for(int i = 0; i < 4; i++){
            app.updateQuality();
        }
        assertEquals(0, testItem.sellIn);
        assertEquals(0, testItem.quality);
    }

    @Test
    void qualityOfAgedBrieIncreases(){
        Item agedBrie = new Item("Aged Brie", 2, 0);
        GildedRose app = new GildedRose(new Item[]{agedBrie});
        for(int i = 0; i < 2; i++){
            app.updateQuality();
        }
        assertEquals(2, agedBrie.quality);
        assertEquals(0, agedBrie.sellIn);

    }

    @Test
    void qualityNeverMoreThanFiftyOnInstantiation(){
        Item testItem = new Item("testItem", 20, 60);
        assertEquals(50, testItem.quality);
    }

    @Test
    void qualityNeverMoreThanFiftyAfterUpdate(){
        Item testItem = new Item ("testItem", 20, 53);
        GildedRose app = new GildedRose(new Item[]{testItem});
        app.updateQuality();
        assertEquals(49, testItem.quality);
    }

    @Test
    void sulfurasTest(){
        Item testItem = new Item("Sulfuras, Hand of Ragnaros", 30, 30);
        GildedRose app = new GildedRose(new Item[]{testItem});
        app.updateQuality();
        assertEquals(30, testItem.sellIn);
        assertEquals(30, testItem.quality);
    }

    @Test
    void backStage10DaysOrLessTest(){
        Item testItem = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        GildedRose app = new GildedRose(new Item[]{testItem});
        app.updateQuality();
        assertEquals(22, testItem.quality);
    }

    @Test
    void backStage5DaysOrLessTest(){
        Item testItem = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 11);
        GildedRose app = new GildedRose(new Item[]{testItem});
        app.updateQuality();
        assertEquals(13, testItem.quality);
    }

    @Test
    void backstageQualityDropsToZeroAfterConcert(){
        Item testItem = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        GildedRose app = new GildedRose(new Item[]{testItem});
        app.updateQuality();
        assertEquals(0, testItem.quality);
    }

    @Test
    void conjuredItemsDegradeTwiceAsFast(){
        ConjuredItem testItem = new ConjuredItem("Conjured sword", 3, 10);
        GildedRose app = new GildedRose(new UpdatableItem[]{testItem});
        app.updateQuality();
        assertEquals(8, testItem.quality);
    }
}
