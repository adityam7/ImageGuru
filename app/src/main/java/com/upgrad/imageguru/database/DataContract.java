package com.upgrad.imageguru.database;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Defining the Contract between Database and application
 * Created by Rachit on 30-Mar-16.
 */
public class DataContract {

    public static final String CONTENT_AUTHORITY = "com.upgrad.imageguru";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_TAG_ITEM = "tag_item";

    public static final class TagItemEntry implements BaseColumns {

        public static final String TABLE_NAME = "TAG_ITEMS";

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

        public static final String COLUMN_TAG_ITEMS_LINK = "TAG_ITEMS_LINK";
        public static final String COLUMN_TAG_ITEMS_IN_GALLERY = "TAG_ITEMS_IN_GALLERY";
        public static final String COLUMN_TAG_ITEMS_SCORE = "TAG_ITEMS_SCORE";
        public static final String COLUMN_TAG_ITEMS_ID = "TAG_ITEMS_ID";
        public static final String COLUMN_TAG_ITEMS_COVER = "TAG_ITEMS_COVER";
        public static final String COLUMN_TAG_ITEMS_TITLE = "TAG_ITEMS_TITLE";
        public static final String COLUMN_TAG_ITEMS_DESCRIPTION = "TAG_ITEMS_DESCRIPTION";
        public static final String COLUMN_TAG_ITEMS_LAYOUT = "TAG_ITEMS_LAYOUT";
        public static final String COLUMN_TAG_ITEMS_ANIMATED = "TAG_ITEMS_ANIMATED";
        public static final String COLUMN_TAG_ITEMS_COVER_HEIGHT = "TAG_ITEMS_COVER_HEIGHT";
        public static final String COLUMN_TAG_ITEMS_POINTS = "TAG_ITEMS_POINTS";
        public static final String COLUMN_TAG_ITEMS_TOPIC_ID = "TAG_ITEMS_TOPIC_ID";
        public static final String COLUMN_TAG_ITEMS_ACCOUNT_URL = "TAG_ITEMS_ACCOUNT_URL";
        public static final String COLUMN_TAG_ITEMS_COVER_WIDTH = "TAG_ITEMS_COVER_WIDTH";
        public static final String COLUMN_TAG_ITEMS_DATETIME = "TAG_ITEMS_DATETIME";
        public static final String COLUMN_TAG_ITEMS_COMMENT_COUNT = "TAG_ITEMS_COMMENT_COUNT";
        public static final String COLUMN_TAG_ITEMS_TOPIC = "TAG_ITEMS_TOPIC";
        public static final String COLUMN_TAG_ITEMS_ACCOUNT_ID = "TAG_ITEMS_ACCOUNT_ID";
        public static final String COLUMN_TAG_ITEMS_VOTE = "TAG_ITEMS_VOTE";
        public static final String COLUMN_TAG_ITEMS_PRIVACY = "TAG_ITEMS_PRIVACY";
        public static final String COLUMN_TAG_ITEMS_FAVORITE = "TAG_ITEMS_FAVORITE";
        public static final String COLUMN_TAG_ITEMS_SECTION = "TAG_ITEMS_SECTION";
        public static final String COLUMN_TAG_ITEMS_NSFW = "TAG_ITEMS_NSFW";
        public static final String COLUMN_TAG_ITEMS_VIEWS = "TAG_ITEMS_VIEWS";
        public static final String COLUMN_TAG_ITEMS_DOWNS = "TAG_ITEMS_DOWNS";
        public static final String COLUMN_TAG_ITEMS_IS_ALBUM = "TAG_ITEMS_IS_ALBUM";
        public static final String COLUMN_TAG_ITEMS_UPS = "TAG_ITEMS_UPS";
        public static final String COLUMN_TAG_ITEMS_IMAGES_COUNT = "TAG_ITEMS_IMAGES_COUNT";

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_TAG_ITEM).build();

        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TAG_ITEM;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TAG_ITEM;

        public static Uri buildUserUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static Uri buildUriFromId(int id) {
            return CONTENT_URI.buildUpon().appendPath(String.valueOf(id)).build();
        }

        public static String getIdFromUri(Uri uri) {
            return uri.getPathSegments().get(1);
        }

    }
}
