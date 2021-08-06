package edu.cnm.deepdive.intergalacticUnknown.controller;

import android.content.Context;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.Navigation;
import com.google.android.material.snackbar.Snackbar;
import edu.cnm.deepdive.intergalacticUnknown.R;
import edu.cnm.deepdive.intergalacticUnknown.databinding.FragmentHomeBinding;
import edu.cnm.deepdive.intergalacticUnknown.databinding.FragmentPlanetBinding;
import edu.cnm.deepdive.intergalacticUnknown.model.pojo.ResourceSummary;


public class PlanetFragment extends Fragment {

  private FragmentPlanetBinding binding;
  private Button button;
  private ConstraintLayout constraintLayout;
  private ResourceSummary resourceSummary;
  private Context context;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    binding = FragmentPlanetBinding.inflate(inflater, container, false);
    binding.nextPlanet.setOnClickListener((v) -> Navigation.findNavController(binding.getRoot())
        .navigate(PlanetFragmentDirections.actionPlanetFragmentToStationFragment()));

    //todo review
    binding.shipStatus.setOnClickListener((v) -> Snackbar.make(binding.getRoot(), context.getResources().toString(), Snackbar.LENGTH_INDEFINITE));
    return binding.getRoot();





  }



  @Override
  public void onViewCreated(@NonNull View view,
      @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
  }

}