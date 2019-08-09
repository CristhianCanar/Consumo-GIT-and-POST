package com.senasoft.consumogetandpost.control;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.senasoft.consumogetandpost.R;
import com.senasoft.consumogetandpost.model.Producto;
import com.senasoft.consumogetandpost.services.PostServices;

import org.json.JSONException;
import org.json.JSONObject;

public class PostArticle extends AppCompatActivity {

    public static String URLDOMAIN = "";//falta ruta
    String urlPost = "savearticle";


    EditText name,volume,value, stock, urlImage;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_article);

        name = findViewById(R.id.edNamePost);
        volume = findViewById(R.id.edVolumePost);
        value = findViewById(R.id.edValuePost);
        stock = findViewById(R.id.edStockPost);
        urlImage = findViewById(R.id.edUrlImagePost);

        btnEnviar = findViewById(R.id.btnEnviarPost);




        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Producto producto = new Producto();
                producto.setNameProduct(name.getText().toString());
                producto.setVolumeProduct(volume.getText().toString());
                producto.setValueProduct(value.getText().toString());
                producto.setStockProduct(stock.getText().toString());
                producto.setUrlImageProduct(urlImage.getText().toString());
                postArticle(producto);
            }
        });



    }

    private void postArticle(Producto producto) {
        String urlSave = URLDOMAIN+urlPost;

        PostServices services = (PostServices) new PostServices(new PostServices.AsyncResponse() {
            @Override
            public void processFinish(String output) {
                if(output != null){
                    try {
                        Log.e("LOGG",output);
                        JSONObject res = new JSONObject();

                        if (!res.isNull("result")){
                            JSONObject resultado = res.getJSONObject("result");
                            Log.e("LOGG",resultado.toString());

                            resultado.getString("message");
                            Log.e("LOGG",resultado.getString("message"));
                            Toast.makeText(PostArticle.this, "Se cargaron los datos", Toast.LENGTH_SHORT).show();

                        }else {
                            Toast.makeText(PostArticle.this, "No se cargaron los datos", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).execute(urlSave,producto.getNameProduct(),producto.getVolumeProduct(),producto.getValueProduct(),
                producto.getStockProduct(),producto.getUrlImageProduct());
    }
}
