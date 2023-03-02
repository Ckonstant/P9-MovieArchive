package fileEngine;

public class ReporterFactory {
	public IReportGenerator createReporter(String mode,String searchFor,String operation){
		if (mode.equals("ReportGeneratorForFiles"))
			return new ReportGeneratorForFiles();
		
		System.out.println("If the code got up to here, you passed a wrong argument to the ReporterFactory Factory");
		return null;
	}
}
