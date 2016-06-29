package com.upgrad.imageguru.model;

public class Data {
    private String comment_count;

    private String account_id;

    private String vote;

    private String link;

    private String score;

    private String privacy;

    private String id;

    private String title;

    private String cover;

    private String description;

    private String views;

    private String layout;

    private Images[] images;

    private String downs;

    private String is_album;

    private String points;

    private String datetime;

    private String account_url;

    private String ups;

    private String images_count;

    public String getComment_count() {
        return comment_count;
    }

    public void setComment_count(String comment_count) {
        this.comment_count = comment_count;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
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

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public Images[] getImages() {
        return images;
    }

    public void setImages(Images[] images) {
        this.images = images;
    }

    public String getDowns() {
        return downs;
    }

    public void setDowns(String downs) {
        this.downs = downs;
    }

    public String getIs_album() {
        return is_album;
    }

    public void setIs_album(String is_album) {
        this.is_album = is_album;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getAccount_url() {
        return account_url;
    }

    public void setAccount_url(String account_url) {
        this.account_url = account_url;
    }

    public String getUps() {
        return ups;
    }

    public void setUps(String ups) {
        this.ups = ups;
    }

    public String getImages_count() {
        return images_count;
    }

    public void setImages_count(String images_count) {
        this.images_count = images_count;
    }

    @Override
    public String toString() {
        return "Data [comment_count = " + comment_count +
                ", account_id = " + account_id +
                ", vote = " + vote +
                ", link = " + link +
                ", score = " + score +
                ", privacy = " + privacy +
                ", id = " + id +
                ", title = " + title +
                ", cover = " + cover +
                ", description = " + description +
                ", views = " + views +
                ", layout = " + layout +
                ", images = " + images.toString() +
                ", downs = " + downs +
                ", is_album = " + is_album +
                ", points = " + points +
                ", datetime = " + datetime +
                ", account_url = " + account_url +
                ", ups = " + ups +
                ", images_count = " + images_count +
                "]";
    }
}

