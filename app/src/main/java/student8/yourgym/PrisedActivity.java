package student8.yourgym;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TextView;

public class PrisedActivity extends Activity {

    TextView tvName, tvInfo, tv[][][] = new TextView[12][8][3];
    int temp, numOfLes = 96;
    String tt[];
    public static final String MK = "myGym";
    public static final String MP = "prised";
    private SharedPreferences mSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prised);
        names();
        tvInfo.setText(tvInfo.getText() + (mSet.getFloat(MP, 0) + " кг жмет"));
    }

    void names(){
        tvName = findViewById(R.id.textViewName);
        tvInfo = findViewById(R.id.textViewInfo);
        mSet = getSharedPreferences(MK, Context.MODE_PRIVATE);

        tt = new String[numOfLes];
        for(int i = 0; i < numOfLes; i++)
            tt[i] = i + "";
        numOfLes = 0;
        for(int k = 0; k < 12; k++)
            for(int i = 0; i < 8; i++)
                for(int j = 0; j < 3; j++){
                    temp = getResources().getIdentifier(tt[numOfLes], "id", getPackageName());
                    numOfLes++;
                    tv[k][i][j] = findViewById(temp);
                }
    }
}
