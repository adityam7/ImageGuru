package com.upgrad.imageguru.utils;

public class Constants {
    /*
      Logging flag
     */
    public static final boolean LOGGING = false;

    /*
      Imgur client ID's
     */
    public static final String IMGUR_CLIENT_ID = "be8c1993e29cbb9";
    public static final String IMGUR_CLIENT_SECRET = "7621e3b7c163ffcebb659a042644f07b1c4a9820";

    /*
      Redirect URL for android.
     */
    public static final String IMGUR_REDIRECT_URL = "http://android";

    /*
      Client Auth
     */
    public static String getClientAuth() {
        return "Client-ID " + IMGUR_CLIENT_ID;
    }

    /*
      Shared Preferences
     */
    public static final String TAG_PREFS = "my_prefs";
    public static final String TAG_SEARCH = "search_tag";
    public static final String TAG_DEFAULT_SEARCH = "9gag";

    /*
      Intent Extras
     */
    public static final String EXTRA_ITEM = "item_extra";
    public static final String EXTRA_IMAGE = "image_extra";
    public static final String EXTRA_TYPE = "type_extra";
    public static final String EXTRA_GALLERY_TITLE = "gallery_title_extra";
    public static final String TYPE_GALLERY = "gallery";
    public static final String TYPE_TAG = "tag";


    /*
      State Management
     */
    public static final String SAVED_LAYOUT_MANAGER_STATE = "saved_layout_manager_state";

}
