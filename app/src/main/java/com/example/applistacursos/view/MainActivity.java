package com.example.applistacursos.view;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.applistacursos.R;
import com.example.applistacursos.controller.CursoController;
import com.example.applistacursos.controller.PessoaController;
import com.example.applistacursos.model.Curso;
import com.example.applistacursos.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    private EditText editNome, editSobrenome, editTelefone;
    private Button btnSalvar, btnLimpar, btnFinalizar;
    private PessoaController pessoaController;
    private CursoController cursoController;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner_cursos);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.lista_cursos,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCourse = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Selecionado: " + selectedCourse, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        pessoaController = new PessoaController(this);
        cursoController = new CursoController(this);

        editNome = findViewById(R.id.editTextText);
        editSobrenome = findViewById(R.id.editTextText2);
        editTelefone = findViewById(R.id.editTextText4);

        btnSalvar = findViewById(R.id.salvar);
        btnLimpar = findViewById(R.id.limpar);
        btnFinalizar = findViewById(R.id.finalizar);

        btnSalvar.setOnClickListener(v -> {
            String cursoSelecionado = spinner.getSelectedItem().toString();
            Pessoa pessoa = new Pessoa(
                    editNome.getText().toString(),
                    editSobrenome.getText().toString(),
                    editTelefone.getText().toString()
            );
            Curso curso = new Curso(
                    cursoSelecionado
            );
            limparDados();
            pessoaController.salvarPessoa(pessoa);
            cursoController.salvarCurso(curso);
            Toast.makeText(this, pessoa.toString(), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, curso.toString(), Toast.LENGTH_SHORT).show();
        });

        btnLimpar.setOnClickListener(v -> {
            limparDados();
            cursoController.apagarCurso();
            pessoaController.apagarPessoa();
            spinner.setSelection(0);
            Toast.makeText(this, "Campos de dados limpos", Toast.LENGTH_SHORT).show();
        });

        btnFinalizar.setOnClickListener(v -> {
            Toast.makeText(this, "Volte sempre!", Toast.LENGTH_SHORT).show();
            finish();
        });
        carregarDadosSalvos();
    }

    private void carregarDadosSalvos() {
        Pessoa pessoa = pessoaController.carregarPessoa();
        Curso curso = cursoController.carregarCurso();
        editNome.setText(pessoa.getNome());
        editSobrenome.setText(pessoa.getSobrenome());
        editTelefone.setText(pessoa.getTelefone());

        String cursoSalvo = curso.getNomeCurso();

        ArrayAdapter <CharSequence> adapter = (ArrayAdapter<CharSequence>) spinner.getAdapter();

        int position = adapter.getPosition(cursoSalvo);
            if (position >= 0) {
                spinner.setSelection(position);
            }
    }

    private void limparDados() {
        editNome.setText("");
        editSobrenome.setText("");
        editTelefone.setText("");
    }
}
