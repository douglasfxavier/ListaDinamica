package br.edu.ifpb.listadinemica3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity implements CadastroPaisAlertDialog.CadastroPaisListener {
    private ListView lvPaises;
    private List<String> listaPaises;
    private FloatingActionButton fabAddPais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        fabAddPais = findViewById(R.id.fabAddPais);
        lvPaises = findViewById(R.id.lvPaises);
        listaPaises = new ArrayList<String>();

//        popularLista();

        ArrayAdapter<String> listaAdapterPaises =
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_list_item_1,
                        listaPaises
                );

        lvPaises.setAdapter(listaAdapterPaises);

        fabAddPais.setOnClickListener(new FabAddPaisClickListener());
    }

    @Override
    public void cadastrarPais(String pais) {
        listaPaises.add(pais);
    }

//    private void popularLista(){
//        listaPaises.add("Alemanha");
//        listaPaises.add("Brasil");
//        listaPaises.add("Canadá");
//    }

    private class FabAddPaisClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            CadastroPaisAlertDialog cadastroPaisAlertDialog = new CadastroPaisAlertDialog();
            FragmentManager fragmentManager = getSupportFragmentManager();
            cadastroPaisAlertDialog.show(fragmentManager,"cadastro_pais");
        }
    }
}