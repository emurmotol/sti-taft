package com.example.sti.sti_taft.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by STI on 1/29/2016.
 */
public class ProwareDBHelper extends SQLiteOpenHelper {

    private static final String LOGTAG = "PROWARESPU";
    private static final String DATABASE_NAME = "proware.db";
    private static final int DATABASE_VERSION = 1;

    //USERS TABLE
    public static final String TABLE_USERS = "users";
    public static final String COLUMN_USER_ID = "userId";
    public static final String COLUMN_USER_NAME = "userName";
    public static final String COLUMN_USER_PASSWORD = "userPassword";
    public static final String COLUMN_USER_FIRST_NAME = "userFirstName";
    public static final String COLUMN_USER_LAST_NAME = "userLastName";
    public static final String COLUMN_USER_BIRTH_DAY = "userBirthDay";
    public static final String COLUMN_USER_STUDENT_NUMBER = "userStudentNumber";
    public static final String COLUMN_USER_SCHOOL = "userSchool";
    public static final String COLUMN_USER_LOAD = "userLoad";
    public static final String COLUMN_USER_LOGGED_IN = "userLoggedIn";

    private static final String CREATE_TABLE_USERS = "CREATE TABLE " + TABLE_USERS +
            " (" + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_USER_NAME + " TEXT, " +
            COLUMN_USER_PASSWORD + " TEXT, " +
            COLUMN_USER_FIRST_NAME + " TEXT, " +
            COLUMN_USER_LAST_NAME + " TEXT, " +
            COLUMN_USER_BIRTH_DAY + " TEXT, " +
            COLUMN_USER_STUDENT_NUMBER + " TEXT, " +
            COLUMN_USER_SCHOOL + " TEXT, " +
            COLUMN_USER_LOAD + " NUMERIC, " +
            COLUMN_USER_LOGGED_IN + " INTEGER)";

    //PRODUCTS TABLE
    public static final String TABLE_PRODUCTS = "products";
    public static final String COLUMN_PRODUCT_ID = "priductId";
    public static final String COLUMN_PRODUCT_NAME = "productName";
    public static final String COLUMN_PRODUCT_PRICE = "productPrice";
    public static final String COLUMN_PRODUCT_IMAGE = "productImage";

    private static final String CREATE_TABLE_PRODUCTS = "CREATE TABLE " + TABLE_PRODUCTS +
            " (" + COLUMN_PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_PRODUCT_NAME + " TEXT, " +
            COLUMN_PRODUCT_PRICE + " NUMERIC, " +
            COLUMN_PRODUCT_IMAGE + " TEXT)";

    //ORDER TABLE
    public static final String TABLE_ORDERS = "orders";
    public static final String COLUMN_ORDER_ID = "orderId";
    public static final String COLUMN_USER_ID_FK = "userId_FK";
    public static final String COLUMN_PRODUCT_ID_FK = "productId_FK";
    public static final String COLUMN_ORDER_QUANTITY = "orderQuantity";

    private static final String CREATE_TABLE_ORDERS = "CREATE TABLE " + TABLE_ORDERS +
            " (" + COLUMN_ORDER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_USER_ID_FK + " INTEGER, " +
            COLUMN_PRODUCT_ID_FK + " INTEGER, " +
            COLUMN_ORDER_QUANTITY + " INTEGER, " +
            "FOREIGN KEY(" + COLUMN_USER_ID_FK + ") REFERENCES " + TABLE_USERS + "(" + COLUMN_USER_ID + "), " +
            "FOREIGN KEY(" + COLUMN_PRODUCT_ID_FK + ") REFERENCES " + TABLE_PRODUCTS + "(" + COLUMN_PRODUCT_ID + "))";

    //CHECKOUT TABLE
    public static final String TABLE_CHEKOUT = "checkOut";
    public static final String COLUMN_CHECKOUT_ID = "checkOutId";
    public static final String COLUMN_ORDER_ID_FK = "orderId_FK";
    public static final String COLUMN_CHECKOUT_TOTAL_PRICE = "checkOutTotalPrice";

    private static final String CREATE_TABLE_CHECKOUT = "CREATE TABLE " + TABLE_CHEKOUT +
            " (" + COLUMN_CHECKOUT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_ORDER_ID_FK + " INTEGER, " +
            COLUMN_CHECKOUT_TOTAL_PRICE + " NUMERIC, " +
            "FOREIGN KEY(" + COLUMN_ORDER_ID_FK + ") REFERENCES " + TABLE_ORDERS + "(" + COLUMN_ORDER_ID + "))";

    public ProwareDBHelper(Context context) {
        super(context, TABLE_USERS, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CHECKOUT);
        Log.i(LOGTAG, "CREATE_TABLE_CHECKOUT table has been created.");
        db.execSQL(CREATE_TABLE_ORDERS);
        Log.i(LOGTAG, "CREATE_TABLE_ORDERS table has been created.");
        db.execSQL(CREATE_TABLE_PRODUCTS);
        Log.i(LOGTAG, "CREATE_TABLE_PRODUCTS table has been created.");
        db.execSQL(CREATE_TABLE_USERS);
        Log.i(LOGTAG, "CREATE_TABLE_USERS table has been created.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST" + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXIST" + TABLE_ORDERS);
        db.execSQL("DROP TABLE IF EXIST" + TABLE_PRODUCTS);
        db.execSQL("DROP TABLE IF EXIST" + TABLE_CHEKOUT);
        onCreate(db);
    }
}
