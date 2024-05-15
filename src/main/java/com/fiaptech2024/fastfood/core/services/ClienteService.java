package com.fiaptech2024.fastfood.core.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.InputMismatchException;
import java.util.UUID;

import com.fiaptech2024.fastfood.core.domain.Cliente;
import com.fiaptech2024.fastfood.core.applications.ports.ClienteServicePort;
import com.fiaptech2024.fastfood.core.applications.ports.ClienteRepositoryPort;
import com.fiaptech2024.fastfood.core.services.exception.RegraDeNegocioException;
import com.fiaptech2024.fastfood.core.services.exception.EntityNotFoundException;


public class ClienteService implements ClienteServicePort {

    private final ClienteRepositoryPort clienteRepositoryPort;

    public ClienteService(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
    }

    @Override
    public Cliente getClienteById(UUID id) {

        return clienteRepositoryPort.getClienteById(id);
                   
    }

    @Override
    public Cliente getClienteByCpf(String cpf) {

        if(!clienteRepositoryPort.existsClienteByCpf(cpf)){
            throw new EntityNotFoundException("CPF do cliente não localizado");
        }

        return clienteRepositoryPort.getClienteByCpf(cpf);
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {

        checkCliente(cliente);
        
        return clienteRepositoryPort.saveCliente(cliente);
    }

    private void checkCliente(Cliente cliente) {

        if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
            throw new RegraDeNegocioException("Nome é obrigatório");
        } 

        if (cliente.getCpf() == null || cliente.getCpf().isEmpty()) {
            throw new RegraDeNegocioException("CPF é obrigatório");
        } 

        if (!cliente.getCpf().matches("[0-9]*")){
            throw new RegraDeNegocioException("CPF deve conter apenas números");    
        }

        if(!isValidCPF(cliente.getCpf())){
            throw new RegraDeNegocioException("CPF inválido");
        }

        if(clienteRepositoryPort.existsClienteByCpf(cliente.getCpf())){
            throw new RegraDeNegocioException("CPF já cadastrado");
        }

        if (!isValidEmail(cliente.getEmail())){
            throw new RegraDeNegocioException("Email inválido");
        } 
    }   

    private static boolean isValidEmail(String email) {

        boolean isEmailIdValid = false;

        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }

        return isEmailIdValid;
    }    

    private static boolean isValidCPF(String cpf) {

		if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") ||
                cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
                || cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
                || cpf.equals("99999999999") || (cpf.length() != 11))
            return(false);
		
		char dig10, dig11;
		int sm, i, r, num, peso;
		
		try {
            sm = 0; peso = 10; for (i=0; i<9; i++) {
                num = (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            
            r = 11 - (sm % 11);
            
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
            	dig10 = (char)(r + 48);
            }
            
            sm = 0;
            peso = 11;
            
            for(i=0; i<10; i++) {
                num = (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            
            r = 11 - (sm % 11);
            
            if ((r == 10) || (r == 11)) {
            	dig11 = '0';
            } else {
            	dig11 = (char)(r + 48);
            }

            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) {
            	return(true);
            } else {
            	return(false);
            }

        } catch (InputMismatchException erro) {
            return(false);
        }
	}

}