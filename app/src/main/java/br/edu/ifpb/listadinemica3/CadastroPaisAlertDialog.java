package br.edu.ifpb.listadinemica3;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class CadastroPaisAlertDialog extends DialogFragment {
    private EditText etPais;
    private CadastroPaisListener cadastroPaisListener;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Adicionar país");

        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View formCadastroPais = inflater.inflate(R.layout.cadastropais_alertdialog,null);

        etPais =  formCadastroPais.findViewById(R.id.etPais);

        builder.setView(formCadastroPais)
                .setPositiveButton(R.string.cadastrar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String pais = String.valueOf(etPais.getText());
                        cadastroPaisListener.cadastrarPais(pais);
                        Log.i("APP",pais);
                    }
                });

        return builder.create();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            cadastroPaisListener = (CadastroPaisListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "precisa implementar a interface CadastroPaisListener");
        }
    }
    public interface CadastroPaisListener{
        void cadastrarPais(String pais);
    }
}
