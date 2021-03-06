package org.freedom.persist.entity;

// Generated 12/05/2014 09:11:34 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * EqsecaoId generated by hbm2java
 */
@Embeddable
public class EqsecaoId implements java.io.Serializable {

	private String codsecao;
	private short codfilial;
	private int codemp;

	public EqsecaoId() {
	}

	public EqsecaoId(String codsecao, short codfilial, int codemp) {
		this.codsecao = codsecao;
		this.codfilial = codfilial;
		this.codemp = codemp;
	}

	@Column(name = "CODSECAO", nullable = false, length = 13)
	public String getCodsecao() {
		return this.codsecao;
	}

	public void setCodsecao(String codsecao) {
		this.codsecao = codsecao;
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
		if (!(other instanceof EqsecaoId))
			return false;
		EqsecaoId castOther = (EqsecaoId) other;

		return ((this.getCodsecao() == castOther.getCodsecao()) || (this
				.getCodsecao() != null && castOther.getCodsecao() != null && this
				.getCodsecao().equals(castOther.getCodsecao())))
				&& (this.getCodfilial() == castOther.getCodfilial())
				&& (this.getCodemp() == castOther.getCodemp());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCodsecao() == null ? 0 : this.getCodsecao().hashCode());
		result = 37 * result + this.getCodfilial();
		result = 37 * result + this.getCodemp();
		return result;
	}

}
