package skeleton.drawer.nav.navigationdrawerskeleton;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FirstFragment extends BaseFragment  {
    public static final String TAG = FirstFragment.class.getSimpleName();

    public static FirstFragment newInstance() {
        return new FirstFragment();
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
