import java.io.*;
public class BingScraper{

//Variables
	public static String output;
	public static String input;
	public static String keywords;
	public static String nKeywords;

	public static void main(String[] args){
	try{
		Parser parser=new Parser();
		//ArrayList<String> array=parser.getKeywords(keywords);
		//String nKeywords=parser.fixKeywords(parser.getKeywords(keywords));
		//parser.getCode("http://www.google.com/");
		//parser.getCode("http://www.google.com/search?q=uga+computer+science+program&btnG=Search&oe=utf-8&rls=org.mozilla%3Aen-US%3Aofficial&client=firefox-a&channel=fflb&gbv=1", output);
		//parser.getCode("http://www.google.com/search?q=" + nKeywords + "&btnG=Search&oe=utf-8&rls=org.mozilla%3Aen-US%3Aofficial&client=firefox-a&channel=fflb&gbv=1", output);
		//parser.parseFile(input, output);

		if(args.length!=4 && args.length!=6){
			System.out.println("Please enter the correct arguments.");

		}
		else if(args[0].equals("-q") || args[0].equals("-o") || args[0].equals("-f")){

		//First flag is -q
			if(args[0].equals("-q")){
				keywords=args[1];
				System.out.println("You are searching for keywords: " + keywords);
				
			//Second flag is -o
				if(args[2].equals("-o")){
					output=args[3];
					System.out.println("Output file is " + output);

				//Third flag is -f
					if(args.length>4){
						if(args[4].equals("-f")){
							input=args[5];
							System.out.println("Ignoring query. Input file is " + input);
							parser.parseFile(input, output);
						}
					}
					else if(args.length>4){
						if(!(args[4].equals("-f"))){
							System.out.println("Error");
						}
					}
					else{
						System.out.println("Conducting search for " + keywords);
						nKeywords=parser.fixKeywords(parser.getKeywords(keywords));
						parser.getCode("http://www.bing.com/search?q=" + nKeywords, "code.txt");
	/*				parser.getCode("http://www.google.com/search?q=" + nKeywords + "&btnG=Search&oe=utf-8&rls=org.mozilla:en-US:official&client=firefox-a&channel=fflb&gbv=1", "code.txt");*/
						parser.parseFile("code.txt", output);
					}
					
				}
			//Second flag is -f					
				else if(args[2].equals("-f")){
					input=args[3];
					System.out.println("Input file is " + input);
					
				//Third flag is -o
					if(args[4].equals("-o")){
						output=args[5];
						System.out.println("Output file is " + output);
						System.out.println("Ignoring query. Input file is " + input);
						parser.parseFile(input, output);
					}
					else{
						System.out.println("You must enter '-q' followed by search keywords and then '-o' followed by and outputfile name.");
						System.exit(0);
					}
				}
				else{
					System.out.println("You must enter '-q' followed by search keywords and then '-o' followed by and outputfile name.");
					System.exit(0);
				}

			}
		//First flag is -o
			else if(args[0].equals("-o")){
				output=args[1];
				System.out.println("Output file will be called " + output);
			//Second flag is -q
				if(args[2].equals("-q")){
					keywords=args[3];
					System.out.println("You are searching for key words " + keywords);
				//Third flag is -f
					if(args.length>4){
						if(args[4].equals("-f")){
							input=args[5];
							System.out.println("Ignoring query. Input file is " + input);
							parser.parseFile(input, output);
						}
					}
					else if(args.length>4){
						if(!(args[4].equals("-f"))){
							System.out.println("Error");
						}
					}
					else{
						System.out.println("Conducting search for " + keywords);
						nKeywords=parser.fixKeywords(parser.getKeywords(keywords));
						parser.getCode("http://www.google.com/search?q=" + nKeywords + "&btnG=Search&oe=utf-8&rls=org.mozilla%3Aen-US%3Aofficial&client=firefox-a&channel=fflb&gbv=1", "code.txt");
						parser.parseFile("code.txt", output);
					}
				}
			//Second flag is -f					
				else if(args[2].equals("-f")){
					input=args[3];
					System.out.println("Input file is " + input);
				//Third flag is -q
					if(args.length>4){
						if(args[4].equals("-q")){
							keywords=args[5];
							System.out.println("You are searching for " + keywords);
							System.out.println("Ignoring query. Input file is " + input);
							parser.parseFile(input, output);
						}
					}
					else if(args.length>4){
						if(!(args[4].equals("-q"))){
							System.out.println("You must enter '-q' followed by search keywords and then '-o' followed by and outputfile name.");
							System.exit(0);
						}
					}
					else{
						parser.parseFile(input, output);
					}
				}
				else{
					System.out.println("You must enter '-q' followed by search keywords and then '-o' followed by and outputfile name.");
					System.exit(0);
				}
			}
		//First flag is -f
			else{
				input=args[1];
				System.out.println("Input file is "+ input);
			//Second flag is -o
				if(args[2].equals("-o")){
					output=args[3];
					System.out.println("Output file is " + output);
					parser.parseFile(input, output);
				}
			//Second flag is -q					
				else if(args[2].equals("-q")){
					keywords=args[3];
					System.out.println("You are searching for key words " + keywords);
				//Third flag is -o
					if(args.length>4){
						if(args[4].equals("-o")){
							output=args[5];
							System.out.println("Output file is " + output);
							System.out.println("Ignoring query. Input file is " + input);
							parser.parseFile(input, output);
						}
					}
					else if(args.length>4){
						if(!(args[4].equals("-o"))){
							System.out.println("Error");
							System.exit(0);
						}
					}
					else{
						System.out.println("You must enter '-q' followed by search keywords and then '-o' followed by and outputfile name.");
						System.exit(0);
					}
				}
				else{
					System.out.println("You must enter '-q' followed by search keywords and then '-o' followed by and outputfile name.");
					System.exit(0);
				}
			}
		}
		else{
			System.out.println("You must enter '-q' followed by search keywords and then '-o' followed by and outputfile name.");
			System.exit(0);
		}

	}
	catch(Exception e){
		System.out.println("Please enter the correct arguments.");
	
	}
	
	}

}
