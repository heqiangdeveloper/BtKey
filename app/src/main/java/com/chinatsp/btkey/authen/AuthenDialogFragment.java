package com.chinatsp.btkey.authen;

import android.view.View;
import android.widget.Button;

import com.chinatsp.btkey.BaseDialogFragment;
import com.chinatsp.btkey.BaseFragment;
import com.chinatsp.btkey.R;
import com.chinatsp.btkey.connect.ConnectFragment;
import com.chinatsp.btkey.utils.ActivityUtils;

/**
 * Created by Administrator on 2020/1/16.
 */

public class AuthenDialogFragment extends BaseDialogFragment implements View.OnClickListener{
    private BaseFragment mFragment;
    private Button auAuthenedBt;
    private Button unAuthenBt;
    @Override
    public int getContentView() {
        return R.layout.fragment_authen_dialog;
    }

    @Override
    public void initView(View view) {
        unAuthenBt = (Button) view.findViewById(R.id.unAuthen_bt);
        auAuthenedBt = (Button) view.findViewById(R.id.authened_bt);
        unAuthenBt.setOnClickListener(this);
        auAuthenedBt.setOnClickListener(this);
    }


    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.authened_bt://已授权
                dismiss();
                mFragment = ConnectFragment.newInstance("", "");
                ActivityUtils.replaceFragmentToActivity(getFragmentManager(), mFragment, R.id.framelayout_content);
                break;
            case R.id.unAuthen_bt://未授权
                dismiss();
                break;
        }
    }
}
