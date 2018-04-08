package hk.ust.cse.comp107x.reboot;
        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.SQLException;
        import android.database.sqlite.SQLiteDatabase;

 class Adapter {
    private static final String DATABASE_NAME = "login.db";
    private static final int DATABASE_VERSION = 1;
    static final String DATABASE_CREATE = "create table " + "LOGIN" + "( "
            + "ID" + " integer primary key autoincrement,"
            + "USERNAME  text,PASSWORD text); ";
    private SQLiteDatabase db;
    private final Context context;
    private Helper dbHelper;

     Adapter(Context _context) {
        context = _context;
        dbHelper = new Helper(context, DATABASE_NAME, null,
                DATABASE_VERSION);
    }

     Adapter open() throws SQLException {
        db = dbHelper.getWritableDatabase();
        return this;
    }

     void close() {
        db.close();
    }
    void insertEntry(String userName, String password) {
        ContentValues newValues = new ContentValues();
        newValues.put("USERNAME", userName);
        newValues.put("PASSWORD", password);
        db.insert("LOGIN", null, newValues);

    }

   String getSinlgeEntry(String userName) {
        Cursor cursor = db.query("LOGIN", null, " USERNAME=?", new String[] { userName }, null, null, null);
        if (cursor.getCount() < 1) {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }

}