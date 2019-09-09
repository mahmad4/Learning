
public class LogisticClassifier extends LinearClassifier {
	
	public LogisticClassifier(int ninputs) {
		super(ninputs);
	}
	
	/**
	 * A LogisticClassifier uses the logistic update rule
	 * (AIMA Eq. 18.8): w_i \leftarrow w_i+\alpha(y-h_w(x)) \times h_w(x)(1-h_w(x)) \times x_i 
	 */
	public void update(double[] x, double y, double alpha) {
	    // Must be implemented by you
		for(int i = 0; i<x.length; i++) {
			double sum = 0.0;
			for(int j = 0; j<x.length; j++) {
				sum += x[j]*weights[j];
			}
			weights[i] = weights[i] + (alpha*(y - threshold(sum))*(threshold(sum))*(1 - threshold(sum))*x[i]);	
		}
	}
	
	/**
	 * A LogisticClassifier uses a 0/1 sigmoid threshold at z=0.
	 */
	public double threshold(double z) {
	    // Must be implemented by you
		z = 1.0/(1.0 + Math.exp(-z));
		return z;
	}

}
