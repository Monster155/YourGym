package student8.yourgym;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class PrisedActivity extends Activity {

    TextView tvInfo, tv11, tv12, tv13, tv14, tv15, tv21, tv22, tv23, tv24, tv25, tv26, tv31, tv32, tv33, tv34, tv35, tv36, tv37;
    public static final String MK = "myGym";
    public static final String MP = "prised";
    private SharedPreferences mSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prised);
        names();
        values();
        tvInfo.setText(tvInfo.getText() + (mSet.getFloat(MP, 0) + ""));
    }

    void names(){
        tvInfo = findViewById(R.id.textViewInfo);
        mSet = getSharedPreferences(MK, Context.MODE_PRIVATE);

        tv11 = findViewById(R.id.textView1_2_1);
        tv12 = findViewById(R.id.textView1_3_1);
        tv13 = findViewById(R.id.textView1_4_1);
        tv14 = findViewById(R.id.textView1_5_1);
        tv15 = findViewById(R.id.textView1_6_1);

        tv21 = findViewById(R.id.textView2_2_1);
        tv22 = findViewById(R.id.textView2_3_1);
        tv23 = findViewById(R.id.textView2_4_1);
        tv24 = findViewById(R.id.textView2_5_1);
        tv25 = findViewById(R.id.textView2_6_1);
        tv26 = findViewById(R.id.textView2_7_1);

        tv31 = findViewById(R.id.textView3_2_1);
        tv32 = findViewById(R.id.textView3_3_1);
        tv33 = findViewById(R.id.textView3_4_1);
        tv34 = findViewById(R.id.textView3_5_1);
        tv35 = findViewById(R.id.textView3_6_1);
        tv36 = findViewById(R.id.textView3_7_1);
        tv37 = findViewById(R.id.textView3_8_1);
    }

    double cycle(double ok){
        int oki = (int)(ok*100);
        oki %= 100;
        if(oki < 13)return (int)ok;
        if(oki < 38 && oki >= 13)return (int)ok + 0.25;
        if(oki < 63 && oki >= 38)return (int)ok + 0.5;
        if(oki < 88 && oki >= 63)return (int)ok + 0.75;
        if(oki >= 88)return (int)ok + 1;
        return ok;
    }

    void values(){
        tv11.setText(cycle(mSet.getFloat(MP, 0)*0.3) + "");
        tv12.setText(cycle(mSet.getFloat(MP, 0)*0.42) + "");
        tv13.setText(cycle(mSet.getFloat(MP, 0)*0.56) + "");
        tv14.setText(cycle(mSet.getFloat(MP, 0)*0.6) + "");
        tv15.setText(cycle(mSet.getFloat(MP, 0)*0.64) + "");

        tv21.setText(cycle(mSet.getFloat(MP, 0)*0.3) + "");
        tv22.setText(cycle(mSet.getFloat(MP, 0)*0.42) + "");
        tv23.setText(cycle(mSet.getFloat(MP, 0)*0.56) + "");
        tv24.setText(cycle(mSet.getFloat(MP, 0)*0.64) + "");
        tv25.setText(cycle(mSet.getFloat(MP, 0)*0.72) + "");
        tv26.setText(cycle(mSet.getFloat(MP, 0)*0.76) + "");

        tv31.setText(cycle(mSet.getFloat(MP, 0)*0.3) + "");
        tv32.setText(cycle(mSet.getFloat(MP, 0)*0.54) + "");
        tv33.setText(cycle(mSet.getFloat(MP, 0)*0.68) + "");
        tv34.setText(cycle(mSet.getFloat(MP, 0)*0.76) + "");
        tv35.setText(cycle(mSet.getFloat(MP, 0)*0.84) + "");
        tv36.setText(cycle(mSet.getFloat(MP, 0)*0.92) + "");
        tv37.setText(cycle(mSet.getFloat(MP, 0)*0.72) + "");
    }
}
