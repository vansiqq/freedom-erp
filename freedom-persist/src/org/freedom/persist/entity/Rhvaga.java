package org.freedom.persist.entity;

// Generated 12/05/2014 09:11:34 by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Rhvaga generated by hbm2java
 */
@Entity
@Table(name = "RHVAGA")
public class Rhvaga implements java.io.Serializable {

	private RhvagaId id;
	private Rhempregador rhempregador;
	private Rhturno rhturno;
	private Rhfuncao rhfuncao;
	private BigDecimal faixasalini;
	private BigDecimal faixasalfim;
	private String stvaga;
	private Date dtultst;
	private Date dtins;
	private Date hins;
	private String idusuins;
	private Date dtalt;
	private Date halt;
	private String idusualt;
	private Set rhvagastatuses = new HashSet(0);
	private Set rhvagacandidatos = new HashSet(0);
	private Set rhvagacaracrests = new HashSet(0);
	private Set rhvagacursos = new HashSet(0);
	private Set rhcandidatostatuses = new HashSet(0);
	private Set rhvagacaracqualis = new HashSet(0);

	public Rhvaga() {
	}

	public Rhvaga(RhvagaId id, Rhempregador rhempregador, Rhfuncao rhfuncao,
			BigDecimal faixasalini, BigDecimal faixasalfim, String stvaga,
			Date dtultst, Date dtins, Date hins, String idusuins) {
		this.id = id;
		this.rhempregador = rhempregador;
		this.rhfuncao = rhfuncao;
		this.faixasalini = faixasalini;
		this.faixasalfim = faixasalfim;
		this.stvaga = stvaga;
		this.dtultst = dtultst;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
	}

	public Rhvaga(RhvagaId id, Rhempregador rhempregador, Rhturno rhturno,
			Rhfuncao rhfuncao, BigDecimal faixasalini, BigDecimal faixasalfim,
			String stvaga, Date dtultst, Date dtins, Date hins,
			String idusuins, Date dtalt, Date halt, String idusualt,
			Set rhvagastatuses, Set rhvagacandidatos, Set rhvagacaracrests,
			Set rhvagacursos, Set rhcandidatostatuses, Set rhvagacaracqualis) {
		this.id = id;
		this.rhempregador = rhempregador;
		this.rhturno = rhturno;
		this.rhfuncao = rhfuncao;
		this.faixasalini = faixasalini;
		this.faixasalfim = faixasalfim;
		this.stvaga = stvaga;
		this.dtultst = dtultst;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
		this.dtalt = dtalt;
		this.halt = halt;
		this.idusualt = idusualt;
		this.rhvagastatuses = rhvagastatuses;
		this.rhvagacandidatos = rhvagacandidatos;
		this.rhvagacaracrests = rhvagacaracrests;
		this.rhvagacursos = rhvagacursos;
		this.rhcandidatostatuses = rhcandidatostatuses;
		this.rhvagacaracqualis = rhvagacaracqualis;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codvaga", column = @Column(name = "CODVAGA", nullable = false)),
			@AttributeOverride(name = "codfilial", column = @Column(name = "CODFILIAL", nullable = false)),
			@AttributeOverride(name = "codemp", column = @Column(name = "CODEMP", nullable = false)) })
	public RhvagaId getId() {
		return this.id;
	}

	public void setId(RhvagaId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODEMPR", referencedColumnName = "CODEMPR", nullable = false),
			@JoinColumn(name = "CODFILIALEM", referencedColumnName = "CODFILIAL", nullable = false),
			@JoinColumn(name = "CODEMPEM", referencedColumnName = "CODEMP", nullable = false) })
	public Rhempregador getRhempregador() {
		return this.rhempregador;
	}

	public void setRhempregador(Rhempregador rhempregador) {
		this.rhempregador = rhempregador;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODTURNO", referencedColumnName = "CODTURNO"),
			@JoinColumn(name = "CODFILIALTN", referencedColumnName = "CODFILIAL"),
			@JoinColumn(name = "CODEMPTN", referencedColumnName = "CODEMP") })
	public Rhturno getRhturno() {
		return this.rhturno;
	}

	public void setRhturno(Rhturno rhturno) {
		this.rhturno = rhturno;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODFUNC", referencedColumnName = "CODFUNC", nullable = false),
			@JoinColumn(name = "CODFILIALFC", referencedColumnName = "CODFILIAL", nullable = false),
			@JoinColumn(name = "CODEMPFC", referencedColumnName = "CODEMP", nullable = false) })
	public Rhfuncao getRhfuncao() {
		return this.rhfuncao;
	}

	public void setRhfuncao(Rhfuncao rhfuncao) {
		this.rhfuncao = rhfuncao;
	}

	@Column(name = "FAIXASALINI", nullable = false, precision = 15, scale = 5)
	public BigDecimal getFaixasalini() {
		return this.faixasalini;
	}

	public void setFaixasalini(BigDecimal faixasalini) {
		this.faixasalini = faixasalini;
	}

	@Column(name = "FAIXASALFIM", nullable = false, precision = 15, scale = 5)
	public BigDecimal getFaixasalfim() {
		return this.faixasalfim;
	}

	public void setFaixasalfim(BigDecimal faixasalfim) {
		this.faixasalfim = faixasalfim;
	}

	@Column(name = "STVAGA", nullable = false, length = 2)
	public String getStvaga() {
		return this.stvaga;
	}

	public void setStvaga(String stvaga) {
		this.stvaga = stvaga;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTULTST", nullable = false, length = 10)
	public Date getDtultst() {
		return this.dtultst;
	}

	public void setDtultst(Date dtultst) {
		this.dtultst = dtultst;
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

/*	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rhvaga")
	public Set getRhvagastatuses() {
		return this.rhvagastatuses;
	}

	public void setRhvagastatuses(Set rhvagastatuses) {
		this.rhvagastatuses = rhvagastatuses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rhvaga")
	public Set getRhvagacandidatos() {
		return this.rhvagacandidatos;
	}

	public void setRhvagacandidatos(Set rhvagacandidatos) {
		this.rhvagacandidatos = rhvagacandidatos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rhvaga")
	public Set getRhvagacaracrests() {
		return this.rhvagacaracrests;
	}

	public void setRhvagacaracrests(Set rhvagacaracrests) {
		this.rhvagacaracrests = rhvagacaracrests;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rhvaga")
	public Set getRhvagacursos() {
		return this.rhvagacursos;
	}

	public void setRhvagacursos(Set rhvagacursos) {
		this.rhvagacursos = rhvagacursos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rhvaga")
	public Set getRhcandidatostatuses() {
		return this.rhcandidatostatuses;
	}

	public void setRhcandidatostatuses(Set rhcandidatostatuses) {
		this.rhcandidatostatuses = rhcandidatostatuses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rhvaga")
	public Set getRhvagacaracqualis() {
		return this.rhvagacaracqualis;
	}

	public void setRhvagacaracqualis(Set rhvagacaracqualis) {
		this.rhvagacaracqualis = rhvagacaracqualis;
	}
*/
}
