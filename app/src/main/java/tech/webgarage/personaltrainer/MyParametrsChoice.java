package tech.webgarage.personaltrainer;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MyParametrsChoice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.my_parametrs_choice);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCreateParam:
                Intent intent1 = new Intent(this, CreateParametr.class);
                startActivity(intent1);
                break;
            case R.id.btnLookParam:
                Intent intent2 = new Intent(this, LookParam.class);
                startActivity(intent2);
                break;
        }
    }
}
