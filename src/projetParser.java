// $ANTLR 3.5.2 projet.g 2018-02-16 21:13:41

import java.io.IOException;
import java.io.DataInputStream;
import java.io.FileInputStream;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class projetParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "ID", "INT", "ML_COMMENT", 
		"WS", "'('", "')'", "'*'", "'+'", "','", "'-'", "':'", "':='", "';'", 
		"'<'", "'<='", "'<>'", "'='", "'>'", "'>='", "'alors'", "'aut'", "'bool'", 
		"'cond'", "'const'", "'debut'", "'def'", "'div'", "'ecrire'", "'ent'", 
		"'et'", "'faire'", "'fait'", "'faux'", "'fcond'", "'fin'", "'fixe'", "'fsi'", 
		"'lire'", "'mod'", "'module'", "'non'", "'ou'", "'proc'", "'programme'", 
		"'ref'", "'si'", "'sinon'", "'ttq'", "'var'", "'vrai'"
	};
	public static final int EOF=-1;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int T__38=38;
	public static final int T__39=39;
	public static final int T__40=40;
	public static final int T__41=41;
	public static final int T__42=42;
	public static final int T__43=43;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int T__50=50;
	public static final int T__51=51;
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int COMMENT=4;
	public static final int ID=5;
	public static final int INT=6;
	public static final int ML_COMMENT=7;
	public static final int WS=8;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public projetParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public projetParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return projetParser.tokenNames; }
	@Override public String getGrammarFileName() { return "projet.g"; }




	// variables globales et methodes utiles a placer ici




	// $ANTLR start "unite"
	// projet.g:37:1: unite : ( unitprog EOF | unitmodule EOF );
	public final void unite() throws RecognitionException {
		try {
			// projet.g:37:8: ( unitprog EOF | unitmodule EOF )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==48) ) {
				alt1=1;
			}
			else if ( (LA1_0==44) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// projet.g:37:12: unitprog EOF
					{
					pushFollow(FOLLOW_unitprog_in_unite63);
					unitprog();
					state._fsp--;

					match(input,EOF,FOLLOW_EOF_in_unite66); 
					PtGen.pt(10);
					}
					break;
				case 2 :
					// projet.g:38:12: unitmodule EOF
					{
					pushFollow(FOLLOW_unitmodule_in_unite81);
					unitmodule();
					state._fsp--;

					match(input,EOF,FOLLOW_EOF_in_unite84); 
					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "unite"



	// $ANTLR start "unitprog"
	// projet.g:41:1: unitprog : 'programme' ident ':' declarations corps ;
	public final void unitprog() throws RecognitionException {
		try {
			// projet.g:42:3: ( 'programme' ident ':' declarations corps )
			// projet.g:42:5: 'programme' ident ':' declarations corps
			{
			match(input,48,FOLLOW_48_in_unitprog97); 
			pushFollow(FOLLOW_ident_in_unitprog99);
			ident();
			state._fsp--;

			match(input,15,FOLLOW_15_in_unitprog101); 
			pushFollow(FOLLOW_declarations_in_unitprog108);
			declarations();
			state._fsp--;

			pushFollow(FOLLOW_corps_in_unitprog115);
			corps();
			state._fsp--;

			 System.out.println("succes, arret de la compilation "); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "unitprog"



	// $ANTLR start "unitmodule"
	// projet.g:47:1: unitmodule : 'module' ident ':' declarations ;
	public final void unitmodule() throws RecognitionException {
		try {
			// projet.g:48:3: ( 'module' ident ':' declarations )
			// projet.g:48:5: 'module' ident ':' declarations
			{
			match(input,44,FOLLOW_44_in_unitmodule130); 
			pushFollow(FOLLOW_ident_in_unitmodule132);
			ident();
			state._fsp--;

			match(input,15,FOLLOW_15_in_unitmodule134); 
			pushFollow(FOLLOW_declarations_in_unitmodule141);
			declarations();
			state._fsp--;

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "unitmodule"



	// $ANTLR start "declarations"
	// projet.g:52:1: declarations : ( partiedef )? ( partieref )? ( consts )? ( vars )? ( decprocs )? ;
	public final void declarations() throws RecognitionException {
		try {
			// projet.g:53:3: ( ( partiedef )? ( partieref )? ( consts )? ( vars )? ( decprocs )? )
			// projet.g:53:5: ( partiedef )? ( partieref )? ( consts )? ( vars )? ( decprocs )?
			{
			// projet.g:53:5: ( partiedef )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==30) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// projet.g:53:5: partiedef
					{
					pushFollow(FOLLOW_partiedef_in_declarations154);
					partiedef();
					state._fsp--;

					}
					break;

			}

			// projet.g:53:16: ( partieref )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==49) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// projet.g:53:16: partieref
					{
					pushFollow(FOLLOW_partieref_in_declarations157);
					partieref();
					state._fsp--;

					}
					break;

			}

			// projet.g:53:27: ( consts )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==28) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// projet.g:53:27: consts
					{
					pushFollow(FOLLOW_consts_in_declarations160);
					consts();
					state._fsp--;

					}
					break;

			}

			// projet.g:53:35: ( vars )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==53) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// projet.g:53:35: vars
					{
					pushFollow(FOLLOW_vars_in_declarations163);
					vars();
					state._fsp--;

					}
					break;

			}

			// projet.g:53:41: ( decprocs )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==47) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// projet.g:53:41: decprocs
					{
					pushFollow(FOLLOW_decprocs_in_declarations166);
					decprocs();
					state._fsp--;

					}
					break;

			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "declarations"



	// $ANTLR start "partiedef"
	// projet.g:56:1: partiedef : 'def' ident ( ',' ident )* ptvg ;
	public final void partiedef() throws RecognitionException {
		try {
			// projet.g:57:3: ( 'def' ident ( ',' ident )* ptvg )
			// projet.g:57:5: 'def' ident ( ',' ident )* ptvg
			{
			match(input,30,FOLLOW_30_in_partiedef180); 
			pushFollow(FOLLOW_ident_in_partiedef182);
			ident();
			state._fsp--;

			// projet.g:57:18: ( ',' ident )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==13) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// projet.g:57:19: ',' ident
					{
					match(input,13,FOLLOW_13_in_partiedef186); 
					pushFollow(FOLLOW_ident_in_partiedef188);
					ident();
					state._fsp--;

					}
					break;

				default :
					break loop7;
				}
			}

			pushFollow(FOLLOW_ptvg_in_partiedef193);
			ptvg();
			state._fsp--;

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "partiedef"



	// $ANTLR start "partieref"
	// projet.g:60:1: partieref : 'ref' specif ( ',' specif )* ptvg ;
	public final void partieref() throws RecognitionException {
		try {
			// projet.g:60:10: ( 'ref' specif ( ',' specif )* ptvg )
			// projet.g:60:12: 'ref' specif ( ',' specif )* ptvg
			{
			match(input,49,FOLLOW_49_in_partieref203); 
			pushFollow(FOLLOW_specif_in_partieref206);
			specif();
			state._fsp--;

			// projet.g:60:26: ( ',' specif )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==13) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// projet.g:60:27: ',' specif
					{
					match(input,13,FOLLOW_13_in_partieref209); 
					pushFollow(FOLLOW_specif_in_partieref211);
					specif();
					state._fsp--;

					}
					break;

				default :
					break loop8;
				}
			}

			pushFollow(FOLLOW_ptvg_in_partieref215);
			ptvg();
			state._fsp--;

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "partieref"



	// $ANTLR start "specif"
	// projet.g:63:1: specif : ident ( 'fixe' '(' type ( ',' type )* ')' )? ( 'mod' '(' type ( ',' type )* ')' )? ;
	public final void specif() throws RecognitionException {
		try {
			// projet.g:63:9: ( ident ( 'fixe' '(' type ( ',' type )* ')' )? ( 'mod' '(' type ( ',' type )* ')' )? )
			// projet.g:63:11: ident ( 'fixe' '(' type ( ',' type )* ')' )? ( 'mod' '(' type ( ',' type )* ')' )?
			{
			pushFollow(FOLLOW_ident_in_specif227);
			ident();
			state._fsp--;

			// projet.g:63:18: ( 'fixe' '(' type ( ',' type )* ')' )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==40) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// projet.g:63:20: 'fixe' '(' type ( ',' type )* ')'
					{
					match(input,40,FOLLOW_40_in_specif232); 
					match(input,9,FOLLOW_9_in_specif234); 
					pushFollow(FOLLOW_type_in_specif236);
					type();
					state._fsp--;

					// projet.g:63:37: ( ',' type )*
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==13) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// projet.g:63:39: ',' type
							{
							match(input,13,FOLLOW_13_in_specif241); 
							pushFollow(FOLLOW_type_in_specif243);
							type();
							state._fsp--;

							}
							break;

						default :
							break loop9;
						}
					}

					match(input,10,FOLLOW_10_in_specif249); 
					}
					break;

			}

			// projet.g:64:18: ( 'mod' '(' type ( ',' type )* ')' )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==43) ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// projet.g:64:20: 'mod' '(' type ( ',' type )* ')'
					{
					match(input,43,FOLLOW_43_in_specif273); 
					match(input,9,FOLLOW_9_in_specif276); 
					pushFollow(FOLLOW_type_in_specif278);
					type();
					state._fsp--;

					// projet.g:64:37: ( ',' type )*
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( (LA11_0==13) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// projet.g:64:39: ',' type
							{
							match(input,13,FOLLOW_13_in_specif283); 
							pushFollow(FOLLOW_type_in_specif285);
							type();
							state._fsp--;

							}
							break;

						default :
							break loop11;
						}
					}

					match(input,10,FOLLOW_10_in_specif291); 
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "specif"



	// $ANTLR start "consts"
	// projet.g:67:1: consts : 'const' ( ident '=' valeur ptvg )+ ;
	public final void consts() throws RecognitionException {
		try {
			// projet.g:67:9: ( 'const' ( ident '=' valeur ptvg )+ )
			// projet.g:67:11: 'const' ( ident '=' valeur ptvg )+
			{
			match(input,28,FOLLOW_28_in_consts306); 
			// projet.g:67:19: ( ident '=' valeur ptvg )+
			int cnt13=0;
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==ID) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// projet.g:67:21: ident '=' valeur ptvg
					{
					pushFollow(FOLLOW_ident_in_consts310);
					ident();
					state._fsp--;

					match(input,21,FOLLOW_21_in_consts313); 
					pushFollow(FOLLOW_valeur_in_consts315);
					valeur();
					state._fsp--;

					pushFollow(FOLLOW_ptvg_in_consts318);
					ptvg();
					state._fsp--;

					PtGen.pt(310);
					}
					break;

				default :
					if ( cnt13 >= 1 ) break loop13;
					EarlyExitException eee = new EarlyExitException(13, input);
					throw eee;
				}
				cnt13++;
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "consts"



	// $ANTLR start "vars"
	// projet.g:70:1: vars : 'var' ( type ident ( ',' ident )* ptvg )+ ;
	public final void vars() throws RecognitionException {
		try {
			// projet.g:70:7: ( 'var' ( type ident ( ',' ident )* ptvg )+ )
			// projet.g:70:9: 'var' ( type ident ( ',' ident )* ptvg )+
			{
			match(input,53,FOLLOW_53_in_vars335); 
			// projet.g:70:15: ( type ident ( ',' ident )* ptvg )+
			int cnt15=0;
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==26||LA15_0==33) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// projet.g:70:17: type ident ( ',' ident )* ptvg
					{
					pushFollow(FOLLOW_type_in_vars339);
					type();
					state._fsp--;

					pushFollow(FOLLOW_ident_in_vars341);
					ident();
					state._fsp--;

					// projet.g:70:28: ( ',' ident )*
					loop14:
					while (true) {
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( (LA14_0==13) ) {
							alt14=1;
						}

						switch (alt14) {
						case 1 :
							// projet.g:70:30: ',' ident
							{
							match(input,13,FOLLOW_13_in_vars345); 
							PtGen.pt(340);
							pushFollow(FOLLOW_ident_in_vars350);
							ident();
							state._fsp--;

							}
							break;

						default :
							break loop14;
						}
					}

					pushFollow(FOLLOW_ptvg_in_vars356);
					ptvg();
					state._fsp--;

					PtGen.pt(340);
					}
					break;

				default :
					if ( cnt15 >= 1 ) break loop15;
					EarlyExitException eee = new EarlyExitException(15, input);
					throw eee;
				}
				cnt15++;
			}

			PtGen.pt(341);
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "vars"



	// $ANTLR start "type"
	// projet.g:73:1: type : ( 'ent' | 'bool' );
	public final void type() throws RecognitionException {
		try {
			// projet.g:73:7: ( 'ent' | 'bool' )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==33) ) {
				alt16=1;
			}
			else if ( (LA16_0==26) ) {
				alt16=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// projet.g:73:9: 'ent'
					{
					match(input,33,FOLLOW_33_in_type375); 
					PtGen.pt(370);
					}
					break;
				case 2 :
					// projet.g:74:9: 'bool'
					{
					match(input,26,FOLLOW_26_in_type387); 
					PtGen.pt(380);
					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "type"



	// $ANTLR start "decprocs"
	// projet.g:77:1: decprocs : ( decproc ptvg )+ ;
	public final void decprocs() throws RecognitionException {
		try {
			// projet.g:77:9: ( ( decproc ptvg )+ )
			// projet.g:77:11: ( decproc ptvg )+
			{
			// projet.g:77:11: ( decproc ptvg )+
			int cnt17=0;
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==47) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// projet.g:77:12: decproc ptvg
					{
					pushFollow(FOLLOW_decproc_in_decprocs400);
					decproc();
					state._fsp--;

					pushFollow(FOLLOW_ptvg_in_decprocs402);
					ptvg();
					state._fsp--;

					}
					break;

				default :
					if ( cnt17 >= 1 ) break loop17;
					EarlyExitException eee = new EarlyExitException(17, input);
					throw eee;
				}
				cnt17++;
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "decprocs"



	// $ANTLR start "decproc"
	// projet.g:80:1: decproc : 'proc' ident ( parfixe )? ( parmod )? ( consts )? ( vars )? corps ;
	public final void decproc() throws RecognitionException {
		try {
			// projet.g:80:9: ( 'proc' ident ( parfixe )? ( parmod )? ( consts )? ( vars )? corps )
			// projet.g:80:12: 'proc' ident ( parfixe )? ( parmod )? ( consts )? ( vars )? corps
			{
			match(input,47,FOLLOW_47_in_decproc416); 
			pushFollow(FOLLOW_ident_in_decproc419);
			ident();
			state._fsp--;

			// projet.g:80:27: ( parfixe )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==40) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// projet.g:80:27: parfixe
					{
					pushFollow(FOLLOW_parfixe_in_decproc422);
					parfixe();
					state._fsp--;

					}
					break;

			}

			// projet.g:80:36: ( parmod )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==43) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// projet.g:80:36: parmod
					{
					pushFollow(FOLLOW_parmod_in_decproc425);
					parmod();
					state._fsp--;

					}
					break;

			}

			// projet.g:80:44: ( consts )?
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==28) ) {
				alt20=1;
			}
			switch (alt20) {
				case 1 :
					// projet.g:80:44: consts
					{
					pushFollow(FOLLOW_consts_in_decproc428);
					consts();
					state._fsp--;

					}
					break;

			}

			// projet.g:80:52: ( vars )?
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==53) ) {
				alt21=1;
			}
			switch (alt21) {
				case 1 :
					// projet.g:80:52: vars
					{
					pushFollow(FOLLOW_vars_in_decproc431);
					vars();
					state._fsp--;

					}
					break;

			}

			pushFollow(FOLLOW_corps_in_decproc434);
			corps();
			state._fsp--;

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "decproc"



	// $ANTLR start "ptvg"
	// projet.g:83:1: ptvg : ( ';' |);
	public final void ptvg() throws RecognitionException {
		try {
			// projet.g:83:7: ( ';' |)
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==17) ) {
				alt22=1;
			}
			else if ( (LA22_0==EOF||LA22_0==ID||LA22_0==26||(LA22_0 >= 28 && LA22_0 <= 29)||LA22_0==33||LA22_0==47||LA22_0==49||LA22_0==53) ) {
				alt22=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}

			switch (alt22) {
				case 1 :
					// projet.g:83:9: ';'
					{
					match(input,17,FOLLOW_17_in_ptvg446); 
					}
					break;
				case 2 :
					// projet.g:85:3: 
					{
					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ptvg"



	// $ANTLR start "corps"
	// projet.g:87:1: corps : 'debut' instructions 'fin' ;
	public final void corps() throws RecognitionException {
		try {
			// projet.g:87:7: ( 'debut' instructions 'fin' )
			// projet.g:87:9: 'debut' instructions 'fin'
			{
			match(input,29,FOLLOW_29_in_corps461); 
			pushFollow(FOLLOW_instructions_in_corps463);
			instructions();
			state._fsp--;

			match(input,39,FOLLOW_39_in_corps465); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "corps"



	// $ANTLR start "parfixe"
	// projet.g:90:1: parfixe : 'fixe' '(' pf ( ';' pf )* ')' ;
	public final void parfixe() throws RecognitionException {
		try {
			// projet.g:90:8: ( 'fixe' '(' pf ( ';' pf )* ')' )
			// projet.g:90:10: 'fixe' '(' pf ( ';' pf )* ')'
			{
			match(input,40,FOLLOW_40_in_parfixe475); 
			match(input,9,FOLLOW_9_in_parfixe477); 
			pushFollow(FOLLOW_pf_in_parfixe479);
			pf();
			state._fsp--;

			// projet.g:90:24: ( ';' pf )*
			loop23:
			while (true) {
				int alt23=2;
				int LA23_0 = input.LA(1);
				if ( (LA23_0==17) ) {
					alt23=1;
				}

				switch (alt23) {
				case 1 :
					// projet.g:90:26: ';' pf
					{
					match(input,17,FOLLOW_17_in_parfixe483); 
					pushFollow(FOLLOW_pf_in_parfixe485);
					pf();
					state._fsp--;

					}
					break;

				default :
					break loop23;
				}
			}

			match(input,10,FOLLOW_10_in_parfixe489); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "parfixe"



	// $ANTLR start "pf"
	// projet.g:93:1: pf : type ident ( ',' ident )* ;
	public final void pf() throws RecognitionException {
		try {
			// projet.g:93:5: ( type ident ( ',' ident )* )
			// projet.g:93:7: type ident ( ',' ident )*
			{
			pushFollow(FOLLOW_type_in_pf501);
			type();
			state._fsp--;

			pushFollow(FOLLOW_ident_in_pf503);
			ident();
			state._fsp--;

			// projet.g:93:19: ( ',' ident )*
			loop24:
			while (true) {
				int alt24=2;
				int LA24_0 = input.LA(1);
				if ( (LA24_0==13) ) {
					alt24=1;
				}

				switch (alt24) {
				case 1 :
					// projet.g:93:21: ',' ident
					{
					match(input,13,FOLLOW_13_in_pf508); 
					pushFollow(FOLLOW_ident_in_pf510);
					ident();
					state._fsp--;

					}
					break;

				default :
					break loop24;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "pf"



	// $ANTLR start "parmod"
	// projet.g:96:1: parmod : 'mod' '(' pm ( ';' pm )* ')' ;
	public final void parmod() throws RecognitionException {
		try {
			// projet.g:96:9: ( 'mod' '(' pm ( ';' pm )* ')' )
			// projet.g:96:11: 'mod' '(' pm ( ';' pm )* ')'
			{
			match(input,43,FOLLOW_43_in_parmod526); 
			match(input,9,FOLLOW_9_in_parmod528); 
			pushFollow(FOLLOW_pm_in_parmod530);
			pm();
			state._fsp--;

			// projet.g:96:24: ( ';' pm )*
			loop25:
			while (true) {
				int alt25=2;
				int LA25_0 = input.LA(1);
				if ( (LA25_0==17) ) {
					alt25=1;
				}

				switch (alt25) {
				case 1 :
					// projet.g:96:26: ';' pm
					{
					match(input,17,FOLLOW_17_in_parmod534); 
					pushFollow(FOLLOW_pm_in_parmod536);
					pm();
					state._fsp--;

					}
					break;

				default :
					break loop25;
				}
			}

			match(input,10,FOLLOW_10_in_parmod540); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "parmod"



	// $ANTLR start "pm"
	// projet.g:99:1: pm : type ident ( ',' ident )* ;
	public final void pm() throws RecognitionException {
		try {
			// projet.g:99:5: ( type ident ( ',' ident )* )
			// projet.g:99:7: type ident ( ',' ident )*
			{
			pushFollow(FOLLOW_type_in_pm552);
			type();
			state._fsp--;

			pushFollow(FOLLOW_ident_in_pm554);
			ident();
			state._fsp--;

			// projet.g:99:19: ( ',' ident )*
			loop26:
			while (true) {
				int alt26=2;
				int LA26_0 = input.LA(1);
				if ( (LA26_0==13) ) {
					alt26=1;
				}

				switch (alt26) {
				case 1 :
					// projet.g:99:21: ',' ident
					{
					match(input,13,FOLLOW_13_in_pm559); 
					pushFollow(FOLLOW_ident_in_pm561);
					ident();
					state._fsp--;

					}
					break;

				default :
					break loop26;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "pm"



	// $ANTLR start "instructions"
	// projet.g:102:1: instructions : instruction ( ';' instruction )* ;
	public final void instructions() throws RecognitionException {
		try {
			// projet.g:103:3: ( instruction ( ';' instruction )* )
			// projet.g:103:5: instruction ( ';' instruction )*
			{
			pushFollow(FOLLOW_instruction_in_instructions578);
			instruction();
			state._fsp--;

			// projet.g:103:17: ( ';' instruction )*
			loop27:
			while (true) {
				int alt27=2;
				int LA27_0 = input.LA(1);
				if ( (LA27_0==17) ) {
					alt27=1;
				}

				switch (alt27) {
				case 1 :
					// projet.g:103:19: ';' instruction
					{
					match(input,17,FOLLOW_17_in_instructions582); 
					pushFollow(FOLLOW_instruction_in_instructions584);
					instruction();
					state._fsp--;

					}
					break;

				default :
					break loop27;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "instructions"



	// $ANTLR start "instruction"
	// projet.g:106:1: instruction : ( inssi | inscond | boucle | lecture | ecriture | affouappel |);
	public final void instruction() throws RecognitionException {
		try {
			// projet.g:107:3: ( inssi | inscond | boucle | lecture | ecriture | affouappel |)
			int alt28=7;
			switch ( input.LA(1) ) {
			case 50:
				{
				alt28=1;
				}
				break;
			case 27:
				{
				alt28=2;
				}
				break;
			case 52:
				{
				alt28=3;
				}
				break;
			case 42:
				{
				alt28=4;
				}
				break;
			case 32:
				{
				alt28=5;
				}
				break;
			case ID:
				{
				alt28=6;
				}
				break;
			case 13:
			case 17:
			case 25:
			case 36:
			case 38:
			case 39:
			case 41:
			case 51:
				{
				alt28=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 28, 0, input);
				throw nvae;
			}
			switch (alt28) {
				case 1 :
					// projet.g:107:5: inssi
					{
					pushFollow(FOLLOW_inssi_in_instruction599);
					inssi();
					state._fsp--;

					}
					break;
				case 2 :
					// projet.g:108:5: inscond
					{
					pushFollow(FOLLOW_inscond_in_instruction605);
					inscond();
					state._fsp--;

					}
					break;
				case 3 :
					// projet.g:109:5: boucle
					{
					pushFollow(FOLLOW_boucle_in_instruction611);
					boucle();
					state._fsp--;

					}
					break;
				case 4 :
					// projet.g:110:5: lecture
					{
					pushFollow(FOLLOW_lecture_in_instruction617);
					lecture();
					state._fsp--;

					}
					break;
				case 5 :
					// projet.g:111:5: ecriture
					{
					pushFollow(FOLLOW_ecriture_in_instruction623);
					ecriture();
					state._fsp--;

					}
					break;
				case 6 :
					// projet.g:112:5: affouappel
					{
					pushFollow(FOLLOW_affouappel_in_instruction629);
					affouappel();
					state._fsp--;

					}
					break;
				case 7 :
					// projet.g:114:3: 
					{
					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "instruction"



	// $ANTLR start "inssi"
	// projet.g:116:1: inssi : 'si' expression 'alors' instructions ( 'sinon' instructions )? 'fsi' ;
	public final void inssi() throws RecognitionException {
		try {
			// projet.g:116:7: ( 'si' expression 'alors' instructions ( 'sinon' instructions )? 'fsi' )
			// projet.g:116:9: 'si' expression 'alors' instructions ( 'sinon' instructions )? 'fsi'
			{
			match(input,50,FOLLOW_50_in_inssi644); 
			pushFollow(FOLLOW_expression_in_inssi646);
			expression();
			state._fsp--;

			match(input,24,FOLLOW_24_in_inssi648); 
			pushFollow(FOLLOW_instructions_in_inssi650);
			instructions();
			state._fsp--;

			// projet.g:116:46: ( 'sinon' instructions )?
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( (LA29_0==51) ) {
				alt29=1;
			}
			switch (alt29) {
				case 1 :
					// projet.g:116:47: 'sinon' instructions
					{
					match(input,51,FOLLOW_51_in_inssi653); 
					pushFollow(FOLLOW_instructions_in_inssi656);
					instructions();
					state._fsp--;

					}
					break;

			}

			match(input,41,FOLLOW_41_in_inssi660); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "inssi"



	// $ANTLR start "inscond"
	// projet.g:119:1: inscond : 'cond' expression ':' instructions ( ',' expression ':' instructions )* ( 'aut' instructions |) 'fcond' ;
	public final void inscond() throws RecognitionException {
		try {
			// projet.g:119:9: ( 'cond' expression ':' instructions ( ',' expression ':' instructions )* ( 'aut' instructions |) 'fcond' )
			// projet.g:119:11: 'cond' expression ':' instructions ( ',' expression ':' instructions )* ( 'aut' instructions |) 'fcond'
			{
			match(input,27,FOLLOW_27_in_inscond671); 
			pushFollow(FOLLOW_expression_in_inscond674);
			expression();
			state._fsp--;

			match(input,15,FOLLOW_15_in_inscond677); 
			pushFollow(FOLLOW_instructions_in_inscond679);
			instructions();
			state._fsp--;

			// projet.g:120:11: ( ',' expression ':' instructions )*
			loop30:
			while (true) {
				int alt30=2;
				int LA30_0 = input.LA(1);
				if ( (LA30_0==13) ) {
					alt30=1;
				}

				switch (alt30) {
				case 1 :
					// projet.g:120:12: ',' expression ':' instructions
					{
					match(input,13,FOLLOW_13_in_inscond692); 
					pushFollow(FOLLOW_expression_in_inscond695);
					expression();
					state._fsp--;

					match(input,15,FOLLOW_15_in_inscond698); 
					pushFollow(FOLLOW_instructions_in_inscond700);
					instructions();
					state._fsp--;

					}
					break;

				default :
					break loop30;
				}
			}

			// projet.g:121:11: ( 'aut' instructions |)
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( (LA31_0==25) ) {
				alt31=1;
			}
			else if ( (LA31_0==38) ) {
				alt31=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 31, 0, input);
				throw nvae;
			}

			switch (alt31) {
				case 1 :
					// projet.g:121:12: 'aut' instructions
					{
					match(input,25,FOLLOW_25_in_inscond716); 
					pushFollow(FOLLOW_instructions_in_inscond719);
					instructions();
					state._fsp--;

					}
					break;
				case 2 :
					// projet.g:121:35: 
					{
					}
					break;

			}

			match(input,38,FOLLOW_38_in_inscond736); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "inscond"



	// $ANTLR start "boucle"
	// projet.g:125:1: boucle : 'ttq' expression 'faire' instructions 'fait' ;
	public final void boucle() throws RecognitionException {
		try {
			// projet.g:125:9: ( 'ttq' expression 'faire' instructions 'fait' )
			// projet.g:125:11: 'ttq' expression 'faire' instructions 'fait'
			{
			match(input,52,FOLLOW_52_in_boucle748); 
			pushFollow(FOLLOW_expression_in_boucle751);
			expression();
			state._fsp--;

			match(input,35,FOLLOW_35_in_boucle753); 
			pushFollow(FOLLOW_instructions_in_boucle755);
			instructions();
			state._fsp--;

			match(input,36,FOLLOW_36_in_boucle757); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "boucle"



	// $ANTLR start "lecture"
	// projet.g:128:1: lecture : 'lire' '(' ident ( ',' ident )* ')' ;
	public final void lecture() throws RecognitionException {
		try {
			// projet.g:128:8: ( 'lire' '(' ident ( ',' ident )* ')' )
			// projet.g:128:10: 'lire' '(' ident ( ',' ident )* ')'
			{
			match(input,42,FOLLOW_42_in_lecture767); 
			match(input,9,FOLLOW_9_in_lecture769); 
			pushFollow(FOLLOW_ident_in_lecture771);
			ident();
			state._fsp--;

			PtGen.pt(920);
			// projet.g:128:44: ( ',' ident )*
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( (LA32_0==13) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// projet.g:128:46: ',' ident
					{
					match(input,13,FOLLOW_13_in_lecture777); 
					pushFollow(FOLLOW_ident_in_lecture779);
					ident();
					state._fsp--;

					PtGen.pt(920);
					}
					break;

				default :
					break loop32;
				}
			}

			match(input,10,FOLLOW_10_in_lecture786); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "lecture"



	// $ANTLR start "ecriture"
	// projet.g:131:1: ecriture : 'ecrire' '(' expression ( ',' expression )* ')' ;
	public final void ecriture() throws RecognitionException {
		try {
			// projet.g:131:9: ( 'ecrire' '(' expression ( ',' expression )* ')' )
			// projet.g:131:11: 'ecrire' '(' expression ( ',' expression )* ')'
			{
			match(input,32,FOLLOW_32_in_ecriture796); 
			match(input,9,FOLLOW_9_in_ecriture798); 
			pushFollow(FOLLOW_expression_in_ecriture800);
			expression();
			state._fsp--;

			PtGen.pt(950);
			// projet.g:131:52: ( ',' expression )*
			loop33:
			while (true) {
				int alt33=2;
				int LA33_0 = input.LA(1);
				if ( (LA33_0==13) ) {
					alt33=1;
				}

				switch (alt33) {
				case 1 :
					// projet.g:131:54: ',' expression
					{
					match(input,13,FOLLOW_13_in_ecriture806); 
					pushFollow(FOLLOW_expression_in_ecriture808);
					expression();
					state._fsp--;

					PtGen.pt(950);
					}
					break;

				default :
					break loop33;
				}
			}

			match(input,10,FOLLOW_10_in_ecriture815); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ecriture"



	// $ANTLR start "affouappel"
	// projet.g:134:1: affouappel : ident ( ':=' expression | ( effixes ( effmods )? )? ) ;
	public final void affouappel() throws RecognitionException {
		try {
			// projet.g:135:3: ( ident ( ':=' expression | ( effixes ( effmods )? )? ) )
			// projet.g:135:5: ident ( ':=' expression | ( effixes ( effmods )? )? )
			{
			pushFollow(FOLLOW_ident_in_affouappel829);
			ident();
			state._fsp--;

			// projet.g:135:12: ( ':=' expression | ( effixes ( effmods )? )? )
			int alt36=2;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==16) ) {
				alt36=1;
			}
			else if ( (LA36_0==9||LA36_0==13||LA36_0==17||LA36_0==25||LA36_0==36||(LA36_0 >= 38 && LA36_0 <= 39)||LA36_0==41||LA36_0==51) ) {
				alt36=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 36, 0, input);
				throw nvae;
			}

			switch (alt36) {
				case 1 :
					// projet.g:135:14: ':=' expression
					{
					PtGen.pt(990);
					match(input,16,FOLLOW_16_in_affouappel836); 
					pushFollow(FOLLOW_expression_in_affouappel838);
					expression();
					state._fsp--;

					PtGen.pt(991);
					}
					break;
				case 2 :
					// projet.g:136:17: ( effixes ( effmods )? )?
					{
					// projet.g:136:17: ( effixes ( effmods )? )?
					int alt35=2;
					int LA35_0 = input.LA(1);
					if ( (LA35_0==9) ) {
						alt35=1;
					}
					switch (alt35) {
						case 1 :
							// projet.g:136:18: effixes ( effmods )?
							{
							pushFollow(FOLLOW_effixes_in_affouappel859);
							effixes();
							state._fsp--;

							// projet.g:136:26: ( effmods )?
							int alt34=2;
							int LA34_0 = input.LA(1);
							if ( (LA34_0==9) ) {
								alt34=1;
							}
							switch (alt34) {
								case 1 :
									// projet.g:136:27: effmods
									{
									pushFollow(FOLLOW_effmods_in_affouappel862);
									effmods();
									state._fsp--;

									}
									break;

							}

							}
							break;

					}

					}
					break;

			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "affouappel"



	// $ANTLR start "effixes"
	// projet.g:140:1: effixes : '(' ( expression ( ',' expression )* )? ')' ;
	public final void effixes() throws RecognitionException {
		try {
			// projet.g:140:9: ( '(' ( expression ( ',' expression )* )? ')' )
			// projet.g:140:11: '(' ( expression ( ',' expression )* )? ')'
			{
			match(input,9,FOLLOW_9_in_effixes890); 
			// projet.g:140:15: ( expression ( ',' expression )* )?
			int alt38=2;
			int LA38_0 = input.LA(1);
			if ( ((LA38_0 >= ID && LA38_0 <= INT)||LA38_0==9||LA38_0==12||LA38_0==14||LA38_0==37||LA38_0==45||LA38_0==54) ) {
				alt38=1;
			}
			switch (alt38) {
				case 1 :
					// projet.g:140:16: expression ( ',' expression )*
					{
					pushFollow(FOLLOW_expression_in_effixes893);
					expression();
					state._fsp--;

					// projet.g:140:28: ( ',' expression )*
					loop37:
					while (true) {
						int alt37=2;
						int LA37_0 = input.LA(1);
						if ( (LA37_0==13) ) {
							alt37=1;
						}

						switch (alt37) {
						case 1 :
							// projet.g:140:29: ',' expression
							{
							match(input,13,FOLLOW_13_in_effixes897); 
							pushFollow(FOLLOW_expression_in_effixes899);
							expression();
							state._fsp--;

							}
							break;

						default :
							break loop37;
						}
					}

					}
					break;

			}

			match(input,10,FOLLOW_10_in_effixes907); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "effixes"



	// $ANTLR start "effmods"
	// projet.g:143:1: effmods : '(' ( ident ( ',' ident )* )? ')' ;
	public final void effmods() throws RecognitionException {
		try {
			// projet.g:143:9: ( '(' ( ident ( ',' ident )* )? ')' )
			// projet.g:143:10: '(' ( ident ( ',' ident )* )? ')'
			{
			match(input,9,FOLLOW_9_in_effmods917); 
			// projet.g:143:14: ( ident ( ',' ident )* )?
			int alt40=2;
			int LA40_0 = input.LA(1);
			if ( (LA40_0==ID) ) {
				alt40=1;
			}
			switch (alt40) {
				case 1 :
					// projet.g:143:15: ident ( ',' ident )*
					{
					pushFollow(FOLLOW_ident_in_effmods920);
					ident();
					state._fsp--;

					// projet.g:143:22: ( ',' ident )*
					loop39:
					while (true) {
						int alt39=2;
						int LA39_0 = input.LA(1);
						if ( (LA39_0==13) ) {
							alt39=1;
						}

						switch (alt39) {
						case 1 :
							// projet.g:143:23: ',' ident
							{
							match(input,13,FOLLOW_13_in_effmods924); 
							pushFollow(FOLLOW_ident_in_effmods926);
							ident();
							state._fsp--;

							}
							break;

						default :
							break loop39;
						}
					}

					}
					break;

			}

			match(input,10,FOLLOW_10_in_effmods934); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "effmods"



	// $ANTLR start "expression"
	// projet.g:146:1: expression : ( exp1 ) ( 'ou' exp1 )* ;
	public final void expression() throws RecognitionException {
		try {
			// projet.g:146:11: ( ( exp1 ) ( 'ou' exp1 )* )
			// projet.g:146:13: ( exp1 ) ( 'ou' exp1 )*
			{
			// projet.g:146:13: ( exp1 )
			// projet.g:146:14: exp1
			{
			pushFollow(FOLLOW_exp1_in_expression945);
			exp1();
			state._fsp--;

			}

			// projet.g:146:20: ( 'ou' exp1 )*
			loop41:
			while (true) {
				int alt41=2;
				int LA41_0 = input.LA(1);
				if ( (LA41_0==46) ) {
					alt41=1;
				}

				switch (alt41) {
				case 1 :
					// projet.g:146:21: 'ou' exp1
					{
					match(input,46,FOLLOW_46_in_expression949); 
					PtGen.pt(1110);
					pushFollow(FOLLOW_exp1_in_expression953);
					exp1();
					state._fsp--;

					PtGen.pt(1110); PtGen.pt(1111);
					}
					break;

				default :
					break loop41;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "expression"



	// $ANTLR start "exp1"
	// projet.g:149:1: exp1 : exp2 ( 'et' exp2 )* ;
	public final void exp1() throws RecognitionException {
		try {
			// projet.g:149:7: ( exp2 ( 'et' exp2 )* )
			// projet.g:149:9: exp2 ( 'et' exp2 )*
			{
			pushFollow(FOLLOW_exp2_in_exp1970);
			exp2();
			state._fsp--;

			// projet.g:149:14: ( 'et' exp2 )*
			loop42:
			while (true) {
				int alt42=2;
				int LA42_0 = input.LA(1);
				if ( (LA42_0==34) ) {
					alt42=1;
				}

				switch (alt42) {
				case 1 :
					// projet.g:149:15: 'et' exp2
					{
					match(input,34,FOLLOW_34_in_exp1973); 
					PtGen.pt(1110);
					pushFollow(FOLLOW_exp2_in_exp1977);
					exp2();
					state._fsp--;

					PtGen.pt(1110); PtGen.pt(1131);
					}
					break;

				default :
					break loop42;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp1"



	// $ANTLR start "exp2"
	// projet.g:152:1: exp2 : ( 'non' exp2 | exp3 );
	public final void exp2() throws RecognitionException {
		try {
			// projet.g:152:7: ( 'non' exp2 | exp3 )
			int alt43=2;
			int LA43_0 = input.LA(1);
			if ( (LA43_0==45) ) {
				alt43=1;
			}
			else if ( ((LA43_0 >= ID && LA43_0 <= INT)||LA43_0==9||LA43_0==12||LA43_0==14||LA43_0==37||LA43_0==54) ) {
				alt43=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 43, 0, input);
				throw nvae;
			}

			switch (alt43) {
				case 1 :
					// projet.g:152:9: 'non' exp2
					{
					match(input,45,FOLLOW_45_in_exp2994); 
					pushFollow(FOLLOW_exp2_in_exp2996);
					exp2();
					state._fsp--;

					PtGen.pt(1160);
					}
					break;
				case 2 :
					// projet.g:153:5: exp3
					{
					pushFollow(FOLLOW_exp3_in_exp21004);
					exp3();
					state._fsp--;

					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp2"



	// $ANTLR start "exp3"
	// projet.g:156:1: exp3 : exp4 ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )? ;
	public final void exp3() throws RecognitionException {
		try {
			// projet.g:156:7: ( exp4 ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )? )
			// projet.g:156:9: exp4 ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )?
			{
			pushFollow(FOLLOW_exp4_in_exp31016);
			exp4();
			state._fsp--;

			// projet.g:157:3: ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )?
			int alt44=7;
			switch ( input.LA(1) ) {
				case 21:
					{
					alt44=1;
					}
					break;
				case 20:
					{
					alt44=2;
					}
					break;
				case 22:
					{
					alt44=3;
					}
					break;
				case 23:
					{
					alt44=4;
					}
					break;
				case 18:
					{
					alt44=5;
					}
					break;
				case 19:
					{
					alt44=6;
					}
					break;
			}
			switch (alt44) {
				case 1 :
					// projet.g:157:5: '=' exp4
					{
					match(input,21,FOLLOW_21_in_exp31022); 
					PtGen.pt(1200);
					pushFollow(FOLLOW_exp4_in_exp31027);
					exp4();
					state._fsp--;

					PtGen.pt(1200); PtGen.pt(1211); PtGen.pt(1201);
					}
					break;
				case 2 :
					// projet.g:158:5: '<>' exp4
					{
					match(input,20,FOLLOW_20_in_exp31035); 
					PtGen.pt(1200);
					pushFollow(FOLLOW_exp4_in_exp31039);
					exp4();
					state._fsp--;

					PtGen.pt(1200); PtGen.pt(1221); PtGen.pt(1201);
					}
					break;
				case 3 :
					// projet.g:159:5: '>' exp4
					{
					match(input,22,FOLLOW_22_in_exp31047); 
					PtGen.pt(1200);
					pushFollow(FOLLOW_exp4_in_exp31052);
					exp4();
					state._fsp--;

					PtGen.pt(1200); PtGen.pt(1231); PtGen.pt(1201);
					}
					break;
				case 4 :
					// projet.g:160:5: '>=' exp4
					{
					match(input,23,FOLLOW_23_in_exp31060); 
					PtGen.pt(1200);
					pushFollow(FOLLOW_exp4_in_exp31064);
					exp4();
					state._fsp--;

					PtGen.pt(1200); PtGen.pt(1241); PtGen.pt(1201);
					}
					break;
				case 5 :
					// projet.g:161:5: '<' exp4
					{
					match(input,18,FOLLOW_18_in_exp31072); 
					PtGen.pt(1200);
					pushFollow(FOLLOW_exp4_in_exp31077);
					exp4();
					state._fsp--;

					PtGen.pt(1200); PtGen.pt(1251); PtGen.pt(1201);
					}
					break;
				case 6 :
					// projet.g:162:5: '<=' exp4
					{
					match(input,19,FOLLOW_19_in_exp31085); 
					PtGen.pt(1200);
					pushFollow(FOLLOW_exp4_in_exp31089);
					exp4();
					state._fsp--;

					PtGen.pt(1200); PtGen.pt(1261); PtGen.pt(1201);
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp3"



	// $ANTLR start "exp4"
	// projet.g:166:1: exp4 : exp5 ( '+' exp5 | '-' exp5 )* ;
	public final void exp4() throws RecognitionException {
		try {
			// projet.g:166:7: ( exp5 ( '+' exp5 | '-' exp5 )* )
			// projet.g:166:9: exp5 ( '+' exp5 | '-' exp5 )*
			{
			pushFollow(FOLLOW_exp5_in_exp41109);
			exp5();
			state._fsp--;

			// projet.g:167:9: ( '+' exp5 | '-' exp5 )*
			loop45:
			while (true) {
				int alt45=3;
				int LA45_0 = input.LA(1);
				if ( (LA45_0==12) ) {
					alt45=1;
				}
				else if ( (LA45_0==14) ) {
					alt45=2;
				}

				switch (alt45) {
				case 1 :
					// projet.g:167:10: '+' exp5
					{
					match(input,12,FOLLOW_12_in_exp41120); 
					PtGen.pt(1200);
					pushFollow(FOLLOW_exp5_in_exp41124);
					exp5();
					state._fsp--;

					PtGen.pt(1200); PtGen.pt(1310);
					}
					break;
				case 2 :
					// projet.g:168:10: '-' exp5
					{
					match(input,14,FOLLOW_14_in_exp41137); 
					PtGen.pt(1200);
					pushFollow(FOLLOW_exp5_in_exp41141);
					exp5();
					state._fsp--;

					PtGen.pt(1200); PtGen.pt(1320);
					}
					break;

				default :
					break loop45;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp4"



	// $ANTLR start "exp5"
	// projet.g:172:1: exp5 : primaire ( '*' primaire | 'div' primaire )* ;
	public final void exp5() throws RecognitionException {
		try {
			// projet.g:172:7: ( primaire ( '*' primaire | 'div' primaire )* )
			// projet.g:172:9: primaire ( '*' primaire | 'div' primaire )*
			{
			pushFollow(FOLLOW_primaire_in_exp51166);
			primaire();
			state._fsp--;

			// projet.g:173:9: ( '*' primaire | 'div' primaire )*
			loop46:
			while (true) {
				int alt46=3;
				int LA46_0 = input.LA(1);
				if ( (LA46_0==11) ) {
					alt46=1;
				}
				else if ( (LA46_0==31) ) {
					alt46=2;
				}

				switch (alt46) {
				case 1 :
					// projet.g:173:14: '*' primaire
					{
					match(input,11,FOLLOW_11_in_exp51181); 
					PtGen.pt(1200);
					pushFollow(FOLLOW_primaire_in_exp51186);
					primaire();
					state._fsp--;

					PtGen.pt(1200); PtGen.pt(1370);
					}
					break;
				case 2 :
					// projet.g:174:13: 'div' primaire
					{
					match(input,31,FOLLOW_31_in_exp51202); 
					PtGen.pt(1200);
					pushFollow(FOLLOW_primaire_in_exp51206);
					primaire();
					state._fsp--;

					PtGen.pt(1200); PtGen.pt(1380);
					}
					break;

				default :
					break loop46;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp5"



	// $ANTLR start "primaire"
	// projet.g:178:1: primaire : ( valeur | ident | '(' expression ')' );
	public final void primaire() throws RecognitionException {
		try {
			// projet.g:178:9: ( valeur | ident | '(' expression ')' )
			int alt47=3;
			switch ( input.LA(1) ) {
			case INT:
			case 12:
			case 14:
			case 37:
			case 54:
				{
				alt47=1;
				}
				break;
			case ID:
				{
				alt47=2;
				}
				break;
			case 9:
				{
				alt47=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 47, 0, input);
				throw nvae;
			}
			switch (alt47) {
				case 1 :
					// projet.g:178:11: valeur
					{
					pushFollow(FOLLOW_valeur_in_primaire1229);
					valeur();
					state._fsp--;

					PtGen.pt(1420);
					}
					break;
				case 2 :
					// projet.g:179:5: ident
					{
					pushFollow(FOLLOW_ident_in_primaire1237);
					ident();
					state._fsp--;

					PtGen.pt(1430);
					}
					break;
				case 3 :
					// projet.g:180:5: '(' expression ')'
					{
					match(input,9,FOLLOW_9_in_primaire1245); 
					pushFollow(FOLLOW_expression_in_primaire1247);
					expression();
					state._fsp--;

					match(input,10,FOLLOW_10_in_primaire1249); 
					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "primaire"



	// $ANTLR start "valeur"
	// projet.g:183:1: valeur : ( nbentier | '+' nbentier | '-' nbentier | 'vrai' | 'faux' );
	public final void valeur() throws RecognitionException {
		try {
			// projet.g:183:9: ( nbentier | '+' nbentier | '-' nbentier | 'vrai' | 'faux' )
			int alt48=5;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt48=1;
				}
				break;
			case 12:
				{
				alt48=2;
				}
				break;
			case 14:
				{
				alt48=3;
				}
				break;
			case 54:
				{
				alt48=4;
				}
				break;
			case 37:
				{
				alt48=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 48, 0, input);
				throw nvae;
			}
			switch (alt48) {
				case 1 :
					// projet.g:183:11: nbentier
					{
					pushFollow(FOLLOW_nbentier_in_valeur1261);
					nbentier();
					state._fsp--;

					PtGen.pt(1470);
					}
					break;
				case 2 :
					// projet.g:184:5: '+' nbentier
					{
					match(input,12,FOLLOW_12_in_valeur1269); 
					pushFollow(FOLLOW_nbentier_in_valeur1271);
					nbentier();
					state._fsp--;

					PtGen.pt(1470);
					}
					break;
				case 3 :
					// projet.g:185:5: '-' nbentier
					{
					match(input,14,FOLLOW_14_in_valeur1279); 
					pushFollow(FOLLOW_nbentier_in_valeur1281);
					nbentier();
					state._fsp--;

					PtGen.pt(1490);
					}
					break;
				case 4 :
					// projet.g:186:5: 'vrai'
					{
					match(input,54,FOLLOW_54_in_valeur1289); 
					PtGen.pt(1500);
					}
					break;
				case 5 :
					// projet.g:187:5: 'faux'
					{
					match(input,37,FOLLOW_37_in_valeur1297); 
					PtGen.pt(1510);
					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "valeur"



	// $ANTLR start "nbentier"
	// projet.g:197:1: nbentier : INT ;
	public final void nbentier() throws RecognitionException {
		Token INT1=null;

		try {
			// projet.g:197:11: ( INT )
			// projet.g:197:15: INT
			{
			INT1=(Token)match(input,INT,FOLLOW_INT_in_nbentier1320); 
			 UtilLex.valNb = Integer.parseInt((INT1!=null?INT1.getText():null));
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "nbentier"



	// $ANTLR start "ident"
	// projet.g:199:1: ident : ID ;
	public final void ident() throws RecognitionException {
		Token ID2=null;

		try {
			// projet.g:199:7: ( ID )
			// projet.g:199:9: ID
			{
			ID2=(Token)match(input,ID,FOLLOW_ID_in_ident1331); 
			 UtilLex.traiterId((ID2!=null?ID2.getText():null)); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ident"

	// Delegated rules



	public static final BitSet FOLLOW_unitprog_in_unite63 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_unite66 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unitmodule_in_unite81 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_unite84 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_48_in_unitprog97 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_unitprog99 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_unitprog101 = new BitSet(new long[]{0x0022800070000000L});
	public static final BitSet FOLLOW_declarations_in_unitprog108 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_corps_in_unitprog115 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_44_in_unitmodule130 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_unitmodule132 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_unitmodule134 = new BitSet(new long[]{0x0022800050000000L});
	public static final BitSet FOLLOW_declarations_in_unitmodule141 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_partiedef_in_declarations154 = new BitSet(new long[]{0x0022800010000002L});
	public static final BitSet FOLLOW_partieref_in_declarations157 = new BitSet(new long[]{0x0020800010000002L});
	public static final BitSet FOLLOW_consts_in_declarations160 = new BitSet(new long[]{0x0020800000000002L});
	public static final BitSet FOLLOW_vars_in_declarations163 = new BitSet(new long[]{0x0000800000000002L});
	public static final BitSet FOLLOW_decprocs_in_declarations166 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_partiedef180 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_partiedef182 = new BitSet(new long[]{0x0000000000022000L});
	public static final BitSet FOLLOW_13_in_partiedef186 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_partiedef188 = new BitSet(new long[]{0x0000000000022000L});
	public static final BitSet FOLLOW_ptvg_in_partiedef193 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_49_in_partieref203 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_specif_in_partieref206 = new BitSet(new long[]{0x0000000000022000L});
	public static final BitSet FOLLOW_13_in_partieref209 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_specif_in_partieref211 = new BitSet(new long[]{0x0000000000022000L});
	public static final BitSet FOLLOW_ptvg_in_partieref215 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_specif227 = new BitSet(new long[]{0x0000090000000002L});
	public static final BitSet FOLLOW_40_in_specif232 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_specif234 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_type_in_specif236 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_13_in_specif241 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_type_in_specif243 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_10_in_specif249 = new BitSet(new long[]{0x0000080000000002L});
	public static final BitSet FOLLOW_43_in_specif273 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_specif276 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_type_in_specif278 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_13_in_specif283 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_type_in_specif285 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_10_in_specif291 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_consts306 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_consts310 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_consts313 = new BitSet(new long[]{0x0040002000005040L});
	public static final BitSet FOLLOW_valeur_in_consts315 = new BitSet(new long[]{0x0000000000020020L});
	public static final BitSet FOLLOW_ptvg_in_consts318 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_53_in_vars335 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_type_in_vars339 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_vars341 = new BitSet(new long[]{0x0000000204022000L});
	public static final BitSet FOLLOW_13_in_vars345 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_vars350 = new BitSet(new long[]{0x0000000204022000L});
	public static final BitSet FOLLOW_ptvg_in_vars356 = new BitSet(new long[]{0x0000000204000002L});
	public static final BitSet FOLLOW_33_in_type375 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_type387 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_decproc_in_decprocs400 = new BitSet(new long[]{0x0000800000020000L});
	public static final BitSet FOLLOW_ptvg_in_decprocs402 = new BitSet(new long[]{0x0000800000000002L});
	public static final BitSet FOLLOW_47_in_decproc416 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_decproc419 = new BitSet(new long[]{0x0020090030000000L});
	public static final BitSet FOLLOW_parfixe_in_decproc422 = new BitSet(new long[]{0x0020080030000000L});
	public static final BitSet FOLLOW_parmod_in_decproc425 = new BitSet(new long[]{0x0020000030000000L});
	public static final BitSet FOLLOW_consts_in_decproc428 = new BitSet(new long[]{0x0020000020000000L});
	public static final BitSet FOLLOW_vars_in_decproc431 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_corps_in_decproc434 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_ptvg446 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_corps461 = new BitSet(new long[]{0x0014040108020020L});
	public static final BitSet FOLLOW_instructions_in_corps463 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_39_in_corps465 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_40_in_parfixe475 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_parfixe477 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_pf_in_parfixe479 = new BitSet(new long[]{0x0000000000020400L});
	public static final BitSet FOLLOW_17_in_parfixe483 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_pf_in_parfixe485 = new BitSet(new long[]{0x0000000000020400L});
	public static final BitSet FOLLOW_10_in_parfixe489 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_pf501 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pf503 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_13_in_pf508 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pf510 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_43_in_parmod526 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_parmod528 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_pm_in_parmod530 = new BitSet(new long[]{0x0000000000020400L});
	public static final BitSet FOLLOW_17_in_parmod534 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_pm_in_parmod536 = new BitSet(new long[]{0x0000000000020400L});
	public static final BitSet FOLLOW_10_in_parmod540 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_pm552 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pm554 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_13_in_pm559 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pm561 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_instruction_in_instructions578 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_17_in_instructions582 = new BitSet(new long[]{0x0014040108020020L});
	public static final BitSet FOLLOW_instruction_in_instructions584 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_inssi_in_instruction599 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_inscond_in_instruction605 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_boucle_in_instruction611 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lecture_in_instruction617 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ecriture_in_instruction623 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_affouappel_in_instruction629 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_inssi644 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_inssi646 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_inssi648 = new BitSet(new long[]{0x0014040108020020L});
	public static final BitSet FOLLOW_instructions_in_inssi650 = new BitSet(new long[]{0x0008020000000000L});
	public static final BitSet FOLLOW_51_in_inssi653 = new BitSet(new long[]{0x0014040108020020L});
	public static final BitSet FOLLOW_instructions_in_inssi656 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_inssi660 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_inscond671 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_inscond674 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_inscond677 = new BitSet(new long[]{0x0014040108020020L});
	public static final BitSet FOLLOW_instructions_in_inscond679 = new BitSet(new long[]{0x0000004002002000L});
	public static final BitSet FOLLOW_13_in_inscond692 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_inscond695 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_inscond698 = new BitSet(new long[]{0x0014040108020020L});
	public static final BitSet FOLLOW_instructions_in_inscond700 = new BitSet(new long[]{0x0000004002002000L});
	public static final BitSet FOLLOW_25_in_inscond716 = new BitSet(new long[]{0x0014040108020020L});
	public static final BitSet FOLLOW_instructions_in_inscond719 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_inscond736 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_52_in_boucle748 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_boucle751 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_boucle753 = new BitSet(new long[]{0x0014040108020020L});
	public static final BitSet FOLLOW_instructions_in_boucle755 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_boucle757 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_42_in_lecture767 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_lecture769 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_lecture771 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_13_in_lecture777 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_lecture779 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_10_in_lecture786 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_32_in_ecriture796 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_ecriture798 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_ecriture800 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_13_in_ecriture806 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_ecriture808 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_10_in_ecriture815 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_affouappel829 = new BitSet(new long[]{0x0000000000010202L});
	public static final BitSet FOLLOW_16_in_affouappel836 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_affouappel838 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_effixes_in_affouappel859 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_effmods_in_affouappel862 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_9_in_effixes890 = new BitSet(new long[]{0x0040202000005660L});
	public static final BitSet FOLLOW_expression_in_effixes893 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_13_in_effixes897 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_effixes899 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_10_in_effixes907 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_9_in_effmods917 = new BitSet(new long[]{0x0000000000000420L});
	public static final BitSet FOLLOW_ident_in_effmods920 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_13_in_effmods924 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_effmods926 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_10_in_effmods934 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp1_in_expression945 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_46_in_expression949 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_exp1_in_expression953 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_exp2_in_exp1970 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_34_in_exp1973 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_exp2_in_exp1977 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_45_in_exp2994 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_exp2_in_exp2996 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp3_in_exp21004 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp4_in_exp31016 = new BitSet(new long[]{0x0000000000FC0002L});
	public static final BitSet FOLLOW_21_in_exp31022 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_exp4_in_exp31027 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_exp31035 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_exp4_in_exp31039 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_22_in_exp31047 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_exp4_in_exp31052 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_23_in_exp31060 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_exp4_in_exp31064 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_exp31072 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_exp4_in_exp31077 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_exp31085 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_exp4_in_exp31089 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp5_in_exp41109 = new BitSet(new long[]{0x0000000000005002L});
	public static final BitSet FOLLOW_12_in_exp41120 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_exp5_in_exp41124 = new BitSet(new long[]{0x0000000000005002L});
	public static final BitSet FOLLOW_14_in_exp41137 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_exp5_in_exp41141 = new BitSet(new long[]{0x0000000000005002L});
	public static final BitSet FOLLOW_primaire_in_exp51166 = new BitSet(new long[]{0x0000000080000802L});
	public static final BitSet FOLLOW_11_in_exp51181 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_primaire_in_exp51186 = new BitSet(new long[]{0x0000000080000802L});
	public static final BitSet FOLLOW_31_in_exp51202 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_primaire_in_exp51206 = new BitSet(new long[]{0x0000000080000802L});
	public static final BitSet FOLLOW_valeur_in_primaire1229 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_primaire1237 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_9_in_primaire1245 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_primaire1247 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_primaire1249 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nbentier_in_valeur1261 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_valeur1269 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_nbentier_in_valeur1271 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_valeur1279 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_nbentier_in_valeur1281 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_54_in_valeur1289 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_37_in_valeur1297 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_nbentier1320 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_ident1331 = new BitSet(new long[]{0x0000000000000002L});
}
