package com.chinatsp.btkey.authen;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.chinatsp.btkey.BaseFragment;
import com.chinatsp.btkey.R;

/**
 * Created by Administrator on 2020/1/16.
 */

public class AuthenFragment extends BaseFragment implements View.OnClickListener{
    private Button checkAuthenBt;

    public static AuthenFragment newInstance(String dataList, String answer) {
        AuthenFragment fragment = new AuthenFragment();
        Bundle bundle = new Bundle();
        bundle.putString("list", dataList);
        bundle.putString("data", answer);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        checkAuthenBt = (Button) view.findViewById(R.id.check_authen_bt);
        checkAuthenBt.setOnClickListener(this);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_authen;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.check_authen_bt:
                checkAuthen();
                break;
        }
    }

    /*
   *  检查是否获得授权
    */
    public void checkAuthen(){
        boolean isAuthened = false;
        if(!isAuthened){
            showAuthenDialog();
        }
    }

    private void showAuthenDialog() {
        AuthenDialogFragment fragment = new AuthenDialogFragment();
        fragment.show(getFragmentManager(), "fingerprint");
    }
}
