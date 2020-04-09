package com.epam.marketspring.service;

import com.epam.marketspring.domain.Item;

import java.util.List;


public interface ItemService {
    List<Item> findAllBySellerId(int sellerId);

    List<Item> findAllItems();

    void deleteById(int itemId);

    Item getItemById(int itemId);

    void saveItem(Item item);

    void updateItem(Item item);

    boolean bidValidation(Integer bid, Item item);

    void setBidAndBidderId(Item item, Integer bid, int bidderId);
}
