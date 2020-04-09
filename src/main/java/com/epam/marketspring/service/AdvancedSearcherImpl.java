package com.epam.marketspring.service;

import com.epam.marketspring.domain.Item;
import com.epam.marketspring.dao.QueryItemInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdvancedSearcherImpl implements AdvancedSearcher {


    @Autowired
    private QueryItemInterface queryItemInterface;

    @Override
    public List<Item> getSearchedItems(AdvancedSearchedItem advancedSearchedItem) {
        List<Item> searchedItems;
        searchedItems = queryItemInterface.getSearchedItems(advancedSearchedItem);
        return searchedItems;
    }
}
