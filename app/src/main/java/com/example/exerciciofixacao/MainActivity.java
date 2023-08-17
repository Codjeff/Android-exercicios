package com.example.exerciciofixacao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    public float cvalor, rvalor, svalor, result;
    EditText cquantidade, rquantidade, squantidade;
    TextView totalpedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cvalor = 2.00f;
        rvalor = 2.50f;
        svalor = 1.50f;

        cquantidade = findViewById(R.id.qtdCachorroQuente);
        rquantidade = findViewById(R.id.qtdRefrigerante);
        squantidade = findViewById(R.id.qtdSobremesa);
        totalpedido = findViewById(R.id.txtvalortotal);

        // pegando o video view
        VideoView video = findViewById(R.id.vv);

        //adicionei uam videoView mostrando as imagens do cardapio
        Uri src = Uri.parse("android.resource://com.example.exercicofixacao/raw/testingClip");
        video.setVideoURI(src);

        video.setMediaController(new MediaController(this));

    }

    public void btncalcular(View v) {

        totalpedido.setText(String.valueOf(valortotal()));

    }

    private float valortotal() {
        float c = Integer.parseInt(cquantidade.getText().toString());
        float r = Integer.parseInt(rquantidade.getText().toString());
        float s = Integer.parseInt(squantidade.getText().toString());

        result = (c * cvalor) + (r * rvalor) + (s * svalor);

        return result;
    }
    public void btnproximo(View s) {
        Intent intent = new Intent(this, exercicio2.class);
        startActivity(intent);
    }
}