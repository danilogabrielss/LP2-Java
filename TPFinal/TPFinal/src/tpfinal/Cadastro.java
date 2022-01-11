package tpfinal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Cadastro extends Frame implements ActionListener {

    Aluno aluno = new Aluno();
    private static final long serialVersionUID = 1L;
    Button incluir, limpar, apresentar, sair;
    Label labelNome, labelIdade, labelPeso, labelAltura, labelObjetivo;
    TextField tfNome, tfIdade, tfPeso, tfAltura, tfObjetivo;
    Panel panelEntrada, panelBotoes;

    public void GUI() {
        Frame frame = new Frame();
        incluir = new Button("Incluir");
        limpar = new Button("Limpar");
        apresentar = new Button("Apresenta");
        sair = new Button("Sair");
        labelNome = new Label("Nome");
        tfNome = new TextField();
        labelIdade = new Label("Idade");
        tfIdade = new TextField();
        labelPeso = new Label("Peso");
        tfPeso = new TextField();
        labelAltura = new Label("Altura");
        tfAltura = new TextField();
        labelObjetivo = new Label("Objetivo");
        tfObjetivo = new TextField();
        panelEntrada = new Panel();
        panelBotoes = new Panel();

        panelEntrada.setLayout(new GridLayout(6, 2));
        panelEntrada.add(labelNome);
        panelEntrada.add(tfNome);
        panelEntrada.add(labelIdade);
        panelEntrada.add(tfIdade);
        panelEntrada.add(labelPeso);
        panelEntrada.add(tfPeso);
        panelEntrada.add(labelAltura);
        panelEntrada.add(tfAltura);
        panelEntrada.add(labelObjetivo);
        panelEntrada.add(tfObjetivo);
        panelBotoes.setLayout(new GridLayout(1, 4));
        panelBotoes.setSize(500, 150);
        panelBotoes.add(incluir);
        panelBotoes.add(limpar);
        panelBotoes.add(apresentar);
        panelBotoes.add(sair);

        incluir.addActionListener(this);
        limpar.addActionListener(this);
        apresentar.addActionListener(this);
        sair.addActionListener(this);

        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(2, 1));
        frame.add(panelEntrada);
        frame.add(panelBotoes);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == incluir) {
            Connection con = null;
            try {
                String url = "jdbc:sqlserver://127.0.0.1\\SQLEXPRESS:1433;databaseName=TPFinalJava;integratedSecurity=true";
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection(url);
                Statement st = con.createStatement();

                String nome = tfNome.getText();
                String idade = tfIdade.getText();
                String peso = tfPeso.getText();
                String altura = tfAltura.getText();
                String objetivo = tfObjetivo.getText();
                String query = "INSERT INTO tbalunos (nome_aluno, idade_aluno, peso_aluno, altura_aluno, objetivo)"
                        + " VALUES ('" + nome + "', " + idade + ", " + peso + ", " + altura + ", '" + objetivo + "');";
                st.executeUpdate(query);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        if (ae.getSource() == limpar) {
            tfNome.setText("");
            tfIdade.setText("");
            tfPeso.setText("");
            tfAltura.setText("");
            tfObjetivo.setText("");
        }

        if (ae.getSource() == apresentar) {
            Connection con = null;
            try {
                String url = "jdbc:sqlserver://127.0.0.1\\SQLEXPRESS:1433;databaseName=TPFinalJava;integratedSecurity=true";
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection(url);
                Statement st = con.createStatement();

                String query = "SELECT nome_aluno, idade_aluno, peso_aluno, altura_aluno, objetivo FROM tbalunos WHERE nome_aluno = '" + tfNome.getText() + "';";
                ResultSet res = st.executeQuery(query);
                String retorno = "";

                while (res.next()) {
                    aluno.setNome(res.getString("nome_aluno"));
                    aluno.setIdade(res.getInt("idade_aluno"));
                    aluno.setAltura(res.getFloat("altura_aluno"));
                    aluno.setPeso(res.getFloat("peso_aluno"));
                    aluno.setObjetivo(res.getString("objetivo"));
                }
                retorno += "{Nome: " + aluno.getNome() + ","
                        + "Idade: " + aluno.getIdade() + ","
                        + "Peso: " + aluno.getPeso() + ","
                        + "Altura: " + aluno.getAltura() + ","
                        + "Objetivo: " + aluno.getObjetivo()+"}";

                JsonParser parser = new JsonParser();
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                JsonElement el = parser.parse(retorno);
                retorno = gson.toJson(el);
                
                JOptionPane.showMessageDialog(null, retorno);
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        if (ae.getSource() == sair) {
            System.exit(0);
        }
    }

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        Cadastro cadastro = new Cadastro();
        cadastro.GUI();
    }

}
