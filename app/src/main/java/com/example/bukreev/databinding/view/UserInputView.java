package com.example.bukreev.databinding.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.bukreev.databinding.MainActivity;
import com.example.bukreev.databinding.PersonActivity;
import com.example.bukreev.databinding.R;
import com.example.bukreev.databinding.databinding.SampleUserInputViewBinding;
import com.example.bukreev.databinding.model.Person;
import com.example.bukreev.databinding.view.Listener.MyListener;
import com.example.bukreev.databinding.view.ViewModel.PersonViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

/**
 * TODO: document your custom view class.
 */
public class UserInputView extends FrameLayout implements MyListener {

    private MaterialButton material_text_button;
    private final SampleUserInputViewBinding binding;

    public UserInputView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.sample_user_input_view, this, true
        );
        material_text_button = findViewById(R.id.material_text_button);
        material_text_button.setEnabled(false);
    }

    public void bind() {
        Person person = new Person();
        binding.setPerson(person);
        binding.setButtonListener(this);
    }

    @Override
    public final void onTextChange() {
        final Person person = binding.getPerson();
        if (isNotEmpty(person.getName()) && isNotEmpty(person.getEmail()) && isNotEmpty(person.getPhone())) {
            material_text_button.setEnabled(true);
        } else {
            material_text_button.setEnabled(false);
        }
    }

    @Override
    public final void onClick() {
        final Person person = binding.getPerson();
        final MainActivity mainActivity = ((MainActivity) getContext());
        final PersonViewModel personViewModel = ViewModelProviders.of(mainActivity).get(PersonViewModel.class);
        personViewModel.setPerson(person);
        mainActivity.startActivity(PersonActivity.class);
    }

    private boolean isNotEmpty(final String data) {
        return data != null && data.length() > 0;
    }
}
