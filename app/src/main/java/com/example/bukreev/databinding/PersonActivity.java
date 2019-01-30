package com.example.bukreev.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.bukreev.databinding.model.Person;
import com.example.bukreev.databinding.view.ViewModel.PersonViewModel;

public class PersonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        final Intent intent = getIntent();
        final String name = intent.getStringExtra("name");
        final String email = intent.getStringExtra("email");
        final String phone = intent.getStringExtra("phone");
        final Person person = new Person(name, email, phone);
        final PersonViewModel personViewModel = ViewModelProviders.of(this).get(PersonViewModel.class);
        personViewModel.setPerson(person);
    }

    public static void startActivity(Context context, final Person person)
    {
        final PersonViewModel personViewModel = ViewModelProviders.of(context.bindServic).get(PersonViewModel.class);
        Intent intent = new Intent(context, PersonActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("name", person.getName());
        intent.putExtra("email", person.getEmail());
        intent.putExtra("phone", person.getPhone());
        context.startActivity(intent);
    }

}
