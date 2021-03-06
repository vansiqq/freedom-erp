package org.freedom.persist.entity;

// Generated 12/05/2014 09:11:34 by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ppfotomtan generated by hbm2java
 */
@Entity
@Table(name = "PPFOTOMTAN")
public class Ppfotomtan implements java.io.Serializable {

	private PpfotomtanId id;
	private Ppmetodoanalise ppmetodoanalise;
	private String descfotomtan;
	private byte[] fotomtan;
	private Date dtins;
	private Date hins;
	private String idusuins;
	private Date dtalt;
	private Date halt;
	private String idusualt;

	public Ppfotomtan() {
	}

	public Ppfotomtan(PpfotomtanId id, Ppmetodoanalise ppmetodoanalise,
			String descfotomtan, byte[] fotomtan, Date dtins, Date hins,
			String idusuins) {
		this.id = id;
		this.ppmetodoanalise = ppmetodoanalise;
		this.descfotomtan = descfotomtan;
		this.fotomtan = fotomtan;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
	}

	public Ppfotomtan(PpfotomtanId id, Ppmetodoanalise ppmetodoanalise,
			String descfotomtan, byte[] fotomtan, Date dtins, Date hins,
			String idusuins, Date dtalt, Date halt, String idusualt) {
		this.id = id;
		this.ppmetodoanalise = ppmetodoanalise;
		this.descfotomtan = descfotomtan;
		this.fotomtan = fotomtan;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
		this.dtalt = dtalt;
		this.halt = halt;
		this.idusualt = idusualt;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codfotomtan", column = @Column(name = "CODFOTOMTAN", nullable = false)),
			@AttributeOverride(name = "codmtanalise", column = @Column(name = "CODMTANALISE", nullable = false)),
			@AttributeOverride(name = "codfilial", column = @Column(name = "CODFILIAL", nullable = false)),
			@AttributeOverride(name = "codemp", column = @Column(name = "CODEMP", nullable = false)) })
	public PpfotomtanId getId() {
		return this.id;
	}

	public void setId(PpfotomtanId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODMTANALISE", referencedColumnName = "CODMTANALISE", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CODFILIAL", referencedColumnName = "CODFILIAL", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CODEMP", referencedColumnName = "CODEMP", nullable = false, insertable = false, updatable = false) })
	public Ppmetodoanalise getPpmetodoanalise() {
		return this.ppmetodoanalise;
	}

	public void setPpmetodoanalise(Ppmetodoanalise ppmetodoanalise) {
		this.ppmetodoanalise = ppmetodoanalise;
	}

	@Column(name = "DESCFOTOMTAN", nullable = false, length = 300)
	public String getDescfotomtan() {
		return this.descfotomtan;
	}

	public void setDescfotomtan(String descfotomtan) {
		this.descfotomtan = descfotomtan;
	}

	@Column(name = "FOTOMTAN", nullable = false)
	public byte[] getFotomtan() {
		return this.fotomtan;
	}

	public void setFotomtan(byte[] fotomtan) {
		this.fotomtan = fotomtan;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTINS", nullable = false, length = 10)
	public Date getDtins() {
		return this.dtins;
	}

	public void setDtins(Date dtins) {
		this.dtins = dtins;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "HINS", nullable = false, length = 8)
	public Date getHins() {
		return this.hins;
	}

	public void setHins(Date hins) {
		this.hins = hins;
	}

	@Column(name = "IDUSUINS", nullable = false, length = 8)
	public String getIdusuins() {
		return this.idusuins;
	}

	public void setIdusuins(String idusuins) {
		this.idusuins = idusuins;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTALT", length = 10)
	public Date getDtalt() {
		return this.dtalt;
	}

	public void setDtalt(Date dtalt) {
		this.dtalt = dtalt;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "HALT", length = 8)
	public Date getHalt() {
		return this.halt;
	}

	public void setHalt(Date halt) {
		this.halt = halt;
	}

	@Column(name = "IDUSUALT", length = 8)
	public String getIdusualt() {
		return this.idusualt;
	}

	public void setIdusualt(String idusualt) {
		this.idusualt = idusualt;
	}

}
