package aima.core.probability.example;

import aima.core.probability.full.FullJointDistributionModel;


import aima.core.probability.RandomVariable;
import aima.core.probability.full.FullJointDistributionModel;

public class FullJointDistirubitionInfectedCoughFever extends
FullJointDistributionModel {

	public FullJointDistirubitionInfectedCoughFever() {
		super(new double[] {
				// Infected = true, Fever = true, Cough = true, VitaminD =
				// very_high
				0.0648,
				// Infected = true, Fever = true, Cough = true, VitaminD = normal
				0.0108,
				// Infected = true, Fever = true, Cough = true, VitaminD =
				// high
				0.03132,
				// Infected = true, Fever = true, Cough = true, VitaminD = low
				0.00108,
				// Infected = true, Fever = true, Cough = false, VitaminD =
				// very_high
				0.0072,
				// Infected = true, Fever = true, Cough = false, VitaminD =
				// normal
				0.0012,
				// Infected = true, Fever = true, Cough = false, VitaminD =
				// high
				0.00348,
				// Infected = true, Fever = true, Cough = false, VitaminD =
				// low
				0.00012,
				// Infected = true, Fever = false, Cough = true, VitaminD =
				// very_high
				0.0096,
				// Infected = true, Fever = false, Cough = true, VitaminD =
				// normal
				0.0016,
				// Infected = true, Fever = false, Cough = true, VitaminD =
				// high
				0.00464,
				// Infected = true, Fever = false, Cough = true, VitaminD =
				// low
				0.00016,
				// Infected = true, Fever = false, Cough = false, VitaminD =
				// very_high
				0.0384,
				// Infected = true, Fever = false, Cough = false, VitaminD =
				// normal
				0.0064,
				// Infected = true, Fever = false, Cough = false, VitaminD =
				// high
				0.01856,
				// Infected = true, Fever = false, Cough = false, VitaminD =
				// low
				0.00064,
				// Infected = false, Fever = true, Cough = true, VitaminD =
				// very_high
				0.0432,
				// Infected = false, Fever = true, Cough = true, VitaminD =
				// normal
				0.0072,
				// Infected = false, Fever = true, Cough = true, VitaminD =
				// high
				0.02088,
				// Infected = false, Fever = true, Cough = true, VitaminD =
				// low
				0.00072,
				// Infected = false, Fever = true, Cough = false, VitaminD =
				// very_high
				0.0048,
				// Infected = false, Fever = true, Cough = false, VitaminD =
				// normal
				0.0008,
				// Infected = false, Fever = true, Cough = false, VitaminD =
				// high
				0.00232,
				// Infected = false, Fever = true, Cough = false, VitaminD =
				// low
				0.00008,
				// Infected = false, Fever = false, Cough = true, VitaminD =
				// very_high
				0.0864,
				// Infected = false, Fever = false, Cough = true, VitaminD =
				// normal
				0.0144,
				// Infected = false, Fever = false, Cough = true, VitaminD =
				// high
				0.04176,
				// Infected = false, Fever = false, Cough = true, VitaminD =
				// low
				0.00144,
				// Infected = false, Fever = false, Cough = false, VitaminD =
				// very_high
				0.3456,
				// Infected = false, Fever = false, Cough = false, VitaminD =
				// normal
				0.0576,
				// Infected = false, Fever = false, Cough = false, VitaminD =
				// high
				0.16704,
				// Infected = false, Fever = false, Cough = false, VitaminD =
				// low
				0.00576 }, ExampleRV.INFECTED_RV, ExampleRV.FEVER_RV,
				ExampleRV.COUGH_RV, ExampleRV.VITAMIND_RV);
	}

}