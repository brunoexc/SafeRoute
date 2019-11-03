package ab.caride.saferoute.TelasJava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import ab.caride.saferoute.R;

public class AdministrarRota extends AppCompatActivity {

    Spinner combo_rotas_str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrar_rota);


        combo_rotas_str = new Spinner(this);

        combo_rotas_str = findViewById(R.id.combo_rotas_str);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.combo_rotas_str, android.R.layout.simple_spinner_item);
        combo_rotas_str.setAdapter(adapter);
    }
}
