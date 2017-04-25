package common.cain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //LinearLayout ll_add = (LinearLayout) findViewById(R.id.ll_add);
        /*((Header) findViewById(R.id.header)).setOnHeaderClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "标题栏的按钮被点击了", Toast.LENGTH_LONG).show();
            }
        });*/

        //Header header = new Header(this);
        //ll_add.addView(header);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
    }

    private Intent intent;

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button1:
                intent = new Intent();
                intent.setClass(MainActivity.this,ActivityOne.class);
                startActivity(intent);
                Log.e("111","button1");
                break;
            case R.id.button2:
                intent = new Intent();
                intent.setClass(MainActivity.this,ActivityTwo.class);
                startActivity(intent);
                break;
            case R.id.button3:
                break;
            case R.id.button4:
                break;
            case R.id.button5:
                break;
        }
    }
}
