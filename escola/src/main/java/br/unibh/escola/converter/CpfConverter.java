package br.unibh.escola.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("cpfConverter")
public class CpfConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String cpf) {
		if(cpf == null || cpf.trim().isEmpty()) {
			return "";
		}
		return cpf.replaceAll("\\.|\\-","");
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object cpf) {
		if(cpf == null || String.valueOf(cpf).trim().isEmpty()) {
			return "";
		}
		
		String cpfFormatado = String.valueOf(cpf);
		return cpfFormatado = cpfFormatado.substring(0,3) + "." + cpfFormatado.substring(3,6) + "." + cpfFormatado.substring(6,9) +"-"+cpfFormatado.substring(9);
		
	}

}
