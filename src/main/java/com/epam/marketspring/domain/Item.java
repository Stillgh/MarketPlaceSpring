package com.epam.marketspring.domain;


import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


public class Item implements Serializable {

    private int id;

    @NotNull
    @NotBlank
    private String title;
    @NotNull
    @NotBlank
    private String description;
    private int sellerId;
    @NotNull
    @DecimalMin(value = "1")
    private float startPrice;
    private float bestOffer;
    private int bidderId;
    @NotNull
    @NotBlank
    private String startDate;
    @NotNull
    @NotBlank
    private String endDate;


    public Item() {
    }

    public Item(String title, String description, int sellerId, float startPrice,
                float bestOffer, int bidderId, String startDate, String endDate) {
        this.title = title;
        this.description = description;
        this.sellerId = sellerId;
        this.startPrice = startPrice;
        this.bestOffer = bestOffer;
        this.bidderId = bidderId;
        this.startDate = startDate;
        this.endDate = endDate;
    }


    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public float getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(float startPrice) {
        this.startPrice = startPrice;
    }

    public float getBestOffer() {
        return bestOffer;
    }

    public void setBestOffer(float bestOffer) {
        this.bestOffer = bestOffer;
    }

    public int getBidderId() {
        return bidderId;
    }

    public void setBidderId(int bidderId) {
        this.bidderId = bidderId;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", sellerId=" + sellerId +
                ", startPrice=" + startPrice +
                ", bestOffer=" + bestOffer +
                ", bidderId=" + bidderId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
