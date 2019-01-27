package com.example.bukreev.databinding.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.example.bukreev.databinding.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * TODO: document your custom view class.
 */
public class MainOutputView extends LinearLayout {


    private UserOutputView user_output_view;

    public MainOutputView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.sample_main_output_view, this);
        setOrientation(VERTICAL);
        this.user_output_view = findViewById(R.id.user_output_view);
        user_output_view.bind();
    }
}
