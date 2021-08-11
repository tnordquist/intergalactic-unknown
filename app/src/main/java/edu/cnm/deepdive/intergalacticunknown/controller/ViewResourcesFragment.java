//package edu.cnm.deepdive.intergalacticUnknown.controller;
//
//import android.app.Dialog;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AlertDialog;
//import androidx.appcompat.app.AlertDialog.Builder;
//import androidx.fragment.app.DialogFragment;
//import androidx.navigation.Navigation;
//import edu.cnm.deepdive.intergalacticUnknown.R;
//import edu.cnm.deepdive.intergalacticUnknown.databinding.FragmentRandomEventBinding;
//import edu.cnm.deepdive.intergalacticUnknown.databinding.FragmentViewResourcesBinding;
//import edu.cnm.deepdive.intergalacticUnknown.viewmodel.MainViewModel;
//
//public class ViewResourcesFragment extends DialogFragment {
//
//
//
//  private MainViewModel viewModel;
//  private AlertDialog dialog;
//  private FragmentViewResourcesBinding binding;
//
//  @NonNull
//  @Override
//  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
//    binding = FragmentViewResourcesBinding.inflate(LayoutInflater.from(getContext()), null, false);
//    dialog = new Builder(getContext())
//        .setTitle(R.string.resource_summary)
//        .setView(binding.getRoot())
//        .setNeutralButton(android.R.string.ok, (d,w) -> { /* Do nothing */})
//        .create();
//    dialog.setOnShowListener((dlg) -> checkSubmitConditions);
//    return dialog;
//  }
//
//  @Nullable
//  @Override
//  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
//      @Nullable Bundle savedInstanceState) {
//    return super.onCreateView(inflater, container, savedInstanceState);
//  }
//
//  @Override
//  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//    super.onViewCreated(view, savedInstanceState);
//  }
//
//  private void checkSubmitConditions() {
//    Button positive = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
//    String displayName = binding.displayName.getText().toString().trim();
//    positive.setEnabled(!displayName.isEmpty());
//  }
//}
