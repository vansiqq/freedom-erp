package org.freedom.persist.entity;

// Generated 12/05/2014 09:11:34 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CrtipochamadoId generated by hbm2java
 */
@Embeddable
public class CrtipochamadoId implements java.io.Serializable {

	private int codtpchamado;
	private short codfilial;
	private int codemp;

	public CrtipochamadoId() {
	}

	public CrtipochamadoId(int codtpchamado, short codfilial, int codemp) {
		this.codtpchamado = codtpchamado;
		this.codfilial = codfilial;
		this.codemp = codemp;
	}

	@Column(name = "CODTPCHAMADO", nullable = false)
	public int getCodtpchamado() {
		return this.codtpchamado;
	}

	public void setCodtpchamado(int codtpchamado) {
		this.codtpchamado = codtpchamado;
	}

	@Column(name = "CODFILIAL", nullable = false)
	public short getCodfilial() {
		return this.codfilial;
	}

	public void setCodfilial(short codfilial) {
		this.codfilial = codfilial;
	}

	@Column(name = "CODEMP", nullable = false)
	public int getCodemp() {
		return this.codemp;
	}

	public void setCodemp(int codemp) {
		this.codemp = codemp;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CrtipochamadoId))
			return false;
		CrtipochamadoId castOther = (CrtipochamadoId) other;

		return (this.getCodtpchamado() == castOther.getCodtpchamado())
				&& (this.getCodfilial() == castOther.getCodfilial())
				&& (this.getCodemp() == castOther.getCodemp());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodtpchamado();
		result = 37 * result + this.getCodfilial();
		result = 37 * result + this.getCodemp();
		return result;
	}

}
