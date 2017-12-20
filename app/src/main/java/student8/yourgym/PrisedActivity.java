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

    TextView tvInfo, tv1[] = new TextView[5], tv2[] = new TextView[6], tv3[] = new TextView[7], tv4[] = new TextView[5];
    public static final String MK = "myGym";
    public static final String MP = "prised";
    private SharedPreferences mSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prised);
        names();
        values();
        tvInfo.setText(tvInfo.getText() + (mSet.getFloat(MP, 0) + " кг"));
    }

    void names(){
        tvInfo = findViewById(R.id.textViewInfo);
        mSet = getSharedPreferences(MK, Context.MODE_PRIVATE);

        tv1[0] = findViewById(R.id.textView1_2_1);
        tv1[1] = findViewById(R.id.textView1_3_1);
        tv1[2] = findViewById(R.id.textView1_4_1);
        tv1[3] = findViewById(R.id.textView1_5_1);
        tv1[4] = findViewById(R.id.textView1_6_1);

        tv2[0] = findViewById(R.id.textView2_2_1);
        tv2[1] = findViewById(R.id.textView2_3_1);
        tv2[2] = findViewById(R.id.textView2_4_1);
        tv2[3] = findViewById(R.id.textView2_5_1);
        tv2[4] = findViewById(R.id.textView2_6_1);
        tv2[5] = findViewById(R.id.textView2_7_1);

        tv3[0] = findViewById(R.id.textView3_2_1);
        tv3[1] = findViewById(R.id.textView3_3_1);
        tv3[2] = findViewById(R.id.textView3_4_1);
        tv3[3] = findViewById(R.id.textView3_5_1);
        tv3[4] = findViewById(R.id.textView3_6_1);
        tv3[5] = findViewById(R.id.textView3_7_1);
        tv3[6] = findViewById(R.id.textView3_8_1);

        tv4[0] = findViewById(R.id.textView4_2_1);
        tv4[1] = findViewById(R.id.textView4_3_1);
        tv4[2] = findViewById(R.id.textView4_4_1);
        tv4[3] = findViewById(R.id.textView4_5_1);
        tv4[4] = findViewById(R.id.textView4_6_1);
    }

    double cycle(double ok){
        int oki = (int)(ok*100);
        int okay = (int)ok/10;
        okay*=10;
        oki %= 1000;
        if(oki < 130)return (int)okay;
        if(oki < 380 && oki >= 130)return okay + 2.5;
        if(oki < 630 && oki >= 380)return okay + 5;
        if(oki < 880 && oki >= 630)return okay + 7.5;
        if(oki >= 880)return okay + 10;
        return ok;
    }

    void values(){
        tv1[0].setText(cycle(mSet.getFloat(MP, 0)*0.3) + "");
        tv1[1].setText(cycle(mSet.getFloat(MP, 0)*0.42) + "");
        tv1[2].setText(cycle(mSet.getFloat(MP, 0)*0.56) + "");
        tv1[3].setText(cycle(mSet.getFloat(MP, 0)*0.6) + "");
        tv1[4].setText(cycle(mSet.getFloat(MP, 0)*0.64) + "");

        tv2[0].setText(cycle(mSet.getFloat(MP, 0)*0.3) + "");
        tv2[1].setText(cycle(mSet.getFloat(MP, 0)*0.42) + "");
        tv2[2].setText(cycle(mSet.getFloat(MP, 0)*0.56) + "");
        tv2[3].setText(cycle(mSet.getFloat(MP, 0)*0.64) + "");
        tv2[4].setText(cycle(mSet.getFloat(MP, 0)*0.72) + "");
        tv2[5].setText(cycle(mSet.getFloat(MP, 0)*0.76) + "");

        tv3[0].setText(cycle(mSet.getFloat(MP, 0)*0.3) + "");
        tv3[1].setText(cycle(mSet.getFloat(MP, 0)*0.54) + "");
        tv3[2].setText(cycle(mSet.getFloat(MP, 0)*0.68) + "");
        tv3[3].setText(cycle(mSet.getFloat(MP, 0)*0.76) + "");
        tv3[4].setText(cycle(mSet.getFloat(MP, 0)*0.84) + "");
        tv3[5].setText(cycle(mSet.getFloat(MP, 0)*0.92) + "");
        tv3[6].setText(cycle(mSet.getFloat(MP, 0)*0.72) + "");

        tv4[0].setText(cycle(mSet.getFloat(MP, 0)*0.3) + "");
        tv4[1].setText(cycle(mSet.getFloat(MP, 0)*0.46) + "");
        tv4[2].setText(cycle(mSet.getFloat(MP, 0)*0.6) + "");
        tv4[3].setText(cycle(mSet.getFloat(MP, 0)*0.64) + "");
        tv4[4].setText(cycle(mSet.getFloat(MP, 0)*0.68) + "");
    }
}
