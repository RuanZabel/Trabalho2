package ifsc.edu.trabalho2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterItens extends ArrayAdapter<ItensCompra> {
    private Context context;
    private int reusourse;
    public  AdapterItens(Context context, int reusorce, ArrayList<ItensCompra> lista){
        super(context,reusorce,lista);
        this.context = context;
        this.reusourse = reusorce;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(reusourse,parent,false);
        TextView produto =(TextView) convertView.findViewById(R.id.textAnoMes);
        TextView qtd =(TextView) convertView.findViewById(R.id.textDescricao);

        ItensCompra l=getItem(position);
        produto.setText(l.getProduto());
        qtd.setText(String.valueOf(l.getQuantidade()));
        //id.setText(String.valueOf(l.buscarId()));
        return  convertView;
    }
}
