package br.unibh.escola.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;

import br.unibh.escola.entidades.Aluno;
import br.unibh.escola.negocio.ServicoAluno;

@FacesConverter(value="ConversorAluno",forClass=Aluno.class)
public class ConversorAluno implements Converter {
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component,
			String value) {
		try {
			ServicoAluno sa = (ServicoAluno) new InitialContext()
			.lookup("java:global/escola/ServicoAluno");
			return sa.find(new Long(value));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public String getAsString(FacesContext ctx, UIComponent component,
			Object value) {
		if (value != null) {
			Aluno a = (Aluno) value;
			if (a.getId() != null)
				return a.getId().toString();
		}
		return null;
	}
}