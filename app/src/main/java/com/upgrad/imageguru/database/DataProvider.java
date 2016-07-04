package com.upgrad.imageguru.database;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by Rachit on 30-Mar-16.
 */
public class DataProvider extends ContentProvider {

    private static final UriMatcher sUriMatcher = buildUriMatcher();
    private DbHelper mOpenHelper;

    static final int USERS = 100;

    private static final SQLiteQueryBuilder sUsersQueryBuilder;

    static {
        sUsersQueryBuilder = new SQLiteQueryBuilder();
        sUsersQueryBuilder.setTables(DataContract.TagItemEntry.TABLE_NAME);
    }

    static UriMatcher buildUriMatcher() {
        UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        matcher.addURI(DataContract.CONTENT_AUTHORITY, DataContract.PATH_USERS, USERS);
        return matcher;
    }

    @Override
    public boolean onCreate() {
        mOpenHelper = new DbHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor retCursor;
        switch (sUriMatcher.match(uri)) {
            case USERS:
                retCursor = mOpenHelper.getReadableDatabase().query(
                        DataContract.TagItemEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);

        }
        retCursor.setNotificationUri(getContext().getContentResolver(), uri);
        return retCursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        final int match = sUriMatcher.match(uri);

        switch (match) {
            case USERS:
                return DataContract.TagItemEntry.CONTENT_TYPE;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        int match = sUriMatcher.match(uri);
        Uri returnUri;

        switch (match) {
            case USERS:
                long _id = db.insert(DataContract.TagItemEntry.TABLE_NAME, null, values);
                if (_id > 0)
                    returnUri = DataContract.TagItemEntry.buildUserUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return returnUri;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        final SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);
        int rowsDeleted;
        // if selection == null, it deletes all rows
        if (null == selection) selection = "1";
        switch (match) {
            case USERS:
                rowsDeleted = db.delete(
                        DataContract.TagItemEntry.TABLE_NAME, selection, selectionArgs);
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        if (rowsDeleted != 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return rowsDeleted;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        final SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);
        int rowsUpdated;

        switch (match) {
            case USERS:
                rowsUpdated = db.update(DataContract.TagItemEntry.TABLE_NAME, values, selection,
                        selectionArgs);
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        if (rowsUpdated != 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return rowsUpdated;
    }

    @Override
    public int bulkInsert(Uri uri, ContentValues[] values) {

        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        int match = sUriMatcher.match(uri);

        switch (match) {
            case USERS:
                db.beginTransaction();
                int returnCount = 0;
                try {
                    for (ContentValues value : values) {
                        long _id = db.insert(DataContract.TagItemEntry.TABLE_NAME, null, value);
                        if (_id != -1) {
                            returnCount++;
                        } else {
                            DataContract.TagItemEntry.buildUserUri(_id);
                        }
                    }
                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }
                getContext().getContentResolver().notifyChange(uri, null);
                return returnCount;
            default:
                return super.bulkInsert(uri, values);
        }
    }
}
