package org.freedom.persist.entity;

// Generated 12/05/2014 09:11:34 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TkctoativId generated by hbm2java
 */
@Embeddable
public class TkctoativId implements java.io.Serializable {

	private int codcto;
	private short codfilial;
	private int codemp;
	private int codativ;
	private short codfilialav;
	private int codempav;

	public TkctoativId() {
	}

	public TkctoativId(int codcto, short codfilial, int codemp, int codativ,
			short codfilialav, int codempav) {
		this.codcto = codcto;
		this.codfilial = codfilial;
		this.codemp = codemp;
		this.codativ = codativ;
		this.codfilialav = codfilialav;
		this.codempav = codempav;
	}

	@Column(name = "CODCTO", nullable = false)
	public int getCodcto() {
		return this.codcto;
	}

	public void setCodcto(int codcto) {
		this.codcto = codcto;
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

	@Column(name = "CODATIV", nullable = false)
	public int getCodativ() {
		return this.codativ;
	}

	public void setCodativ(int codativ) {
		this.codativ = codativ;
	}

	@Column(name = "CODFILIALAV", nullable = false)
	public short getCodfilialav() {
		return this.codfilialav;
	}

	public void setCodfilialav(short codfilialav) {
		this.codfilialav = codfilialav;
	}

	@Column(name = "CODEMPAV", nullable = false)
	public int getCodempav() {
		return this.codempav;
	}

	public void setCodempav(int codempav) {
		this.codempav = codempav;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TkctoativId))
			return false;
		TkctoativId castOther = (TkctoativId) other;

		return (this.getCodcto() == castOther.getCodcto())
				&& (this.getCodfilial() == castOther.getCodfilial())
				&& (this.getCodemp() == castOther.getCodemp())
				&& (this.getCodativ() == castOther.getCodativ())
				&& (this.getCodfilialav() == castOther.getCodfilialav())
				&& (this.getCodempav() == castOther.getCodempav());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodcto();
		result = 37 * result + this.getCodfilial();
		result = 37 * result + this.getCodemp();
		result = 37 * result + this.getCodativ();
		result = 37 * result + this.getCodfilialav();
		result = 37 * result + this.getCodempav();
		return result;
	}

}
