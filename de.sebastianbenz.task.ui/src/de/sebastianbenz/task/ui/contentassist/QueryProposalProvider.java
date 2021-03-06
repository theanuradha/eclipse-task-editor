/*
* generated by Xtext
*/
package de.sebastianbenz.task.ui.contentassist;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

import com.google.inject.Inject;

import de.sebastianbenz.task.TaskPackage;

/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
public class QueryProposalProvider extends AbstractQueryProposalProvider {

	@Inject
	private IResourceDescriptions resourceDescriptions;
	
	@Override
	public void complete_Phrase(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		acceptor.accept(createCompletionProposal("\"phrase\"", context));
	}
	
	
	@Override
	public void completeTagReference_Value(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		completeAll(TaskPackage.Literals.TAG, context, acceptor);
	}
	
	private void completeAll(EClass type, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		completeAll(type, "", context, acceptor);
	}

	private void completeAll(EClass type, String prefix, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		Iterable<IEObjectDescription> candidates = resourceDescriptions.getExportedObjectsByType(type);
		for (IEObjectDescription candidate : candidates) {
			acceptor.accept(createCompletionProposal(prefix + getName(candidate), context));
		}
	}


	protected String getName(IEObjectDescription candidate) {
		String result = candidate.getName().toString();
		if(result.contains(" ")){
			result = "\"" + result + "\"";
		}
		return result;
	}


	@Override
	public void completeProjectReference_Value(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		completeAll(TaskPackage.Literals.PROJECT, context, acceptor);
	}
	
	@Override
	public void complete_TagReference(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		completeAll(TaskPackage.Literals.TAG, "@", context, acceptor);
	}
	
	@Override
	public void complete_STRING(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
	}
	
}
