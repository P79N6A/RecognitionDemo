package com.lxl.shop.page;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.lxl.shop.R;

/**
 * Created by yanglei on 2018/11/23.
 */

public class MainActivity extends Activity implements View.OnClickListener {

    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_page_main);
        initView();
        initAction();

    }

    private void initAction() {
        textView.setOnClickListener(this);
    }

    private void initView() {
        textView = findViewById(R.id.add_customer);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.add_customer) {


        } else {


        }
    }
}
