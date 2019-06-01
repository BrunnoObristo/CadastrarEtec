package br.com.brunnomarcos.cadastroEtec.business;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
	public void save(Etec etec) throws Exception {
		
		Etec existe = cadastroDAO.findByNomeOrCodigo(etec.getNome(), etec.getCodigo());
		
		if (existe !=null) {
			throw new Exception("Este usuário já existe");
		}
		else {
		cadastroDAO.save(etec);
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void remove(Etec etec) {
		cadastroDAO.delete(etec);
	}
		
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Etec> findAll() {
		return cadastroDAO.findAll();
	}
	
}

