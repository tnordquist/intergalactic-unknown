package edu.cnm.deepdive.intergalacticunknown.controller;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import com.google.android.material.snackbar.Snackbar;
import edu.cnm.deepdive.intergalacticunknown.databinding.FragmentPlanetBinding;
import edu.cnm.deepdive.intergalacticunknown.model.pojo.ResourceSummary;
import edu.cnm.deepdive.intergalacticunknown.model.pojo.TripWithLandings;
import edu.cnm.deepdive.intergalacticunknown.model.types.PlanetType;
import edu.cnm.deepdive.intergalacticunknown.viewmodel.MainViewModel;


public class PlanetFragment extends Fragment {

  private FragmentPlanetBinding binding;
  private MainViewModel viewModel;
  private Button button;
  private ConstraintLayout constraintLayout;
  private ResourceSummary resourceSummary;
  private TripWithLandings trip;
  private Context context;
  private PlanetType planetType;
  private PlanetType nextPlanetType;
  private boolean landed;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    planetType = PlanetFragmentArgs.fromBundle(getArguments()).getPlanetType();
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    binding = FragmentPlanetBinding.inflate(inflater, container, false);




    binding.shipStatus.setOnClickListener((v) -> Snackbar.make(binding.getRoot(), context.getResources().toString(), Snackbar.LENGTH_INDEFINITE));
    binding.minePlanet.setOnClickListener((v) -> Snackbar.make(binding.getRoot(), viewModel.getMineAttempt().toString(), Snackbar.LENGTH_INDEFINITE));
    return binding.getRoot();


  }

  private void setUpTravelButton() {

    if (trip.getLandings().size() % 3 == 0) {
      binding.nextPlanet.setOnClickListener((v) -> Navigation.findNavController(binding.getRoot())
          .navigate(PlanetFragmentDirections.actionPlanetFragmentToStationFragment()));
    }
    else {
      binding.nextPlanet.setOnClickListener((v) -> Navigation.findNavController(binding.getRoot())
          .navigate(PlanetFragmentDirections.actionPlanetFragmentSelf(nextPlanetType)));
    }

  }


  @Override
  public void onViewCreated(@NonNull View view,
      @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    viewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
    //todo land at designated planet type
    viewModel.getTrip().observe(getViewLifecycleOwner(), (trip) -> {
      this.trip = trip;
      land();
      setUpTravelButton();
    });
    viewModel.getRandomPlanetType().observe(getViewLifecycleOwner(), (planetType) -> nextPlanetType = planetType);
    viewModel.generateRandomPlanetType();
  }

  private void land() {
    if (!landed) {
      landed = true;
      viewModel.land(planetType);
    }
  }


}