package com.example.bukreev.databinding.view.ViewModel;

import com.example.bukreev.databinding.model.Person;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

public class PersonViewModel extends ViewModel {

    final private MutableLiveData<Person> personMutableLiveData;

    public PersonViewModel() {
        this.personMutableLiveData = new MutableLiveData<>();
    }

    public final void observePerson(final LifecycleOwner lifecycleOwner,
                                    final Observer<Person> personObserver) {
        personMutableLiveData.observe(lifecycleOwner, personObserver);
    }

    public Person getPerson() {
        return personMutableLiveData.getValue();
    }

    public final void setPerson(final Person person) {
        personMutableLiveData.setValue(person);
    }
}
