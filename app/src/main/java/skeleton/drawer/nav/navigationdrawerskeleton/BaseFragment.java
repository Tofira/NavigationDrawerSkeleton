package skeleton.drawer.nav.navigationdrawerskeleton;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BaseFragment extends Fragment  {
    public static final String TAG = BaseFragment.class.getSimpleName();
    private OnToolbarFragmentInteractionsListener mListener;
    protected View rootView;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rootView = view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnToolbarFragmentInteractionsListener) context;
        } catch (ClassCastException ignored) {
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    protected void setupToolbar(String title) {
        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        ((TextView) toolbar.findViewById(R.id.tv_toolbar_title)).setText(title);
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null)
                    mListener.onNavigationButtonClicked();
            }
        });
    }

}
