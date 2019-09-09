

import java.io.File;
import java.io.IOException;
import java.util.Set;


/**
 * The restaurant WillWait example from AIMA Section 18.3, data
 * from file WillWait-data.txt.
 * <p>
 * Run and pass dataset filename on cmd-line.
 */
public class house_votes extends Problem {
	
	public house_votes() {
		super();
		// Input variables
		//Domain yesNoDomain = new YesNoDomain();
		this.inputs.add(new Variable("Handicapped-infants", new Domain("y", "n", "?")));
		this.inputs.add(new Variable("water-project-cost-sharing", new Domain("y", "n", "?")));
		this.inputs.add(new Variable("adoption-of-the-budget-resolution", new Domain("y", "n", "?")));
		this.inputs.add(new Variable("physician-fee-freeze", new Domain("y", "n", "?")));
		this.inputs.add(new Variable("el-salvador-aid", new Domain("y", "n", "?")));
		this.inputs.add(new Variable("religious-groups-in-schools", new Domain("y", "n", "?")));
		this.inputs.add(new Variable("anti-satellite-test-ban", new Domain("y", "n", "?")));
		this.inputs.add(new Variable("aid-to-nicaraguan-contras", new Domain("y", "n", "?")));
		this.inputs.add(new Variable("mx-missile", new Domain("y", "n", "?")));
		this.inputs.add(new Variable("immigration", new Domain("y", "n", "?")));
		this.inputs.add(new Variable("synfuels-corporation-cutback", new Domain("y", "n", "?")));
		this.inputs.add(new Variable("education-spending", new Domain("y", "n", "?")));
		this.inputs.add(new Variable("superfund-right-to-sue", new Domain("y", "n", "?")));
		this.inputs.add(new Variable("crime", new Domain("y", "n", "?")));
		this.inputs.add(new Variable("duty-free-exports", new Domain("y", "n", "?")));
		this.inputs.add(new Variable("export-administration-act-south-africa", new Domain("y", "n", "?")));
		
		
		
		// Output variable
		this.output = new Variable("Class name", new Domain("democrat", "republican"));
	}
	
	public static void main(String[] args) throws IOException {
		Problem problem = new house_votes();
		problem.dump();
		//String filename = "C:\\Users\\muham\\Desktop\\CSC_242\\Project_4\\Project_4_extra_dt\\src\\house-votes-84.data.mod.txt";
		//Set<Example> examples = problem.readExamplesFromCSVFile(new File(filename));		 
		Set<Example> examples = problem.readExamplesFromCSVFile(new File(args[0]));
		for (Example e : examples) {
			System.out.println(e);
		}
		DecisionTree tree = new DecisionTreeLearner(problem).learn(examples);
		tree.dump();
		tree.test(examples);
	}

}
