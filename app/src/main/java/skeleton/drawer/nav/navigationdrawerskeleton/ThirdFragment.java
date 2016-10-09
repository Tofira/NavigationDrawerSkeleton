package skeleton.drawer.nav.navigationdrawerskeleton;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ThirdFragment extends FirstFragment  {
    public static final String TAG = ThirdFragment.class.getSimpleName();

    public static ThirdFragment newInstance() {
        return new ThirdFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupToolbar(TAG);
        TextView textView = (TextView) rootView.findViewById(R.id.fragmentTextView);
        textView.setText(TAG);
    }
}
