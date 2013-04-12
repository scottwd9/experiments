package me.wds.helloandroid.account;

import static android.accounts.AccountManager.ACTION_AUTHENTICATOR_INTENT;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class AccountAuthenticatorService extends Service {

    private static AccountAuthenticator AUTHENTICATOR = null;

    public IBinder onBind(Intent intent) {
        return intent.getAction().equals(ACTION_AUTHENTICATOR_INTENT) ? getAuthenticator()
                .getIBinder() : null;
    }

    private AccountAuthenticator getAuthenticator() {
        if (AUTHENTICATOR == null)
            AUTHENTICATOR = new AccountAuthenticator(this);
        return AUTHENTICATOR;
    }
}
