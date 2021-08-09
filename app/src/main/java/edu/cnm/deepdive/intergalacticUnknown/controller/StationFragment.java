package edu.cnm.deepdive.intergalacticUnknown.controller;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import edu.cnm.deepdive.intergalacticUnknown.R;
import edu.cnm.deepdive.intergalacticUnknown.databinding.FragmentHomeBinding;
import edu.cnm.deepdive.intergalacticUnknown.databinding.FragmentStationBinding;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.Trip;
import edu.cnm.deepdive.intergalacticUnknown.model.types.PlanetType;
import edu.cnm.deepdive.intergalacticUnknown.model.types.ResourceType;
import edu.cnm.deepdive.intergalacticUnknown.viewmodel.MainViewModel;


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
      viewModel.startTrip((ResourceType) binding.freeResource.getSelectedItem(), (PlanetType) binding.firstPlanet.getSelectedItem());
      Navigation.findNavController(binding.getRoot()).navigate(StationFragmentDirections.actionStationFragmentToPlanetFragment());
    });




    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view,
      @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
    viewModel.getTrip().observe(getViewLifecycleOwner(), (trip) -> {
      if(trip != null && !navigationInProgress){
        //todo show results of the trip
      }else if(!navigationInProgress){
        //todo indicate start of new trip.
      }
    });
    //TODO set up observers
  }

}