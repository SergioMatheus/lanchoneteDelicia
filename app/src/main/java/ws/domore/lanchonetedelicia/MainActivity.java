package ws.domore.lanchonetedelicia;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView)this.findViewById(R.id.text_view_title);
        textView.setText(R.string.products_title);

        ArrayList<Item> produto_list = new ArrayList<Item>();

        produto_list.add(new Item("Suco Onda Tropical","R$10,00","Um Suco composto de frutas tropicais batido na hora","SUCOONDATROPICAL"));
        produto_list.add(new Item("Vitamina Planetaria","R$25,00","Vitamina que une a maior parte banana, whey protein e um pouco de mamao para dar um gosto diferencial","VITAMINAPLANETARIA"));
//        produto_list.add("Hamburguer Exagerado");
//        produto_list.add("Pastel Super");
//        produto_list.add("Empada Olho Grande");
//        produto_list.add("Boliviado Quente");
//        produto_list.add("Quibe POP");
//        produto_list.add("Esfirra do Sabor");
//        produto_list.add("Crepioca Saborosa");
//        produto_list.add("Pao de Nuvem");
//        produto_list.add("Bruschetta Integral");
//        produto_list.add("Banana chips");
//        produto_list.add("Sopa Funcional");
//        produto_list.add("Sanduche Natureba");
//        produto_list.add("Salada  Surpresa");

        ArrayAdapter<Item> adapter = new ArrayAdapter<Item>(
                this,
                R.layout.list_item_produto,
                R.id.text_view_produto,
                produto_list
        );

        ListView listView = (ListView)this.findViewById(R.id.list_view_produtos);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(MainActivity.this, ActivityVisualizarItens.class);
                intent.putExtra("Item", (Serializable) adapterView.getItemAtPosition(position));
                startActivity(intent);
            }
        });
    }
}
