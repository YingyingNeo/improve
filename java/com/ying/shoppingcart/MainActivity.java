package com.ying.shoppingcart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private EditText et_password;
    private EditText et_phone;
    private Button btn_forget;
    private String mPassword = "111111";
    private int mRequestCode = 0; // 跳转页面时的请求代码
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_forget).setOnClickListener(this);
        findViewById(R.id.login).setOnClickListener(this);
        et_password=findViewById(R.id.edt_password);
        et_phone=findViewById(R.id.edt_phone);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == mRequestCode && data != null) {
            // 用户密码已改为新密码，故更新密码变量
            mPassword = data.getStringExtra("new_password");
        }
    }
    // startActivityForResult()需要一个int类型的请求码，这个请求码会随着登陆Activity的跳转而带过去，
//            而跳转过去的忘记密码Activity执行finish()的时候，我们需要使用setResult()来设置一个结果码，
//            这个结果码必须为RESULT_OK，因为登陆Activity的onActivityResult()会依次判断结果码和请求码，
//            只有都符合的时候，OK，我们可以从onActivityResult()的参数Intent data中获取数据，
//            这个data就是忘记密码Activity中的Intent。
    @Override
    public void onClick(View v) {
        String phone = et_phone.getText().toString();
        if (v.getId() == R.id.btn_forget) { // 点击了“忘记密码”按钮
            if (et_phone.length() < 11) { // 手机号码不足11位
                Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                return;
            }
            Intent intent = new Intent(this, LoginForgetActivity.class);
            // 携带手机号码跳转到找回密码页面
            intent.putExtra("phone", phone);
            //从忘记密码界面跳回到登陆界面，并调用登陆界面的onActivityResult( )方法
            startActivityForResult(intent, mRequestCode);
            }
        else if (v.getId() == R.id.login) {
            if (et_phone.length() < 11) { // 手机号码不足11位
                Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                return;
            }
            else if (!et_password.getText().toString().equals(mPassword)) {
                Toast.makeText(this, "请输入正确的密码", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ShoppingCartActivity.class);
            startActivity(intent);
            }
        }
    }
