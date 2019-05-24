package br.com.brunnomarcos.cadastroEtec.business;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.brunnomarcos.cadastroEtec.dao.CadastroDAO;
import br.com.brunnomarcos.cadastroEtec.model.Etec;
import br.com.etechoracio.common.business.BaseSB;

@Service
public class CadastroSB extends BaseSB {

	private CadastroDAO cadastroDAO;
	
	@Override
	protected void postConstructImpl() {
		cadastroDAO = getDAO(CadastroDAO.class);
		
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(Etec etec) {
		cadastroDAO.save(etec);
	}
}
