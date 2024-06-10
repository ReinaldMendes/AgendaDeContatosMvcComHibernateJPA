package view;

import controller.ProfissaoController;
import modelo.Profissao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProfissaoView extends JFrame {
    private JPanel mainPanel;
    private JTextField descricaoField;
    private JButton salvarButton;
    private JButton listarButton;
    private JTextArea listarTextArea;
    private ProfissaoController profissaoController;

    public ProfissaoView() {
        profissaoController = new ProfissaoController();
        setContentPane(mainPanel);
        setTitle("Cadastro de Profissão");
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Profissao profissao = new Profissao();
                profissao.setDescricao(descricaoField.getText());
                profissaoController.adicionarProfissao(profissao);
                JOptionPane.showMessageDialog(null, "Profissão salva com sucesso!");
                limparCampos();
            }
        });

        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarProfissoes();
            }
        });
    }

    private void listarProfissoes() {
        List<Profissao> profissoes = profissaoController.listarProfissoes();
        listarTextArea.setText("");
        for (Profissao profissao : profissoes) {
            listarTextArea.append(profissao.toString() + "\n");
        }
    }

    private void limparCampos() {
        descricaoField.setText("");
    }

    public static void main(String[] args) {
        new ProfissaoView();
    }
}
