package com.upgrad.imageguru.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Class for Database Helper
 * Created by Rachit on 20-07-2015.
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "image_guru";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String CREATE_LOGIN_TABLE_QUERY = "CREATE TABLE " + DataContract.TagItemEntry.TABLE_NAME + " ( " +
                DataContract.TagItemEntry.COLUMN_TAG_ITEMS_LINK + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DataContract.TagItemEntry.COLUMN_TAG_ITEMS_IN_GALLERY + " VARCHAR NOT NULL, " +
                DataContract.TagItemEntry.COLUMN_TAG_ITEMS_SCORE + " VARCHAR, " +
                DataContract.TagItemEntry.COLUMN_TAG_ITEMS_ID + " VARCHAR, " +
                DataContract.TagItemEntry.COLUMN_TAG_ITEMS_COVER + " INTEGER, " +
                DataContract.TagItemEntry.COLUMN_TAG_ITEMS_TITLE + " VARCHAR, " +
                DataContract.TagItemEntry.COLUMN_TAG_ITEMS_DESCRIPTION + " VARCHAR " +
                DataContract.TagItemEntry.COLUMN_TAG_ITEMS_LAYOUT + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DataContract.TagItemEntry.COLUMN_TAG_ITEMS_ANIMATED + " VARCHAR NOT NULL, " +
                DataContract.TagItemEntry.COLUMN_TAG_ITEMS_COVER_HEIGHT + " VARCHAR, " +
                DataContract.TagItemEntry.COLUMN_TAG_ITEMS_POINTS + " VARCHAR, " +
                DataContract.TagItemEntry.COLUMN_TAG_ITEMS_TOPIC_ID + " INTEGER, " +
                DataContract.TagItemEntry.COLUMN_TAG_ITEMS_ACCOUNT_URL + " VARCHAR, " +
                DataContract.TagItemEntry.COLUMN_TAG_ITEMS_COVER_WIDTH + " VARCHAR " +
                DataContract.TagItemEntry.COLUMN_TAG_ITEMS_DATETIME + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DataContract.TagItemEntry.COLUMN_TAG_ITEMS_COMMENT_COUNT + " VARCHAR NOT NULL, " +
                DataContract.TagItemEntry.COLUMN_TAG_ITEMS_TOPIC + " VARCHAR, " +
                DataContract.TagItemEntry.COLUMN_TAG_ITEMS_ACCOUNT_ID + " VARCHAR, " +
                DataContract.TagItemEntry.COLUMN_TAG_ITEMS_VOTE + " INTEGER, " +
                DataContract.TagItemEntry.COLUMN_TAG_ITEMS_PRIVACY + " VARCHAR, " +
                DataContract.TagItemEntry.COLUMN_TAG_ITEMS_FAVORITE + " VARCHAR " +
                DataContract.TagItemEntry.COLUMN_TAG_ITEMS_SECTION + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DataContract.TagItemEntry.COLUMN_TAG_ITEMS_NSFW + " VARCHAR NOT NULL, " +
                DataContract.TagItemEntry.COLUMN_TAG_ITEMS_VIEWS + " VARCHAR, " +
                DataContract.TagItemEntry.COLUMN_TAG_ITEMS_DOWNS + " VARCHAR, " +
                DataContract.TagItemEntry.COLUMN_TAG_ITEMS_IS_ALBUM + " INTEGER, " +
                DataContract.TagItemEntry.COLUMN_TAG_ITEMS_UPS + " VARCHAR, " +
                DataContract.TagItemEntry.COLUMN_TAG_ITEMS_IMAGES_COUNT + " VARCHAR " +
                " )";
        db.execSQL(CREATE_LOGIN_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DataContract.TagItemEntry.TABLE_NAME);
        onCreate(db);
    }
}