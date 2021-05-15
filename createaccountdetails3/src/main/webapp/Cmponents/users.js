$(document).ready(function() {
    if ($("#alertSuccess").text().trim() == "") {
        $("#alertSuccess").hide();
    }
    $("#alertError").hide();
});


///CLIENT-MODEL================================================================
function validateusersForm() {

    // UserFirstName
    if ($("#UserFirstName").val().trim() == "") {
        return "Insert UserFirstName.";
    }
    // UserLastName
    if ($("#UserLastName").val().trim() == "") {
        return "Insert UserLastName.";
    }
    // UserAddress
    if ($("#UserAddress").val().trim() == "") {
        return "Insert UserAddress.";
    }
    // UserNIC
    if ($("#UserNIC").val().trim() == "") {
        return "Insert UserNIC.";
    }
    // UserPhoneNumber
    if ($("#UserPhoneNumber").val().trim() == "") {
        return "Insert UserPhoneNumber.";
    }
    // UserEmail
    if ($("#UserEmail").val().trim() == "") {
        return "Insert UserEmail.";
    }
    // UserName
    if ($("#UserName").val().trim() == "") {
        return "Insert UserName.";
    }
    // UserPassword
    if ($("#UserPassword").val().trim() == "") {
        return "Insert UserPassword.";
    }

    return true;
}


//save button
$(document).on("click", "#btnSave", function(event) {
    // Clear alerts---------------------
    $("#alertSuccess").text("");
    $("#alertSuccess").hide();
    $("#alertError").text("");
    $("#alertError").hide();
    // Form validation-------------------
    var status = validateusersForm();
    if (status != true) {
        $("#alertError").text(status);
        $("#alertError").show();
        return;
    }
    // If valid------------------------
    var type = ($("#hidUserIdSave").val() == "") ? "POST" : "PUT";
    $.ajax({
        url: "usersAPI",
        type: type,
        data: $("#formusers").serialize(),
        dataType: "text",
        complete: function(response, status) {
            onusersSaveComplete(response.responseText, status);
        }
    });
});


function onusersSaveComplete(response, status) {
    if (status == "success") {
        var resultSet = JSON.parse(response);
        if (resultSet.status.trim() == "success") {
            $("#alertSuccess").text("Successfully saved.");
            $("#alertSuccess").show();
            $("#divusersGrid").html(resultSet.data);
        } else if (resultSet.status.trim() == "error") {
            $("#alertError").text(resultSet.data);
            $("#alertError").show();
        }
    } else if (status == "error") {
        $("#alertError").text("Error while saving.");
        $("#alertError").show();
    } else {
        $("#alertError").text("Unknown error while saving..");
        $("#alertError").show();
    }
    $("#hidUserIdSave").val("");
    $("#formusers")[0].reset();
}


//update button
$(document).on("click", ".btnUpdate", function(event) {
    $("#hidUserIdSave").val($(this).data("userid"));
    $("#UserFirstName").val($(this).closest("tr").find('td:eq(0)').text());
    $("#UserLastName").val($(this).closest("tr").find('td:eq(1)').text());
    $("#UserAddress").val($(this).closest("tr").find('td:eq(2)').text());
    $("#UserNIC").val($(this).closest("tr").find('td:eq(3)').text());
    $("#UserPhoneNumber").val($(this).closest("tr").find('td:eq(4)').text());
    $("#UserEmail").val($(this).closest("tr").find('td:eq(5)').text());
    $("#UserName").val($(this).closest("tr").find('td:eq(6)').text());
    $("#UserPassword").val($(this).closest("tr").find('td:eq(7)').text());



});


//delete button
$(document).on("click", ".btnRemove", function(event) {
    $.ajax({
        url: "usersAPI",
        type: "DELETE",
        data: "UserId=" + $(this).data("userid"),
        dataType: "text",
        complete: function(response, status) {
            onusersDeleteComplete(response.responseText, status);
        }
    });
});


function onusersDeleteComplete(response, status) {
    if (status == "success") {
        var resultSet = JSON.parse(response);
        if (resultSet.status.trim() == "success") {
            $("#alertSuccess").text("Successfully deleted.");
            $("#alertSuccess").show();
            $("#divusersGrid").html(resultSet.data);
        } else if (resultSet.status.trim() == "error") {
            $("#alertError").text(resultSet.data);
            $("#alertError").show();
        }
    } else if (status == "error") {
        $("#alertError").text("Error while deleting.");
        $("#alertError").show();
    } else {
        $("#alertError").text("Unknown error while deleting..");
        $("#alertError").show();
    }
}