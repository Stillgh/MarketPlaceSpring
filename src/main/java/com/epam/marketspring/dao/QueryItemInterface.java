package com.epam.marketspring.dao;

import com.epam.marketspring.domain.Item;
import com.epam.marketspring.service.AdvancedSearchedItem;

import java.util.List;

public interface QueryItemInterface {
    List<Item> getAllItems();

    void deleteById(int itemId);

    List<Item> getSearchedItems(AdvancedSearchedItem item);

    List<Item> findAllBySellerId(int sellerId);

    Item getItemById(int itemId);

    void saveItem(Item item);

    void updateItem(Item item);
}
