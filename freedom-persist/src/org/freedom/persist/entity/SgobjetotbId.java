package org.freedom.persist.entity;

// Generated 12/05/2014 09:11:34 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SgobjetotbId generated by hbm2java
 */
@Embeddable
public class SgobjetotbId implements java.io.Serializable {

	private short codtb;
	private short codfilialtb;
	private int codemptb;
	private String idobj;
	private int codemp;

	public SgobjetotbId() {
	}

	public SgobjetotbId(short codtb, short codfilialtb, int codemptb,
			String idobj, int codemp) {
		this.codtb = codtb;
		this.codfilialtb = codfilialtb;
		this.codemptb = codemptb;
		this.idobj = idobj;
		this.codemp = codemp;
	}

	@Column(name = "CODTB", nullable = false)
	public short getCodtb() {
		return this.codtb;
	}

	public void setCodtb(short codtb) {
		this.codtb = codtb;
	}

	@Column(name = "CODFILIALTB", nullable = false)
	public short getCodfilialtb() {
		return this.codfilialtb;
	}

	public void setCodfilialtb(short codfilialtb) {
		this.codfilialtb = codfilialtb;
	}

	@Column(name = "CODEMPTB", nullable = false)
	public int getCodemptb() {
		return this.codemptb;
	}

	public void setCodemptb(int codemptb) {
		this.codemptb = codemptb;
	}

	@Column(name = "IDOBJ", nullable = false, length = 30)
	public String getIdobj() {
		return this.idobj;
	}

	public void setIdobj(String idobj) {
		this.idobj = idobj;
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
		if (!(other instanceof SgobjetotbId))
			return false;
		SgobjetotbId castOther = (SgobjetotbId) other;

		return (this.getCodtb() == castOther.getCodtb())
				&& (this.getCodfilialtb() == castOther.getCodfilialtb())
				&& (this.getCodemptb() == castOther.getCodemptb())
				&& ((this.getIdobj() == castOther.getIdobj()) || (this
						.getIdobj() != null && castOther.getIdobj() != null && this
						.getIdobj().equals(castOther.getIdobj())))
				&& (this.getCodemp() == castOther.getCodemp());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodtb();
		result = 37 * result + this.getCodfilialtb();
		result = 37 * result + this.getCodemptb();
		result = 37 * result
				+ (getIdobj() == null ? 0 : this.getIdobj().hashCode());
		result = 37 * result + this.getCodemp();
		return result;
	}

}
