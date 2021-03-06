package org.freedom.persist.entity;

// Generated 12/05/2014 09:11:34 by Hibernate Tools 4.0.0

import java.math.BigDecimal;
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
 * Svavaliacao generated by hbm2java
 */
@Entity
@Table(name = "SVAVALIACAO")
public class Svavaliacao implements java.io.Serializable {

	private SvavaliacaoId id;
	private Eqproduto eqproduto;
	private Svitos svitos;
	private String refprod;
	private BigDecimal qtdaval;
	private BigDecimal precoaval;
	private BigDecimal vlrtotaval;
	private BigDecimal vlrdescaval;
	private BigDecimal vlrliqaval;
	private String sitaval;
	private String sitaprovaval;
	private Date dtins;
	private Date hins;
	private String idusuins;
	private Date dtalt;
	private Date halt;
	private String idusualt;

	public Svavaliacao() {
	}

	public Svavaliacao(SvavaliacaoId id, Eqproduto eqproduto, Svitos svitos,
			String refprod, BigDecimal qtdaval, BigDecimal precoaval,
			BigDecimal vlrtotaval, BigDecimal vlrdescaval,
			BigDecimal vlrliqaval, String sitaval, String sitaprovaval,
			Date dtins, Date hins, String idusuins) {
		this.id = id;
		this.eqproduto = eqproduto;
		this.svitos = svitos;
		this.refprod = refprod;
		this.qtdaval = qtdaval;
		this.precoaval = precoaval;
		this.vlrtotaval = vlrtotaval;
		this.vlrdescaval = vlrdescaval;
		this.vlrliqaval = vlrliqaval;
		this.sitaval = sitaval;
		this.sitaprovaval = sitaprovaval;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
	}

	public Svavaliacao(SvavaliacaoId id, Eqproduto eqproduto, Svitos svitos,
			String refprod, BigDecimal qtdaval, BigDecimal precoaval,
			BigDecimal vlrtotaval, BigDecimal vlrdescaval,
			BigDecimal vlrliqaval, String sitaval, String sitaprovaval,
			Date dtins, Date hins, String idusuins, Date dtalt, Date halt,
			String idusualt) {
		this.id = id;
		this.eqproduto = eqproduto;
		this.svitos = svitos;
		this.refprod = refprod;
		this.qtdaval = qtdaval;
		this.precoaval = precoaval;
		this.vlrtotaval = vlrtotaval;
		this.vlrdescaval = vlrdescaval;
		this.vlrliqaval = vlrliqaval;
		this.sitaval = sitaval;
		this.sitaprovaval = sitaprovaval;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
		this.dtalt = dtalt;
		this.halt = halt;
		this.idusualt = idusualt;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codos", column = @Column(name = "CODOS", nullable = false)),
			@AttributeOverride(name = "coditos", column = @Column(name = "CODITOS", nullable = false)),
			@AttributeOverride(name = "codaval", column = @Column(name = "CODAVAL", nullable = false)),
			@AttributeOverride(name = "codfilial", column = @Column(name = "CODFILIAL", nullable = false)),
			@AttributeOverride(name = "codemp", column = @Column(name = "CODEMP", nullable = false)) })
	public SvavaliacaoId getId() {
		return this.id;
	}

	public void setId(SvavaliacaoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD", nullable = false),
			@JoinColumn(name = "CODFILIALPD", referencedColumnName = "CODFILIAL", nullable = false),
			@JoinColumn(name = "CODEMPPD", referencedColumnName = "CODEMP", nullable = false) })
	public Eqproduto getEqproduto() {
		return this.eqproduto;
	}

	public void setEqproduto(Eqproduto eqproduto) {
		this.eqproduto = eqproduto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODOS", referencedColumnName = "CODOS", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CODITOS", referencedColumnName = "CODITOS", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CODFILIAL", referencedColumnName = "CODFILIAL", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CODEMP", referencedColumnName = "CODEMP", nullable = false, insertable = false, updatable = false) })
	public Svitos getSvitos() {
		return this.svitos;
	}

	public void setSvitos(Svitos svitos) {
		this.svitos = svitos;
	}

	@Column(name = "REFPROD", nullable = false, length = 20)
	public String getRefprod() {
		return this.refprod;
	}

	public void setRefprod(String refprod) {
		this.refprod = refprod;
	}

	@Column(name = "QTDAVAL", nullable = false, precision = 15, scale = 5)
	public BigDecimal getQtdaval() {
		return this.qtdaval;
	}

	public void setQtdaval(BigDecimal qtdaval) {
		this.qtdaval = qtdaval;
	}

	@Column(name = "PRECOAVAL", nullable = false, precision = 15, scale = 5)
	public BigDecimal getPrecoaval() {
		return this.precoaval;
	}

	public void setPrecoaval(BigDecimal precoaval) {
		this.precoaval = precoaval;
	}

	@Column(name = "VLRTOTAVAL", nullable = false, precision = 15, scale = 5)
	public BigDecimal getVlrtotaval() {
		return this.vlrtotaval;
	}

	public void setVlrtotaval(BigDecimal vlrtotaval) {
		this.vlrtotaval = vlrtotaval;
	}

	@Column(name = "VLRDESCAVAL", nullable = false, precision = 15, scale = 5)
	public BigDecimal getVlrdescaval() {
		return this.vlrdescaval;
	}

	public void setVlrdescaval(BigDecimal vlrdescaval) {
		this.vlrdescaval = vlrdescaval;
	}

	@Column(name = "VLRLIQAVAL", nullable = false, precision = 15, scale = 5)
	public BigDecimal getVlrliqaval() {
		return this.vlrliqaval;
	}

	public void setVlrliqaval(BigDecimal vlrliqaval) {
		this.vlrliqaval = vlrliqaval;
	}

	@Column(name = "SITAVAL", nullable = false, length = 2)
	public String getSitaval() {
		return this.sitaval;
	}

	public void setSitaval(String sitaval) {
		this.sitaval = sitaval;
	}

	@Column(name = "SITAPROVAVAL", nullable = false, length = 2)
	public String getSitaprovaval() {
		return this.sitaprovaval;
	}

	public void setSitaprovaval(String sitaprovaval) {
		this.sitaprovaval = sitaprovaval;
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
