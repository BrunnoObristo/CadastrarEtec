package br.com.brunnomarcos.cadastroEtec.view;

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
	
	private Etec edit = new Etec();
	
	public void onSave() {
		cadastroSB.save(edit);
		showInsertMessage();
	}
	
}