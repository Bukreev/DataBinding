package com.example.bukreev.databinding.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.example.bukreev.databinding.R;

import androidx.annotation.Nullable;

/**
 * TODO: document your custom view class.
 */
public class MainView extends LinearLayout {


    private UserInputView user_input_view;

    public MainView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.sample_main_view, this);
        setOrientation(VERTICAL);
        user_input_view = findViewById(R.id.user_input_view);
        user_input_view.bind();
    }
}
