package com.epam.marketspring.service;

import com.epam.marketspring.domain.Item;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ItemRowMapper implements RowMapper<Item> {

    @Override
    public Item mapRow(ResultSet rs, int i) throws SQLException {
        Item item = new Item();
        item.setId(rs.getInt("id"));
        item.setTitle(rs.getString("title"));
        item.setDescription(rs.getString("description"));
        item.setStartPrice(rs.getFloat("start_price"));
        item.setBestOffer(rs.getFloat("best_offer"));
        item.setSellerId(rs.getInt("seller_id"));
        item.setBidderId(rs.getInt("bidder_id"));
        item.setStartDate(rs.getString("start_date"));
        item.setEndDate(rs.getString("end_date"));
        return item;
    }
}
