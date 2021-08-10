package edu.cnm.deepdive.intergalacticUnknown.controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.snackbar.Snackbar;
import edu.cnm.deepdive.intergalacticUnknown.R;
import edu.cnm.deepdive.intergalacticUnknown.databinding.ActivityLoginBinding;
import edu.cnm.deepdive.intergalacticUnknown.service.GoogleSignInService;

public class LoginActivity extends AppCompatActivity {

  private static final int LOGIN_REQUEST_CODE = 8191;

  private GoogleSignInService service;
  private ActivityLoginBinding binding;

  @SuppressLint("CheckResult")
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    service = GoogleSignInService.getInstance();
    service.refresh()
        .subscribe(
            this::switchToMain,
            (throwable -> {
              binding = ActivityLoginBinding.inflate(getLayoutInflater());
              binding.signIn.setOnClickListener((v) ->
                  service.startSignIn(this, LOGIN_REQUEST_CODE));
              setContentView(binding.getRoot());
            }
            ));
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    if (requestCode == LOGIN_REQUEST_CODE) {
      service.completeSignIn(data)
          .addOnSuccessListener(this::switchToMain)
          .addOnFailureListener(this::informFailure);
    } else {
      super.onActivityResult(requestCode, resultCode, data);
    }
  }

  private void switchToMain(GoogleSignInAccount account) {
    Intent intent = new Intent(this, MainActivity.class)
        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
    startActivity(intent);
  }

  private void informFailure(Throwable throwable) {
    Snackbar.make(binding.getRoot(), R.string.login_failure_message, Snackbar.LENGTH_LONG).show();
  }

}
