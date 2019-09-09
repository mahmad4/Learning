
public class PerceptronClassifier extends LinearClassifier {
	
	public PerceptronClassifier(int ninputs) {
		super(ninputs);
	}
	
	/**
	 * A PerceptronClassifier uses the perceptron learning rule
	 * (AIMA Eq. 18.7): w_i \leftarrow w_i+\alpha(y-h_w(x)) \times x_i 
	 */
	public void update(double[] x, double y, double alpha) {
	    // Must be implemented by you
		for(int i = 0; i<x.length; i++) {
			double sum = 0.0;
			for(int j = 0; j<x.length; j++) {
				sum += x[j]*weights[j];
			}
			weights[i] = weights[i] + alpha*(y - threshold(sum))*x[i];
			
		}
	}
	
	/**
	 * A PerceptronClassifier uses a hard 0/1 threshold.
	 */
	public double threshold(double z) {
		// Must be implemented by you
		if(z >= 0) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
}
