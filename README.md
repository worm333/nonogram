# Nonogram
This is nonogram solver based on genetic algorithm principle. It works well for small and medium puzzles but it can not cope with big(eg 50x50). Solving algorithm is not perfect and needs to be improvemed.
#Usage example
```
    @Autowired
    protected INonogram nonogram;
    @Autowired
    protected INonogramFactory nonogramFactory;
    @Autowired
    protected FitnessCalculationAlgorithm<Integer> fitnessCalculationAlgorithm;
    @Autowired
    protected RandomAlgorithm<Integer> randomAlgorithm;
    @Autowired
    protected MutationAlgorithm<Integer> mutationAlgorithm;
    @Autowired
    protected IndividualFactory<Integer> individualFactory;
    @Autowired
    protected ReproductionAlgorithm<Integer> reproductionAlgorithm;
    @Autowired
    protected SelectionAlgorithm<Integer> selectionAlgorithm;
    
    public void solve()
    {
    	int maxGeneration = 100000;
    	int populationSize = nonogram.getWidth() * nonogram.getWidth();
    	float mutationPersentage = 5f;
    
    	EngineBuilder<Integer> engineBuilder = GeneticEnginBuilder.<Integer> build().withMaxGeneration(maxGeneration)
    		.withPopulationSize(populationSize).withMutationPersentage(mutationPersentage)
    		.withIndividualFactory(individualFactory).withPopulationFactory(new IntegerPopulationFactory())
    		.withFitnessCalculationAlgorithm(fitnessCalculationAlgorithm).withMutationAlgorithm(mutationAlgorithm)
    		.withRandomAlgorithm(randomAlgorithm).withReproductionAlgorithm(reproductionAlgorithm)
    		.withSelectionAlgorithm(selectionAlgorithm);
    	Engine<Integer> nonogramSolver = new SolutionSolver(engineBuilder);
    	nonogramSolver.exec();
    	Individual<Integer> individual = nonogramSolver.getBestIndividual();
    	System.out.println(individual.toString());
    }
```
