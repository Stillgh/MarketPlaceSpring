package com.epam.marketspring.service;

public class AdvancedSearchedItem {

    private String id = "%";
    private String title = "%";
    private String description = "%";
    private String startPrice = "0";
    private String bestOffer = "9999999";
    private String startDate = "1970-01-01";
    private String endDate = "2100-01-01";

    @Override
    public String toString() {
        return "AdvancedSearchedItem{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startPrice='" + startPrice + '\'' +
                ", bestOffer='" + bestOffer + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }

    public AdvancedSearchedItem() {
    }

    public AdvancedSearchedItem(String id, String title, String description,
                                String startPrice, String bestOffer, String startDate, String endDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startPrice = startPrice;
        this.bestOffer = bestOffer;
        this.startDate = startDate;
        this.endDate = endDate;
    }


    public void advancedSearchedItemSetter(AdvancedSearchedItem item) {
        if (!item.getId().isEmpty()) {
            this.setId(item.getId());
        }
        if (!item.getTitle().isEmpty()) {
            this.setTitle(item.getTitle());
        }
        if (!item.getDescription().isEmpty()) {
            this.setDescription(item.getDescription());
        }
        if (!item.getStartPrice().isEmpty()) {
            this.setStartPrice(item.getStartPrice());
        }
        if (!item.getBestOffer().isEmpty()) {
            this.setBestOffer(item.getBestOffer());
        }
        if (!item.getStartDate().isEmpty()) {
            this.setStartDate(item.getStartDate());
        }
        if (!item.getEndDate().isEmpty()) {
            this.setEndDate(item.getEndDate());
        }
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(String startPrice) {
        this.startPrice = startPrice;
    }

    public String getBestOffer() {
        return bestOffer;
    }

    public void setBestOffer(String bestOffer) {
        this.bestOffer = bestOffer;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

}
