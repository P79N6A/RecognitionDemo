package com.lxl.shop.page;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aiwinn.base.util.StringUtils;
import com.lxl.shop.R;
import com.lxl.shop.utils.StockUtil;
import com.lxl.shop.utils.StringUtil;
import com.lxl.shop.viewmodel.CustomerModel;
import com.lxl.shop.widget.StockTitleView;

/**
 * Created by yanglei on 2018/11/23.
 */

public class AddCustomerPage extends Activity implements View.OnClickListener {

    StockTitleView mTitle;
    Button mSubmit;

    TextView mUserIconViewDesc;
    ImageView mUserIconViewImg;

    LinearLayout mShopRegisterView;

    TextView mUserInfoGenderMan;
    TextView mUserInfoGenderWoman;

    LinearLayout mShopRegisterContainer;

    CustomerModel mCustomerModel = new CustomerModel();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_page_register_customer);
        initView();
        initAction();
        initData();
    }

    private void initData() {
        //以id为配置
        mSubmit.requestFocus();
        addRegisterItem("会员名称", R.drawable.register_username, "string");
        addRegisterItem("电话号码", R.drawable.register_phone, "number");
        addRegisterItem("邮箱", R.drawable.register_email, "string");
        addRegisterItem("出生日期", R.drawable.register_date, "string");
        addRegisterItem("地址", R.drawable.register_address, "string");
    }

    private void addRegisterItem(String desc, int resourceId, String type) {
        View inflate = View.inflate(this, R.layout.shop_view_register_item, null);
        ImageView img = inflate.findViewById(R.id.add_customer_img);
        EditText editEdit = inflate.findViewById(R.id.add_customer_edit);
        img.setBackgroundResource(resourceId);
        editEdit.setHint(desc);
        inflate.setTag(desc);
        if (type.equals("string")) {
            editEdit.setInputType(InputType.TYPE_CLASS_TEXT);
        } else if (type.equals("number")) {
            editEdit.setInputType(InputType.TYPE_CLASS_NUMBER);
        }
        mShopRegisterContainer.addView(inflate);
    }


    private void initAction() {
        mSubmit.setOnClickListener(this);
    }

    private String checkCustomer() {
        CustomerModel customerModel = new CustomerModel();
        int childCount = mShopRegisterContainer.getChildCount();

        String error = "";
        for (int i = 0; i < childCount; i++) {
            View childAt = mShopRegisterContainer.getChildAt(i);
            Object tag = childAt.getTag();
            EditText editView = childAt.findViewById(R.id.add_customer_edit);
            String s = editView.getText().toString();
            if (StringUtils.isEmpty(s)) {
                error = tag + "不能为空";
                break;
            }
            if ("会员名称".equals(tag)) {
                customerModel.name = s;
                continue;
            } else if ("电话号码".equals(tag)) {
                customerModel.moblie = s;
                continue;
            } else if ("邮箱".equals(tag)) {
                customerModel.email = s;
                continue;
            } else if ("出生日期".equals(tag)) {
                customerModel.birthday = s;
                continue;
            } else if ("地址".equals(tag)) {
                customerModel.address = s;
                continue;
            }
        }
        if (!StringUtils.isEmpty(error)) {
            mCustomerModel = customerModel;
        }
        return error;
    }

    private void initView() {
        mTitle = (StockTitleView) findViewById(R.id.page_title);
        mSubmit = (Button) findViewById(R.id.submit);
        mUserIconViewDesc = (TextView) findViewById(R.id.user_icon_view_desc);
        mUserIconViewImg = (ImageView) findViewById(R.id.user_icon_view_img);
        mShopRegisterView = (LinearLayout) findViewById(R.id.shop_register_view);
        mUserInfoGenderMan = (TextView) findViewById(R.id.user_info_gender_man);
        mUserInfoGenderWoman = (TextView) findViewById(R.id.user_info_gender_woman);
        mShopRegisterContainer = (LinearLayout) findViewById(R.id.add_customer_container);
    }

    private void sendSubmitService() {
        StockUtil.showToastOnMainThread(getApplicationContext(), "提交成功");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.submit) {
            String error = checkCustomer();
            if (!StringUtil.emptyOrNull(error)) {
                sendSubmitService();
            } else {
                StockUtil.showToastOnMainThread(getApplicationContext(), error);
            }

        }
    }

}
