import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Parser{

	public Parser(){
		System.out.println("Parser created.");
	}
	
	public String fixKeywords(ArrayList<String> array){
		String nKeywords="";
		for(int i=0; i<array.size(); i++){
			if(i==array.size()-1){
				nKeywords+=array.get(i);
			}
			else{
				nKeywords+=array.get(i)+"+";
			}
		}

		return nKeywords;
	}

	public ArrayList<String> getKeywords(String keywords){
		String key="";
		ArrayList<String> keywordArray=new ArrayList<String>();
		for(int i=0; i<keywords.length(); i++){
			if(keywords.charAt(i)==' '){
				keywordArray.add(key);
				key="";
			}
			if(keywords.charAt(i)!=' '){
				key=key + keywords.charAt(i);
			}
		}
		//Add last key word
		keywordArray.add(key);		

		for(int i=0; i<keywordArray.size(); i++){
		}		
		return keywordArray;
	}

	public void getCode(String url, String output){
		try{
		URL link=new URL(url);
		URLConnection conn= link.openConnection();
		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.6; rv:16.0) Gecko/20100101 Firefox/16.0");
		InputStreamReader isr= new InputStreamReader(conn.getInputStream());
		BufferedReader br=new BufferedReader(isr);
		String c;
		
			FileOutputStream out=null;
			out=new FileOutputStream(output);
			PrintStream p=new PrintStream(out);
		//Prints each line of code from search results page
		while((c=br.readLine())!=null){
			p.println(c);
		}
		}

		catch (IOException e){
			e.printStackTrace();

			System.out.println("Didn't work sorry");
		}
	}
	
	public void parseFile(String input, String output){
		try{
		boolean begin=false;
		int content;
		int results=0;
		int number=0;
	//Inputting the file
		File file=new File(input);
		FileInputStream fis= null;
		fis=new FileInputStream(file);
		
	//Outputting the file
		FileOutputStream out=null;
		out=new FileOutputStream(output);
		PrintStream p=new PrintStream(out);
		p.println("Top 5 Bing Search Results\n");
			while((content=fis.read())!=-1 && results<5){
				begin=false;
				if(((char)content)=='<'){
					content=fis.read();
					if(((char)content)=='l'){
						content=fis.read();
						if(((char)content)=='i'){
							//System.out.println("li found");
							while((content=fis.read())!=-1 && begin==false){
							
							if(((char)content)=='<'){
								content=fis.read();
								if(((char)content)=='h'){
									content=fis.read();
									if(((char)content)=='2'){
										//System.out.println("h2 found");
										while((content=fis.read())!=-1 && begin==false){

										if(((char)content)=='<'){
											content=fis.read();
											if(((char)content)=='a'){
												//System.out.println("a found");

											while((content=fis.read())!=-1 && begin==false){
												if(((char)content)=='f'){
													content=fis.read();
													if(((char)content)=='='){
													content=fis.read();
													content=fis.read(); //This always begins the href with a " so we skip it
														if(((char)content)=='h'){
												//for loop copies the link follwing the first "
												number++;
												p.print(number +". " );
												for(int i=0; ((char)content)!='\"'; i++){
													p.print((char)content);
													content=fis.read();
												}
												p.println(" ");
												results++;
												begin=true;
														}
													}
												
												}
											}
											}
										}
										}
									}
								}
							}
							}
						}
					}
				}
			}
		}
		catch(IOException e){
      System.out.println("Exception caught");
		}
	}

}
