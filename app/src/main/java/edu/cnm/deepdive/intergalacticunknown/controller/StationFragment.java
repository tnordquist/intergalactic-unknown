package edu.cnm.deepdive.intergalacticunknown.controller;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import edu.cnm.deepdive.intergalacticunknown.databinding.FragmentHomeBinding;
import edu.cnm.deepdive.intergalacticunknown.databinding.FragmentStationBinding;
import edu.cnm.deepdive.intergalacticunknown.model.entity.Trip;
import edu.cnm.deepdive.intergalacticunknown.model.types.PlanetType;
import edu.cnm.deepdive.intergalacticunknown.model.types.ResourceType;
import edu.cnm.deepdive.intergalacticunknown.viewmodel.MainViewModel;


public class StationFragment extends Fragment {


  private FragmentStationBinding binding;
  private boolean navigationInProgress; //default false
  private MainViewModel viewModel;
  private Trip trip;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    binding = FragmentStationBinding.inflate(inflater, container, false);
    ArrayAdapter<ResourceType> resourceAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, ResourceType.values());
    resourceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    binding.freeResource.setAdapter(resourceAdapter);

    ArrayAdapter<PlanetType> planetTypeAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, PlanetType.values());
    planetTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    binding.firstPlanet.setAdapter(planetTypeAdapter);

    binding.depart.setOnClickListener((v) -> {

      navigationInProgress = true;
      if (trip == null) {
        viewModel.startTrip((ResourceType) binding.freeResource.getSelectedItem(), (PlanetType) binding.firstPlanet.getSelectedItem());
      } else {
        viewModel.continueTrip((ResourceType) binding.freeResource.getSelectedItem(), (PlanetType) binding.firstPlanet.getSelectedItem());
      }
    });




    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view,
      @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
    viewModel.getTrip().observe(getViewLifecycleOwner(), (trip) -> {
      if (trip != null) {
        this.trip = trip;
        if (!navigationInProgress) {

          //todo this is where we come back in the middle of a trip.
        } else {
          //todo indicate start of new trip.
          if(trip.isRandomEvent()) {
            Navigation.findNavController(binding.getRoot())
                .navigate(StationFragmentDirections.actionStationFragmentToAcknowledgmentFragment());
          } else {
            Navigation.findNavController(binding.getRoot())
                .navigate(StationFragmentDirections.actionStationFragmentToPlanetFragment(trip.getPreferredDestination()));
          }
        }
      } else if (!navigationInProgress) {
        //todo indicate start of new trip.

      }
    });
//    viewModel.getRandomEventAcknowledged().observe(getViewLifecycleOwner(), (acknowledged) -> {
//      if(acknowledged != null) {
//        Navigation.findNavController(binding.getRoot())
//            .navigate(StationFragmentDirections.actionStationFragmentToPlanetFragment());
//      }
//    });
    //TODO set up observers
  }

}