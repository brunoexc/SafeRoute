package ab.caride.saferoute;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ConsultarRota extends AppCompatActivity {

    Spinner combo_rotas_str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_rota);


        combo_rotas_str = new Spinner(this);

        combo_rotas_str = findViewById(R.id.combo_rotas_consultar);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.combo_rotas_str, android.R.layout.simple_spinner_item);
        combo_rotas_str.setAdapter(adapter);
    }
}
