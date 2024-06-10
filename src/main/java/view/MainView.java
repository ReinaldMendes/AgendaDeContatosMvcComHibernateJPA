package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//
public class MainView extends JFrame {
    public MainView() {
        setTitle("Agenda de Contatos");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JButton btnContatos = new JButton("Gerenciar Contatos");
        JButton btnUsuarios = new JButton("Gerenciar Usuários");
        JButton btnEnderecos = new JButton("Gerenciar Endereços");
        JButton btnTelefones = new JButton("Gerenciar Telefones");
        JButton btnProfissoes = new JButton("Gerenciar Profissões");

        btnContatos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ContatoView();
            }
        });

        btnUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new UsuarioView();
            }
        });

        btnEnderecos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new EnderecoView();
            }
        });

        btnTelefones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelefoneView();
            }
        });

        btnProfissoes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ProfissaoView();
            }
        });

        panel.add(btnContatos);
        panel.add(btnUsuarios);
        panel.add(btnEnderecos);
        panel.add(btnTelefones);
        panel.add(btnProfissoes);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainView();
    }
}
