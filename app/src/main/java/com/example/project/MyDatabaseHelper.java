package com.example.project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    public static final String DATABASE_NAME = "petshop.db";
    public static final int DATABASE_VERSION = 1;

    // tao ten bang, cot va gan ten vao bang va cac cot
    public static final String TABLE_USERS = "users";
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_USER_NAME = "user_name";
    public static final String COLUMN_USER_PASSWORD = "user_password";
    public static final String COLUMN_USER_PHONE = "user_phone";
    public static final String COLUMN_USER_ADDRESS = "user_address";
    public static final String COLUMN_USER_DATE_CREATE = "user_date_create";

    public static final String TABLE_PETS = "pets";
    public static final String COLUMN_PETS_NAME = "pet_name";
    public static final String COLUMN_PETS_DESCRIPTION = "pet_description";
    public static final String COLUMN_PETS_CATEGOGY_ID = "pet_category_id";
    public static final String COLUMN_PETS_IMG = "pet_img";
    public static final String COLUMN_PETS_USER_ID = "user_id";
    public static final String COLUMN_PETS_DATE = "pet_date";
    public static final String COLUMN_PETS_STATUS = "pet_status";
    public static final String COLUMN_PETS_SERVICE_DETAIL = "pet_service_deltail";
    public static final String COLUMN_PETS_SERVICE_FEE = "pet_service_fee";
    public static final String COLUMN_PETS_SERVICE_DATE = "pet_service_date";
    public static final String COLUMN_PETS_ID = "pet_id";
    public static final String COLUMN_PETS_COUNT = "pet_count";

    public static final String TABLE_PET_CATEGOGY = "pet_category";
    public static final String COLUMN_PET_CATEGORY_ID = "pet_category_id";
    public static final String COLUMN_PET_CATEGORY_NAME = "pet_category_name";
    public static final String COLUMN_PET_CATEGORY_DATE_CHANGE = "pet_category_date_change";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
