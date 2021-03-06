package com.lqs.fast.gamestore.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.lqs.fast.gamestore.R;
import com.lqs.fast.gamestore.adatpter.MyDetailDialogAdatpter;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

/**
 * Created by dell on 2016/10/17.
 */

public class GameDetailImagesDialogFragment extends DialogFragment {

    private ViewPager mVpImages;
    private View mLayout;
    private LayoutInflater mInflate;
    private List<String> mUrlList = new ArrayList<>();
    private static final String BUNDLE_KEY="Bundle_Key";

    public GameDetailImagesDialogFragment(){
        super();
    }

//    public GameDetailImagesDialogFragment(List<String> list) {
//        this.mUrlList = list;
//    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);

        initData();

        mLayout = inflater.inflate(R.layout.dialog_gamedetail_images, container, true);
        this.mInflate = inflater;
        initViewPage();

        mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameDetailImagesDialogFragment.this.dismiss();
            }
        });

        Window window = getDialog().getWindow();
        window.setGravity(Gravity.FILL); //可设置dialog的位置
        window.getDecorView().setPadding(0, 0, 0, 0); //消除边距

        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;   //设置宽度充满屏幕
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(lp);

//        View button = mLayout.findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dismiss();
//            }
//        });
        return mLayout;
    }

    private void initData() {
        Bundle arguments = getArguments();
        ArrayList<String> list = arguments.getStringArrayList(BUNDLE_KEY);
        mUrlList.addAll(list);
    }

    @Override
    public void onStart() {
        super.onStart();
//        DisplayMetrics dm = new DisplayMetrics();
//        getActivity().getWindowManager().getDefaultDisplay().getMetrics( dm );
//        Window window = getDialog().getWindow();
//        window.setLayout( dm.widthPixels, window.getAttributes().height );


        Dialog dialog = getDialog();
        if (dialog != null) {

//            Window window = dialog.getWindow();
//            window.setGravity(Gravity.BOTTOM); //可设置dialog的位置
//            window.getDecorView().setPadding(0, 0, 0, 0); //消除边距
//
//            WindowManager.LayoutParams lp = window.getAttributes();
//            lp.width = WindowManager.LayoutParams.MATCH_PARENT;   //设置宽度充满屏幕
//            lp.height = WindowManager.LayoutParams.MATCH_PARENT;
//            window.setAttributes(lp);
        }
    }

    private void initViewPage() {
        mVpImages = (ViewPager) mLayout.findViewById(R.id.vp_dialogfragment_images);
        FragmentManager fm = getChildFragmentManager();
        MyDetailDialogAdatpter adatpter = new MyDetailDialogAdatpter(fm, mInflate, mUrlList);
        mVpImages.setAdapter(adatpter);
    }

    public void setViewPageItem(int position) {
        int size = mUrlList.size();
        if (position >= 0 && position < size) {
            mVpImages.setCurrentItem(position, false);

        }
    }

    public static DialogFragment getInstance(List<String> list){
        GameDetailImagesDialogFragment fragment = new GameDetailImagesDialogFragment();
        Bundle bundle = new Bundle();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(list);
        bundle.putStringArrayList(BUNDLE_KEY,arrayList);
        fragment.setArguments(bundle);
        return fragment;
    }
}
