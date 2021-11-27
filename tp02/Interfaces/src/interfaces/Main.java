package interfaces;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class Main extends Frame implements ActionListener {

    private static Label l1 = new Label("O botão ainda nao foi pressionado");
    private ArrayList<Aluno> listaAluno = new ArrayList<>();

    private static JButton b1, b2, b3, b4;
    private static JFrame f;
    private static JPanel panelButton;
    private static Panel panelSup;
    private static Label labelNome;
    private static TextField textFieldNome;
    private static Label labelIdade;
    private static TextField textFieldIdade;
    private static Label labelEndereco;
    private static TextField textFieldEndereco;

    public void GUI() {
        b1 = new JButton("Ok");
        b2 = new JButton("Limpar");
        b3 = new JButton("Mostrar");
        b4 = new JButton("Sair");
        f = new JFrame("FlowLayout");
        f.setSize(400, 180);
        panelSup = new Panel();
        panelButton = new JPanel();
        labelNome = new Label("Nome:");
        textFieldNome = new TextField();
        labelIdade = new Label("Idade:");
        textFieldIdade = new TextField();
        labelEndereco = new Label("Endereco:");
        textFieldEndereco = new TextField();
        panelSup.setLayout(new GridLayout(4, 2, 10, 10));
        panelSup.add(labelNome, BorderLayout.WEST);
        panelSup.add(textFieldNome, BorderLayout.EAST);
        panelSup.add(labelIdade, BorderLayout.WEST);
        panelSup.add(textFieldIdade, BorderLayout.EAST);
        panelSup.add(labelEndereco, BorderLayout.WEST);
        panelSup.add(textFieldEndereco, BorderLayout.EAST);
        panelSup.add(l1, BorderLayout.CENTER);
        panelButton.setLayout(new GridLayout(1, 4));
        panelButton.add(b1);
        panelButton.add(b2);
        panelButton.add(b3);
        panelButton.add(b4);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        f.add(panelSup);
        f.add(panelButton, BorderLayout.SOUTH);
        f.setVisible(true);
        f.show();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String nome = textFieldNome.getText();
            int idade = Integer.parseInt(textFieldIdade.getText());
            String endereco = textFieldEndereco.getText();
            Aluno aluno = new Aluno(endereco, idade, nome);
            listaAluno.add(aluno);
        }
        if (ae.getSource() == b2) {
            l1.setText("O botão ainda nao foi pressionado");
            textFieldNome.setText("");
            textFieldEndereco.setText("");
            textFieldIdade.setText("");
        }
        if (ae.getSource() == b3) {
            l1.setText("");
            String retorna = "";
            for (Aluno a : listaAluno) {
                retorna += (l1.getText() + a.toString());
            }
            JOptionPane.showMessageDialog(this, retorna);
        }
        if (ae.getSource() == b4) {
            System.exit(0);
        }
    }

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        Main main = new Main();
        main.GUI();
    }
}
