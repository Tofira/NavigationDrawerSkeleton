package skeleton.drawer.nav.navigationdrawerskeleton;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks,
        OnToolbarFragmentInteractionsListener{
    private int currentItem = -1;
    private FrameLayout flContainer;
    private NavigationDrawerFragment mNavigationDrawerFragment;
    public static final long DRAWER_CLOSE_DELAY = 300L;
    public static final int FIRST_ITEM = 0;
    public static final int SECOND_ITEM = 1;
    public static final int THIRD_ITEM = 2;
    public static final int FOURTH_ITEM = 3;

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler();
        setupDrawer();

    }

    private void setupDrawer() {

        flContainer = (FrameLayout) findViewById(R.id.container);
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);


        List<MenuItem> menuItems = new ArrayList<MenuItem>() {{
            add(new MenuItem("First Item", true));
            add(new MenuItem("Second Item", true));
            add(new MenuItem("Third Item", false));
        }};

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout),
                menuItems);
        mNavigationDrawerFragment.closeDrawer();

        mNavigationDrawerFragment.selectItem(FIRST_ITEM);

    }

    public boolean isMenuClosed(){
        return !mNavigationDrawerFragment.isDrawerOpen();
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        if (currentItem == position)
            return;

        currentItem = position;
        final Fragment fragment;
        final String tag;
        switch (position) {
            case FIRST_ITEM:
                fragment = FirstFragment.newInstance();
                tag = FirstFragment.TAG;
                break;
            case SECOND_ITEM:
                fragment = SecondFragment.newInstance();
                tag = SecondFragment.TAG;
                break;
            case THIRD_ITEM:
                fragment = ThirdFragment.newInstance();
                tag = ThirdFragment.TAG;
                break;
            case FOURTH_ITEM:
                Toast.makeText(MainActivity.this, "Does something else", Toast.LENGTH_LONG).show();
                return;
            default:
                Toast.makeText(this, "Hasn't been  implemented yet", Toast.LENGTH_SHORT).show();
                return;
        }
        //prevent drawer close lag during fragment transaction
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                replaceFragment(fragment, tag, false);
            }
        }, DRAWER_CLOSE_DELAY);
    }

    @Override
    public void onNavigationStateChanged() {
        flContainer.setClickable(false);
    }

    @Override
    public void onMenuClosed() {
        flContainer.setClickable(true);
    }

    @Override
    public void onMenuOpened() {
        flContainer.setClickable(false);
    }

    @Override
    public void onBackPressed() {
        if (mNavigationDrawerFragment.isDrawerOpen()) {
            mNavigationDrawerFragment.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    public void openNavigationDrawer() {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            mNavigationDrawerFragment.openDrawer();
        }
    }

    @Override
    public void onNavigationButtonClicked() {
        hideKeyboard();
        if (mNavigationDrawerFragment.isDrawerOpen()) {
            mNavigationDrawerFragment.closeDrawer();
        } else {
            mNavigationDrawerFragment.openDrawer();
        }
    }

    /**
     * Replace a Fragment in the container of the layout.
     * @param fragment the new Fragment
     * @param tag the Fragment's tag.
     * @param addToBackStack
     */
    public void replaceFragment(Fragment fragment, String tag, boolean addToBackStack) {
        if (isFinishing()) {
            return;
        }
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment, tag);
        if(addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commitAllowingStateLoss();
        hideKeyboard();
    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}
