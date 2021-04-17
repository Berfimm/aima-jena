package aima.test.core.unit.environment.vacuum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import aima.core.environment.vacuum.ModelBasedReflexVacuumAgent;
import aima.core.environment.vacuum.VacuumEnvironment;

/**
 * @author Ravi Mohan
 * 
 */
public class VacuumEnvironmentTest {
	VacuumEnvironment tve, tve2, tve3, tve4, tve5, tve6;

	ModelBasedReflexVacuumAgent a;
	
	//I added new setup for new initial condition.

	@Before
	public void setUp() {
		tve = new VacuumEnvironment(VacuumEnvironment.LocationState.Dirty,
				VacuumEnvironment.LocationState.Dirty);
		tve2 = new VacuumEnvironment(VacuumEnvironment.LocationState.Clean,
				VacuumEnvironment.LocationState.Clean);
		tve3 = new VacuumEnvironment(VacuumEnvironment.LocationState.Clean,
				VacuumEnvironment.LocationState.Dirty);
		tve4 = new VacuumEnvironment(VacuumEnvironment.LocationState.Dirty,
				VacuumEnvironment.LocationState.Clean);
		tve5 = new VacuumEnvironment(VacuumEnvironment.LocationState.Dirty,
				VacuumEnvironment.LocationState.Wet);
		tve6 = new VacuumEnvironment(VacuumEnvironment.LocationState.Clean,
				VacuumEnvironment.LocationState.Wet);
		a = new ModelBasedReflexVacuumAgent();
	}

	//I added here Wet environment in LOCATION_B
	@Test
	public void testTVEConstruction() {
		Assert.assertEquals(VacuumEnvironment.LocationState.Dirty,
				tve.getLocationState(VacuumEnvironment.LOCATION_A));
		Assert.assertEquals(VacuumEnvironment.LocationState.Dirty,
				tve.getLocationState(VacuumEnvironment.LOCATION_B));
		Assert.assertEquals(VacuumEnvironment.LocationState.Clean,
				tve2.getLocationState(VacuumEnvironment.LOCATION_A));
		Assert.assertEquals(VacuumEnvironment.LocationState.Clean,
				tve2.getLocationState(VacuumEnvironment.LOCATION_B));
		Assert.assertEquals(VacuumEnvironment.LocationState.Wet,
				tve6.getLocationState(VacuumEnvironment.LOCATION_B));
		Assert.assertEquals(VacuumEnvironment.LocationState.Wet,
				tve6.getLocationState(VacuumEnvironment.LOCATION_B));

	}

	@Test
	public void testAgentAdd() {
		tve.addAgent(a, VacuumEnvironment.LOCATION_A);
		Assert.assertEquals(VacuumEnvironment.LOCATION_A,
				tve.getAgentLocation(a));
		Assert.assertEquals(1, tve.getAgents().size());
	}
}
