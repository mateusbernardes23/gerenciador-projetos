package com.codegroup.model.enums;

public enum Risco {
	BAIXO("Baixo"), MEDIO("Médio"), ALTO("Alto");

	private String label;

	private Risco(String label) {
		this.setLabel(label);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
