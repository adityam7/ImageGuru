package com.upgrad.imageguru.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import com.osahub.rachit.sqliteadvanced.UserBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Parsing data from Local Database to UI
 * Created by Rachit on 30-Mar-16.
 */
public class DataBeanParser {

    private static final String LOG_TAG = "OSAHUB " + DataBeanParser.class.getSimpleName();

    static final int COL_ID = 0;
    static final int COL_NAME = 1;
    static final int COL_PASSWORD = 2;
    static final int COL_MOBILE = 3;
    static final int COL_AGE = 4;
    static final int COL_ADDRESS = 5;
    static final int COL_COLLEGE = 6;

    public static boolean addUser(Context context, UserBean user) {

        Cursor userCursor = context.getContentResolver().query(
                DataContract.TagItemEntry.CONTENT_URI,
                new String[]{DataContract.TagItemEntry.COLUMN_USER_NAME},
                DataContract.TagItemEntry.COLUMN_USER_NAME + " = ?",
                new String[]{user.getName()},
                null);

        if (userCursor != null && userCursor.moveToFirst()) {
            int userNameIndex = userCursor.getColumnIndex(DataContract.TagItemEntry.COLUMN_USER_NAME);
            Toast.makeText(context, "User with name " + userCursor.getString(userNameIndex) + "already exists.", Toast.LENGTH_SHORT).show();
            userCursor.close();
            return false;
        } else {
            ContentValues userValues = new ContentValues();
            userValues.put(DataContract.TagItemEntry.COLUMN_USER_NAME, user.getName());
            userValues.put(DataContract.TagItemEntry.COLUMN_USER_PASSWORD, user.getPass());
            userValues.put(DataContract.TagItemEntry.COLUMN_USER_MOBILE, user.getMobile());
            userValues.put(DataContract.TagItemEntry.COLUMN_USER_AGE, user.getAge());
            userValues.put(DataContract.TagItemEntry.COLUMN_USER_ADDRESS, user.getAddress());
            userValues.put(DataContract.TagItemEntry.COLUMN_USER_COLLEGE, user.getCollege());

            Uri insertedUri = context.getContentResolver().insert(DataContract.TagItemEntry.CONTENT_URI, userValues);
            Log.i(LOG_TAG, "User inserted" + insertedUri);
            return true;
        }
    }

    public static UserBean getUserById(Context context, int id) {
        UserBean user = new UserBean();
        Cursor userCursor = context.getContentResolver().query(DataContract.TagItemEntry.buildUriFromId(id), null,
                DataContract.TagItemEntry.COLUMN_USER_NAME + " = ?", new String[]{user.getName()}, null);

        if (userCursor != null) {
            if (userCursor.moveToFirst()) {
                do {
                    user.setId(userCursor.getInt(COL_ID));
                    user.setName(userCursor.getString(COL_NAME));
                    user.setPass(userCursor.getString(COL_PASSWORD));
                    user.setMobile(userCursor.getString(COL_MOBILE));
                    user.setAge(userCursor.getInt(COL_AGE));
                    user.setAddress(userCursor.getString(COL_ADDRESS));
                    user.setMobile(userCursor.getString(COL_COLLEGE));
                } while (userCursor.moveToNext());
            }
            userCursor.close();
        } else {
            Log.d(LOG_TAG, "Can't find user with id = " + id);
        }
        return user;
    }

    public static List<UserBean> getAllUsers(Context context) {
        List<UserBean> userList = new ArrayList<>();
        Cursor userCursor = context.getContentResolver().query(DataContract.TagItemEntry.CONTENT_URI, null,
                null, null, null);

        if (userCursor != null) {
            if (userCursor.moveToFirst()) {
                do {
                    UserBean user = new UserBean();
                    user.setId(userCursor.getInt(COL_ID));
                    user.setName(userCursor.getString(COL_NAME));
                    user.setPass(userCursor.getString(COL_PASSWORD));
                    user.setMobile(userCursor.getString(COL_MOBILE));
                    user.setAge(userCursor.getInt(COL_AGE));
                    user.setAddress(userCursor.getString(COL_ADDRESS));
                    user.setCollege(userCursor.getString(COL_COLLEGE));
                    userList.add(user);
                } while (userCursor.moveToNext());
            }
            userCursor.close();
        } else {
            Log.d(LOG_TAG, "User List is empty, No records in database");
        }
        return userList;
    }

    public static boolean updateUser(Context context, UserBean oldUser, UserBean newUser) {
        ContentValues updateUserValues = new ContentValues();
        updateUserValues.put(DataContract.TagItemEntry.COLUMN_USER_ID, newUser.getId());
        updateUserValues.put(DataContract.TagItemEntry.COLUMN_USER_NAME, newUser.getName());
        updateUserValues.put(DataContract.TagItemEntry.COLUMN_USER_PASSWORD, newUser.getPass());
        updateUserValues.put(DataContract.TagItemEntry.COLUMN_USER_MOBILE, newUser.getMobile());
        updateUserValues.put(DataContract.TagItemEntry.COLUMN_USER_AGE, newUser.getAge());
        updateUserValues.put(DataContract.TagItemEntry.COLUMN_USER_ADDRESS, newUser.getAddress());
        updateUserValues.put(DataContract.TagItemEntry.COLUMN_USER_COLLEGE, newUser.getCollege());

        int updated = context.getContentResolver().update(DataContract.TagItemEntry.buildUriFromId(oldUser.getId()), updateUserValues,
                DataContract.TagItemEntry.COLUMN_USER_NAME + " = ?", new String[]{oldUser.getName()});

        Log.i(LOG_TAG, "User Updated " + updated);

        return updated != 0;
    }
}
