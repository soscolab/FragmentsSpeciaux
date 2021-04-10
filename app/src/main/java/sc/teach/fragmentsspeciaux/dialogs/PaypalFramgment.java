package sc.teach.fragmentsspeciaux.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import sc.teach.fragmentsspeciaux.R;

public class PaypalFramgment extends DialogFragment {


    private EditText mEditText;
    private SimpleDialogListener listener;
    private Button btn;


    public PaypalFramgment() {
        // le fragment est créé par la méthode newInstance
    }

    public static PaypalFramgment newInstance(String title) {

        PaypalFramgment frag = new PaypalFramgment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_simple_dialog, container);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        listener = (SimpleDialogListener) getActivity();

        mEditText = (EditText) view.findViewById(R.id.name);
        btn = (Button) view.findViewById(R.id.ok);

        // quand le button est cliqué, l'activité est appellé,
        // la valeur mEditText est passeé à l'activité en paramètre

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onOkClickDialog(mEditText.getText().toString());
            }
        });

        String title = getArguments().getString("title", "Votre nom");

        getDialog().setTitle(title);

        mEditText.requestFocus();

        getDialog().getWindow().setSoftInputMode(

                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

    }


}
