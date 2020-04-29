<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/js/bootstrap.min.css">
  <script src="/resources/js/jquery.min.js"></script>
  <script src="/resources/js/popper.min.js"></script>
  <script src="/resources/js/bootstrap.min.js"></script>
  
  
  <script type="text/javascript">
function validateForm() {
alert("inside validate form");
var name = $("#name"). val();
var email = $("#email"). val();
var dept= $("#dept"). val();

alert(name)
alert(email)
alert(dept)
$.ajax({
    type : "POST",
    url : "insertData",
    data : {
    	"name" : name,
    	"email" : email,
    	"dept" : dept
    	
    },
    success: function(data){
       /*  $('#input_field').val(data); */
       $("#name").val("");
       $("#email").val("");
       $("#dept").val("");
      
       alert(data);
    }
});

}
</script>
</head>
<body>

<div class="container">
  <h2 >Add form</h2>
  <form id="formid" >
  <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
    </div>
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
    <div class="form-group">
      <label for="dept">Department:</label>
      <input type="text" class="form-control" id="dept" placeholder="Enter Department" name="dept">
    </div>
    <!-- <div class="form-group form-check">
      <label class="form-check-label">
        <input class="form-check-input" type="checkbox" name="remember"> Remember me
      </label>
    </div> -->
    <button type="button" class="btn btn-primary" onclick="validateForm()">Submit</button>
    
  </form>
</div>

</body>
</html>