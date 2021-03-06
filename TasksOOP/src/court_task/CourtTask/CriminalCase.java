package CourtTask;

public class CriminalCase extends Case{
	final static int NUMBER_OF_JURORS = 13;
	private Prosecutor prosecutor;
	
	CriminalCase(Judge judge, Defendant defendant, Prosecutor prosecutor){
		super(judge,defendant);
		if(prosecutor!=null){
			this.prosecutor=prosecutor;
		}
		else{
			System.out.println("Can't assign prosecutor to case!");
		}
		setJury(NUMBER_OF_JURORS);
	}
	
	@Override
	public void increaseCasesOfAll() {
		super.increaseCasesOfAll();
		prosecutor.increaseNumberOfCases();
	}
	
	@Override
	public void conduct() {
		this.increaseCasesOfAll();
	}
}
