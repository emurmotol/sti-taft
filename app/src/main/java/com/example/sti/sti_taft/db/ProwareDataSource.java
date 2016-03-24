package com.example.sti.sti_taft.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by STI on 1/29/2016.
 */
public class ProwareDataSource {

    private static final String LOGTAG = "PROWARESPU";

    SQLiteOpenHelper dbHelper;
    SQLiteDatabase database;

    public ProwareDataSource(Context context) {
        dbHelper = new ProwareDBHelper(context);
    }

    public void open() {
        database = dbHelper.getReadableDatabase();
        Log.i(LOGTAG, "DATABASE opened.");

        Cursor cursor = database.query(ProwareDBHelper.TABLE_PRODUCTS, allProducts, null, null, null, null, null);
        Log.i(LOGTAG, "Returned " + cursor.getCount() + " rows.");
        if (cursor.getCount() == 0)
        {
            addProduct();
            cursor = database.query(ProwareDBHelper.TABLE_PRODUCTS, allProducts, null, null, null, null, null);
            Log.i(LOGTAG, "Returned " + cursor.getCount() + " rows.");
        }

    }

    public void close() {
        dbHelper.close();
        Log.i(LOGTAG, "DATABASE closed.");
    }

    //CRUD

    //PRODUCT INSERT

    public void addProduct() {
//        ContentValues values = new ContentValues();
//        values.put(ProwareDBHelper.COLUMN_PRODUCT_NAME, product.getProductName());
//        values.put(ProwareDBHelper.COLUMN_PRODUCT_PRICE, product.getProductPrice());
//        values.put(ProwareDBHelper.COLUMN_PRODUCT_IMAGE, product.getProductImage());
//        long insertId = database.insert(ProwareDBHelper.TABLE_PRODUCTS, null, values);
//        return product;
        ContentValues values = new ContentValues();
        values.put(ProwareDBHelper.COLUMN_PRODUCT_NAME, "31st Anniversary Shirt");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_PRICE, "165.00");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_IMAGE, "anniv_tshirt");
        long insertId = database.insert(ProwareDBHelper.TABLE_PRODUCTS, null, values);

        values.put(ProwareDBHelper.COLUMN_PRODUCT_NAME, "32nd Anniversary Shirt");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_PRICE, "165.00");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_IMAGE, "anniv_tshirt2");
        insertId = database.insert(ProwareDBHelper.TABLE_PRODUCTS, null, values);

        values.put(ProwareDBHelper.COLUMN_PRODUCT_NAME, "STI Back Pack(Navy Blue)");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_PRICE, "280.00");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_IMAGE, "backpack");
        insertId = database.insert(ProwareDBHelper.TABLE_PRODUCTS, null, values);

        values.put(ProwareDBHelper.COLUMN_PRODUCT_NAME, "STI Baller ID");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_PRICE, "23.00");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_IMAGE, "baller");
        insertId = database.insert(ProwareDBHelper.TABLE_PRODUCTS, null, values);

        values.put(ProwareDBHelper.COLUMN_PRODUCT_NAME, "STI Button pins");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_PRICE, "20.00");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_IMAGE, "button_pins");
        insertId = database.insert(ProwareDBHelper.TABLE_PRODUCTS, null, values);

        values.put(ProwareDBHelper.COLUMN_PRODUCT_NAME, "STI Dog Tag");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_PRICE, "35.00");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_IMAGE, "dog_tag");
        insertId = database.insert(ProwareDBHelper.TABLE_PRODUCTS, null, values);

        values.put(ProwareDBHelper.COLUMN_PRODUCT_NAME, "30th Anniversary Shirt (Dryfit)");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_PRICE, "165.00");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_IMAGE, "dryfit");
        insertId = database.insert(ProwareDBHelper.TABLE_PRODUCTS, null, values);

        values.put(ProwareDBHelper.COLUMN_PRODUCT_NAME, "STI Eco Bag");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_PRICE, "20.00");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_IMAGE, "ecobag");
        insertId = database.insert(ProwareDBHelper.TABLE_PRODUCTS, null, values);

        values.put(ProwareDBHelper.COLUMN_PRODUCT_NAME, "STI Hoody Jacket (Blue)");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_PRICE, "280.00");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_IMAGE, "hoody_jacket");
        insertId = database.insert(ProwareDBHelper.TABLE_PRODUCTS, null, values);

        values.put(ProwareDBHelper.COLUMN_PRODUCT_NAME, "STI Keychain (Black)");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_PRICE, "20.00");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_IMAGE, "keychain");
        insertId = database.insert(ProwareDBHelper.TABLE_PRODUCTS, null, values);

        values.put(ProwareDBHelper.COLUMN_PRODUCT_NAME, "32nd Limited Edition Shirt");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_PRICE, "170.00");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_IMAGE, "lim_edit");
        insertId = database.insert(ProwareDBHelper.TABLE_PRODUCTS, null, values);

        values.put(ProwareDBHelper.COLUMN_PRODUCT_NAME, "STI Pillow(Blue)");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_PRICE, "60.00");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_IMAGE, "pillow");
        insertId = database.insert(ProwareDBHelper.TABLE_PRODUCTS, null, values);

        values.put(ProwareDBHelper.COLUMN_PRODUCT_NAME, "STI Pouch (Navy Blue)");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_PRICE, "55.00");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_IMAGE, "pouch");
        insertId = database.insert(ProwareDBHelper.TABLE_PRODUCTS, null, values);

        values.put(ProwareDBHelper.COLUMN_PRODUCT_NAME, "STI Set of Pens");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_PRICE, "55.00");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_IMAGE, "set_of_pens");
        insertId = database.insert(ProwareDBHelper.TABLE_PRODUCTS, null, values);

        values.put(ProwareDBHelper.COLUMN_PRODUCT_NAME, "STI Sling Bag");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_PRICE, "100.00");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_IMAGE, "pouch");
        insertId = database.insert(ProwareDBHelper.TABLE_PRODUCTS, null, values);

        values.put(ProwareDBHelper.COLUMN_PRODUCT_NAME, "STI Cap(Black)");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_PRICE, "60.00");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_IMAGE, "sti_cap_black");
        insertId = database.insert(ProwareDBHelper.TABLE_PRODUCTS, null, values);

        values.put(ProwareDBHelper.COLUMN_PRODUCT_NAME, "STI Cellphone Chain(Black)");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_PRICE, "15.00");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_IMAGE, "sti_cellphone_chain");
        insertId = database.insert(ProwareDBHelper.TABLE_PRODUCTS, null, values);

        values.put(ProwareDBHelper.COLUMN_PRODUCT_NAME, "STI Umbrella (Folded)");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_PRICE, "260.00");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_IMAGE, "sti_umbrella_folded");
        insertId = database.insert(ProwareDBHelper.TABLE_PRODUCTS, null, values);

        values.put(ProwareDBHelper.COLUMN_PRODUCT_NAME, "STI Umbrella(21\" Standard)");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_PRICE, "160.00");
        values.put(ProwareDBHelper.COLUMN_PRODUCT_IMAGE, "sti_umbrella_standard");
        insertId = database.insert(ProwareDBHelper.TABLE_PRODUCTS, null, values);

    }

    //PRODUCT SELECT

    private static final String[] allProducts = {
            ProwareDBHelper.COLUMN_PRODUCT_ID,
            ProwareDBHelper.COLUMN_PRODUCT_NAME,
            ProwareDBHelper.COLUMN_PRODUCT_PRICE,
            ProwareDBHelper.COLUMN_PRODUCT_IMAGE};

    public List<Product>findAllProducts() {
        Cursor cursor = database.query(ProwareDBHelper.TABLE_PRODUCTS, allProducts, null, null, null, null, null);
        Log.i(LOGTAG, "Returned " + cursor.getCount() + " rows.");
        List<Product> product = cursorToList(cursor);
        return product;
    }

    public List<User> findUsers(String uname, String password) {
        Cursor cursor = database.query(ProwareDBHelper.TABLE_PRODUCTS, allProducts, "where userName=? and userPassword=?", new String[]{uname,password}, null, null, null);
        Log.i(LOGTAG, "Returned " + cursor.getCount() + " rows.");
        if (cursor.getCount()==1)
        {
            List<User> product = cursorToListUser(cursor);
            return product;
        }
        else {
            return null;
        }
    }

    public boolean findLogIn() {
        Cursor cursor = database.query(ProwareDBHelper.TABLE_PRODUCTS, new String[]{ProwareDBHelper.COLUMN_USER_LOGGED_IN}, "where userLoggedIn=1", null, null, null, null);
        Log.i(LOGTAG, "Returned " + cursor.getCount() + " rows.");
        return true;
    }

    public boolean updateLogIn(long user) {
        ContentValues values = new ContentValues();
        values.put(ProwareDBHelper.COLUMN_USER_ID, user);
        String id=String.valueOf(user);
        long update = database.update(ProwareDBHelper.TABLE_USERS, values, "where " + ProwareDBHelper.COLUMN_USER_ID + "=?", new String[]{id});
        return true;
    }

    //@NonNull
    private List<Product> cursorToList(Cursor cursor) {
        List<Product> products = new ArrayList<Product>();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Product product = new Product();
                product.setProductId(cursor.getLong(cursor.getColumnIndex(ProwareDBHelper.COLUMN_PRODUCT_ID)));
                product.setProductName(cursor.getString(cursor.getColumnIndex(ProwareDBHelper.COLUMN_PRODUCT_NAME)));
                product.setProductPrice(cursor.getDouble(cursor.getColumnIndex(ProwareDBHelper.COLUMN_PRODUCT_PRICE)));
                products.add(product);
            }
        }
        return products;
    }
    private List<User> cursorToListUser(Cursor cursor) {
        List<User> products = new ArrayList<User>();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                User product = new User();
                product.setUserId(cursor.getLong(cursor.getColumnIndex(ProwareDBHelper.COLUMN_USER_ID)));
                products.add(product);
            }
        }
        return products;
    }

    //USER INSERT

    public User addUser(User user) {
        ContentValues values = new ContentValues();
        values.put(ProwareDBHelper.COLUMN_USER_NAME, user.getUserName());
        values.put(ProwareDBHelper.COLUMN_USER_PASSWORD, user.getUserPassword());
        values.put(ProwareDBHelper.COLUMN_USER_FIRST_NAME, user.getUserFirstName());
        values.put(ProwareDBHelper.COLUMN_USER_LAST_NAME, user.getUserLastName());
        values.put(ProwareDBHelper.COLUMN_USER_BIRTH_DAY, user.getUserBirthDay());
        values.put(ProwareDBHelper.COLUMN_USER_STUDENT_NUMBER, user.getUserStudentNumber());
        values.put(ProwareDBHelper.COLUMN_USER_SCHOOL, user.getUserSchool());
        values.put(ProwareDBHelper.COLUMN_USER_LOGGED_IN, user.getUserLoggedIn());
        long insertId = database.insert(ProwareDBHelper.TABLE_USERS, null, values);
        return user;
    }

    //ORDER INSERT

    public Order addOrder(Order order) {
        ContentValues values = new ContentValues();
        values.put(ProwareDBHelper.COLUMN_USER_ID_FK, order.getUserId_FK());
        values.put(ProwareDBHelper.COLUMN_PRODUCT_ID_FK, order.getProductId_FK());
        values.put(ProwareDBHelper.COLUMN_ORDER_QUANTITY, order.getOrderQuantity());
        long insertId = database.insert(ProwareDBHelper.TABLE_ORDERS, null, values);
        return order;
    }

    //ORDER DELETE

    public boolean deleteOrder(Long deleteId) {
        String where = ProwareDBHelper.COLUMN_ORDER_ID + " = " + deleteId;
        int result = database.delete(ProwareDBHelper.TABLE_ORDERS, where, null);
        return (result == 1);
    }

    //CHECKOUT INSERT

    public CheckOut addChekOut(CheckOut checkout) {
        ContentValues values = new ContentValues();
        values.put(ProwareDBHelper.COLUMN_ORDER_ID_FK, checkout.getOrderId_FK());
        values.put(ProwareDBHelper.COLUMN_CHECKOUT_TOTAL_PRICE, checkout.getCheckOutTotalPrice());
        long insertId = database.insert(ProwareDBHelper.TABLE_CHEKOUT, null, values);
        return checkout;
    }

}
