package br.unibh.escola.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;

import br.unibh.escola.entidades.Professor;
import br.unibh.escola.negocio.ServicoProfessor;

@FacesConverter(value="ConversorProfessor",forClass=Professor.class)
public class ConversorProfessor implements Converter {
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component,
			String value) {
		try {
			ServicoProfessor sp = (ServicoProfessor) new InitialContext()
			.lookup("java:global/escola/ServicoProfessor");
			return sp.find(new Long(value));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public String getAsString(FacesContext ctx, UIComponent component,
			Object value) {
		if (value != null) {
			Professor p = (Professor) value;
			if (p.getId() != null)
				return p.getId().toString();
		}
		return null;
	}
}