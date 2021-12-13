package tp;

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
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TpJava extends Frame implements ActionListener {

    private static Button btnPesquisa, btnAnterior, btnProximo;
    private static Frame frame;
    private static Panel panelSuperior;
    private static Panel panelInferior;
    private static Label lblNomePesquisa;
    private static TextField txtNomePesquisa;
    private static Label lblNome;
    private static TextField txtNome;
    private static Label lblSalario;
    private static TextField txtSalario;
    private static Label lblCargo;
    private static TextField txtCargo;
    private static Panel panelCenter;

    public void GUI() {
        btnPesquisa = new Button("Pesquisar");
        btnProximo = new Button("Proximo");
        btnAnterior = new Button("Anterior");
        frame = new Frame("FlowLayout");
        frame.setSize(350, 250);
        panelInferior = new Panel();
        panelSuperior = new Panel();
        panelCenter = new Panel();
        lblNomePesquisa = new Label("Nome:");
        txtNomePesquisa = new TextField();
        lblNome = new Label("Nome:");
        txtNome = new TextField();
        lblSalario = new Label("Salario:");
        txtSalario = new TextField();
        lblCargo = new Label("Cargo:");
        txtCargo = new TextField();

        panelSuperior.setLayout(new GridLayout(1, 2));
        panelSuperior.add(lblNomePesquisa, BorderLayout.WEST);
        panelSuperior.add(txtNomePesquisa, BorderLayout.EAST);
        panelInferior.setLayout((new GridLayout(4, 2)));
        panelInferior.add(lblNome, BorderLayout.WEST);
        panelInferior.add(txtNome, BorderLayout.EAST);
        panelInferior.add(lblSalario, BorderLayout.WEST);
        panelInferior.add(txtSalario, BorderLayout.EAST);
        panelInferior.add(lblCargo, BorderLayout.WEST);
        panelInferior.add(txtCargo, BorderLayout.EAST);
        panelInferior.add(btnAnterior, BorderLayout.WEST);
        panelInferior.add(btnProximo, BorderLayout.WEST);
        panelCenter.add(btnPesquisa, BorderLayout.CENTER);
        btnProximo.addActionListener(this);
        btnPesquisa.addActionListener(this);
        btnAnterior.addActionListener(this);
        frame.setLayout(new GridLayout(3, 1));
        frame.add(panelSuperior);
        frame.add(panelCenter);
        frame.add(panelInferior);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Conexion con = new Conexion();
        con.getConexion();
        TpJava tp = new TpJava();
        tp.GUI();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnPesquisa) {
            Connection con = null;
            try {
                String url = "jdbc:sqlserver://127.0.0.1\\SQLEXPRESS:1433;databaseName=aulajava;integratedSecurity=true";
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection(url);
                Statement st = con.createStatement();

                String x = "SELECT nome_func , sal_func , ds_cargo FROM tbfuncs INNER JOIN tbcargos "
                        + "ON tbcargos.cd_cargo = tbfuncs.cod_cargo WHERE nome_func = '" + txtNomePesquisa.getText() + "' ";
                ResultSet res = st.executeQuery(x);
                while(res.next()){
                    String returnTxtNome = res.getString("nome_func");
                    txtNome.setText(returnTxtNome);
                    String returnSalario = res.getString("sal_func");
                    txtSalario.setText(returnSalario);
                    String dscCargo = res.getString("ds_cargo");
                    txtCargo.setText(dscCargo);
                }
                //txtNome = res.toString();
            } catch (SQLException ex) {
                Logger.getLogger(TpJava.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TpJava.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (ae.getSource() == btnAnterior) {
            Connection con = null;
            try {
                String url = "jdbc:sqlserver://127.0.0.1\\SQLEXPRESS:1433;databaseName=aulajava;integratedSecurity=true";
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection(url);
                Statement st = con.createStatement();
                String x = "SELECT nome_func , sal_func , ds_cargo FROM tbfuncs INNER JOIN tbcargos "
                        + "ON tbcargos.cd_cargo = tbfuncs.cod_cargo";
                ResultSet res = st.executeQuery(x);
                while(res.previous()){
                    String returnTxtNome = res.getString("nome_func");
                    txtNome.setText(returnTxtNome);
                    String returnSalario = res.getString("sal_func");
                    txtSalario.setText(returnSalario);
                    String dscCargo = res.getString("ds_cargo");
                    txtCargo.setText(dscCargo);
                }                
            } catch (SQLException ex) {
                Logger.getLogger(TpJava.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TpJava.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (ae.getSource() == btnProximo) {
            Connection con = null;
            try {
                String url = "jdbc:sqlserver://127.0.0.1\\SQLEXPRESS:1433;databaseName=aulajava;integratedSecurity=true";
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection(url);
                Statement st = con.createStatement();
                String x = "SELECT nome_func , sal_func , ds_cargo FROM tbfuncs INNER JOIN tbcargos "
                        + "ON tbcargos.cd_cargo = tbfuncs.cod_cargo";
                ResultSet res = st.executeQuery(x);
                if(res.next()){
                    String returnTxtNome = res.getString("nome_func");
                    txtNome.setText(returnTxtNome);
                    String returnSalario = res.getString("sal_func");
                    txtSalario.setText(returnSalario);
                    String dscCargo = res.getString("ds_cargo");
                    txtCargo.setText(dscCargo);
                    //res.next();
                }
                //txtNome = res.toString();
            } catch (SQLException ex) {
                Logger.getLogger(TpJava.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TpJava.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

//lblNomePesquisa.getText();
//String y = "SELECT TOP 1 cod_func FROM tbfuncs ORDER BY cod_func DESC";
//ResultSet res = st.executeQuery(y);
//int resultado = res.getInt(0);
