import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class USABServer {

	public static void main (String[] args) throws IOException{
		Socket socket = null;
	    ServerSocket serverSocket = new ServerSocket(1234);
	    InputStreamReader inputStreamReader = null;
	    OutputStreamWriter outputStreamWriter = null;
	    BufferedWriter bufferedWriter = null;
	    BufferedReader bufferedReader = null;
		
		while(true) {//---------------------------------------------------------Server Start--------------------------------------------------------------------------
			socket = serverSocket.accept();
			

		    
		    LocalDateTime myDateObj = LocalDateTime.now();
		    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm");

		    String formattedDate = myDateObj.format(myFormatObj);

			
			inputStreamReader = new InputStreamReader(socket.getInputStream());
    		outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
    		bufferedWriter = new BufferedWriter(outputStreamWriter);
    		bufferedReader = new BufferedReader(inputStreamReader);

    		bufferedWriter.write("Console_Appendation: Connection Established " + formattedDate);
			bufferedWriter.newLine();
			bufferedWriter.flush();

    		
			
			while(true) {//---------------------------------------------------------Server Main Start------------------------------------------
				
				String identifyingCommand = bufferedReader.readLine();
				System.out.println("Client: " + identifyingCommand);
				System.out.println("Identifying Command:" + identifyingCommand);
				if(identifyingCommand.equals("add")) {
					System.out.println("Addition System Accessed");
					String vendorNameToAdd = bufferedReader.readLine();
					System.out.println("Vendor: " + vendorNameToAdd);
					String AccountToAdd = bufferedReader.readLine();
					System.out.println("Account: " + AccountToAdd);
					String numberToAdd = bufferedReader.readLine();
					System.out.println("Number: " + numberToAdd);
					String InfoToAdd = bufferedReader.readLine();
					System.out.println("Info: " + InfoToAdd);
					
					
					
					
				      File myObj = new File(vendorNameToAdd + ".txt");
				      if (myObj.createNewFile()) {
				        System.out.println("File created: " + myObj.getName());
				        
			    		bufferedWriter.write("Console_Appendation: Vendor Successfuly Added");
						bufferedWriter.newLine();
						bufferedWriter.flush();
				        
						
						try {
						      FileWriter myWriter = new FileWriter(vendorNameToAdd + ".txt");
						      myWriter.write("VendorID: " + vendorNameToAdd);
						      myWriter.write(System.getProperty( "line.separator" ));
						      myWriter.write("AccountID: " + AccountToAdd);
						      myWriter.write(System.getProperty( "line.separator" ));
						      myWriter.write("NumberID: " + numberToAdd);
						      myWriter.write(System.getProperty( "line.separator" ));
						      myWriter.write("InfoID: " + InfoToAdd);
						      myWriter.write(System.getProperty( "line.separator" ));
						    
						      
						      myWriter.close();

						    } catch (IOException e) {
						      System.out.println("An error occurred.");
						      e.printStackTrace();
						    }
						
						
						
						try {
						      FileWriter myWriter = new FileWriter("vendorManagmentList.txt",true);
						      myWriter.write(vendorNameToAdd + " ");
						      myWriter.write(System.getProperty( "line.separator" ));
						      myWriter.close();

						    } catch (IOException e) {
						      System.out.println("An error occurred.");
						      e.printStackTrace();
						    }
						
				        
						System.out.println("Addition System Complete");
				        
				      } else {
				    		bufferedWriter.write("Console_Appendation: Vendor Already Exists");
							bufferedWriter.newLine();
							bufferedWriter.flush();
				      }
					
					
					
					
					

				
				}
				
				if(identifyingCommand.equals("search")) {
					System.out.println("Search System Accessed");
					
					String vendorNameToSearch = bufferedReader.readLine();
					System.out.println("Search Target: " + vendorNameToSearch);
					
					

					
					
					 
					File f = new File(vendorNameToSearch + ".txt");
					if(f.exists() && !f.isDirectory()) { 
						System.out.println("File Exist");	
			    		bufferedWriter.write("Console_Appendation: Vendor Located");
						bufferedWriter.newLine();
						bufferedWriter.flush();
						
						
						String clientIDMessage = "Error";
						
			    		bufferedWriter.write("Target_Search nullData");
						bufferedWriter.newLine();
						bufferedWriter.flush();
						
						System.out.println("Search Command Sent");
						
						try (Stream<String> stream = Files.lines(Paths.get(vendorNameToSearch + ".txt"))) {

					        List<String> abc = stream.filter(str->str.startsWith("AccountID:"))
					                                 .map(s->s.split("AccountID:")[1]).collect(Collectors.toList());

					        System.out.println("Account ID located: " + abc);    
					        
					        String AccountIDPacket = String.join(", ", abc);
					        
					        if(AccountIDPacket.equals("")) {
					        	AccountIDPacket = "NO DATA";
					        }
				    		bufferedWriter.write(AccountIDPacket);
							bufferedWriter.newLine();
							bufferedWriter.flush();
				    		System.out.println("Sent:" + AccountIDPacket);
				    		
				    		

					    } catch (IOException e) {
					        e.printStackTrace();
					    }
						
						
						try (Stream<String> stream = Files.lines(Paths.get(vendorNameToSearch + ".txt"))) {

					        List<String> abc = stream.filter(str->str.startsWith("VendorID:"))
					                                 .map(s->s.split("VendorID:")[1]).collect(Collectors.toList());

					        System.out.println("Vendor ID located: " + abc);    
					        
					        String VendorIDPacket = String.join(", ", abc);
					        
					        if(VendorIDPacket.equals("")) {
					        	VendorIDPacket = "NO DATA";
					        }
					        
				    		bufferedWriter.write(VendorIDPacket);
							bufferedWriter.newLine();
							bufferedWriter.flush();
				    		System.out.println("Sent:" + VendorIDPacket);

					    } catch (IOException e) {
					        e.printStackTrace();
					    }
						
						try (Stream<String> stream = Files.lines(Paths.get(vendorNameToSearch + ".txt"))) {

					        List<String> abc = stream.filter(str->str.startsWith("InfoID:"))
					                                 .map(s->s.split("InfoID:")[1]).collect(Collectors.toList());

					        System.out.println("Info ID located: " + abc);    
					        
					        String InfoIDPacket = String.join(",", abc);
					        
					        if(InfoIDPacket.equals("")) {
					        	InfoIDPacket = "NO DATA";
					        }
					        
				    		bufferedWriter.write(InfoIDPacket);
							bufferedWriter.newLine();
							bufferedWriter.flush();
				    		System.out.println("Sent:" + InfoIDPacket);

					    } catch (IOException e) {
					        e.printStackTrace();
					    }
						
						try (Stream<String> stream = Files.lines(Paths.get(vendorNameToSearch + ".txt"))) {

					        List<String> abc = stream.filter(str->str.startsWith("NumberID:"))
					                                 .map(s->s.split("NumberID:")[1]).collect(Collectors.toList());

					        System.out.println("NumberID located: " + abc);
					        
					        String NumberIDPacket = String.join(", ", abc);
					        
					        if(NumberIDPacket.equals("")) {
					        	NumberIDPacket = "NO DATA";
					        }
					        
				    		bufferedWriter.write(NumberIDPacket);
							bufferedWriter.newLine();
							bufferedWriter.flush();
				    		System.out.println("Sent:" + NumberIDPacket);

					    } catch (IOException e) {
					        e.printStackTrace();
					    }
						
						
						
						
					}
					else {
						System.out.println("File Does Not Exist");	
			    		bufferedWriter.write("Console_Appendation: Vendor File Not Found");
						bufferedWriter.newLine();
						bufferedWriter.flush();
					}
					
					
					
				
				
				}
				
				if(identifyingCommand.equals("Delete")) {
					System.out.println("Removal System Accessed");
					String vendorToDelete =  bufferedReader.readLine();
					System.out.println("Target Vendor: " + vendorToDelete);
				       File file = new File(vendorToDelete + ".txt");
				          
				        if(file.delete())
				        {
				    		bufferedWriter.write("Console_Appendation: Vendor Successfuly Deleted");
							bufferedWriter.newLine();
							bufferedWriter.flush();
							System.out.println("Removal Successful");
							
							
							
							Path path = Paths.get("vendorManagmentList" + ".txt");
							Charset charset = StandardCharsets.UTF_8;

							String content = new String(Files.readAllBytes(path), charset);
							content = content.replaceAll(vendorToDelete + " ","");
							System.out.println("Vendor List To Delete: " + vendorToDelete + " ");
							Files.write(path, content.getBytes(charset));
							
				        }
				        else
				        {
				    		bufferedWriter.write("Console_Appendation: Vendor File Not Found");
							bufferedWriter.newLine();
							bufferedWriter.flush();
							System.out.println("Removal Error");
				        }
					
				}
				
				
				if(identifyingCommand.equals("edit")) {
					System.out.println("Edit System Accessed");
					
					String editSubject = bufferedReader.readLine();
					System.out.println("Edit subject: " + editSubject);
					
					while(true) { 
						

						String fullEditPacket = bufferedReader.readLine();
						System.out.println("Edit full edit packet: " + fullEditPacket);
						
						String arr[] = fullEditPacket.split(" ", 2);
						System.out.println("Edit full edit packet organized: " + arr);

						String editCommand = arr[0];  
						String dataChange = arr[1];     
						
						System.out.println("Edit Command new: " + editCommand);
						System.out.println("Edit Data new: " + dataChange);
						
						//String editCommand = bufferedReader.readLine();
						//System.out.println("Edit command: " + editCommand);
						
						
						
						if(editCommand.equals("+Number")) {
							String numberToAdd = dataChange;
							System.out.println("Adding number:" + numberToAdd);
							
							Path path = Paths.get(editSubject + ".txt");
							Charset charset = StandardCharsets.UTF_8;
							
							String content = new String(Files.readAllBytes(path), charset);
							content = content.replaceAll("NumberID: NO DATA", "");
							Files.write(path, content.getBytes(charset));
							
							
							try {
							      FileWriter myWriter = new FileWriter(editSubject + ".txt",true);
							      myWriter.write(System.getProperty( "line.separator" ));
							      myWriter.write("NumberID: " + numberToAdd);
							      myWriter.write(System.getProperty( "line.separator" ));
							      myWriter.close();

							    } catch (IOException e) {
						    		bufferedWriter.write("Console_Appendation: Error Writing NumberID");
									bufferedWriter.newLine();
									bufferedWriter.flush();
							    }
							
						}
						if(editCommand.equals("+Account")) {
							String accountToAdd = dataChange;
							System.out.println("Adding Account:" + accountToAdd);
							
							Path path = Paths.get(editSubject + ".txt");
							Charset charset = StandardCharsets.UTF_8;
							
							String content = new String(Files.readAllBytes(path), charset);
							content = content.replaceAll("AccountID: NO DATA", "");
							Files.write(path, content.getBytes(charset));
							
							
							try {
							      FileWriter myWriter = new FileWriter(editSubject + ".txt",true);
							      myWriter.write(System.getProperty( "line.separator" ));
							      myWriter.write("AccountID: " + accountToAdd);
							      myWriter.write(System.getProperty( "line.separator" ));
							      myWriter.close();

							    } catch (IOException e) {
						    		bufferedWriter.write("Console_Appendation: Error Writing AccountID");
									bufferedWriter.newLine();
									bufferedWriter.flush();
							    }
						}
						if(editCommand.equals("+Info")) {
							
							Path path = Paths.get(editSubject + ".txt");
							Charset charset = StandardCharsets.UTF_8;
							
							String content = new String(Files.readAllBytes(path), charset);
							content = content.replaceAll("InfoID: NO DATA", "");
							Files.write(path, content.getBytes(charset));
							
							
							String InfoToAdd = dataChange;
							System.out.println("Adding Info:" + InfoToAdd);
							
							try {
							      FileWriter myWriter = new FileWriter(editSubject + ".txt",true);
							      myWriter.write(System.getProperty( "line.separator" ));
							      myWriter.write("InfoID: " + InfoToAdd);
							      myWriter.write(System.getProperty( "line.separator" ));
							      myWriter.close();

							    } catch (IOException e) {
						    		bufferedWriter.write("Console_Appendation: Error Writing LocationID");
									bufferedWriter.newLine();
									bufferedWriter.flush();
							    }
						}

						if(editCommand.equals("-Number")) {
							String numberToRemove = dataChange;
							System.out.println("Removing number:" + numberToRemove);
							
							Path path = Paths.get(editSubject + ".txt");
							Charset charset = StandardCharsets.UTF_8;

							String content = new String(Files.readAllBytes(path), charset);
							content = content.replaceAll("NumberID: " + numberToRemove, "ARCHIVED " + numberToRemove);
							Files.write(path, content.getBytes(charset));
							
							
						}
						if(editCommand.equals("-Account")) {
							String accountToRemove = dataChange;
							System.out.println("Removing Account:" + accountToRemove);
							
							Path path = Paths.get(editSubject + ".txt");
							Charset charset = StandardCharsets.UTF_8;

							String content = new String(Files.readAllBytes(path), charset);
							content = content.replaceAll("AccountID: " + accountToRemove, "ARCHIVED " + accountToRemove);
							Files.write(path, content.getBytes(charset));
							
							
						}
						if(editCommand.equals("-Info")) {
							String InfoToRemove = dataChange;
							System.out.println("Removing Info:" + InfoToRemove);
							
							Path path = Paths.get(editSubject + ".txt");
							Charset charset = StandardCharsets.UTF_8;

							String content = new String(Files.readAllBytes(path), charset);
							content = content.replaceAll("InfoID: " + InfoToRemove, "ARCHIVED " + InfoToRemove);
							Files.write(path, content.getBytes(charset));
						}
						if(editCommand.equals("END_EDIT")) {
							System.out.println("Edits done");
							break;
						}
						
						
					}
					
		    		bufferedWriter.write("Console_Appendation: Edits Applied to Vendor: " + editSubject);
					bufferedWriter.newLine();
					bufferedWriter.flush();
					System.out.println("Edit System Exited");
					
					
					
					
				}
				
				if(identifyingCommand.equals("check")) {
					String vendorToCheck = bufferedReader.readLine();
					System.out.println("Checking System Accessed");
					File f = new File(vendorToCheck + ".txt");
					if(f.exists() && !f.isDirectory()) { 
			    		bufferedWriter.write("Console_Appendation: Vendor Located");
						bufferedWriter.newLine();
						bufferedWriter.flush();
						
						System.out.println("Sending Edit_Enabled true packet");
			    		bufferedWriter.write("Edit_Enabled true");
						bufferedWriter.newLine();
						bufferedWriter.flush();
						
					}
					else {
			    		bufferedWriter.write("Console_Appendation: Vendor File Not Found");
						bufferedWriter.newLine();
						bufferedWriter.flush();
					}
					
				}
				if(identifyingCommand.equals("search_combo_request")) {
					System.out.println("Vendor List System Accessed");
					
					BufferedReader br = new BufferedReader(new FileReader("vendorManagmentList.txt"));
					try {
					    StringBuilder sb = new StringBuilder();
					    String line = br.readLine();

					    while (line != null) {					    	
					        sb.append(line + ",");
					        System.out.println("Vendor List Reader: " + line);
					         
					      StringBuffer StringBuff= new StringBuffer(line);
					      System.out.println("Pre-String Buff: " + StringBuff);
					      
					      int lengthCounter = StringBuff.length();
					      
					     
	  
					      
					      

					      System.out.println("String Buff: " + StringBuff);
					      if(lengthCounter > 1) {
						      StringBuff.deleteCharAt(StringBuff.length()-1);
					    	  System.out.println("Empty Checkpoint Passed");
				    		bufferedWriter.write("search_combo_request: " + StringBuff);
							bufferedWriter.newLine();
							bufferedWriter.flush();
					      }
							
							
					        line = br.readLine();
					    }
					    String everything = sb.toString();
					    

					    
					    System.out.println(everything);
					} finally {
					    br.close();
					}
					
				}
				
				
				
				
				if(identifyingCommand.equals("CLOSE")) {
						
					break;
				}
				
				}
			// ---------------------------------------------------------Server Main End--------------------------------------------------------------------------
			
    		socket.close();
    		inputStreamReader.close();
    		outputStreamWriter.close();
    		bufferedReader.close();
    		bufferedWriter.close();
    		System.out.println("Exited");

			
		}//---------------------------------------------------------Server End--------------------------------------------------------------------------
		
		
		
		
		
		
		
		
	}
}
