package view;

import controller.TelefoneController;
import modelo.Telefone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelefoneView extends JFrame {
    private TelefoneController telefoneController = new TelefoneController();

    private JTextField txtNumero;
    private JButton btnSalvar, btnListar;

    public TelefoneView() {
        setTitle("Gerenciar Telefones");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("Número:"));
        txtNumero = new JTextField();
        panel.add(txtNumero);

        btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvarTelefone();
            }
        });
        panel.add(btnSalvar);

        btnListar = new JButton("Listar Telefones");
        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarTelefones();
            }
        });
        panel.add(btnListar);

        add(panel);
        setVisible(true);
    }

    private void salvarTelefone() {
        Telefone telefone = new Telefone();
        telefone.setNumero(txtNumero.getText());
        telefoneController.adicionarTelefone(telefone);
        JOptionPane.showMessageDialog(this, "Telefone salvo com sucesso!");
        txtNumero.setText("");
    }

    private void listarTelefones() {
        List<Telefone> telefones = telefoneController.listarTelefones();
        StringBuilder sb = new StringBuilder();
        for (Telefone telefone : telefones) {
            sb.append("ID: ").append(telefone.getId()).append(", Número: ").append(telefone.getNumero()).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString(), "Lista de Telefones", JOptionPane.INFORMATION_MESSAGE);
    }
}
