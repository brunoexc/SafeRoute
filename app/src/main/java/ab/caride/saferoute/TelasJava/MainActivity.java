package ab.caride.saferoute.TelasJava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import ab.caride.saferoute.R;

public class MainActivity extends AppCompatActivity {

    public String input_user, input_password, super_user, super_password;
    public EditText get_user, get_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        super_user = "admin"; super_password = "admin";

        //user_controller = new UserController(this);

        //helper = new Database(this);
        //db = helper.getWritableDatabase();
    }


    public void OnClickbuttonAcessar(){

        get_user = (EditText) findViewById(R.id.txt_input_Login);
        input_user = get_user.getText().toString();

        get_password = (EditText) findViewById(R.id.txt_input_Password);
        input_password = get_password.getText().toString();


        if (input_user.equals(super_user) && input_password.equals(super_password)){

            Toast.makeText(this, "Bem vindo!", Toast.LENGTH_SHORT).show();
            Intent call_activity_menu = new Intent(this, MenuPrincipal.class);
            this.startActivity(call_activity_menu);
            finish();
        }
        else{

            Boolean validate_user = false;

            //validate_user = user_controller.ReadUser(input_user, input_password, validate_user);

            if (validate_user == true){

                Toast.makeText(this, "Bem vindo!", Toast.LENGTH_SHORT).show();
                Intent call_activity_menu = new Intent(this, MenuPrincipal.class);
                this.startActivity(call_activity_menu);
                finish();
            }
            else{

                Toast.makeText(this, "Usuário ou Senha Incorreto(s)", Toast.LENGTH_SHORT).show();
            }
        }


    }
}
