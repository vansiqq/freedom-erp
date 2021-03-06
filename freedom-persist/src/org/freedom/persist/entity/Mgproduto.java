package org.freedom.persist.entity;

// Generated 12/05/2014 09:11:34 by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Mgproduto generated by hbm2java
 */
@Entity
@Table(name = "MGPRODUTO")
public class Mgproduto implements java.io.Serializable {

	private MgprodutoId id;
	private Eqproduto eqproduto;
	private String descprod;
	private String descprodcompl;
	private Date dtins;
	private String idusuins;
	private Date dtalt;
	private String idusualt;
	private Date hins;
	private Date halt;

	public Mgproduto() {
	}

	public Mgproduto(Eqproduto eqproduto, String descprod) {
		this.eqproduto = eqproduto;
		this.descprod = descprod;
	}

	public Mgproduto(Eqproduto eqproduto, String descprod,
			String descprodcompl, Date dtins, String idusuins, Date dtalt,
			String idusualt, Date hins, Date halt) {
		this.eqproduto = eqproduto;
		this.descprod = descprod;
		this.descprodcompl = descprodcompl;
		this.dtins = dtins;
		this.idusuins = idusuins;
		this.dtalt = dtalt;
		this.idusualt = idusualt;
		this.hins = hins;
		this.halt = halt;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codprod", column = @Column(name = "CODPROD", nullable = false)),
			@AttributeOverride(name = "codfilial", column = @Column(name = "CODFILIAL", nullable = false)),
			@AttributeOverride(name = "codemp", column = @Column(name = "CODEMP", nullable = false)) })
	public MgprodutoId getId() {
		return this.id;
	}

	public void setId(MgprodutoId id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Eqproduto getEqproduto() {
		return this.eqproduto;
	}

	public void setEqproduto(Eqproduto eqproduto) {
		this.eqproduto = eqproduto;
	}

	@Column(name = "DESCPROD", nullable = false)
	public String getDescprod() {
		return this.descprod;
	}

	public void setDescprod(String descprod) {
		this.descprod = descprod;
	}

	@Column(name = "DESCPRODCOMPL", length = 0)
	public String getDescprodcompl() {
		return this.descprodcompl;
	}

	public void setDescprodcompl(String descprodcompl) {
		this.descprodcompl = descprodcompl;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTINS", length = 10)
	public Date getDtins() {
		return this.dtins;
	}

	public void setDtins(Date dtins) {
		this.dtins = dtins;
	}

	@Column(name = "IDUSUINS", length = 8)
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

	@Column(name = "IDUSUALT", length = 8)
	public String getIdusualt() {
		return this.idusualt;
	}

	public void setIdusualt(String idusualt) {
		this.idusualt = idusualt;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "HINS", length = 8)
	public Date getHins() {
		return this.hins;
	}

	public void setHins(Date hins) {
		this.hins = hins;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "HALT", length = 8)
	public Date getHalt() {
		return this.halt;
	}

	public void setHalt(Date halt) {
		this.halt = halt;
	}

}
