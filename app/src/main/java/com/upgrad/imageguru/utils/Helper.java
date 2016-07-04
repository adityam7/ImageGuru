package com.upgrad.imageguru.utils;

import com.upgrad.imageguru.model.gallery.GalleryImage;
import com.upgrad.imageguru.model.tag.TagItem;

/**
 * Created by rachitgoyal on 6/30/16.
 */
public class Helper {

    public static String generateURL(TagItem item) {
        if (item.is_album()) {
            if (item.isAnimated()) {
                return "http://i.imgur.com/" + item.getCover() + ".gif";
            } else {
                return "http://i.imgur.com/" + item.getCover() + "m.jpg";
            }
        } else {
            if (item.isAnimated()) {
                return "http://i.imgur.com/" + item.getId() + ".gif";
            } else {
                return "http://i.imgur.com/" + item.getId() + "m.jpg";
            }
        }
    }

    public static String generateURL(GalleryImage image) {
        if(image.isAnimated()) {
            return "http://i.imgur.com/" + image.getId() + ".gif";
        } else {
            return "http://i.imgur.com/" + image.getId() + "l.jpg";
        }
    }
}
