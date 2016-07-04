package com.upgrad.imageguru.model.tag;

import java.io.Serializable;

/**
 * Created by rachitgoyal on 6/29/16.
 */
public class TagItem implements Serializable {
    private String link;
    private boolean in_gallery;
    private int score;
    private String id;
    private String cover;
    private String title;
    private String description;
    private String layout;
    private boolean animated;
    private int cover_height;
    private int points;
    private int topic_id;
    private String account_url;
    private int cover_width;
    private long datetime;
    private int comment_count;
    private String topic;
    private String account_id;
    private int vote;
    private String privacy;
    private boolean favorite;
    private String section;
    private boolean nsfw;
    private int views;
    private int downs;
    private boolean is_album;
    private int ups;
    private int images_count;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean isIn_gallery() {
        return in_gallery;
    }

    public void setIn_gallery(boolean in_gallery) {
        this.in_gallery = in_gallery;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
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

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public boolean isAnimated() {
        return animated;
    }

    public void setAnimated(boolean animated) {
        this.animated = animated;
    }

    public int getCover_height() {
        return cover_height;
    }

    public void setCover_height(int cover_height) {
        this.cover_height = cover_height;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }

    public String getAccount_url() {
        return account_url;
    }

    public void setAccount_url(String account_url) {
        this.account_url = account_url;
    }

    public int getCover_width() {
        return cover_width;
    }

    public void setCover_width(int cover_width) {
        this.cover_width = cover_width;
    }

    public long getDatetime() {
        return datetime;
    }

    public void setDatetime(long datetime) {
        this.datetime = datetime;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public boolean isNsfw() {
        return nsfw;
    }

    public void setNsfw(boolean nsfw) {
        this.nsfw = nsfw;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getDowns() {
        return downs;
    }

    public void setDowns(int downs) {
        this.downs = downs;
    }

    public boolean is_album() {
        return is_album;
    }

    public void setIs_album(boolean is_album) {
        this.is_album = is_album;
    }

    public int getUps() {
        return ups;
    }

    public void setUps(int ups) {
        this.ups = ups;
    }

    public int getImages_count() {
        return images_count;
    }

    public void setImages_count(int images_count) {
        this.images_count = images_count;
    }

    @Override
    public String toString() {
        return "ClassPojo [link = " + link +
                ", in_gallery = " + in_gallery +
                ", score = " + score +
                ", id = " + id +
                ", cover = " + cover +
                ", title = " + title +
                ", description = " + description +
                ", layout = " + layout +
                ", cover_height = " + cover_height +
                ", points = " + points +
                ", topic_id = " + topic_id +
                ", account_url = " + account_url +
                ", cover_width = " + cover_width +
                ", datetime = " + datetime +
                ", comment_count = " + comment_count +
                ", topic = " + topic +
                ", account_id = " + account_id +
                ", vote = " + vote +
                ", privacy = " + privacy +
                ", favorite = " + favorite +
                ", section = " + section +
                ", nsfw = " + nsfw +
                ", views = " + views +
                ", downs = " + downs +
                ", is_album = " + is_album +
                ", ups = " + ups +
                ", images_count = " + images_count +
                "]";
    }
}