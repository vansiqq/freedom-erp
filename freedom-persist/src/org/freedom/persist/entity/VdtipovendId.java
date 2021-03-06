package org.freedom.persist.entity;

// Generated 12/05/2014 09:11:34 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VdtipovendId generated by hbm2java
 */
@Embeddable
public class VdtipovendId implements java.io.Serializable {

	private int codtipovend;
	private short codfilial;
	private int codemp;

	public VdtipovendId() {
	}

	public VdtipovendId(int codtipovend, short codfilial, int codemp) {
		this.codtipovend = codtipovend;
		this.codfilial = codfilial;
		this.codemp = codemp;
	}

	@Column(name = "CODTIPOVEND", nullable = false)
	public int getCodtipovend() {
		return this.codtipovend;
	}

	public void setCodtipovend(int codtipovend) {
		this.codtipovend = codtipovend;
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
		if (!(other instanceof VdtipovendId))
			return false;
		VdtipovendId castOther = (VdtipovendId) other;

		return (this.getCodtipovend() == castOther.getCodtipovend())
				&& (this.getCodfilial() == castOther.getCodfilial())
				&& (this.getCodemp() == castOther.getCodemp());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodtipovend();
		result = 37 * result + this.getCodfilial();
		result = 37 * result + this.getCodemp();
		return result;
	}

}
