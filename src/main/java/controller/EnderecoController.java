package controller;

import dao.EnderecoDAO;
import modelo.Endereco;

import java.util.List;

public class EnderecoController {
    private EnderecoDAO enderecoDAO = new EnderecoDAO();

    public void adicionarEndereco(Endereco endereco) {
        enderecoDAO.salvar(endereco);
    }

    public List<Endereco> listarEnderecos() {
        return enderecoDAO.listar();
    }

    public void atualizarEndereco(Endereco endereco) {
        enderecoDAO.atualizar(endereco);
    }

    public void deletarEndereco(Long id) {
        enderecoDAO.deletar(id);
    }

    public Endereco obterEndereco(Long id) {
        return enderecoDAO.obter(id);
    }
}
