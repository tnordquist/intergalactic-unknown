package edu.cnm.deepdive.intergalacticunknown.controller;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import edu.cnm.deepdive.intergalacticunknown.R;
import edu.cnm.deepdive.intergalacticunknown.databinding.FragmentRandomEventBinding;
import edu.cnm.deepdive.intergalacticunknown.model.pojo.TripWithLandings;
import edu.cnm.deepdive.intergalacticunknown.viewmodel.MainViewModel;

public class RandomEventFragment extends DialogFragment {

  private MainViewModel viewModel;
  private Dialog dialog;
  private FragmentRandomEventBinding binding;
  private TripWithLandings trip;

  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    binding = FragmentRandomEventBinding.inflate(LayoutInflater.from(getContext()), null, false);
    dialog = new Builder(getContext())
        .setTitle(R.string.random_event_title)
        .setView(binding.getRoot())
        .setNeutralButton(android.R.string.ok, (d,w) -> {
          Bundle args = new Bundle();
          args.putSerializable("planet_type", trip.getPreferredDestination());
          Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.planet_fragment, args);
        })
        .create();
    return dialog;
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
    viewModel.getTrip().observe(getViewLifecycleOwner(), (trip) -> {
      this.trip = trip;
      binding.newPlanet.setText(trip.getPreferredDestination().toString());
      binding.newResource.setText(trip.getAugmentedResource().toString());

      //todo set text in binding objects to values of trip fields / properties. (put in planet fragment as well)
    });
  }
}
