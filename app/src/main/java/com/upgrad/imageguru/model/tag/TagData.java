package com.upgrad.imageguru.model.tag;

/**
 * Created by rachitgoyal on 6/29/16.
 */
public class TagData {
    private boolean following;
    private int followers;
    private TagItem[] items;
    private int total_items;
    private String name;

    public boolean isFollowing() {
        return following;
    }

    public void setFollowing(boolean following) {
        this.following = following;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public TagItem[] getItems() {
        return items;
    }

    public void setItems(TagItem[] items) {
        this.items = items;
    }

    public int getTotal_items() {
        return total_items;
    }

    public void setTotal_items(int total_items) {
        this.total_items = total_items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClassPojo [following = " + following +
                ", followers = " + followers +
                ", items = " + items +
                ", total_items = " + total_items +
                ", name = " + name +
                "]";
    }
}
