package com.joaofelipe.cadastrousuario;

//Bloco de importações
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

//Classe principal
public class CreateUser extends AppCompatActivity {

    TextInputEditText editNome, editEmail;
    Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        //Vincula variável com elemento da interface gráfica, escrito
        editNome = findViewById(R.id.nome_completo);
        editEmail = findViewById(R.id.email);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(View v -> {
            String nome = editNome.getText().toString();
            String email = editEmail.getText().toString();

            if(!nome.isEmpty()){
                MainActivity.litaNomes.add(nome + " (" + email + ") ");
                finish();
            }
        });
    }
}
