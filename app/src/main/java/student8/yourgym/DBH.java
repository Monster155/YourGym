package student8.yourgym;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBH extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "GYM";
    public static final String TABLE_NAME = "GYM";

    public static final int DATABASE_VERSION = 1;

    public static final String JYM = "JYM";
    public static final String PRISED = "PRISED";
    public static final String TYAGA = "TYAGA";

    public DBH(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBH(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " ( " + JYM + " DOUBLE, " + PRISED + " DOUBLE, " + TYAGA + " DOUBLE);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_NAME);
        onCreate(db);
    }
}
