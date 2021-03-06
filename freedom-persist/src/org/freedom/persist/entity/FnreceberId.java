package org.freedom.persist.entity;

// Generated 12/05/2014 09:11:34 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FnreceberId generated by hbm2java
 */
@Embeddable
public class FnreceberId implements java.io.Serializable {

	private int codrec;
	private short codfilial;
	private int codemp;

	public FnreceberId() {
	}

	public FnreceberId(int codrec, short codfilial, int codemp) {
		this.codrec = codrec;
		this.codfilial = codfilial;
		this.codemp = codemp;
	}

	@Column(name = "CODREC", nullable = false)
	public int getCodrec() {
		return this.codrec;
	}

	public void setCodrec(int codrec) {
		this.codrec = codrec;
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
		if (!(other instanceof FnreceberId))
			return false;
		FnreceberId castOther = (FnreceberId) other;

		return (this.getCodrec() == castOther.getCodrec())
				&& (this.getCodfilial() == castOther.getCodfilial())
				&& (this.getCodemp() == castOther.getCodemp());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodrec();
		result = 37 * result + this.getCodfilial();
		result = 37 * result + this.getCodemp();
		return result;
	}

}
