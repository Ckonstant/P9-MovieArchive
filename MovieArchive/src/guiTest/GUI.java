package guiTest;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Scanner;
import dataModel.Country;
import dataModel.Movie;
import mainManager.IMainApplication;
import mainManager.MainEngineFactory;
import mainManager.MainManager;
public class GUI extends JFrame {
	private JTextField searchBar;
    private JEditorPane display;
    private JButton loadData;
    private JButton loadTags;
    private JButton search;
    private JButton exitB;
    
    private JPanel panel;
    private ImageIcon image;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private int temp;
    private String report = "Feedback--->";
    private static String[] filename = {"Search description By ID","Search description By Title","-------","Search Movie by Country","Search Movie by Genre","Search Movie by Actor","Search Movie By Director","-------","Search Tags","Search Rates","Search Both"};
    private JComboBox box;
    private boolean moviesLoaded = false;
    public GUI(){
        super("IMDB/RottenTommatoes Movie Archive");
        MainEngineFactory mainEngineFactory = new MainEngineFactory();
		IMainApplication mainEngine  = mainEngineFactory.createMainEngine();
		ArrayList<Movie> movies;
		
        searchBar = new JTextField(report+"Movie Archive Launched...");
        searchBar.setEditable(false);
        add(searchBar,BorderLayout.SOUTH);
        
        
        box = new JComboBox(filename);
        box.setBounds(55,165,250,20);
        box.setVisible(false);
       // box.addItem("Search Criteria");
        //box.addItem("Search Genre");
       // box.setSelectedIndex(1);
       // box.addActionListener(this);
        add(box);
        panel = new JPanel();
        panel.setLayout(null);
        
        
        
        //load of images rottten/imdb
        ImageIcon imdbic = new ImageIcon(getClass().getResource("i.jpg"));
        ImageIcon rottenic = new ImageIcon(getClass().getResource("rotten.jpg"));
        label1 = new JLabel(imdbic);
        label1.setBounds(180, 1, 150, 80);
        add(label1);
        label2 = new JLabel(rottenic);
        label2.setBounds(180, 80, 150, 60);
        add(label2);
        label3 = new JLabel("IMDB/Rotten Movie Archive.");
        label3.setBounds(170, 140, 150, 20);
        add(label3);
        
        
        
        //LOAD DATA ACTION
        loadData = new JButton("Load Data");
        loadData.setBounds(1,1,160,35);
        loadData.addActionListener(
                new ActionListener(){       	
                    public void actionPerformed(ActionEvent event){
                    	searchBar.setText(report+"Data is loading...");
                    	temp = mainEngine.loadAllData();
        				if (temp == 0){
        					moviesLoaded = true;
        				}
        				if(moviesLoaded == true )
        				{
        					
							//JOptionPane.showMessageDialog( null, "Movies Loaded = TRUE");
							searchBar.setText(report+"Data loaded(Movies)..");
							loadData.setEnabled(false);
							search.setEnabled(true);
							loadTags.setEnabled((true));
							box.setVisible(true);
							
        				}
                    }
                }
        );
        
        add(loadData);
        
        
        
        
        
        
        //LOAD TAGS ACCTION
        loadTags = new JButton("Load Tags/Rates");
        loadTags.setBounds(1,41,160,35);
        loadTags.setEnabled(false);
        add(loadTags);
        
        
       
        
        
        
        
        //SEARCH ACTION
        search = new JButton("Submit Query");
        search.setBounds(1,81,160,35);
        search.setEnabled(false);
        search.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                    	String operation;
                    	if(moviesLoaded == true )
        				{
                    		String value = (String)box.getSelectedItem();
                    		try{
                    			
                    			while(!value.equals("-------")){
                    				if(value=="Search Movie by Genre"){
                    				operation ="1";
                    				String name = JOptionPane.showInputDialog(panel,value,null,JOptionPane.INFORMATION_MESSAGE);
                    				searchBar.setText(report+"Searching:"+name);
                    				if (name == null || (name != null && ("".equals(name)))){
                    					
                    					
                    					value=("-------"); //Klisi termatismou 
                    					}
                    			
                    				
                    				else
                    				{
                    					String fileType = JOptionPane.showInputDialog(panel,"1.Save .Txt\n2.Save .MarkDown\n3.Save .pdf\n4.Save .html",JOptionPane.INFORMATION_MESSAGE);
                    					int g = Integer.parseInt(fileType);
                    					
                    					if (fileType.equals("1"))
                    					{
                    						mainEngine.createReports("ReportGeneratorForFiles",name,operation);
                							JOptionPane.showMessageDialog( null, "File saved to .txt format.");
                    						int result = JOptionPane.showConfirmDialog(null, "Do you want to convert to pdf ?",null, JOptionPane.YES_NO_OPTION);
                    						if (result == JOptionPane.YES_OPTION){
                    							
                    							JOptionPane.showMessageDialog( null, "Converted to pdf!");
                    							Desktop desktop = Desktop.getDesktop();
                    	                         File dirToOpen = null;
                    	                         try {
                    	                             dirToOpen = new File("C:/Users/Vanyar/workspace/MovieArchive/output");
                    	                             desktop.open(dirToOpen);
                    	                         
                    	                         } catch (IOException e) {
                    								// TODO Auto-generated catch block
                    								e.printStackTrace();
                    							}
                    						}
                    						value = "-------";
                    						
                    					}
                    					else if (fileType.equals("2")){
                    						JOptionPane.showMessageDialog( null, "Selected 2");
                    					}
                    					else if (fileType.equals("3"))
                    					{
                    						JOptionPane.showMessageDialog( null, "Selected 3");
                    					}
                    					else if (fileType.equals("4"))
                    					{
                    						JOptionPane.showMessageDialog( null, "Selected 4");
                    					}
                    					else
                    					{
                    						value = "-------";
                    					}
                    					
                    				}
                    				}
                    				else
                    				{
                    					System.out.println("Failed");
                    					value ="-------";
                    				}
                    				
                    			}
                    		}catch(IllegalArgumentException e){
                    			
                    			System.err.println(e.getMessage());
                    			System.err.println("Fail to load data from input files.");
                    			System.exit(0);
                    			
                    		}
        				}
        				else 
        				{
        					JOptionPane.showMessageDialog( null, "Load Movies first.");
        					System.exit(0);
        				}
                    }
                }
        );
        add(search);
        
        
        
        
        //SAVE FILE ACTION
        exitB = new JButton("Exit");
        exitB.setBounds(1,121,160,35);
        
        exitB.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                    		
                    	 
        					JOptionPane.showMessageDialog( null, "Exiting from program...");
        					System.exit(0);
        				
                    }
                }
        );
        add(exitB);
        
        
       /* box.addItemListener(
        		new ItemListener(){
        			public void itemStateChanged(ItemEvent event){
        				if (event.getSource() == box){
        					if(box.getSelectedItem().equals("Search Criteria"))
        					{
        						JOptionPane.showMessageDialog( null, "criteria.");
        					}
        					else if (box.getSelectedItem().equals("Search Genre"))
        					{
        						JOptionPane.showMessageDialog( null, "Genre.");
        					}
        				}
        			}
        		}
        		); */
        
        
        
        

        add(panel,BorderLayout.CENTER);
        setSize(365,250);
        setVisible(true);
    }
    
    
    
}
