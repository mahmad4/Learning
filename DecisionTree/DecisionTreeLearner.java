

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;



/**
 * Implementation of the decision-tree learning algorithm in AIMA Fig 18.5.
 * This is based on ID3 (AIMA p. 758).
 */
public class DecisionTreeLearner extends AbstractDecisionTreeLearner {
	
	/**
	 * Construct and return a new DecisionTreeLearner for the given Problem.
	 */
	public DecisionTreeLearner(Problem problem) {
		super(problem);
	}
	
	/**
	 * Main recursive decision-tree learning (ID3) method.  
	 */
	@Override
	protected DecisionTree learn(Set<Example> examples, List<Variable> attributes, Set<Example> parent_examples) {
		
		
		if (examples.isEmpty()) {
			return new DecisionTree(pluralityValue(parent_examples));
		}
		// Must be implemented by you; the following two methods may be useful
				int count = 0;
				// chooses the first examples value
				Iterator<Example> iterator = examples.iterator();
				String temp_classification = iterator.next().getOutputValue();
				count++;
				// compare it with all the others
				while(iterator.hasNext()) {
					if(iterator.next().getOutputValue().equals(temp_classification)) {
						count++;
					}
				}	
		if(count == examples.size()) {
			return new DecisionTree(temp_classification);
		}
		else if(attributes.isEmpty()) {
			return new DecisionTree(pluralityValue(examples));
		}
		else {
			Variable A = mostImportantVariable(attributes, examples);
			DecisionTree tree = new DecisionTree(A);
			
			for(String vk : A.getDomain()) {
				Set<Example> exs = examplesWithValueForAttribute(examples, A, vk);
				//List<Variable> new_attributes = new ArrayList<Variable>(attributes);
				
				attributes.remove(A);
				//Set<Example> new_examples = new ArraySet<Example>(examples);
				DecisionTree subtree = learn(exs, attributes, examples);
				//
				//
				tree.children.add(subtree);
			}
			return tree;
		}
	}
	
	private boolean same_classification(Set<Example> examples) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Returns the most common output value among a set of Examples,
	 * breaking ties randomly.
	 * I don't do the random part yet.
	 */
	@Override
	protected String pluralityValue(Set<Example> examples) {
		// Must be implemented by you
		int max = 0;
		String temp = null;
		for (Example e : examples) {
			if(max <= countExamplesWithValueForOutput(examples, e.getOutputValue())) {
				max = countExamplesWithValueForOutput(examples, e.getOutputValue());
				temp = e.getOutputValue();
			}
		}
		return temp;
	}
	
	/**
	 * Returns the single unique output value among the given examples
	 * is there is only one, otherwise null.
	 */
	@Override
	protected String uniqueOutputValue(Set<Example> examples) {
		// Must be implemented by you
		
		return null;
	}
	
	//
	// Utility methods required by the AbstractDecisionTreeLearner
	//

	/**
	 * Return the subset of the given examples for which Variable a has value vk.
	 */
	@Override
	protected Set<Example> examplesWithValueForAttribute(Set<Example> examples, Variable a, String vk) {
	    // Must be implemented by you
		Set<Example> subset = new ArraySet<Example>();
		for (Example e : examples) {
			if (e.getInputValue(a).equals(vk)) {
				subset.add(e);
			}
		}
		return subset;
	}
	
	/**
	 * Return the number of the given examples for which Variable a has value vk.
	 */
	@Override
	protected int countExamplesWithValueForAttribute(Set<Example> examples, Variable a, String vk) {
		int result = 0;
		for (Example e : examples) {
			if (e.getInputValue(a).equals(vk)) {
				result += 1;
			}
		}
		return result;
		
	}

	/**
	 * Return the number of the given examples for which the output has value vk.
	 */
	@Override
	protected int countExamplesWithValueForOutput(Set<Example> examples, String vk) {
	    // Must be implemented by you
		int result = 0;
		for (Example e : examples) {
			if (e.getOutputValue().equals(vk)) {
				result += 1;
			}
		}
		return result;
	}

}
