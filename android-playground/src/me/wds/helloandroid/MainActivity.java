package me.wds.helloandroid;

import me.wds.helloandroid.SendFragment.MessageListener;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class MainActivity extends FragmentActivity implements MessageListener {

    protected static final String MSG = "msg";
    private View fragmentContainer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        fragmentContainer = findViewById(R.id.fragment_container);
        if (fragmentContainer != null) {
            if (savedInstanceState != null) {
                return;
            }
            SendFragment sendFragment = new SendFragment();
            sendFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, sendFragment).commit();
        }
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public void onMessageReceived(String msg) {
        // hide virtual keyboard
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getRootView().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);

        DisplayFragment displayFragment = new DisplayFragment();
        Bundle args = new Bundle();
        args.putString(MainActivity.MSG, msg);
        displayFragment.setArguments(args);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, displayFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private View getRootView() {
        return getWindow().getDecorView().findViewById(android.R.id.content);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if(menuItem.getItemId() == R.id.menu_account) {
            Intent accountIntent = new Intent(this, AccountActivity.class);
            startActivity(accountIntent);
        }
        
        return true;
    }
}
