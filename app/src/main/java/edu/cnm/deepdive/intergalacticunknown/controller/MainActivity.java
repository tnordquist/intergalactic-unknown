package edu.cnm.deepdive.intergalacticunknown.controller;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.snackbar.Snackbar;
import edu.cnm.deepdive.intergalacticunknown.databinding.ActivityMainBinding;
import edu.cnm.deepdive.intergalacticunknown.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

  private MainViewModel viewModel;
  private ActivityMainBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    viewModel = new ViewModelProvider(this).get(MainViewModel.class);
    getLifecycle().addObserver(viewModel);
    viewModel.getThrowable().observe(this, (throwable) -> {
      if(throwable != null) {
        Snackbar.make(binding.getRoot(), throwable.getMessage(), Snackbar.LENGTH_LONG).show();
      }
    });



  }
}