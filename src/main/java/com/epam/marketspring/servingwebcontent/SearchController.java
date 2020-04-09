package com.epam.marketspring.servingwebcontent;

import com.epam.marketspring.domain.Item;
import com.epam.marketspring.service.AdvancedSearchedItem;
import com.epam.marketspring.service.AdvancedSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private AdvancedSearcher advancedSearcher;


    @GetMapping("/search")
    public String search() {
        return "searchPage";
    }


    @PostMapping("/search")
    public String searchParam(AdvancedSearchedItem advancedsearcheditem, Model model) {

        AdvancedSearchedItem searchedItem = new AdvancedSearchedItem();

        searchedItem.advancedSearchedItemSetter(advancedsearcheditem);

        List<Item> listItems = advancedSearcher.getSearchedItems(searchedItem);

        model.addAttribute("searchItemsList", listItems);

        return "adavancedSearchItemsPage";

    }
}


