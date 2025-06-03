package com.example.applistacursos.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.applistacursos.R;
import com.example.applistacursos.controller.CursoController;
import com.example.applistacursos.controller.PessoaController;
import com.example.applistacursos.model.Curso;
import com.example.applistacursos.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    private EditText editNome, editSobrenome, editTelefone, editCurso;
    private Button btnSalvar, btnLimpar, btnFinalizar;
    private PessoaController pessoaController;
    private CursoController cursoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        pessoaController = new PessoaController(this);
        cursoController = new CursoController(this);

        editNome = findViewById(R.id.editTextText);
        editSobrenome = findViewById(R.id.editTextText2);
        editCurso = findViewById(R.id.editTextText3);
        editTelefone = findViewById(R.id.editTextText4);

        btnSalvar = findViewById(R.id.salvar);
        btnLimpar = findViewById(R.id.limpar);
        btnFinalizar = findViewById(R.id.finalizar);

        btnSalvar.setOnClickListener(v -> {
            Pessoa pessoa = new Pessoa(
                    editNome.getText().toString(),
                    editSobrenome.getText().toString(),
                    editTelefone.getText().toString()
            );
            Curso curso = new Curso(editCurso.getText().toString());
            
            pessoaController.salvarPessoa(pessoa);
            cursoController.salvarCurso(curso);
        });

        btnLimpar.setOnClickListener(v -> {
            editNome.setText("");
            editSobrenome.setText("");
            editCurso.setText("");
            editTelefone.setText("");
        });

        btnFinalizar.setOnClickListener(v -> {
            Toast.makeText(this, "Volte sempre! ", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
