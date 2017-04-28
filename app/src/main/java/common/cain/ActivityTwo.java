package common.cain;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityTwo extends Activity implements View.OnClickListener {

    private static final int REQUEST_CODE_TEST = 11221;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

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


    public void requestPermissiontest() {
        // you needer permissions
        String[] permissions = {Manifest.permission.READ_PHONE_STATE};
        // check it is needed
        permissions = CheckPermissionUtils.getNeededPermission(this, permissions);
        // requestPermissions
        if (permissions.length > 0) {
            ActivityCompat.requestPermissions(this,permissions, REQUEST_CODE_TEST);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_TEST:
                if (grantResults.length > 0) {
                    return;
                }

                if (!CheckPermissionUtils.isNeedAddPermission(this, Manifest.permission.READ_PHONE_STATE)) {
                    // do something
                    Toast.makeText(this, "申请权限成功:" + Manifest.permission.READ_PHONE_STATE, Toast.LENGTH_LONG).show();
                }
                if (!CheckPermissionUtils.isNeedAddPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    // do something
                    Toast.makeText(this, "申请权限成功:" + Manifest.permission.WRITE_EXTERNAL_STORAGE, Toast.LENGTH_LONG).show();
                }

                break;

        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                requestPermissiontest();
                break;
            case R.id.button2:
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
