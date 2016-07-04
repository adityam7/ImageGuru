package com.upgrad.imageguru.model.gallery;

import java.io.Serializable;

public class GalleryImage implements Serializable {
    private String id;
    private boolean animated;
    private String title;
    private int height;
    private int views;
    private String description;
    private String link;
    private int width;
    private String type;
    private long datetime;
    private String bandwidth;
    private int size;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isAnimated() {
        return animated;
    }

    public void setAnimated(boolean animated) {
        this.animated = animated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getDatetime() {
        return datetime;
    }

    public void setDatetime(long datetime) {
        this.datetime = datetime;
    }

    public String getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(String bandwidth) {
        this.bandwidth = bandwidth;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "GalleryImage [id = " + id +
                ", animated = " + animated +
                ", title = " + title +
                ", height = " + height +
                ", views = " + views +
                ", description = " + description +
                ", link = " + link +
                ", width = " + width +
                ", type = " + type +
                ", datetime = " + datetime +
                ", bandwidth = " + bandwidth +
                ", size = " + size +
                "]";
    }
}
