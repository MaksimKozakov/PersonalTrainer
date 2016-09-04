package tech.webgarage.personaltrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //private final static int NOTIFY_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }


    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnMyParam:
                Intent intent = new Intent(this, MyParametrsChoice.class);
                startActivity(intent);
                break;
            case R.id.btnCalendar:
                Intent intent2 = new Intent(this, Calendar.class);
                startActivity(intent2);
                break;
            case R.id.btnContCourse:
                Intent intent3 = new Intent(this, ContinCourse.class);
                startActivity(intent3);
                break;
            case R.id.btnCourseDone:
                Intent intent4 = new Intent(this, PreparedCourses.class);
                startActivity(intent4);
                break;
            case R.id.btnCreateCourse:
                Intent intent5 = new Intent(this, CreateCourse.class);
                startActivity(intent5);
                break;
            case R.id.btnMyGoal:
                Intent intent6 = new Intent(this, MyGoal.class);
                startActivity(intent6);
                break;
        }
        /*Toast toast = Toast.makeText(MainActivity.this, "Hi", Toast.LENGTH_LONG);
        toast.show();*/

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


