package com.epam.marketspring.service;

import com.epam.marketspring.domain.Item;

import java.util.List;


public interface AdvancedSearcher {

    List<Item> getSearchedItems(AdvancedSearchedItem advancedSearchedItem);

}
