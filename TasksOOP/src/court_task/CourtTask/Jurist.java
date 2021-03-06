package CourtTask;

public abstract class Jurist extends Person implements IJurist{
	private int experience;
	private int numberOfCases;
	
	Jurist(String name){
		super(name);
		setExperience(0);
		setNumberOfCases(0);
	}
	
	Jurist(String name, int exp , int cases){
		super(name);
		setExperience(exp);
		setNumberOfCases(cases);
	}
	
	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		if(experience >= 0){
			this.experience = experience;
		}
	}

	public int getNumberOfCases() {
		return numberOfCases;
	}

	public void setNumberOfCases(int numberOfCases) {
		if(numberOfCases>=0){
			this.numberOfCases = numberOfCases;
		}
	}
	
	public void increaseNumberOfCases(){
		this.numberOfCases++;
	}
	
	public void askQuestion(Citizen c){
		System.out.println("Lawyer " + getName() + " asks question to " + c.getName());
	}
	
	public void askMultipleQuestions(Citizen c, int number){
		for(int i=0;i<number;i++){
			askQuestion(c);
		}
	}
	
	public void takeNotes(){
		
	}
}
