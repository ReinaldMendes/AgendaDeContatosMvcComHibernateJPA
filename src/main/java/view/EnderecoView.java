package view;

import controller.EnderecoController;
import modelo.Endereco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EnderecoView extends JFrame {
    private EnderecoController enderecoController = new EnderecoController();

    private JTextField txtRua, txtCidade, txtEstado;
    private JButton btnSalvar, btnListar;

    public EnderecoView() {
        setTitle("Gerenciar Endereços");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        panel.add(new JLabel("Rua:"));
        txtRua = new JTextField();
        panel.add(txtRua);

        panel.add(new JLabel("Cidade:"));
        txtCidade = new JTextField();
        panel.add(txtCidade);

        panel.add(new JLabel("Estado:"));
        txtEstado = new JTextField();
        panel.add(txtEstado);

        btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvarEndereco();
            }
        });
        panel.add(btnSalvar);

        btnListar = new JButton("Listar Endereços");
        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarEnderecos();
            }
        });
        panel.add(btnListar);

        add(panel);
        setVisible(true);
    }

    private void salvarEndereco() {
        Endereco endereco = new Endereco();
        endereco.setRua(txtRua.getText());
        endereco.setCidade(txtCidade.getText());
        endereco.setEstado(txtEstado.getText());
        enderecoController.adicionarEndereco(endereco);
        JOptionPane.showMessageDialog(this, "Endereço salvo com sucesso!");
        txtRua.setText("");
        txtCidade.setText("");
        txtEstado.setText("");
    }

    private void listarEnderecos() {
        List<Endereco> enderecos = enderecoController.listarEnderecos();
        StringBuilder sb = new StringBuilder();
        for (Endereco endereco : enderecos) {
            sb.append("ID: ").append(endereco.getId()).append(", Rua: ").append(endereco.getRua())
              .append(", Cidade: ").append(endereco.getCidade()).append(", Estado: ").append(endereco.getEstado()).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString(), "Lista de Endereços", JOptionPane.INFORMATION_MESSAGE);
    }
}
