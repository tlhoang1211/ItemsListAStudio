package com.example.callapi.model;

import com.example.callapi.network.APIManager;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Item {
    private int id;
    private String date;
    private String title;
    private Content content;
    private int image;

    public Item(int id, String date, String title, Content content, int image) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.content = content;
        this.image = image;
    }

    public static Item getItem(int id) {
        for (Item item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

//    Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl(APIManager.SERVER_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build();
//
//    APIManager service = retrofit.create(APIManager.class);
//    Item[] ITEMS = new Item[] {(Item) service.getListData()};

    public static final Item[] ITEMS = new Item[] { };
}
