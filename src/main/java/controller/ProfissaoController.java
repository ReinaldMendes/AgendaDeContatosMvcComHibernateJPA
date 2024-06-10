package controller;

import dao.ProfissaoDAO;
import modelo.Profissao;

import java.util.List;

public class ProfissaoController {
    private ProfissaoDAO profissaoDAO = new ProfissaoDAO();

    public void adicionarProfissao(Profissao profissao) {
        profissaoDAO.salvar(profissao);
    }

    public List<Profissao> listarProfissoes() {
        return profissaoDAO.listar();
    }

    public void atualizarProfissao(Profissao profissao) {
        profissaoDAO.atualizar(profissao);
    }

    public void deletarProfissao(Long id) {
        profissaoDAO.deletar(id);
    }

    public Profissao obterProfissao(Long id) {
        return profissaoDAO.obter(id);
    }
}
