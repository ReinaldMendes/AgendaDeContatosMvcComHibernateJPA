package view;

import controller.UsuarioController;
import modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UsuarioView extends JFrame {
    private UsuarioController usuarioController = new UsuarioController();

    private JTextField txtNome, txtEmail;
    private JButton btnSalvar, btnListar;

    public UsuarioView() {
        setTitle("Gerenciar Usuários");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        panel.add(txtNome);

        panel.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        panel.add(txtEmail);

        btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvarUsuario();
            }
        });
        panel.add(btnSalvar);

        btnListar = new JButton("Listar Usuários");
        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarUsuarios();
            }
        });
        panel.add(btnListar);

        add(panel);
        setVisible(true);
    }

    private void salvarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNome(txtNome.getText());
        usuario.setEmail(txtEmail.getText());
        usuarioController.adicionarUsuario(usuario);
        JOptionPane.showMessageDialog(this, "Usuário salvo com sucesso!");
        txtNome.setText("");
        txtEmail.setText("");
    }

    private void listarUsuarios() {
        List<Usuario> usuarios = usuarioController.listarUsuarios();
        StringBuilder sb = new StringBuilder();
        for (Usuario usuario : usuarios) {
            sb.append("ID: ").append(usuario.getId()).append(", Nome: ").append(usuario.getNome()).append(", Email: ").append(usuario.getEmail()).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString(), "Lista de Usuários", JOptionPane.INFORMATION_MESSAGE);
    }
}
