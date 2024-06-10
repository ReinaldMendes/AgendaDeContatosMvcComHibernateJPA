package controller;

import dao.TelefoneDAO;
import modelo.Telefone;

import java.util.List;


public class TelefoneController {
    private TelefoneDAO telefoneDAO = new TelefoneDAO();

    public void adicionarTelefone(Telefone telefone) {
        telefoneDAO.salvar(telefone);
    }

    public List<Telefone> listarTelefones() {
        return telefoneDAO.listar();
    }

    public void atualizarTelefone(Telefone telefone) {
        telefoneDAO.atualizar(telefone);
    }

    public void deletarTelefone(Long id) {
        telefoneDAO.deletar(id);
    }

    public Telefone obterTelefone(Long id) {
        return telefoneDAO.obter(id);
    }
}
