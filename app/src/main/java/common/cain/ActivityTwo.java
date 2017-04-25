package common.cain;

import android.app.Activity;
import android.os.Bundle;

public class ActivityTwo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        //LinearLayout ll_add = (LinearLayout) findViewById(R.id.ll_add);
        /*((Header) findViewById(R.id.header)).setOnHeaderClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "标题栏的按钮被点击了", Toast.LENGTH_LONG).show();
            }
        });*/

        //Header header = new Header(this);
        //ll_add.addView(header);
    }
}
