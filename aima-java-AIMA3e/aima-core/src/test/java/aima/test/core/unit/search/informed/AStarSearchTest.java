package aima.test.core.unit.search.informed;

import aima.core.agent.Action;
import aima.core.environment.eightpuzzle.BidirectionalEightPuzzleProblem;
import aima.core.environment.eightpuzzle.EightPuzzleBoard;
import aima.core.environment.eightpuzzle.EightPuzzleFunctions;
import aima.core.environment.map.*;
import aima.core.search.framework.Node;
import aima.core.search.agent.SearchAgent;
import aima.core.search.framework.SearchForActions;
import aima.core.search.framework.problem.GeneralProblem;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.qsearch.GraphSearch;
import aima.core.search.framework.qsearch.QueueSearch;
import aima.core.search.framework.qsearch.TreeSearch;
import aima.core.search.informed.AStarSearch;
import jdk.internal.agent.resources.agent;

import org.junit.Assert;
import org.junit.Test;


import java.util.List;
import java.util.Properties;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

public class AStarSearchTest {

	

	@Test
	public void testAStarSearch_ManhattanDistance() {
		// added to narrow down bug report filed by L.N.Sudarshan of
		// Thoughtworks and Xin Lu of UCI
		try {
			// EightPuzzleBoard extreme = new EightPuzzleBoard(new int[]
			// {2,0,5,6,4,8,3,7,1});
			// EightPuzzleBoard extreme = new EightPuzzleBoard(new int[]
			// {0,8,7,6,5,4,3,2,1});
			EightPuzzleBoard board = new EightPuzzleBoard(new int[] { '*', 2, 4, '*', 0, '*', '*', 3, 1 });
		
			Problem<EightPuzzleBoard, Action> problem = new BidirectionalEightPuzzleProblem(board);
			SearchForActions<EightPuzzleBoard, Action> search = new AStarSearch<>(new GraphSearch<>(),
					EightPuzzleFunctions::getManhattanDistance);
			SearchAgent<Object, EightPuzzleBoard, Action> agent = new SearchAgent<>(problem, search);
			System.out.println("AStarSearch(Manhattan Distance):" + search.getMetrics());
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			Assert.assertEquals(18, agent.getActions().size());
			Assert.assertEquals("1102", // "926" GraphSearchReduced Frontier
					agent.getInstrumentation().getProperty("nodesExpanded"));
			
			Assert.assertEquals("596", // "534" GraphSearchReduced Frontier
					agent.getInstrumentation().getProperty("queueSize"));
			Assert.assertEquals("597", // "535" GraphSearchReduced Frontier
					agent.getInstrumentation().getProperty("maxQueueSize"));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception thrown");
		}
		
		
		
	}

	@Test
	public void testAStarSearch_NumberOfMisplacedTiles() {
		// added to narrow down bug report filed by L.N.Sudarshan of
		// Thoughtworks and Xin Lu of UCI
		try {
			// EightPuzzleBoard extreme = new EightPuzzleBoard(new int[]
			// {2,0,5,6,4,8,3,7,1});
			// EightPuzzleBoard extreme = new EightPuzzleBoard(new int[]
			// {0,8,7,6,5,4,3,2,1});
			EightPuzzleBoard board = new EightPuzzleBoard(new int[] { '*', 2, 4, '*', 0, '*', '*', 3, 1 });
		
			Problem<EightPuzzleBoard, Action> problem = new BidirectionalEightPuzzleProblem(board);
			SearchForActions<EightPuzzleBoard, Action> search = new AStarSearch<>(new GraphSearch<>(),
					EightPuzzleFunctions::getNumberOfMisplacedTiles);
			SearchAgent<Object, EightPuzzleBoard, Action> agent = new SearchAgent<>(problem, search);
			System.out.println("AStarSearch(NumberOfMisplacedTiles):" + search.getMetrics());
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			Assert.assertEquals(18, agent.getActions().size());
			Assert.assertEquals("4048", // "926" GraphSearchReduced Frontier
					agent.getInstrumentation().getProperty("nodesExpanded"));
			
			Assert.assertEquals("1784", // "534" GraphSearchReduced Frontier
					agent.getInstrumentation().getProperty("queueSize"));
			Assert.assertEquals("1785", // "535" GraphSearchReduced Frontier
					agent.getInstrumentation().getProperty("maxQueueSize"));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception thrown");
		}
		
		
		
	}
	
	private static void printInstrumentation(Properties properties) {
		properties.keySet().stream().map(key -> key + "=" + properties.get(key)).forEach(System.out::println);
	}

	private static void printActions(List<Action> actions) {
		actions.forEach(System.out::println);
	}

	

	@Test
	public void testTreeSearch_NumberOfMisplacedTiles() {
		// added to narrow down bug report filed by L.N.Sudarshan of
		// Thoughtworks and Xin Lu of UCI
		try {
			// EightPuzzleBoard extreme = new EightPuzzleBoard(new int[]
			// {2,0,5,6,4,8,3,7,1});
			// EightPuzzleBoard extreme = new EightPuzzleBoard(new int[]
			// {0,8,7,6,5,4,3,2,1});
			EightPuzzleBoard board = new EightPuzzleBoard(new int[] { '*', 2, 4, '*', 0, '*', '*', 3, 1 });
		
			Problem<EightPuzzleBoard, Action> problem = new BidirectionalEightPuzzleProblem(board);
			SearchForActions<EightPuzzleBoard, Action> search = new AStarSearch<>(new TreeSearch<>(),
					EightPuzzleFunctions::getNumberOfMisplacedTiles);
			SearchAgent<Object, EightPuzzleBoard, Action> agent = new SearchAgent<>(problem, search);
			System.out.println("ATreeSearch(NumberOfMisplacedTilese):" + search.getMetrics());
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			Assert.assertEquals(18, agent.getActions().size());
			Assert.assertEquals("7031333", // "926" GraphSearchReduced Frontier
					agent.getInstrumentation().getProperty("nodesExpanded"));
			
			Assert.assertEquals("12672141", // "534" GraphSearchReduced Frontier
					agent.getInstrumentation().getProperty("queueSize"));
			Assert.assertEquals("12672142", // "535" GraphSearchReduced Frontier
					agent.getInstrumentation().getProperty("maxQueueSize"));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception thrown");
		}
		
		
		
	}
	
	@Test
	public void testTreeSearch_ManhattanDistance() {
		// added to narrow down bug report filed by L.N.Sudarshan of
		// Thoughtworks and Xin Lu of UCI
		try {
			// EightPuzzleBoard extreme = new EightPuzzleBoard(new int[]
			// {2,0,5,6,4,8,3,7,1});
			// EightPuzzleBoard extreme = new EightPuzzleBoard(new int[]
			// {0,8,7,6,5,4,3,2,1});
			EightPuzzleBoard board = new EightPuzzleBoard(new int[] { '*', 2, 4, '*', 0, '*', '*', 3, 1 });
		
			Problem<EightPuzzleBoard, Action> problem = new BidirectionalEightPuzzleProblem(board);
			SearchForActions<EightPuzzleBoard, Action> search = new AStarSearch<>(new TreeSearch<>(),
					EightPuzzleFunctions::getManhattanDistance);
			SearchAgent<Object, EightPuzzleBoard, Action> agent = new SearchAgent<>(problem, search);
			System.out.println("ATreeSearch(Manhattan Distance):" + search.getMetrics());
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			Assert.assertEquals(18, agent.getActions().size());
			Assert.assertEquals("311194", // "926" GraphSearchReduced Frontier
					agent.getInstrumentation().getProperty("nodesExpanded"));
			
			Assert.assertEquals("534300", // "534" GraphSearchReduced Frontier
					agent.getInstrumentation().getProperty("queueSize"));
			Assert.assertEquals("534301", // "535" GraphSearchReduced Frontier
					agent.getInstrumentation().getProperty("maxQueueSize"));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception thrown");
		}
		
		
		
	}
	


	@Test
	public void testAIMA3eFigure3_15() throws Exception {
		Map romaniaMap = new SimplifiedRoadMapOfRomania();
		Problem<String, MoveToAction> problem = new GeneralProblem<>(
				SimplifiedRoadMapOfRomania.SIBIU,
				MapFunctions.createActionsFunction(romaniaMap),
				MapFunctions.createResultFunction(),
				Predicate.isEqual(SimplifiedRoadMapOfRomania.BUCHAREST),
				MapFunctions.createDistanceStepCostFunction(romaniaMap));

		SearchForActions<String, MoveToAction> search = new AStarSearch<>(new GraphSearch<>(),
				MapFunctions.createSLDHeuristicFunction(SimplifiedRoadMapOfRomania.BUCHAREST, romaniaMap));
		SearchAgent<Object, String, MoveToAction> agent = new SearchAgent<>(problem, search);

		List<MoveToAction> actions = agent.getActions();

		Assert.assertEquals(
				"[Action[name=moveTo, location=RimnicuVilcea], Action[name=moveTo, location=Pitesti], Action[name=moveTo, location=Bucharest]]",
				actions.toString());
		Assert.assertEquals("278.0",
				search.getMetrics().get(QueueSearch.METRIC_PATH_COST));
	}
	

	
	@Test
	public void testAIMA3eFigure3_24() throws Exception {
		Map romaniaMap = new SimplifiedRoadMapOfRomania();
		Problem<String, MoveToAction> problem = new GeneralProblem<>(
						SimplifiedRoadMapOfRomania.ARAD,
						MapFunctions.createActionsFunction(romaniaMap),
						MapFunctions.createResultFunction(),
						Predicate.isEqual(SimplifiedRoadMapOfRomania.BUCHAREST),
						MapFunctions.createDistanceStepCostFunction(romaniaMap));

		SearchForActions<String, MoveToAction> search = new AStarSearch<>(new TreeSearch<>(),
				MapFunctions.createSLDHeuristicFunction(SimplifiedRoadMapOfRomania.BUCHAREST, romaniaMap));
		SearchAgent<Object, String, MoveToAction> agent = new SearchAgent<>(problem, search);
		Assert.assertEquals(
				"[Action[name=moveTo, location=Sibiu], Action[name=moveTo, location=RimnicuVilcea], Action[name=moveTo, location=Pitesti], Action[name=moveTo, location=Bucharest]]",
				agent.getActions().toString());
		Assert.assertEquals(4, agent.getActions().size());
		Assert.assertEquals("5",
				agent.getInstrumentation().getProperty("nodesExpanded"));
		Assert.assertEquals("10",
				agent.getInstrumentation().getProperty("queueSize"));
		Assert.assertEquals("11",
				agent.getInstrumentation().getProperty("maxQueueSize"));
	}

	@Test
	public void testAIMA3eFigure3_24_using_GraphSearch() throws Exception {
		Map romaniaMap = new SimplifiedRoadMapOfRomania();
		Problem<String, MoveToAction> problem = new GeneralProblem<>(
				SimplifiedRoadMapOfRomania.ARAD,
				MapFunctions.createActionsFunction(romaniaMap),
				MapFunctions.createResultFunction(),
				Predicate.isEqual(SimplifiedRoadMapOfRomania.BUCHAREST),
				MapFunctions.createDistanceStepCostFunction(romaniaMap));

		SearchForActions<String, MoveToAction> search = new AStarSearch<>(new GraphSearch<>(),
				MapFunctions.createSLDHeuristicFunction(SimplifiedRoadMapOfRomania.BUCHAREST, romaniaMap));
		SearchAgent<Object, String, MoveToAction> agent = new SearchAgent<>(problem, search);
		Assert.assertEquals(
				"[Action[name=moveTo, location=Sibiu], Action[name=moveTo, location=RimnicuVilcea], Action[name=moveTo, location=Pitesti], Action[name=moveTo, location=Bucharest]]",
				agent.getActions().toString());
		Assert.assertEquals(4, agent.getActions().size());
		Assert.assertEquals("5",
				agent.getInstrumentation().getProperty("nodesExpanded"));
		Assert.assertEquals("6",
				agent.getInstrumentation().getProperty("queueSize"));
		Assert.assertEquals("7",
				agent.getInstrumentation().getProperty("maxQueueSize"));
	}

	@Test
	public void testCheckFrontierPathCost() throws Exception {
		ExtendableMap map = new ExtendableMap();
		map.addBidirectionalLink("start", "b", 2.5);
		map.addBidirectionalLink("start", "c", 1.0);
		map.addBidirectionalLink("b", "d", 2.0);
		map.addBidirectionalLink("c", "d", 4.0);
		map.addBidirectionalLink("c", "e", 1.0);
		map.addBidirectionalLink("d", "goal", 1.0);
		map.addBidirectionalLink("e", "goal", 5.0);
		Problem<String, MoveToAction> problem = new GeneralProblem<>("start",
				MapFunctions.createActionsFunction(map),
				MapFunctions.createResultFunction(), Predicate.isEqual("goal"),
				MapFunctions.createDistanceStepCostFunction(map));

		ToDoubleFunction<Node<String, MoveToAction>> h = node -> 0.0; // Don't have one for this test

		SearchForActions<String, MoveToAction> search = new AStarSearch<>(new GraphSearch<>(), h);
		SearchAgent<Object, String, MoveToAction> agent = new SearchAgent<>(problem, search);

		List<MoveToAction> actions = agent.getActions();

		Assert.assertEquals(
				"[Action[name=moveTo, location=b], Action[name=moveTo, location=d], Action[name=moveTo, location=goal]]",
				actions.toString());
		Assert.assertEquals("5.5",
				search.getMetrics().get(QueueSearch.METRIC_PATH_COST));
	}
	
	
	
}
