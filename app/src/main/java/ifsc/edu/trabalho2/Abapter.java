package ifsc.edu.trabalho2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Abapter extends ArrayAdapter<ListaCompra> {
    private Context context;
    private int reusourse;
    public  Abapter(Context context, int reusorce, ArrayList<ListaCompra> lista){
        super(context,reusorce,lista);
        this.context = context;
        this.reusourse = reusorce;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(reusourse,parent,false);
        TextView textAnomes =(TextView) convertView.findViewById(R.id.textAnoMes);
        TextView textdesc =(TextView) convertView.findViewById(R.id.textDescricao);
        ListaCompra l=getItem(position);
        textAnomes.setText(l.buscarAnoMes());
        textdesc.setText(l.buscarDesc());
        return  convertView;
    }
}
