package loadData;

public class LoaderFactory {
	
	public IDataLoader createDataLoader(String className){
		if(className.equals("DataLoader"))
			return new DataLoader();
		
		System.out.println("If the code got up to here, you passed a wrong argument to the FullDataLoader Factory");
		return null;
	}
		
	}

