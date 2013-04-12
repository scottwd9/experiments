package me.wds.helloandroid;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SendFragment extends Fragment {

    private MessageListener msgCallback;

    public interface MessageListener {
        public void onMessageReceived(String msg);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            msgCallback = (MessageListener) activity;
        } catch (ClassCastException ex) {
            throw new ClassCastException("Activity must implement MessageListener.");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        setRetainInstance(true);
        return inflater.inflate(R.layout.fragment_send, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        Button btnSend = (Button) getActivity().findViewById(R.id.send);
        btnSend.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText msg = (EditText) getActivity().findViewById(R.id.msg);
                msgCallback.onMessageReceived(msg.getText().toString());
            }
        });
    }
}
