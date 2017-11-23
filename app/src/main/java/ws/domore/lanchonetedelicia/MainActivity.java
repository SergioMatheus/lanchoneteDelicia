package ws.domore.lanchonetedelicia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) this.findViewById(R.id.text_view_title);
        textView.setText(R.string.products_title);

        ArrayList<Item> produto_list = new ArrayList<Item>();

        produto_list.add(new Item("Suco Onda Tropical", "R$10,00", "Um Suco composto de frutas tropicais batido na hora", "SUCOONDATROPICAL"));
        produto_list.add(new Item("Vitamina Planetaria", "R$25,00", "Vitamina que une a maior parte banana, whey protein e um pouco de mamao para dar um gosto diferencial", "VITAMINAPLANETARIA"));
        produto_list.add(new Item("Hamburguer Exagerado", "R$30,00", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec in pulvinar sem. Etiam aliquet ipsum eu arcu vestibulum, eget porta mi mattis. Suspendisse porttitor dignissim sollicitudin. Mauris facilisis, diam ac volutpat ultricies, nisl massa varius lacus, ac scelerisque nisi tortor in leo.", "HAMBURGUEREXAGERADO"));
        //criar categoria e mudar img
        produto_list.add(new Item("Pastel Super","R$12,00","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec in pulvinar sem. Etiam aliquet ipsum eu arcu vestibulum, eget porta mi mattis. Suspendisse porttitor dignissim sollicitudin. Mauris facilisis, diam ac volutpat ultricies, nisl massa varius lacus, ac scelerisque nisi tortor in leo.","PASTELSUPER"));
        produto_list.add(new Item("Empada Olho Grande","R$15,00","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec in pulvinar sem. Etiam aliquet ipsum eu arcu vestibulum, eget porta mi mattis. Suspendisse porttitor dignissim sollicitudin. Mauris facilisis, diam ac volutpat ultricies, nisl massa varius lacus, ac scelerisque nisi tortor in leo.","EMPADAOLHOGRANDE"));
        produto_list.add(new Item("Boliviado Quente","R$22,00","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec in pulvinar sem. Etiam aliquet ipsum eu arcu vestibulum, eget porta mi mattis. Suspendisse porttitor dignissim sollicitudin. Mauris facilisis, diam ac volutpat ultricies, nisl massa varius lacus, ac scelerisque nisi tortor in leo.","BOLIVIADOQUENTE"));
        produto_list.add(new Item("Quibe POP","R$5,00","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec in pulvinar sem. Etiam aliquet ipsum eu arcu vestibulum, eget porta mi mattis. Suspendisse porttitor dignissim sollicitudin. Mauris facilisis, diam ac volutpat ultricies, nisl massa varius lacus, ac scelerisque nisi tortor in leo.","QUIBEPOP"));
        produto_list.add(new Item("Esfirra do Sabor", "R$7,00", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec in pulvinar sem. Etiam aliquet ipsum eu arcu vestibulum, eget porta mi mattis. Suspendisse porttitor dignissim sollicitudin. Mauris facilisis, diam ac volutpat ultricies, nisl massa varius lacus, ac scelerisque nisi tortor in leo.", "ESFIRRADOSABOR"));
        produto_list.add(new Item("Crepioca Saborosa", "R$19,00", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec in pulvinar sem. Etiam aliquet ipsum eu arcu vestibulum, eget porta mi mattis. Suspendisse porttitor dignissim sollicitudin. Mauris facilisis, diam ac volutpat ultricies, nisl massa varius lacus, ac scelerisque nisi tortor in leo.", "CREPIOCASABOROSA"));
        produto_list.add(new Item("Pao de Nuvem", "R$10,50", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec in pulvinar sem. Etiam aliquet ipsum eu arcu vestibulum, eget porta mi mattis. Suspendisse porttitor dignissim sollicitudin. Mauris facilisis, diam ac volutpat ultricies, nisl massa varius lacus, ac scelerisque nisi tortor in leo.", "PAODENUVEM"));
        produto_list.add(new Item("Bruschetta Integral", "R$30,00", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec in pulvinar sem. Etiam aliquet ipsum eu arcu vestibulum, eget porta mi mattis. Suspendisse porttitor dignissim sollicitudin. Mauris facilisis, diam ac volutpat ultricies, nisl massa varius lacus, ac scelerisque nisi tortor in leo.", "BRUSCHETTAINTEGRAL"));

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

        ListView listView = (ListView) this.findViewById(R.id.list_view_produtos);

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
