package com.epam.marketspring.servingwebcontent;


import com.epam.marketspring.domain.Item;
import com.epam.marketspring.domain.User;
import com.epam.marketspring.service.ItemService;
import com.epam.marketspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ItemsController {


    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String root() {
        return "redirect:/showitems";
    }


    @GetMapping("/showitems")
    public String allItemsPage(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {

        List<Item> allItems = itemService.findAllItems();

        model.addAttribute("itemsList", allItems);
        return "showItems";
    }

    @GetMapping("/myitems")
    public String myItemsPage(Model model) {

        final String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userService.getUserByUserName(currentUserName);

        List<Item> myItems = itemService.findAllBySellerId(user.getId());

        model.addAttribute("myItems", myItems);

        return "myItemsPage";
    }

    @PostMapping("/myitems")
    public String deleteItem(@RequestParam(name = "it") Integer itemId, Model model) {

        itemService.deleteById(itemId);
        return "redirect:/myitems";
    }

    @PostMapping("/showitems")
    public String bid(@RequestParam(name = "bd") Integer bid, @RequestParam(name = "it") Integer itemId, Model model) {

        final String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userService.getUserByUserName(currentUserName);

        Item item = itemService.getItemById(itemId);

        if (itemService.bidValidation(bid, item)) {
            itemService.setBidAndBidderId(item, bid, user.getId());
            itemService.updateItem(item);
        } else {
            return "invalidBid";
        }

        return "redirect:/showitems";
    }


    @GetMapping("/additem")
    public String addItemPage() {

        return "addItemsPage";
    }

    @PostMapping("/additem")
    public String addItem(@Valid Item item, BindingResult bindingResult, Model model) {

        final String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userService.getUserByUserName(currentUserName);
        item.setSellerId(user.getId());


        if (bindingResult.hasErrors()) {
            model.addAttribute("error", "ALL FIELDS MUST BE FULLFILLED");
            return "addItemsPage";
        }

        itemService.saveItem(item);

        return "redirect:showitems";
    }

}