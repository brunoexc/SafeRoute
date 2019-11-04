package ab.caride.saferoute.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import ab.caride.saferoute.Classes.Users;
import ab.caride.saferoute.R;

public class AdaptadorUsuario extends ArrayAdapter<Users> {


    TextView txt_user_id,txt_user_name, txt_user;


    public AdaptadorUsuario(Context context, List<Users> objects) {
        super(context, android.R.layout.simple_list_item_1, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Users usuario = getItem(position);

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_lista_usuarios, parent, false);

        txt_user_id = convertView.findViewById(R.id.txt_LUL_UserID);
        txt_user_name = convertView.findViewById(R.id.txt_LUL_UserName);
        txt_user = convertView.findViewById(R.id.txt_LUL_User);

        txt_user_id.setText(String.valueOf(usuario.id));
        txt_user_name.setText(usuario.name);
        txt_user.setText(usuario.user);



        return convertView;
    }
}
