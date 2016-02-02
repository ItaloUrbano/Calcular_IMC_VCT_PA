package projeto.ifpb.edu.br.calcular_imc_vct_pa;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttEnviar = (Button)findViewById(R.id.buttEnviar);
        buttEnviar.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Log.i("Calcular_IMC_VCT_PA", "Clique no botão da ENVIAR");

                EditText EditTextNome = (EditText) findViewById(R.id.EditTextNome);
                String nome = EditTextNome.getText().toString();

                LoginAsyncTask loginAsyncTask = new LoginAsyncTask(v.getContext());
                String[] valores = {nome};

                loginAsyncTask.execute(valores);
            }
        });
    }
}