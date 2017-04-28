package common.cain;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityOne extends Activity implements View.OnClickListener {

    private static final int REQUEST_CODE = 22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

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

    /**
     * Called when the 'loadIMEI' function is triggered.
     */
    public void loadIMEI() {

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                callPhone();
                break;
            case R.id.button2:
                callPhone2();
                break;
            case R.id.button3:
                callPhone3();
                break;
            case R.id.button4:
                callPhone4();
                break;
            case R.id.button5:
                break;
        }
    }

    /**
     * 这么写 就可以了
     * 动态权限 只是在 6.0 以上才有 意思 就是 你手动禁止了 还可以 动态去申请权限
     * 以下
     * 如果在Manifest文件里 申请了 就自动会有
     *  但是 如果你手动又去禁止了,那么 就没有反应了 不能动态申请权限
     */
    private void callPhone2() {
        boolean b = new PermissionUtils(this).requesCallPhonePermissions(200);
        if (b) {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "15652287701"));
            startActivity(intent);
        } else {

        }
    }

    private void callPhone3() {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "15652287701"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CALL_PHONE)) {
                //已经禁止提示了
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE);
            }
        }else {
            startActivity(intent);
        }

    }

    private void callPhone4() {
        PackageManager pkm = getPackageManager();
        boolean has_permission = (PackageManager.PERMISSION_GRANTED == pkm.checkPermission("android.permission.CALL_PHONE", "com.qdtevc.teld.app"));
        if (has_permission) {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "15652287701"));
            startActivity(intent);
        } else {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE);
            Toast.makeText(this, "没有设置权限", Toast.LENGTH_SHORT).show();
        }

    }

    private void callPhone() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE);
            } else {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "15652287701"));
                startActivity(intent);
            }

        } else {

            PackageManager pkm = getPackageManager();
            boolean has_permission = (PackageManager.PERMISSION_GRANTED == pkm.checkPermission("android.permission.CALL_PHONE", "com.qdtevc.teld.app"));
            if (has_permission) {
                // 这里才开始真的干活的
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "15652287701"));
                startActivity(intent);
            } else {
                // showToast("没有权限");
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE);
                Toast.makeText(this, "没有设置权限", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //用户同意授权
                    callPhone();
                } else {
                    //用户拒绝授权
                }
                break;
        }
    }
}
