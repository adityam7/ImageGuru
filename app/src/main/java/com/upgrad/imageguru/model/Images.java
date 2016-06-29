package com.upgrad.imageguru.model;

public class Images {
    private String id;

    private String animated;

    private String title;

    private String height;

    private String views;

    private String description;

    private String link;

    private String width;

    private String type;

    private String datetime;

    private String bandwidth;

    private String size;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAnimated() {
        return animated;
    }

    public void setAnimated(String animated) {
        this.animated = animated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
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

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(String bandwidth) {
        this.bandwidth = bandwidth;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Images [id = " + id +
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
