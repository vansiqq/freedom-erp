package org.freedom.persist.entity;

// Generated 12/05/2014 09:11:34 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Crmarcador generated by hbm2java
 */
@Entity
@Table(name = "CRMARCADOR")
public class Crmarcador implements java.io.Serializable {

	private CrmarcadorId id;
	private String descmarcor;
	private String vermarcor;
	private Date dtins;
	private Date hins;
	private String idusuins;
	private Date dtalt;
	private Date halt;
	private String idusualt;
	private Set crtarefas = new HashSet(0);

	public Crmarcador() {
	}

	public Crmarcador(CrmarcadorId id, String descmarcor, String vermarcor,
			Date dtins, Date hins, String idusuins) {
		this.id = id;
		this.descmarcor = descmarcor;
		this.vermarcor = vermarcor;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
	}

	public Crmarcador(CrmarcadorId id, String descmarcor, String vermarcor,
			Date dtins, Date hins, String idusuins, Date dtalt, Date halt,
			String idusualt, Set crtarefas) {
		this.id = id;
		this.descmarcor = descmarcor;
		this.vermarcor = vermarcor;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
		this.dtalt = dtalt;
		this.halt = halt;
		this.idusualt = idusualt;
		this.crtarefas = crtarefas;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codmarcor", column = @Column(name = "CODMARCOR", nullable = false)),
			@AttributeOverride(name = "codfilial", column = @Column(name = "CODFILIAL", nullable = false)),
			@AttributeOverride(name = "codemp", column = @Column(name = "CODEMP", nullable = false)) })
	public CrmarcadorId getId() {
		return this.id;
	}

	public void setId(CrmarcadorId id) {
		this.id = id;
	}

	@Column(name = "DESCMARCOR", nullable = false, length = 100)
	public String getDescmarcor() {
		return this.descmarcor;
	}

	public void setDescmarcor(String descmarcor) {
		this.descmarcor = descmarcor;
	}

	@Column(name = "VERMARCOR", nullable = false, length = 10)
	public String getVermarcor() {
		return this.vermarcor;
	}

	public void setVermarcor(String vermarcor) {
		this.vermarcor = vermarcor;
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

	@Column(name = "IDUSUINS", nullable = false, length = 128)
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

	@Column(name = "IDUSUALT", length = 128)
	public String getIdusualt() {
		return this.idusualt;
	}

	public void setIdusualt(String idusualt) {
		this.idusualt = idusualt;
	}

	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "crmarcador")
	public Set getCrtarefas() {
		return this.crtarefas;
	}

	public void setCrtarefas(Set crtarefas) {
		this.crtarefas = crtarefas;
	}
*/
}
