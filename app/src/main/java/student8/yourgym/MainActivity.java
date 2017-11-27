package student8.yourgym;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity /*implements View.OnClickListener*/ {

    Button btnJ, btnP, btnT;
    TextView tvJ, tvP, tvT;
    EditText etJ, etP, etT;

    DBH dbh;
    SQLiteDatabase db;

    public static final String MJ = "myJym";
    public static final String MJC = "counter";
    public static final String MP = "myPrised";
    public static final String MPC = "counter";
    public static final String MT = "myTyaga";
    public static final String MTC = "counter";

    private SharedPreferences mSetJ, mSetP, mSetT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        names();

        btnJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double a = Double.parseDouble(etJ.getText().toString());
                SharedPreferences.Editor editor = mSetJ.edit();
                editor.putFloat(MJC, (float)a);
                editor.apply();
            }
        });
        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double a = Double.parseDouble(etP.getText().toString());
                SharedPreferences.Editor editor = mSetP.edit();
                editor.putFloat(MPC, (float)a);
                editor.apply();
            }
        });
        btnT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double a = Double.parseDouble(etT.getText().toString());
                SharedPreferences.Editor editor = mSetT.edit();
                editor.putFloat(MTC, (float)a);
                editor.apply();
            }
        });
    }

    public void names() {
        dbh = new DBH(this, dbh.DATABASE_NAME, null, dbh.DATABASE_VERSION);
        db = dbh.getWritableDatabase();

        mSetJ = getSharedPreferences(MJ, Context.MODE_PRIVATE);
        mSetP = getSharedPreferences(MP, Context.MODE_PRIVATE);
        mSetT = getSharedPreferences(MT, Context.MODE_PRIVATE);

        btnJ = findViewById(R.id.button);
        btnP = findViewById(R.id.button2);
        btnT = findViewById(R.id.button3);

        tvJ = findViewById(R.id.textView);
        tvP = findViewById(R.id.textView2);
        tvT = findViewById(R.id.textView3);

        etJ = findViewById(R.id.editText);
        etP = findViewById(R.id.editText2);
        etT = findViewById(R.id.editText3);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Запоминаем данные
        SharedPreferences.Editor editorJ = mSetJ.edit();
        editorJ.putFloat(MJC, (float) Double.parseDouble(etJ.getText().toString()));
        editorJ.apply();
        SharedPreferences.Editor editorP = mSetP.edit();
        editorP.putFloat(MPC, (float) Double.parseDouble(etP.getText().toString()));
        editorP.apply();
        SharedPreferences.Editor editorT = mSetT.edit();
        editorT.putFloat(MTC, (float) Double.parseDouble(etT.getText().toString()));
        editorT.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mSetJ.contains(MJC))
            etJ.setText(mSetJ.getFloat(MJC, 0)+"");
        if (mSetP.contains(MPC))
            etP.setText(mSetP.getFloat(MPC, 0)+"");
        if (mSetT.contains(MTC))
            etT.setText(mSetT.getFloat(MTC, 0)+"");
    }
}