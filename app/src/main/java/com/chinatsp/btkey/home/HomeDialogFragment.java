package com.chinatsp.btkey.home;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chinatsp.btkey.BaseDialogFragment;
import com.chinatsp.btkey.BaseFragment;
import com.chinatsp.btkey.MainActivity;
import com.chinatsp.btkey.R;
import com.chinatsp.btkey.connect.ConnectFragment;
import com.chinatsp.btkey.utils.ActivityUtils;

/**
 * Created by Administrator on 2020/1/16.
 */

public class HomeDialogFragment extends BaseDialogFragment implements View.OnClickListener{
    private BaseFragment mFragment;
    private ImageView iconIv;
    private TextView contentTv;
    private int resId;
    private String contentStr;
    private Context mContext;

    public static HomeDialogFragment newInstance(int resId, String contentStr) {
        HomeDialogFragment fragment = new HomeDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("resId", resId);
        bundle.putString("contentStr", contentStr);
        fragment.setArguments(bundle);
        return fragment;
    }

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1000:
                    dismiss();
                    break;
            }
        }
    };

    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.windowAnimations = R.style.HomeDialog;
        window.setAttributes(params);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Message msg = new Message();
        msg.what = 1000;
        mHandler.sendMessageDelayed(msg,5000);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = (MainActivity) context;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_home_dialog;
    }

    @Override
    public void initView(View view) {
        iconIv = (ImageView) view.findViewById(R.id.icon_iv);
        contentTv = (TextView) view.findViewById(R.id.content_tv);
    }


    @Override
    public void initData() {
        iconIv.setBackground(mContext.getDrawable(getArguments().getInt("resId")));
        contentTv.setText(getArguments().getString("contentStr"));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

        }
    }
}
