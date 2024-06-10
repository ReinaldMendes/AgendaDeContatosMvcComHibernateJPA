package controller;

import dao.ContatoDAO;
import modelo.Contato;

import java.util.List;

public class ContatoController {
    private ContatoDAO contatoDAO = new ContatoDAO();

    public void adicionarContato(Contato contato) {
        contatoDAO.salvar(contato);
    }

    public List<Contato> listarContatos() {
        return contatoDAO.listar();
    }

    public void atualizarContato(Contato contato) {
        contatoDAO.atualizar(contato);
    }

    public void deletarContato(Long id) {
        contatoDAO.deletar(id);
    }

    public Contato obterContato(Long id) {
        return contatoDAO.obter(id);
    }
}
