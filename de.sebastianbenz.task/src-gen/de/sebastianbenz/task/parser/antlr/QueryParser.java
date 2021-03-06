/*
* generated by Xtext
*/
package de.sebastianbenz.task.parser.antlr;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;

import com.google.inject.Inject;

import de.sebastianbenz.task.services.QueryGrammarAccess;

public class QueryParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private QueryGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected de.sebastianbenz.task.parser.antlr.internal.InternalQueryParser createParser(XtextTokenStream stream) {
		return new de.sebastianbenz.task.parser.antlr.internal.InternalQueryParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "Query";
	}
	
	public QueryGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(QueryGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
