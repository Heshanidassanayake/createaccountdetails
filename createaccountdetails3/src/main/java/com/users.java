package com;

import java.sql.*;

public class users 
{

			//CONNECTION
			public Connection connect()
			{
					Connection con = null;

					try
					{
							Class.forName("com.mysql.jdbc.Driver");
							con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gadgetbadget02",	"root", "");
			
							//For testing
							System.out.print("Successfully connected");
					}
					catch(Exception e)
					{
							e.printStackTrace();
					}

					return con;
			}

			//INSERT
			public String insertusers(String UserFirstName, String UserLastName, String UserAddress, String UserNIC, String UserPhoneNumber, String UserEmail, String UserName, String UserPassword)
				{
						String output = "";
						
						try
						{
								Connection con = connect();
								
								if (con == null)
								{
										return "Error while connecting to the database for inserting";
								}

								// create a prepared statement
								String query = " insert into users(`UserId`,`UserFirstName`,`UserLastName`,`UserAddress`,`UserNIC`,`UserPhoneNumber`,`UserEmail`,`UserName`,`UserPassword`) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
								
								PreparedStatement preparedStmt = con.prepareStatement(query);

								// binding values
								preparedStmt.setInt(1, 0);
								preparedStmt.setString(2, UserFirstName);
								preparedStmt.setString(3, UserLastName);
								preparedStmt.setString(4, UserAddress);
								preparedStmt.setString(5, UserNIC); 
								preparedStmt.setString(6, UserPhoneNumber);
								preparedStmt.setString(7, UserEmail);
								preparedStmt.setString(8, UserName);
								preparedStmt.setString(9, UserPassword);

								//execute the statement
								preparedStmt.execute();
								con.close();

								String newusers = readusers();
								output = "{\"status\":\"success\", \"data\": \"" + newusers + "\"}";
				
						}
						catch (Exception e)
						{
									output = "{\"status\":\"error\", \"data\":\"Error while inserting the users.\"}";
									System.err.println(e.getMessage());
						}
						
						return output;
				}
				

			//READ
			public String readusers()
			{
					String output = "";
					
					try
					{
							Connection con = connect();
							
							if (con == null)
							{
									return "Error while connecting to the database for reading.";
							}
							
							// Prepare the HTML table to be displayed
							output = "<table  class='table table-dark table-striped'><tr><th>UserFirstName</th>"
									+"<th>UserLastName</th><th>UserAddress</th>"
									+ "<th>UserNIC</th><th>UserPhoneNumber</th><th>UserEmail</th><th>UserName</th><th>UserPassword</th>"
									
									+ "<th>Update</th><th>Remove</th></tr>";

							String query = "select * from users";
							Statement stmt = con.createStatement();
							ResultSet rs = stmt.executeQuery(query);

							// iterate through the rows in the result set
							while (rs.next())
							{
									String UserId  = Integer.toString(rs.getInt("UserId"));
									String UserFirstName = rs.getString("UserFirstName");
									String UserLastName = rs.getString("UserLastName");
									String UserAddress = rs.getString("UserAddress");
									String UserNIC = rs.getString("UserNIC");
									String UserPhoneNumber = rs.getString("UserPhoneNumber");
									String UserEmail = rs.getString("UserEmail");
									String UserName = rs.getString("UserName");
									String UserPassword = rs.getString("UserPassword");

									// Add a row into the HTML table
									output += "<tr><td>" + UserFirstName + "</td>";
									output += "<td>" + UserLastName + "</td>";
									output += "<td>" + UserAddress + "</td>"; 
									output += "<td>" + UserNIC + "</td>";
									output += "<td>" + UserPhoneNumber + "</td>";
									output += "<td>" + UserEmail + "</td>"; 
									output += "<td>" + UserName + "</td>";
				 					output += "<td>" + UserPassword + "</td>";

									// buttons
									output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary' data-userid='" + UserId + "'></td>"
											+"<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-userid='" + UserId + "'>" + "</td></tr>";
							}

							con.close();

							// Complete the HTML table
							output += "</table>";
					}
					catch (Exception e)
					{
							output = "Error while reading the users.";
							System.err.println(e.getMessage());
					}
					
					return output;
			}

			
			//UPDATE
			public String updateusers(int UserId , String UserFirstName, String UserLastName, String UserAddress, String UserNIC, String UserPhoneNumber, String UserEmail, String UserName, String UserPassword)
			{
					String output = "";
					
					try
					{
							Connection con = connect();
							
							if (con == null)
							{
									return "Error while connecting to the database for updating";
							}

							// create a prepared statement
							String query = "update users set `UserFirstName`=?,`UserLastName`=?,`UserAddress`=?,`UserNIC`=?,`UserPhoneNumber`=?,`UserEmail`=?,`UserName`=?,`UserPassword`=? where `UserId`=?";
							
							PreparedStatement preparedStmt = con.prepareStatement(query);

							// binding values
							preparedStmt.setString(1, UserFirstName);
							preparedStmt.setString(2, UserLastName);
							preparedStmt.setString(3, UserAddress);
							preparedStmt.setString(4, UserNIC);
							preparedStmt.setString(5, UserPhoneNumber);
							preparedStmt.setString(6, UserEmail);
							preparedStmt.setString(7, UserName);
							preparedStmt.setString(8, UserPassword);
							preparedStmt.setInt(9, UserId);

							//execute the statement
							preparedStmt.executeUpdate();
							con.close();

							String newusers = readusers();
							output = "{\"status\":\"success\", \"data\": \"" + newusers + "\"}";
			
			
					}
					catch (Exception e)
					{
							output = "{\"status\":\"error\", \"data\":\"Error while updating the users.\"}";
							System.err.println(e.getMessage());
					}
					
					return output;
			}
			
			

			//DELETE
			public String removeusers(int UserId)
			{
					String output = "";
					
					try
					{
							Connection con = connect();
							
							if (con == null)
							{
									return "Error while connecting to the database for deleting";
							}

							// create a prepared statement
							String query = "delete from users where `UserId`=?;";
							
							PreparedStatement preparedStmt = con.prepareStatement(query);

							// binding values
							preparedStmt.setInt(1, UserId);

							//execute the statement
							preparedStmt.executeUpdate();
							con.close();

							String newusers = readusers();
							output = "{\"status\":\"success\", \"data\": \"" + newusers + "\"}";
					}
					catch (Exception e)
					{
						output = "{\"status\":\"error\", \"data\":\"Error while deleting the users.\"}";
						System.err.println(e.getMessage());
					}
					
					return output;
			}

	
}
