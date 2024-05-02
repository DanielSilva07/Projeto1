package br.com.danielsilva.dao;

import br.com.danielsilva.Cliente;

import java.util.Collection;

public interface IClienteDAO {

    public  boolean cadastrar(Cliente cliente);
    public void excluir (Long cpf);
    public void alterar(Cliente cliente);
    public Cliente consultar (Long cpf);
    public Collection<Cliente> buscarTodos();

}
