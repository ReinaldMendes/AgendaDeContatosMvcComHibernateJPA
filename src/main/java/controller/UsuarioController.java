package controller;

import dao.UsuarioDAO;
import modelo.Usuario;

import java.util.List;

public class UsuarioController {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public void adicionarUsuario(Usuario usuario) {
        usuarioDAO.salvar(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioDAO.listar();
    }

    public void atualizarUsuario(Usuario usuario) {
        usuarioDAO.atualizar(usuario);
    }

    public void deletarUsuario(Long id) {
        usuarioDAO.deletar(id);
    }

    public Usuario obterUsuario(Long id) {
        return usuarioDAO.obter(id);
    }
}
