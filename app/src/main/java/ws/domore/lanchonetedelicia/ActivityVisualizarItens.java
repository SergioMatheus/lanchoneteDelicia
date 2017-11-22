package ws.domore.lanchonetedelicia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityVisualizarItens extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_item);

        Item item=(Item) getIntent().getSerializableExtra("Item");

        ImageView imagem = (ImageView)
                findViewById(R.id.imagemItem);
        TextView nomeItem = (TextView)
                findViewById(R.id.nomeItem);
        TextView valorItem = (TextView)
                findViewById(R.id.valorItem);
        TextView descricaoItem = (TextView)
                findViewById(R.id.descricaoItem);

        nomeItem.setText(item.getNome());
        valorItem.setText(item.getValor());
        descricaoItem.setText(item.getDescricao());
        Categoria categoria = item.getCategoria();
        if (categoria.equals(Categoria.SUCOONDATROPICAL)){
            imagem.setImageResource(R.drawable.suco_tropical);
        }else if(categoria.equals(Categoria.VITAMINAPLANETARIA)){
            imagem.setImageResource(R.drawable.vitamina_planetaria);
        }
    }
}
