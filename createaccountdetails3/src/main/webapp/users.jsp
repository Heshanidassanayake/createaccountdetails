<%@ page import="com.users"%>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="ISO-8859-1">
            <title>users Management</title>
            <script src="Cmponents/jquery-3.2.1.min.js"></script>
            <script src="Cmponents/users.js"></script>
            <link rel="stylesheet" href="Views/bootstrap.min.css">
        </head>

        <body>
            <div class="container">
                <div class="row">
                    <div class="col">


                        <h1>Users Management</h1>
                        <form id="formusers" name="formusers">
                            UserFirstName:
                            <input id="UserFirstName" name="UserFirstName" type="text" class="form-control form-control-sm">
                            <br> UserLastName:
                            <input id="UserLastName" name="UserLastName" type="text" class="form-control form-control-sm">
                            <br> UserAddress:
                            <input id="UserAddress" name="UserAddress" type="text" class="form-control form-control-sm">
                            <br> UserNIC:
                            <input id="UserNIC" name="UserNIC" type="text" class="form-control form-control-sm">
                            <br> UserPhoneNumber:
                            <input id="UserPhoneNumber" name="UserPhoneNumber" type="text" class="form-control form-control-sm">
                            <br> UserEmail:
                            <input id="UserEmail" name="UserEmail" type="text" class="form-control form-control-sm">
                            <br> UserName:
                            <input id="UserName" name="UserName" type="text" class="form-control form-control-sm">
                            <br> UserPassword:
                            <input id="UserPassword" name="UserPassword" type="text" class="form-control form-control-sm">
                            <br>

                            <input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
                            <input type="hidden" id="hidUserIdSave" name="hidUserIdSave" value="">
                        </form>


                        <br>

                        <div id='alertSuccess' name='alertSuccess' class='alert alert-success'></div>
                        <div id='alertError' name='alertError' class='alert alert-danger'></div>

                        <br>
                        <div id="divusersGrid">
                            <%
				users usersObjRead = new users();
				out.print(usersObjRead.readusers());
				%>
                        </div>

                    </div>
                </div>
            </div>
        </body>

        </html>