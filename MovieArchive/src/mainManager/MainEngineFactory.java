package mainManager;

public class MainEngineFactory {
	public IMainApplication createMainEngine(){
		return new MainManager();
	}
}
