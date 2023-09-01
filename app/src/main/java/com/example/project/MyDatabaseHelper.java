package com.example.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.project.user.User;

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
    public static final String COLUMN_USER_EMAIL = "user_email";

    public static final String TABLE_PETS = "pets";
    public static final String COLUMN_PETS_NAME = "pet_name";
    public static final String COLUMN_PETS_DESCRIPTION = "pet_description";
    public static final String COLUMN_PETS_CATEGORY_ID = "pet_category_id";
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
    public static final String COLUMN_PET_CATEGORY_DATE_ADD = "pet_category_date_add";

    public static final String TABLE_ORDERS = "orders";
    public static final String COLUMN_ORDERS_ID = "order_id";
    public static final String COLUMN_ORDERS_DATE = "order_date";
    public static final String COLUMN_ORDERS_TOTAL = "order_total";
    public static final String COLUMN_ORDERS_NUMBER_OF_ITEM = "order_number_of_item";
    public static final String COLUMN_ORDERS_USER_ID = "user_id";
    public static final String COLUMN_ORDERS_STATUS = "order_status";
    public static final String COLUMN_ORDERS_PET_PROD_ID = "pet_prod_id";
    public static final String COLUMN_ORDERS_COUNT = "order_count";

    public static final String TABLE_PET_PRODUCT = "pet_product";
    public static final String COLUMN_PET_PROD_ID = "pet_prod_id";
    public static final String COLUMN_PET_PROD_NAME = "pet_prod_name";
    public static final String COLUMN_PET_PROD_DETAIL = "pet_prod_detail";
    public static final String COLUMN_PET_PROD_PRICE = "pet_prod_price";
    public static final String COLUMN_PET_PROD_ORIGIN = "pet_prod_origin";
    public static final String COLUMN_PET_PROD_IMAGE = "pet_prod_image";
    public static final String COLUMN_PET_PROD_QUANTITY = "pet_prod_quantity";
    public static final String COLUMN_PET_PROD_COUNT = "pet_prod_count";
    public static final String COLUMN_PET_PROD_DATE_ADD = "pet_prod_date_add";
    public static final String COLUMN_PET_PROD_DATE_CHANGE = "pet_prod_date_change";
    public static final String COLUMN_PET_PROD_CATEGOGY_ID = "pet_category_id";

    public static final String TABLE_ADMIN = "admin";
    public static final String COLUMN_ADMIN_NAME = "admin_name";
    public static final String COLUMN_ADMIN_PASSWORD = "admin_password";
    public static final String COLUMN_ADMIN_COUNT= "admin_count";
    public static final String COLUMN_ADMIN_DATE_CHANGE = "admin_date_change";

    public static final String TABLE_CONTACT = "contacts";
    public static final String COLUMN_CONTACT_COUNT = "contact_count";
    public static final String COLUMN_CONTACT_MESS = "contact_mess";
    public static final String COLUMN_CONTACT_NAME= "contact_name";
    public static final String COLUMN_CONTACT_EMAIL = "contact_email";
    public static final String COLUMN_CONTACT_DATE_SEND = "contact_date_send";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //tao bang users
        db.execSQL("CREATE TABLE " + TABLE_USERS + "("
                + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_USER_NAME + " TEXT,"
                + COLUMN_USER_PASSWORD + " TEXT,"
                + COLUMN_USER_PHONE + " TEXT,"
                + COLUMN_USER_ADDRESS + " TEXT,"
                + COLUMN_USER_DATE_CREATE + " DATETIME, "
                + COLUMN_USER_EMAIL + " TEXT "
                + ")");

        //tao bang pet_categogy
        db.execSQL("CREATE TABLE " + TABLE_PET_CATEGOGY + "("
                + COLUMN_PET_CATEGORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_PET_CATEGORY_NAME + " TEXT,"
                + COLUMN_PET_CATEGORY_DATE_ADD + " DATETIME"
                + ")");

        //tao bang pets
        db.execSQL("CREATE TABLE " + TABLE_PETS + "("
                + COLUMN_PETS_COUNT + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_PETS_ID + " TEXT UNIQUE,"
                + COLUMN_PETS_NAME + " TEXT,"
                + COLUMN_PETS_DESCRIPTION + " TEXT,"
                + COLUMN_PETS_CATEGORY_ID + " INTEGER,"
                + COLUMN_PETS_IMG + " TEXT,"
                + COLUMN_PETS_USER_ID + " INTEGER,"
                + COLUMN_PETS_DATE + " DATETIME,"
                + COLUMN_PETS_STATUS + " INTEGER DEFAULT 0,"
                + COLUMN_PETS_SERVICE_FEE + " REAL,"
                + COLUMN_PETS_SERVICE_DETAIL + " TEXT,"
                + COLUMN_PETS_SERVICE_DATE + " DATETIME, "
                + "FOREIGN KEY(" + COLUMN_PETS_USER_ID + ") REFERENCES " + TABLE_USERS + "(" + COLUMN_USER_ID + "), "
                + "FOREIGN KEY(" + COLUMN_PETS_CATEGORY_ID + ") REFERENCES " + TABLE_PET_CATEGOGY + "(" + COLUMN_PET_CATEGORY_ID + ")"
                + ")");

        //tao bang pet_product
        db.execSQL("CREATE TABLE " + TABLE_PET_PRODUCT + "("
                + COLUMN_PET_PROD_COUNT + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_PET_PROD_ID + " TEXT UNIQUE,"
                + COLUMN_PET_PROD_NAME + " TEXT,"
                + COLUMN_PET_PROD_DETAIL + " TEXT,"
                + COLUMN_PET_PROD_PRICE + " REAL,"
                + COLUMN_PET_PROD_ORIGIN + " TEXT,"
                + COLUMN_PET_PROD_IMAGE + " INTEGER,"
                + COLUMN_PET_PROD_QUANTITY + " INTEGER,"
                + COLUMN_PET_PROD_DATE_ADD + " DATETIME,"
                + COLUMN_PET_PROD_DATE_CHANGE + " DATETIME,"
                + COLUMN_PET_PROD_CATEGOGY_ID + " INTERGER, "
                + "FOREIGN KEY(" + COLUMN_PET_PROD_CATEGOGY_ID + ") REFERENCES " + TABLE_PET_CATEGOGY + "(" + COLUMN_PET_CATEGORY_ID + ")"
                + ")");

        // tao bang orders
        db.execSQL("CREATE TABLE " + TABLE_ORDERS + "("
                + COLUMN_ORDERS_COUNT + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_ORDERS_ID + " TEXT UNIQUE,"
                + COLUMN_ORDERS_DATE + " DATETIME,"
                + COLUMN_ORDERS_TOTAL + " REAL,"
                + COLUMN_ORDERS_NUMBER_OF_ITEM + " INTEGER,"
                + COLUMN_ORDERS_USER_ID + " INTEGER,"
                + COLUMN_ORDERS_STATUS + " INTEGER DEFAULT 0,"
                + COLUMN_ORDERS_PET_PROD_ID + " TEXT,"
                + "FOREIGN KEY(" + COLUMN_ORDERS_USER_ID + ") REFERENCES " + TABLE_USERS + "(" + COLUMN_USER_ID + "), "
                + "FOREIGN KEY(" + COLUMN_ORDERS_PET_PROD_ID + ") REFERENCES " + TABLE_PET_PRODUCT + "(" + COLUMN_PET_PROD_ID + ")"
                + ")");

        //tao bang admin
        db.execSQL("CREATE TABLE " + TABLE_ADMIN + "("
                + COLUMN_ADMIN_COUNT + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_ADMIN_NAME + " TEXT,"
                + COLUMN_ADMIN_PASSWORD + " TEXT,"
                + COLUMN_ADMIN_DATE_CHANGE + " DATETIME"
                + ")");

        //tao bang contact
        db.execSQL("CREATE TABLE " + TABLE_CONTACT + "("
                + COLUMN_CONTACT_COUNT + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_CONTACT_NAME + " TEXT,"
                + COLUMN_CONTACT_EMAIL + " TEXT,"
                + COLUMN_CONTACT_MESS + " TEXT,"
                + COLUMN_CONTACT_DATE_SEND + " DATETIME"
                + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public long insertUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("COLUMN_USER_NAME", user.getFirstname() + user.getLastname());
        values.put("COLUMN_USER_PASSWORD", user.getConfpassword());
        values.put("COLUMN_USER_PHONE", user.getContactno());
        values.put("COLUMN_USER_EMAIL", user.getEmail());

        // Thực hiện chèn dữ liệu và trả về kết quả (row ID)
        long result = db.insert("users", null, values);
        db.close();

        return result;

    }
}
