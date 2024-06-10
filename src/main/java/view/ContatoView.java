package view;

import controller.ContatoController;
import modelo.Contato;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ContatoView extends JFrame {
    private ContatoController contatoController = new ContatoController();

    private JTextField txtNome;
    private JButton btnSalvar, btnListar;

    public ContatoView() {
        setTitle("Gerenciar Contatos");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        panel.add(txtNome);

        btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvarContato();
            }
        });
        panel.add(btnSalvar);

        btnListar = new JButton("Listar Contatos");
        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarContatos();
            }
        });
        panel.add(btnListar);

        add(panel);
        setVisible(true);
    }

    private void salvarContato() {
        Contato contato = new Contato();
        contato.setNome(txtNome.getText());
        contatoController.adicionarContato(contato);
        JOptionPane.showMessageDialog(this, "Contato salvo com sucesso!");
        txtNome.setText("");
    }

    private void listarContatos() {
        List<Contato> contatos = contatoController.listarContatos();
        StringBuilder sb = new StringBuilder();
        for (Contato contato : contatos) {
            sb.append("ID: ").append(contato.getId()).append(", Nome: ").append(contato.getNome()).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString(), "Lista de Contatos", JOptionPane.INFORMATION_MESSAGE);
    }
}
