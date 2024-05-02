package br.com.danielsilva.dao;

import br.com.danielsilva.Cliente;

import javax.swing.*;

public class App {

    private static IClienteDAO iClienteDAO;

    public static void main (String Args []){

         iClienteDAO = new ClienteMapDAO();

        String opcao = JOptionPane.showInputDialog( null , "Digite 1 para cadastro , 2 para consultar, 3 para exclusao, 4 para alteracao ou 5 para sair",
        "Cadastro" , JOptionPane.INFORMATION_MESSAGE);

        while (isOpcaoValida(opcao)){
            if (isOpcaoSair(opcao)){
                sair();
            }
             else if (isCadastro(opcao)){
                String dados = JOptionPane.showInputDialog( null , "Digite os dados do cliente separado por virgula, Exemplo : Nome , CPF , Tel ",
                        "Cadastro" , JOptionPane.INFORMATION_MESSAGE);
                

                cadastrar(dados);
            }
        }

        while (!isOpcaoValida(opcao)){
            if ("".equals(opcao)){
                sair();

            }
            opcao = JOptionPane.showInputDialog( null , "Opcao invalida , Digite 1 para cadastro , 2 para consultar, 3 para exclusao, 4 para alteracao ou 5 para sair",
                    "Cadastro" , JOptionPane.INFORMATION_MESSAGE);

        }


    }

    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split( " , ");
        Cliente cliente = new Cliente(dadosSeparados [0], dadosSeparados [1], dadosSeparados [2], dadosSeparados[3], dadosSeparados[4] , dadosSeparados[5],dadosSeparados[6] );
        boolean iscadastrado =  iClienteDAO.cadastrar(cliente);
        if (iscadastrado){
            JOptionPane.showMessageDialog(null ,"Cliente cadastrado com sucesso" ,"Sucesso" , JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null ,"Cliente ja cadastrado " ,"Sucesso" , JOptionPane.INFORMATION_MESSAGE);
        }



    }


    private static boolean isCadastro(String opcao) {
        if ("1".equals(opcao)){
            return true;
        }
        return false;
    }

    private static boolean isOpcaoSair(String opcao) {
        if ("5".equals(opcao)){
            return true;
        }
        return false;
    }

    private static void sair() {
        JOptionPane.showMessageDialog( null , "até logo", "Sair" , JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);

    }

    private static boolean isOpcaoValida(String opcao) {
        if ("1".equals(opcao) || "2".equals(opcao)
            || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao)){
            return true;
        }
        return false;
    }
}
