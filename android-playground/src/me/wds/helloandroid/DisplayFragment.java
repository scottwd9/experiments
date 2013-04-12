package me.wds.helloandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        setRetainInstance(true);
        return inflater.inflate(R.layout.fragment_display, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle args = getArguments();
        if (args != null) {
            String msg = args.getString(MainActivity.MSG);
            if (msg != null) {
                TextView displayMessage = (TextView) getActivity().findViewById(
                        R.id.display_message);
                displayMessage.setText(msg);
            }
        }
    }
}
