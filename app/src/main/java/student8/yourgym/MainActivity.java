package student8.yourgym;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button btnJ, btnP, btnT;
    EditText etJ, etP, etT;

    public static final String MK = "myGym";
    public static final String MJ = "jym";
    public static final String MP = "prised";
    public static final String MT = "tyaga";

    private SharedPreferences mSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        names();

        btnJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double a = Double.parseDouble(etJ.getText().toString());
                SharedPreferences.Editor editor = mSet.edit();
                editor.putFloat(MJ, (float)a);
                editor.apply();
                Toast toast = Toast.makeText(getApplicationContext(),"Ваш макс. жим сохранен", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double a = Double.parseDouble(etP.getText().toString());
                SharedPreferences.Editor editor = mSet.edit();
                editor.putFloat(MP, (float)a);
                editor.apply();
                Toast toast = Toast.makeText(getApplicationContext(),"Ваш макс. присед сохранен", Toast.LENGTH_SHORT);
                toast.show();
                Intent i = new Intent(MainActivity.this, PrisedActivity.class);
                startActivity(i);
            }
        });
        btnT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double a = Double.parseDouble(etT.getText().toString());
                SharedPreferences.Editor editor = mSet.edit();
                editor.putFloat(MT, (float)a);
                editor.apply();
                Toast toast = Toast.makeText(getApplicationContext(),"Ваша макс. тяга сохранен", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    public void names() {
        mSet = getSharedPreferences(MK, Context.MODE_PRIVATE);

        btnJ = findViewById(R.id.button);
        btnP = findViewById(R.id.button2);
        btnT = findViewById(R.id.button3);

        etJ = findViewById(R.id.editText);
        etP = findViewById(R.id.editText2);
        etT = findViewById(R.id.editText3);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Запоминаем данные
        SharedPreferences.Editor editorJ = mSet.edit();
        editorJ.putFloat(MJ, (float) Double.parseDouble(etJ.getText().toString()));
        editorJ.apply();
        SharedPreferences.Editor editorP = mSet.edit();
        editorP.putFloat(MP, (float) Double.parseDouble(etP.getText().toString()));
        editorP.apply();
        SharedPreferences.Editor editorT = mSet.edit();
        editorT.putFloat(MT, (float) Double.parseDouble(etT.getText().toString()));
        editorT.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
            etJ.setText(mSet.getFloat(MJ, 0)+"");
            etP.setText(mSet.getFloat(MP, 0)+"");
            etT.setText(mSet.getFloat(MT, 0)+"");
    }
}