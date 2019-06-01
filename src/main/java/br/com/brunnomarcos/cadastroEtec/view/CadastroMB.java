package br.com.brunnomarcos.cadastroEtec.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import br.com.brunnomarcos.cadastroEtec.business.CadastroSB;
import br.com.brunnomarcos.cadastroEtec.model.Etec;
import br.com.etechoracio.common.view.BaseMB;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Controller
@Scope("view")
public class CadastroMB extends BaseMB {
	
	@Autowired
	private CadastroSB cadastroSB;
	
	
	private List<Etec> registros;
	
	private Etec edit = new Etec();
	
	protected void postConstruct() {
		registros = cadastroSB.findAll();
	}
	
	public void onRemove(Etec etec) {
		cadastroSB.remove(etec);
		registros = cadastroSB.findAll();
		showDeleteMessage();
	}
	
	public void onUpdate(Etec etec){
		edit = etec;
	} 
	
	public void onSave() {
		try {
			cadastroSB.save(edit);
			showInsertMessage();
		} catch (Exception e) {
			showErrorMessage(e.getMessage());
		}
	}
	
}
