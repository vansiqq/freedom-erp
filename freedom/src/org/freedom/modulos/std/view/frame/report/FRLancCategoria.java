/**
 * @version 04/06/2002 <BR>
 * @author Setpoint Inform�tica Ltda. <BR>
 * 
 *         Projeto: Freedom <BR>
 * 
 *         Pacote: org.freedom.modulos.std <BR>
 *         Classe: @(#)FRLancCategoria.java <BR>
 * 
 *         Este arquivo � parte do sistema Freedom-ERP, o Freedom-ERP � um software livre; voc� pode redistribui-lo e/ou <BR>
 *         modifica-lo dentro dos termos da Licen�a P�blica Geral GNU como publicada pela Funda��o do Software Livre (FSF); <BR>
 *         na vers�o 2 da Licen�a, ou (na sua opni�o) qualquer vers�o. <BR>
 *         Este programa � distribuido na esperan�a que possa ser util, mas SEM NENHUMA GARANTIA; <BR>
 *         sem uma garantia implicita de ADEQUA��O a qualquer MERCADO ou APLICA��O EM PARTICULAR. <BR>
 *         Veja a Licen�a P�blica Geral GNU para maiores detalhes. <BR>
 *         Voc� deve ter recebido uma c�pia da Licen�a P�blica Geral GNU junto com este programa, se n�o, <BR>
 *         escreva para a Funda��o do Software Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA <BR>
 * <BR>
 * 
 *         Coment�rios sobre a classe...
 * 
 */
package org.freedom.modulos.std.view.frame.report;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import net.sf.jasperreports.engine.JasperPrintManager;

import org.freedom.acao.CarregaEvent;
import org.freedom.acao.CarregaListener;
import org.freedom.bmps.Icone;
import org.freedom.infra.model.jdbc.DbConnection;
import org.freedom.library.functions.Funcoes;
import org.freedom.library.persistence.GuardaCampo;
import org.freedom.library.persistence.ListaCampos;
import org.freedom.library.swing.component.JButtonPad;
import org.freedom.library.swing.component.JLabelPad;
import org.freedom.library.swing.component.JPanelPad;
import org.freedom.library.swing.component.JTablePad;
import org.freedom.library.swing.component.JTextFieldFK;
import org.freedom.library.swing.component.JTextFieldPad;
import org.freedom.library.swing.frame.Aplicativo;
import org.freedom.library.swing.frame.FPrinterJob;
import org.freedom.library.swing.frame.FRelatorio;
import org.freedom.library.type.TYPE_PRINT;
import org.freedom.modulos.fnc.library.swing.component.JTextFieldPlan;

public class FRLancCategoria extends FRelatorio implements ActionListener, CarregaListener {

	enum SEQUENCIA {
		CODIGO, DESCRICAO, NIVEL
	}

	private static final long serialVersionUID = 1L;

	private JTextFieldPad txtDataini = new JTextFieldPad( JTextFieldPad.TP_DATE, 10, 0 );

	private JTextFieldPad txtDatafim = new JTextFieldPad( JTextFieldPad.TP_DATE, 10, 0 );

	private JTextFieldPad txtCodCC = new JTextFieldPad( JTextFieldPad.TP_STRING, 19, 0 );

	private JTextFieldFK txtDescCC = new JTextFieldFK( JTextFieldPad.TP_STRING, 50, 0 );

	private JTextFieldFK txtSiglaCC = new JTextFieldFK( JTextFieldPad.TP_STRING, 10, 0 );

	private JTextFieldPad txtCodConta = new JTextFieldPad( JTextFieldPad.TP_STRING, 10, 0 );

	private JTextFieldFK txtDescConta = new JTextFieldFK( JTextFieldPad.TP_STRING, 40, 0 );

	private JTextFieldPlan txtCodPlan = new JTextFieldPlan( JTextFieldPad.TP_STRING, 13, 0 );

	private JTextFieldFK txtDescPlan = new JTextFieldFK( JTextFieldPad.TP_STRING, 40, 0 );

	private JTextFieldFK txtNivelPlan = new JTextFieldFK( JTextFieldPad.TP_INTEGER, 8, 0 );

	private JTextFieldPad txtMatempr = new JTextFieldPad( JTextFieldPad.TP_INTEGER, 8, 0 );

	private JTextFieldFK txtNomeempr = new JTextFieldFK( JTextFieldPad.TP_STRING, 60, 0 );

	private ListaCampos lcCC = new ListaCampos( this );

	private ListaCampos lcConta = new ListaCampos( this );

	private ListaCampos lcPlan = new ListaCampos( this );

	private ListaCampos lcEmpregado = new ListaCampos( this );

	private JButtonPad btAdic = new JButtonPad( Icone.novo( "btAdic.gif" ) );

	private JButtonPad btLimpa = new JButtonPad( Icone.novo( "btNada.png" ) );

	private JButtonPad btDeletaSelecionado = new JButtonPad( Icone.novo( "btExcluir.png" ) );

	private JButtonPad btAdicCC = new JButtonPad( Icone.novo( "btAdic.gif" ) );

	private JButtonPad btLimpaCC = new JButtonPad( Icone.novo( "btNada.png" ) );

	private JButtonPad btDeletaSelecionadoCC = new JButtonPad( Icone.novo( "btExcluir.png" ) );

	private JTablePad tbPlanoPag = new JTablePad();

	private JTablePad tbCentroCusto = new JTablePad();

	private JScrollPane scrol = new JScrollPane( tbPlanoPag );

	private JScrollPane scrol2 = new JScrollPane( tbCentroCusto );

	private JPanelPad pnCampos = new JPanelPad();

	private JPanelPad pnTabela = new JPanelPad( new BorderLayout() );

	private JPanelPad pnTabelaCC = new JPanelPad( new BorderLayout() );

	int iAnoBase = 0;

	int linha = 0;

	public FRLancCategoria() {

		super( false );

		setTitulo( "Lan�amentos por categoria" );
		setAtribos( 80, 80, 460, 565 );

		montaTela();
		montaListaCampos();

		btAdic.addActionListener( this );
		btLimpa.addActionListener( this );
		btDeletaSelecionado.setToolTipText( "Excluir" );
		btDeletaSelecionado.addActionListener( this );
		btLimpa.setToolTipText( "Exclui todos" );

		btAdicCC.addActionListener( this );
		btLimpaCC.addActionListener( this );
		btDeletaSelecionadoCC.setToolTipText( "Excluir" );
		btDeletaSelecionadoCC.addActionListener( this );
		btLimpaCC.setToolTipText( "Exclui todos" );
		btExportXLS.setEnabled( true );
		// btExportXLS.addActionListener( this );
		lcPlan.addCarregaListener( this );
		lcCC.addCarregaListener( this );
	}

	private void montaTela() {

		JLabel periodo = new JLabel( "Per�odo", SwingConstants.CENTER );
		periodo.setOpaque( true );
		adic( periodo, 25, 10, 80, 20 );
		JLabel borda = new JLabel();
		borda.setBorder( BorderFactory.createEtchedBorder() );
		adic( borda, 7, 20, 420, 45 );
		adic( txtDataini, 85, 35, 110, 20 );
		adic( new JLabel( "at�", SwingConstants.CENTER ), 195, 35, 40, 20 );
		adic( txtDatafim, 235, 35, 110, 20 );

		GregorianCalendar cPeriodo = new GregorianCalendar();
		txtDatafim.setVlrDate( cPeriodo.getTime() );
		cPeriodo.set( Calendar.DAY_OF_MONTH, cPeriodo.get( Calendar.DAY_OF_MONTH ) - 30 );
		txtDataini.setVlrDate( cPeriodo.getTime() );

		adic( new JLabelPad( "C�d.Conta" ), 7, 65, 80, 20 );
		adic( txtCodConta, 7, 85, 80, 20 );
		adic( new JLabelPad( "Descri��o da  Conta" ), 90, 65, 230, 20 );
		adic( txtDescConta, 90, 85, 337, 20 );

		adic( new JLabelPad( "Matr�cula" ), 7, 105, 80, 20 );
		adic( txtMatempr, 7, 125, 80, 20 );
		adic( new JLabelPad( "Nome do empregado/colaborador" ), 90, 105, 230, 20 );
		adic( txtNomeempr, 90, 125, 337, 20 );

		adic( new JLabelPad( "C�d. CC" ), 7, 145, 80, 20 );
		adic( txtCodCC, 7, 165, 80, 20 );
		adic( new JLabelPad( "Descri��o do Centro de custo" ), 90, 145, 230, 20 );
		adic( txtDescCC, 90, 165, 307, 20 );
		adic( btAdicCC, 400, 165, 30, 30 );
		adic( btDeletaSelecionadoCC, 400, 205, 30, 30 );
		adic( btLimpaCC, 400, 238, 30, 30 );
		adic( pnTabelaCC, 7, 205, 390, 100 );

		adic( new JLabelPad( "C�d.Plan." ), 7, 320, 80, 20 );
		adic( txtCodPlan, 7, 340, 80, 20 );
		adic( new JLabelPad( "Descri��o do planejamento" ), 90, 320, 230, 20 );
		adic( txtDescPlan, 90, 340, 307, 20 );
		adic( btAdic, 400, 340, 20, 20 );
		adic( btDeletaSelecionado, 400, 380, 30, 30 );
		adic( btLimpa, 400, 413, 30, 30 );
		adic( pnTabela, 7, 380, 390, 100 );

		pnTabelaCC.add( scrol2, BorderLayout.CENTER );

		tbCentroCusto.adicColuna( "C�d. CC" );
		tbCentroCusto.adicColuna( "Singla CC" );
		tbCentroCusto.adicColuna( "Descri��o do Centro de custo" );

		tbCentroCusto.setTamColuna( 90, 0 );
		tbCentroCusto.setTamColuna( 90, 1 );
		tbCentroCusto.setTamColuna( 205, 2 );

		pnTabela.add( scrol, BorderLayout.CENTER );

		tbPlanoPag.adicColuna( "C�d.Plan" );
		tbPlanoPag.adicColuna( "Descri��o do Planejamento" );
		tbPlanoPag.adicColuna( "Nivel" );

		tbPlanoPag.setTamColuna( 90, 0 );
		tbPlanoPag.setTamColuna( 205, 1 );
		tbPlanoPag.setTamColuna( 90, 2 );

	}

	private void montaListaCampos() {

		/*******************
		 * Centro de custo *
		 *******************/

		lcCC.add( new GuardaCampo( txtCodCC, "CodCC", "C�d.cc.", ListaCampos.DB_PK, false ) );
		lcCC.add( new GuardaCampo( txtSiglaCC, "SiglaCC", "Sigla", ListaCampos.DB_SI, false ) );
		lcCC.add( new GuardaCampo( txtDescCC, "DescCC", "Descri��o do centro de custo", ListaCampos.DB_SI, false ) );
		lcCC.setReadOnly( true );
		lcCC.montaSql( false, "CC", "FN" );
		txtCodCC.setTabelaExterna( lcCC, null );
		txtCodCC.setFK( true );
		txtCodCC.setNomeCampo( "CodCC" );
		txtSiglaCC.setListaCampos( lcCC );
		lcCC.setMuiltiselecaoF2( true );
		/*********
		 * Conta *
		 *********/

		lcConta.add( new GuardaCampo( txtCodConta, "NumConta", "C�d.conta", ListaCampos.DB_PK, false ) );
		lcConta.add( new GuardaCampo( txtDescConta, "DescConta", "Descri��o da conta", ListaCampos.DB_SI, false ) );
		lcConta.montaSql( false, "CONTA", "FN" );
		lcConta.setReadOnly( true );
		txtCodConta.setTabelaExterna( lcConta, null );
		txtCodConta.setFK( true );
		txtCodConta.setNomeCampo( "NumConta" );

		/****************
		 * Planejamento * *
		 ************/

		lcPlan.add( new GuardaCampo( txtCodPlan, "CodPlan", "C�d.plan", ListaCampos.DB_PK, false ) );
		lcPlan.add( new GuardaCampo( txtDescPlan, "DescPlan", "Descri��o do planejamento", ListaCampos.DB_SI, false ) );
		lcPlan.add( new GuardaCampo( txtNivelPlan, "NivelPlan", "N�vel de planejamento", ListaCampos.DB_SI, false ) );
		lcPlan.montaSql( false, "PLANEJAMENTO", "FN" );
		lcPlan.setReadOnly( true );
		txtCodPlan.setTabelaExterna( lcPlan, null );
		txtCodPlan.setFK( true );
		txtCodPlan.setNomeCampo( "CodPlan" );
		lcPlan.setMuiltiselecaoF2( true );

		/****************
		 * Empregado/colaborador * *
		 ************/

		txtMatempr.setNomeCampo( "matempr" );
		lcEmpregado.add( new GuardaCampo( txtMatempr, "MatEmpr", "Matr�cula", ListaCampos.DB_PK, false ) );
		lcEmpregado.add( new GuardaCampo( txtNomeempr, "NomeEmpr", "Nome empregado/colaborador", ListaCampos.DB_SI, false ) );
		lcEmpregado.setReadOnly( true );
		lcEmpregado.setQueryCommit( false );
		lcEmpregado.montaSql( false, "EMPREGADO", "RH" );
		txtMatempr.setTabelaExterna( lcEmpregado, null );
		txtMatempr.setListaCampos( lcEmpregado );
		txtNomeempr.setListaCampos( lcEmpregado );
		txtMatempr.setFK( true );

	}

	public void imprimir( TYPE_PRINT bVisualizar ) {

		StringBuilder sql = new StringBuilder();
		ResultSet rs = null;
		StringBuilder cab = new StringBuilder();
		StringBuilder where = new StringBuilder();
		int iParam = 1;
		String codplan = txtCodPlan.getVlrString().trim();
		String codcc = txtCodCC.getVlrString().trim();

		if ( txtDatafim.getVlrDate().before( txtDataini.getVlrDate() ) ) {
			Funcoes.mensagemInforma( this, "Data final maior que a data inicial!" );
			return;
		}
		if ( tbCentroCusto.getRowCount() > 0 ) {
			where.append( "and sl.codemp=? and sl.codfilial=? and sl.codcc in (" );
			int numLinhas = tbCentroCusto.getNumLinhas();
			int numLinhasSel = 0;
			String[] sValores = null;
			Vector<String> vValores = new Vector<String>();
			String ret = "";
			try {

				for ( int i = 0; i < numLinhas; i++ ) {
					vValores.add( "'" + tbCentroCusto.getValor( i, SEQUENCIA.CODIGO.ordinal() ).toString() + "'" );
				}

				ret = Funcoes.vectorToString( vValores, "," );

			} catch ( Exception e ) {
				e.printStackTrace();
			}
			where.append( ret + ") " );
			cab.append( " Planejamento:  " + txtCodPlan.getVlrString() + " " + txtDescPlan.getVlrString() );
		}
		else {

			if ( !"".equals( txtCodCC.getVlrString().trim() ) ) {

				where.append( "and sl.codemp=? and sl.codfilial=? and sl.codcc like? " );
				cab.append( " Centro de custo:  " + txtCodCC.getVlrString() + "  " + txtDescCC.getVlrString() );
			}
		}

		if ( !"".equals( txtCodConta.getVlrString() ) ) {

			where.append( "and c.codemp=? and c.codfilial=? and c.numconta=? " );
			cab.append( " Conta:  " + txtCodConta.getVlrString() + " " + txtDescConta.getVlrString() );
		}

		if ( !"".equals( txtMatempr.getVlrString() ) ) {

			where.append( "and sl.codempem=? and sl.codfilial=? and sl.matempr=? " );
			cab.append( " Empregado/colaborador:  " + txtMatempr.getVlrString() + " " + txtNomeempr.getVlrString() );
		}

		if ( tbPlanoPag.getRowCount() > 0 ) {
			where.append( "and sl.codemp=? and sl.codfilial=? and sl.codplan in (" );
			int numLinhas = tbPlanoPag.getNumLinhas();
			int numLinhasSel = 0;
			String[] sValores = null;
			Vector<String> vValores = new Vector<String>();
			String ret = "";
			try {
				for ( int i = 0; i < numLinhas; i++ ) {
					vValores.add( "'" + tbPlanoPag.getValor( i, SEQUENCIA.CODIGO.ordinal() ).toString() + "'" );
				}
				ret = Funcoes.vectorToString( vValores, "," );
			} catch ( Exception e ) {
				e.printStackTrace();
			}
			where.append( ret + ") " );
			cab.append( " Planejamento:  " + txtCodPlan.getVlrString() + " " + txtDescPlan.getVlrString() );
		}
		else {
			if ( !"".equals( txtCodPlan.getVlrString() ) ) {
				where.append( "and sl.codemp=? and sl.codfilial=? and sl.codplan like ?" );
				cab.append( " Planejamento:  " + txtCodPlan.getVlrString() + " " + txtDescPlan.getVlrString() );
			}
		}
		cab.append( "  Per�odo: " + txtDataini.getVlrString() + " " + " At� " + " " + txtDatafim.getVlrString() );
		sql.append( " select sl.codplan, pl.descplan, sl.datasublanca, sl.histsublanca, l.doclanca, sl.vlrsublanca,cc.desccc, c.descconta " );
		sql.append( "from fnsublanca sl " );
		sql.append( "left outer join fnplanejamento pl on pl.codemp=sl.codemppn and pl.codfilial=sl.codfilialpn and pl.codplan=sl.codplan " );
		sql.append( "left outer join fnlanca l on l.codemp=sl.codemp and l.codfilial=sl.codfilial and l.codlanca=sl.codlanca " );
		sql.append( "left outer join fncc cc on cc.codemp=sl.codempcc and cc.codfilial=sl.codfilialcc and cc.codcc=sl.codcc and cc.anocc=sl.anocc " );
		sql.append( "left outer join fnplanejamento pl2 on pl2.codemp=l.codemppn and pl2.codfilial=l.codfilialpn and pl2.codplan=l.codplan " );
		sql.append( "left outer join fnconta c on c.codemppn=pl2.codemp and c.codfilialpn=pl2.codfilial and c.codplan=pl2.codplan " );
		sql.append( "where sl.codemp=? and sl.codfilial=? and sl.datasublanca between ? and ? " );
		sql.append( where );
		sql.append( "order by sl.codplan, sl.datasublanca" );

		try {

			PreparedStatement ps = con.prepareStatement( sql.toString() );

			ps.setInt( iParam++, Aplicativo.iCodEmp );
			ps.setInt( iParam++, ListaCampos.getMasterFilial( "FNSUBLANCA" ) );
			ps.setDate( iParam++, Funcoes.dateToSQLDate( txtDataini.getVlrDate() ) );
			ps.setDate( iParam++, Funcoes.dateToSQLDate( txtDatafim.getVlrDate() ) );

			if ( tbCentroCusto.getRowCount() == 0 ) {

				if ( !"".equals( txtCodCC.getVlrString() ) ) {
					ps.setInt( iParam++, Aplicativo.iCodEmp );
					ps.setInt( iParam++, ListaCampos.getMasterFilial( "FNSUBLANCA" ) );
					if ( codcc.indexOf( "%" ) == -1 ) {
						if ( codcc.length() < 13 ) {
							codcc += "%";
						}
					}
					ps.setString( iParam++, codcc );
				}

			}
			else {
				ps.setInt( iParam++, Aplicativo.iCodEmp );
				ps.setInt( iParam++, ListaCampos.getMasterFilial( "FNSUBLANCA" ) );
			}
			if ( !"".equals( txtCodConta.getVlrString() ) ) {
				ps.setInt( iParam++, Aplicativo.iCodEmp );
				ps.setInt( iParam++, ListaCampos.getMasterFilial( "FNCONTA" ) );
				ps.setString( iParam++, txtCodConta.getVlrString() );
			}
			if ( !"".equals( txtMatempr.getVlrString().trim() ) ) {
				ps.setInt( iParam++, Aplicativo.iCodEmp );
				ps.setInt( iParam++, ListaCampos.getMasterFilial( "RHEMPREGADO" ) );
				ps.setInt( iParam++, txtMatempr.getVlrInteger() );
			}
			if ( tbPlanoPag.getRowCount() == 0 ) {

				if ( !"".equals( txtCodPlan.getVlrString() ) ) {
					ps.setInt( iParam++, Aplicativo.iCodEmp );
					ps.setInt( iParam++, ListaCampos.getMasterFilial( "FNPLANEJAMENTO" ) );
					if ( codplan.indexOf( "%" ) == -1 ) {
						if ( codplan.length() < 13 ) {
							codplan += "%";
						}
					}

					ps.setString( iParam++, codplan );
				}

			}
			else {
				ps.setInt( iParam++, Aplicativo.iCodEmp );
				ps.setInt( iParam++, ListaCampos.getMasterFilial( "FNPLANEJAMENTO" ) );
			}

			rs = ps.executeQuery();

		} catch ( Exception e ) {

			e.printStackTrace();
			Funcoes.mensagemErro( this, "Erro ao buscar dados " + e.getMessage() );
		}

		if ( bVisualizar == TYPE_PRINT.EXPORT ) {
			if ( btExportXLS.execute( rs, getTitle() ) ) {
				Funcoes.mensagemInforma( this, "Arquivo exportado com sucesso !" );
			}
			try {
				rs.close();
				con.commit();
			} catch ( SQLException e ) {
				e.printStackTrace();
			}
		}
		else {
			imprimiGrafico( rs, bVisualizar, cab.toString() );
		}
	}

	private void imprimiGrafico( final ResultSet rs, final TYPE_PRINT bVisualizar, final String cab ) {

		FPrinterJob dlGr = null;
		HashMap<String, Object> hParam = new HashMap<String, Object>();

		hParam.put( "CODEMP", Aplicativo.iCodEmp );
		hParam.put( "CODFILIAL", ListaCampos.getMasterFilial( "FNCONTA" ) );
		hParam.put( "RAZAOEMP", Aplicativo.empresa.toString() );
		hParam.put( "FILTROS", cab );

		dlGr = new FPrinterJob( "relatorios/FRLancamentos.jasper", "Lan�amentos por categoria", cab, rs, hParam, this );

		if ( bVisualizar == TYPE_PRINT.VIEW ) {
			dlGr.preview();
		}

		else {

			try {
				dlGr.print(true);
			} catch ( Exception err ) {
				Funcoes.mensagemErro( this, "erro na impress�o do relat�rio!" + err.getMessage(), true, con, err );
			}
		}
	}

	public void setConexao( DbConnection cn ) {

		super.setConexao( cn );
		iAnoBase = buscaAnoBaseCC();
		lcConta.setConexao( cn );
		lcPlan.setConexao( cn );
		lcCC.setConexao( cn );
		lcCC.setWhereAdic( "ANOCC=" + iAnoBase );
		lcEmpregado.setConexao( cn );
	}

	private int buscaAnoBaseCC() {

		int iRet = 0;
		String sql = "SELECT ANOCENTROCUSTO FROM SGPREFERE1 WHERE CODEMP=? AND CODFILIAL=?";
		try {
			PreparedStatement ps = con.prepareStatement( sql );
			ps.setInt( 1, Aplicativo.iCodEmp );
			ps.setInt( 2, ListaCampos.getMasterFilial( "SGPREFERE1" ) );
			ResultSet rs = ps.executeQuery();
			if ( rs.next() )
				iRet = rs.getInt( "ANOCENTROCUSTO" );
			rs.close();
			ps.close();
		} catch ( SQLException err ) {
			Funcoes.mensagemErro( this, "Erro ao buscar o ano-base para o centro de custo.\n" + err.getMessage(), true, con, err );
		}
		return iRet;
	}

	@ Override
	public void actionPerformed( ActionEvent evt ) {

		if ( evt.getSource() == btAdicCC ) {
			adicionaGridCentroCusto();
		}
		else if ( evt.getSource() == btLimpaCC ) {
			limpaGridCC();
		}
		else if ( evt.getSource() == btDeletaSelecionadoCC ) {
			deletaLinhaSelecionadaCC();
		}
		else if ( evt.getSource() == btAdic ) {
			adicionaGridPlanPag();
		}
		else if ( evt.getSource() == btLimpa ) {
			limpaGridPlanPag();
		}
		else if ( evt.getSource() == btDeletaSelecionado ) {
			deletaLinhaSelecionada();
		}
		else if ( evt.getSource() == btExportXLS ) {

		}

		super.actionPerformed( evt );
	}

	private void deletaLinhaSelecionadaCC() {

		if ( tbCentroCusto.getSelectedRow() != -1 ) {
			int linha = tbCentroCusto.getSelectedRow();
			tbCentroCusto.delLinha( linha );
		}
		else {
			Funcoes.mensagemInforma( this, "Centro de custo n�o selecionado!" );
			txtCodCC.requestFocus();
			return;
		}

	}

	private void deletaLinhaSelecionada() {

		if ( tbPlanoPag.getSelectedRow() != -1 ) {
			int linha = tbPlanoPag.getSelectedRow();
			tbPlanoPag.delLinha( linha );
		}
		else {
			Funcoes.mensagemInforma( this, "Plano de pagamento n�o selecionado!" );
			txtCodPlan.requestFocus();
			return;
		}

	}

	private void limpaGridCC() {

		tbCentroCusto.limpa();

	}

	private void limpaGridPlanPag() {

		tbPlanoPag.limpa();

	}

	private void adicionaGridCentroCusto() {

		int colCodCC = 0;
		int colSiglaCC = 1;
		int colDescCC = 2;

		int qtdLinhas = tbCentroCusto.getNumLinhas();

		if ( "".equals( txtCodCC.getVlrString() ) ) {
			Funcoes.mensagemInforma( this, "Plano de Pagamento n�o selecionado!" );
			txtCodCC.requestFocus();
			return;
		}

		if ( qtdLinhas > 0 ) {
			String compare = null;
			boolean cadastrado = false;
			for ( int i = 0; i < qtdLinhas; i++ ) {
				compare = tbCentroCusto.getValor( i, 0 ).toString();

				if ( compare.equals( txtCodCC.getVlrString() ) ) {
					cadastrado = true;
					break;
				}

			}

			if ( cadastrado ) {
				Funcoes.mensagemInforma( this, "C�digo Centro de custo j� adicionado!" );
				txtCodCC.requestFocus();
				return;
			}
		}

		tbCentroCusto.adicLinha();

		tbCentroCusto.setValor( txtCodCC.getVlrString(), qtdLinhas, colCodCC );
		tbCentroCusto.setValor( txtSiglaCC.getVlrString(), qtdLinhas, colSiglaCC );
		tbCentroCusto.setValor( txtDescCC.getVlrString(), qtdLinhas, colDescCC );
	}

	private void adicionaGridPlanPag() {

		int qtdLinhas = tbPlanoPag.getNumLinhas();

		if ( "".equals( txtCodPlan.getVlrString() ) ) {
			Funcoes.mensagemInforma( this, "Plano de Pagamento n�o selecionado!" );
			txtCodPlan.requestFocus();
			return;
		}

		if ( txtNivelPlan.getVlrInteger() != 6 ) {
			Funcoes.mensagemInforma( this, "Apenas planejamentos anal�ticos s�o permitidos nessa op��o!" );
			txtCodPlan.requestFocus();
			return;
		}

		if ( qtdLinhas > 0 ) {
			String compare = null;
			boolean cadastrado = false;
			for ( int i = 0; i < qtdLinhas; i++ ) {
				compare = tbPlanoPag.getValor( i, 0 ).toString();

				if ( compare.equals( txtCodPlan.getVlrString() ) ) {
					cadastrado = true;
					break;
				}

			}

			if ( cadastrado ) {
				Funcoes.mensagemInforma( this, "C�digo de planejamento j� adicionado!" );
				txtCodPlan.requestFocus();
				return;
			}
		}

		tbPlanoPag.adicLinha();

		tbPlanoPag.setValor( txtCodPlan.getVlrString(), qtdLinhas, SEQUENCIA.CODIGO.ordinal() );
		tbPlanoPag.setValor( txtDescPlan.getVlrString(), qtdLinhas, SEQUENCIA.DESCRICAO.ordinal() );
		tbPlanoPag.setValor( txtNivelPlan.getVlrInteger(), qtdLinhas, SEQUENCIA.NIVEL.ordinal() );
	}

	public void beforeCarrega( CarregaEvent cevt ) {

		// TODO Auto-generated method stub

	}

	public void afterCarrega( CarregaEvent cevt ) {

		if ( cevt.getListaCampos() == lcPlan ) {
			Vector<Object> lista = txtCodPlan.getResultF2();

			if ( lista != null && lista.size() > 0 ) {
				String anatiticos = "6";
				tbPlanoPag.limpa();

				for ( Object row : lista ) {
					@ SuppressWarnings ( "unchecked" )
					Vector<Object> rowVect = (Vector<Object>) row;
					String nivel = (String) rowVect.elementAt( SEQUENCIA.NIVEL.ordinal() );
					if ( anatiticos.equals( nivel ) ) {
						tbPlanoPag.adicLinha( rowVect );
					}

				}
				txtCodPlan.setResultF2( null );
				txtCodPlan.setVlrString( "" );
				txtDescPlan.setVlrString( "" );
			}
		}

		if ( cevt.getListaCampos() == lcCC ) {
			Vector<Object> lista = txtCodCC.getResultF2();

			if ( lista != null && lista.size() > 0 ) {
				tbCentroCusto.limpa();

				for ( Object row : lista ) {
					@ SuppressWarnings ( "unchecked" )
					Vector<Object> rowVect = (Vector<Object>) row;
					tbCentroCusto.adicLinha( rowVect );
				}
				txtCodCC.setResultF2( null );
				txtCodCC.setVlrString( "" );
				txtDescCC.setVlrString( "" );
			}
		}

	}

}
