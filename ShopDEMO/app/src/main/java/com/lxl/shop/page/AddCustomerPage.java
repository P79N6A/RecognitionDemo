package com.lxl.shop.page;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lxl.shop.R;
import com.lxl.shop.widget.StockTitleView;

/**
 * Created by yanglei on 2018/11/23.
 */

public class AddCustomerPage extends Activity {

    StockTitleView title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_page_add_customer);
        initView();
        initAction();
        initData();
    }

    private void initData() {
    }

    private void initAction() {

    }

    private void initView() {
        title = (StockTitleView) findViewById(R.id.page_title);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
