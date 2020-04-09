package com.epam.marketspring.service;

import com.epam.marketspring.domain.Item;
import com.epam.marketspring.dao.QueryItemInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ItemServiceImpl implements ItemService {

    @Autowired
    private QueryItemInterface queryItemInterface;

    @Override
    public List<Item> findAllItems() {
        return queryItemInterface.getAllItems();
    }

    @Override
    public void updateItem(Item item) {
        queryItemInterface.updateItem(item);
    }

    @Override
    public Item getItemById(int itemId) {
        return queryItemInterface.getItemById(itemId);
    }

    @Override
    public void deleteById(int itemId) {
        queryItemInterface.deleteById(itemId);
    }

    @Override
    public List<Item> findAllBySellerId(int sellerId) {
        return queryItemInterface.findAllBySellerId(sellerId);
    }

    @Override
    public void saveItem(Item item) {
        queryItemInterface.saveItem(item);
    }

    @Override
    public boolean bidValidation(Integer bid, Item item) {
        return item.getBestOffer() < bid && item.getStartPrice() < bid;
    }

    @Override
    public void setBidAndBidderId(Item item, Integer bid, int bidderId) {
        item.setBestOffer(bid);
        item.setBidderId(bidderId);
    }
}
