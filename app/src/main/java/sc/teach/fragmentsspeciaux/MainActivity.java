package sc.teach.fragmentsspeciaux;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import sc.teach.fragmentsspeciaux.dialogs.PapalFragment;
import sc.teach.fragmentsspeciaux.dialogs.SimpleDialogListener;
import sc.teach.fragmentsspeciaux.dialogs.SimpleDialogFragment;


public class MainActivity extends AppCompatActivity implements  SimpleDialogListener {

    Button frag_simple_btn;
    Button frag_paypal_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frag_simple_btn = findViewById(R.id.PaiementCarte);
        frag_paypal_btn = findViewById(R.id.PaiementPaypal);


        frag_simple_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSimpleDialog();

            }
        });

        frag_paypal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgressDialog();

            }
        });

    }


    private void showSimpleDialog() {

        FragmentManager fm = getSupportFragmentManager();
        SimpleDialogFragment simpleDialogFragment = SimpleDialogFragment.newInstance("Titre");
        simpleDialogFragment.show(fm, "fragment_simple_dialog");

    }


    public void showProgressDialog() {

        FragmentManager fm = getSupportFragmentManager();
        PapalFragment fragment_paypal = PapalFragment.newInstance("titre");
        fragment_paypal.show(fm, "fragment_simple_dialog");
            }





    // Cette méthode est appellée dans l'activité quand le listener est déclanché
    // Les données sont passées en paramétres
    @Override
    public void onOkClickDialog(String nom) {
        Toast.makeText(this, "Hi, " + nom, Toast.LENGTH_SHORT).show();
    }

}

//test