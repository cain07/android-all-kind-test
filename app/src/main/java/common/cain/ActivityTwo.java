package common.cain;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import common.cain.utils.RequestCode;

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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                requestPermissiontest();
                break;
            case R.id.button2:
                doCallPhone();
                break;
            case R.id.button3:
                break;
            case R.id.button4:
                break;
            case R.id.button5:
                break;
        }
    }

    /**
     * 拨打电话
     */
    private void doCallPhone() {
        XPermissionUtils.requestPermissions(this, RequestCode.PHONE, new String[] {
                Manifest.permission.CALL_PHONE
        }, new XPermissionUtils.OnPermissionListener() {
            @Override
            public void onPermissionGranted() {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:10010"));
                startActivity(intent);
            }

            @Override
            public void onPermissionDenied(String[] deniedPermissions, boolean alwaysDenied) {
                Toast.makeText(ActivityTwo.this, "获取拨打电话权限失败", Toast.LENGTH_SHORT).show();
                if (alwaysDenied) {
                    //DialogUtil.showPermissionManagerDialog(ActivityTwo.this, "拨打电话");
                    Toast.makeText(ActivityTwo.this, "拨打电话", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        XPermissionUtils.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
