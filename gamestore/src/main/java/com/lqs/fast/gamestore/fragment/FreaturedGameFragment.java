package com.lqs.fast.gamestore.fragment;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lqs.fast.fast.base_ui.ABaseFragment;
import com.lqs.fast.gamestore.R;
import com.lqs.fast.gamestore.adatpter.MyVpGameFragmentAdatpter;

/**
 * Created by dell on 2016/10/11.
 */

public class FreaturedGameFragment extends ABaseFragment<FreaturedGameFragment, String> {

    private RadioGroup mRgGameFragmentSelect;
    private ViewPager mVpGameFragment;
    private boolean isDrag = false;
    private RadioButton mRbGame;
    private RadioButton mRbKf;

    @Override
    protected void initMvp() {

    }

    @Override
    protected void initUI() {
        mRgGameFragmentSelect = (RadioGroup) mFragmentLauout.findViewById(R.id.fragmain_selete1_rg);
        mVpGameFragment = (ViewPager) mFragmentLauout.findViewById(R.id.fragmain_selete1_vp);
        mRbGame = (RadioButton) mFragmentLauout.findViewById(R.id.fragmain_selete1_game_rb);
        mRbKf = (RadioButton) mFragmentLauout.findViewById(R.id.fragmain_selete1_kaifu_rb);
        MyVpGameFragmentAdatpter myVpGameFragmentAdatpter = new MyVpGameFragmentAdatpter(getChildFragmentManager());
        mVpGameFragment.setAdapter(myVpGameFragmentAdatpter);
        mVpGameFragment.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int id = -1;
                if(position == 0)
                {
                    id = mRbGame.getId();
                }else if(position == 1)
                {
                    id = mRbKf.getId();
                }
                if(id != -1){

                    mRgGameFragmentSelect.check(id);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                isDrag = (state == ViewPager.SCROLL_STATE_DRAGGING);
            }
        });

        mRgGameFragmentSelect.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (!isDrag) {
                    int position = -1;
                    if (checkedId == mRbGame.getId()) {
                        position = 0;
                    }else if(checkedId == mRbKf.getId()){
                        position = 1;
                    }
                    if(position != -1){
                        mVpGameFragment.setCurrentItem(position);
                    }
                }
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.frag_selete1;
    }

    @Override
    public String getViewTag() {
        return null;
    }
}
