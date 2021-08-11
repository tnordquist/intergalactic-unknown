package edu.cnm.deepdive.intergalacticunknown.controller;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.Navigation;
import edu.cnm.deepdive.intergalacticunknown.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

  private FragmentHomeBinding binding;


  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    binding = FragmentHomeBinding.inflate(inflater, container, false);
    binding.startGame.setOnClickListener((v) -> Navigation.findNavController(binding.getRoot())
        .navigate(HomeFragmentDirections.actionHomeFragmentToStationFragment()));
    //TODO attach listener to high scores.
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view,
      @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
  }
}