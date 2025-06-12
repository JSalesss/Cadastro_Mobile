package com.joao.applistacursos.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.applistacursos.R;
import com.joao.applistacursos.controller.ControllerDB;
import com.joao.applistacursos.controller.CursoController;
import com.joao.applistacursos.controller.PessoaController;
import com.joao.applistacursos.controller.SpinnerController;
import com.joao.applistacursos.model.Curso;
import com.joao.applistacursos.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    private EditText editNome, editSobrenome, editTelefone;
    private Button btnSalvar, btnLimpar, btnFinalizar;
    private PessoaController pessoaController;
    private CursoController cursoController;
    private SpinnerController spinnerController;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editNome = findViewById(R.id.editTextText);
        editSobrenome = findViewById(R.id.editTextText2);
        editTelefone = findViewById(R.id.editTextText4);
        spinner = findViewById(R.id.spinner_cursos);

        btnSalvar = findViewById(R.id.salvar);
        btnLimpar = findViewById(R.id.limpar);
        btnFinalizar = findViewById(R.id.finalizar);

        pessoaController = new PessoaController(this);
        cursoController = new CursoController(this);
        Curso curso = new Curso(this);
        spinnerController = new SpinnerController(this, spinner);

        ControllerDB db = new ControllerDB(this);

        btnSalvar.setOnClickListener(view -> {
            Pessoa pessoa = new Pessoa(
                    editNome.getText().toString(),
                    editSobrenome.getText().toString(),
                    editTelefone.getText().toString()
            );
            String cursoSelecionado = spinnerController.getCursoSelecionado();

            if (!pessoaController.validarPessoa(pessoa) || cursoSelecionado.equals("Selecione um curso")) {
                Toast.makeText(this, "Preencha todos os campos corretamente!", Toast.LENGTH_SHORT).show();
                return;
            }

            db.inserirDados(pessoa.getNome(),pessoa.getSobrenome(), pessoa.getTelefone(), curso.getNomeCurso());
            pessoaController.salvarPessoa(pessoa);
            cursoController.salvarCurso(new Curso(cursoSelecionado));
            Toast.makeText(this, "Dados salvos com sucesso!", Toast.LENGTH_SHORT).show();
        });

        btnLimpar.setOnClickListener(view ->  {
            pessoaController.apagarPessoa();
            cursoController.apagarCurso();
            editNome.setText("");
            editSobrenome.setText("");
            editTelefone.setText("");
            spinnerController.resetar();
            Toast.makeText(this, "Campos limpos", Toast.LENGTH_SHORT).show();
        });

        btnFinalizar.setOnClickListener(view ->  {
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
        spinnerController.selecionarCurso(curso.getNomeCurso());
    }
}