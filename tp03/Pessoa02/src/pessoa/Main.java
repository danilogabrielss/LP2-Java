package pessoa;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Button;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Main extends Frame implements ActionListener {

    private ArrayList<Pessoa02> listaPessoa = new ArrayList<>();

    private static Button b1, b2, b3, b4;
    private static JFrame f;
    private static JPanel panelButton;
    private static JPanel panelBttn;
    private static ButtonGroup painelBtn;
    private static JPanel panelSup;
    private static Label labelNumero;
    private static TextField textFieldNumero;
    private static Label labelNome;
    private static TextField textFieldNome;
    private static Label labelSexo;
    private static JRadioButton btnSexoFem, btnSexoMasc;
    private static Label labelIdade;
    private static TextField textFieldIdade;

    public void GUI() {
        b1 = new Button("Ok");
        b2 = new Button("Limpar");
        b3 = new Button("Mostrar");
        b4 = new Button("Sair");
        f = new JFrame("FlowLayout");
        f.setSize(400, 180);
        panelSup = new JPanel();
        panelButton = new JPanel();
        panelBttn = new JPanel();
        painelBtn = new ButtonGroup();
        labelNumero = new Label("Numero:");
        textFieldNumero = new TextField();
        textFieldNumero.disable();
        labelNome = new Label("Nome:");
        textFieldNome = new TextField();
        labelSexo = new Label("Sexo:");
        btnSexoFem = new JRadioButton("F");
        btnSexoMasc = new JRadioButton("M");
        labelIdade = new Label("Idade:");
        textFieldIdade = new TextField();

        painelBtn.add(btnSexoFem);
        painelBtn.add(btnSexoMasc);
        panelBttn.add(btnSexoFem);
        panelBttn.add(btnSexoMasc);

        panelSup.setLayout(new GridLayout(4, 2, 10, 10));
        panelSup.add(labelNumero, BorderLayout.WEST);
        panelSup.add(textFieldNumero, BorderLayout.EAST);
        panelSup.add(labelNome, BorderLayout.WEST);
        panelSup.add(textFieldNome, BorderLayout.EAST);
        panelSup.add(labelSexo, BorderLayout.WEST);
        panelSup.add(panelBttn, BorderLayout.EAST);
        panelSup.add(labelIdade, BorderLayout.WEST);
        panelSup.add(textFieldIdade, BorderLayout.EAST);
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
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String nome = textFieldNome.getText();
            int idade = Integer.parseInt(textFieldIdade.getText());
            char sexo = 'a';
            if (btnSexoFem.isSelected()) {
                sexo = 'F';
            }
            if (btnSexoMasc.isSelected()) {
                sexo = 'M';
            }
            Pessoa02 pessoa = new Pessoa02(nome, sexo, idade);
            listaPessoa.add(pessoa);
        }
        if (ae.getSource() == b2) {
            textFieldNome.setText("");
            painelBtn.clearSelection();
            textFieldIdade.setText("");
        }

        if (ae.getSource() == b3) {
            String retorna = "";
            for (Pessoa02 p : listaPessoa) {
                retorna += p.toString();
            }
            JOptionPane.showMessageDialog(this, retorna);
        }

        if (ae.getSource()
                == b4) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.GUI();
    }
}
