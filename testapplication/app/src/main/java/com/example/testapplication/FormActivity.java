package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormActivity extends AppCompatActivity {
    private TextInputEditText fullnameEditText;
    private TextInputEditText descriptionEditText;
    private TextInputEditText localisationEditText;
    private TextInputEditText emailEditText;
    private Spinner servicesSpinner;
    private Button returnButton, addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        // Récupérez les références des champs de saisie et des boutons
        fullnameEditText = findViewById(R.id.fullname);
        descriptionEditText = findViewById(R.id.description);
        localisationEditText = findViewById(R.id.localisation);
        emailEditText = findViewById(R.id.email);
        servicesSpinner = findViewById(R.id.services);
        returnButton = findViewById(R.id.add1);
        addButton = findViewById(R.id.add2);

        // Ajoutez un écouteur de clic sur le bouton "Ajouter service"
        addButton.setOnClickListener(v -> {
            if (validateInputs()) {
                // Effectuez les actions d'ajout du service ici
                // ...
            }
        });
    }

    private boolean validateInputs() {
        String fullname = fullnameEditText.getText().toString().trim();
        String description = descriptionEditText.getText().toString().trim();
        String localisation = localisationEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        int selectedServiceIndex = servicesSpinner.getSelectedItemPosition();

        // Vérifier si le nom complet ne contient que des chiffres et des espaces
        if (!isValidFullname(fullname)) {
            fullnameEditText.setError("Veuillez saisir un nom complet valide");
            return false;
        }

        // Vérifier si l'adresse e-mail est valide
        if (!isValidEmail(email)) {
            emailEditText.setError("Veuillez saisir une adresse e-mail valide");
            return false;
        }

        // Vérifier si tous les champs sont remplis
        if (fullname.isEmpty() || description.isEmpty() || localisation.isEmpty() || email.isEmpty() || selectedServiceIndex == 0) {
            return false;
        }

        return true;
    }

    private boolean isValidFullname(String fullname) {
        String fullnameRegex = "^[a-zA-Z0-9\\s]+$";
        Pattern pattern = Pattern.compile(fullnameRegex);
        Matcher matcher = pattern.matcher(fullname);
        return matcher.matches();
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
