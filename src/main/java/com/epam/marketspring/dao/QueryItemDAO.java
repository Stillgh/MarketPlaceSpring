package com.epam.marketspring.dao;

import com.epam.marketspring.domain.Item;
import com.epam.marketspring.service.AdvancedSearchedItem;
import com.epam.marketspring.service.ItemRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.List;

@Service
public class QueryItemDAO extends JdbcDaoSupport implements QueryItemInterface {

    @Autowired
    public QueryItemDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }


    public List<Item> getAllItems() {
        String query = "select * from forspringdb.item";
        List<Item> listOfItems = this.getJdbcTemplate().query(query, new ItemRowMapper());

        return listOfItems;
    }

    public void deleteById(int itemId) {
        String query = "DELETE FROM forspringdb.item WHERE id = ?";
        this.getJdbcTemplate().update(query, preparedStatement -> preparedStatement.setInt(1, itemId));
    }

    public List<Item> getSearchedItems(AdvancedSearchedItem item) {
        String query =
                "SELECT * FROM forspringdb.item WHERE id like ? and title like ? and description like ? and start_price >= ? and start_price <= ? and best_offer <= ? "
                        + "and best_offer >= ? and start_date >= ? and start_date <= ? and end_date <= ? and end_date >= ?";

        List<Item> itemsPrep = this.getJdbcTemplate().query(
                query, preparedStatement -> {
                    preparedStatement.setString(1, item.getId());
                    preparedStatement.setString(2, item.getTitle());
                    preparedStatement.setString(3, item.getDescription());
                    preparedStatement.setFloat(4, Float.parseFloat(item.getStartPrice()));
                    preparedStatement.setFloat(5, Float.parseFloat(item.getBestOffer()));
                    preparedStatement.setFloat(6, Float.parseFloat(item.getBestOffer()));
                    preparedStatement.setFloat(7, Float.parseFloat(item.getStartPrice()));
                    preparedStatement.setDate(8, Date.valueOf(item.getStartDate()));
                    preparedStatement.setDate(9, Date.valueOf(item.getEndDate()));
                    preparedStatement.setDate(10, Date.valueOf(item.getEndDate()));
                    preparedStatement.setDate(11, Date.valueOf(item.getStartDate()));
                },
                new ItemRowMapper());

        return itemsPrep;

    }


    public List<Item> findAllBySellerId(int sellerId) {
        String query = "select * from forspringdb.item where seller_id = ?";

        List<Item> myItems = this.getJdbcTemplate().query(
                query, preparedStatement -> {
                    preparedStatement.setInt(1, sellerId);
                },
                new ItemRowMapper());

        return myItems;
    }

    public Item getItemById(int itemId) {
        String query = "select * from forspringdb.item where id = ?";

        Item item = this.getJdbcTemplate().queryForObject(query, new Object[]{itemId}, new ItemRowMapper());

        return item;
    }

    public void saveItem(Item item) {

        String query = "INSERT INTO forspringdb.item(id, title, description, seller_id, start_price, best_offer, bidder_id, end_date, start_date) "
                + "VALUES(?,?,?,?,?,?,?,?,?)";

        this.getJdbcTemplate().update(query, preparedStatement -> {
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, item.getTitle());
            preparedStatement.setString(3, item.getDescription());
            preparedStatement.setInt(4, item.getSellerId());
            preparedStatement.setFloat(5, item.getStartPrice());
            preparedStatement.setFloat(6, 0);
            preparedStatement.setInt(7, 0);
            preparedStatement.setDate(8, Date.valueOf(item.getEndDate()));
            preparedStatement.setDate(9, Date.valueOf(item.getStartDate()));
        });
    }


    public void updateItem(Item item) {
        String query = "update forspringdb.item set best_offer = ?, bidder_id = ?  where id = ?";
        this.getJdbcTemplate().update(query, preparedStatement -> {
            preparedStatement.setFloat(1, item.getBestOffer());
            preparedStatement.setInt(2, item.getBidderId());
            preparedStatement.setInt(3, item.getId());
        });

    }
}

