package com.example.bukreev.databinding.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.bukreev.databinding.MainActivity;
import com.example.bukreev.databinding.PersonActivity;
import com.example.bukreev.databinding.R;
import com.example.bukreev.databinding.databinding.SampleUserInputViewBinding;
import com.example.bukreev.databinding.databinding.SampleUserOutputViewBinding;
import com.example.bukreev.databinding.model.Person;
import com.example.bukreev.databinding.view.ViewModel.PersonViewModel;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

/**
 * TODO: document your custom view class.
 */
public class UserOutputView extends FrameLayout {

    private final SampleUserOutputViewBinding binding;

    public UserOutputView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.sample_user_output_view, this, true
        );
    }

    public final void bind() {
        final PersonActivity personActivity = ((PersonActivity) getContext());
        final PersonViewModel personViewModel = ViewModelProviders.of(personActivity).get(PersonViewModel.class);
        final Person person = personViewModel.getPerson();
        binding.setPerson(person);
    }
}
