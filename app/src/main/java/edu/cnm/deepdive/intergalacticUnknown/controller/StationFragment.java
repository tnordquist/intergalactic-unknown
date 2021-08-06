package edu.cnm.deepdive.intergalacticUnknown.controller;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.Navigation;
import edu.cnm.deepdive.intergalacticUnknown.R;
import edu.cnm.deepdive.intergalacticUnknown.databinding.FragmentHomeBinding;
import edu.cnm.deepdive.intergalacticUnknown.databinding.FragmentStationBinding;
import edu.cnm.deepdive.intergalacticUnknown.model.types.PlanetType;
import edu.cnm.deepdive.intergalacticUnknown.model.types.ResourceType;


public class StationFragment extends Fragment {

  private FragmentStationBinding binding;

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
      /* TODO invoke view model method to create trip */
      Navigation.findNavController(binding.getRoot()).navigate(StationFragmentDirections.actionStationFragmentToPlanetFragment());
    });

    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view,
      @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
  }

}