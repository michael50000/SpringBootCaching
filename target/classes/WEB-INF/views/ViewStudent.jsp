<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/resources/js/bootstrap.min.css">
  <script src="/resources/js/jquery.min.js"></script>
  <script src="/resources/js/popper.min.js"></script>
  <script src="/resources/js/bootstrap.min.js"></script>
  
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.css">
  
  <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>
  
<title>Insert title here</title>

<script type="text/javascript">
$(document).ready( function () {
    $('#table_id').DataTable();
});

function deletes(stid){
	alert("hello")
	alert(stid)
	
	$.ajax({
	    type : "POST",
	    url : "DeleteStd",
	    data : {
	    	"stid" : stid
	    	
	    },
	    success: function(data){
	       /*  $('#input_field').val(data); */
	    if(data=='S'){
	    	
	    	alert("Deleted Successfully")
	    	 location.reload();
	    }
	      
	    }
	});
	
}

function validateForm(sid,name,email,dept){
	//alert(sid)
	//alert(name)
	//alert(email)
	//alert(dept)
	 $('#myModal').modal('show'); 
	 $("#sid"). val(sid);
	 $("#name"). val(name);
	 $("#email").val(email);
	 $("#dept"). val(dept);
	
	

}

function updateSubmit(){
	alert("update")
	
	var stid = $("#sid"). val();
	var name = $("#name"). val();
	var email = $("#email"). val();
	var dept= $("#dept"). val();

	
	 $.ajax({
    type : "POST",
    url : "updateStudent",
    data : {
    	"stid" : stid,
    	"name" : name,
    	"email": email,
    	"dept" : dept
    	
    	
    },
    success: function(data){
      //alert(data)
    if(data=='S'){
    	
    	alert("Updated Successfully")
    	 location.reload();
    }
      
    }
});
 
	
}

</script>
</head>
<body>


<h1>Employees List</h1>  
<%-- <table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Email</th><th>Dept</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="emp" items="${list}">   
   <tr>  
   <td>${emp.sid}</td>  
   <td>${emp.name}</td>  
   <td>${emp.email}</td>  
   <td>${emp.dept}</td>  
   <td><a >Edit</a></td>  
   <td><a href="javascript:undefined" onclick="deletes()">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
    --%>
   <table id="table_id" class="display">
    <thead>
        <tr>
            <th>Id</th><th>Name</th><th>Email</th><th>Dept</th><th>Delete</th><th>Edit</th>
        </tr>
    </thead>
    
    <tbody>
    <c:forEach var="emp" items="${list}">   
    <tr id="tr_${emp.sid}">  
   <td>${emp.sid}</td>  
   <td>${emp.name}</td>  
   <td>${emp.email}</td>  
   <td>${emp.dept}</td>  
  
   <td><a href="javascript:undefined" onclick="deletes('${emp.sid}')">Delete</a></td>  
    <td><a href="javascript:undefined" onclick="validateForm('${emp.sid}','${emp.name}','${emp.email}','${emp.dept}')">Edit</a></td>  
   </tr>  
    </c:forEach>  
    </tbody>
   
</table>
   
   
   
   
   
   
   
<div class="container">
 
  <!-- Trigger the modal with a button -->
 <!--  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>
 -->
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
         
        </div>
        <div class="modal-body">
        
 <div class="container">
  <h2 >Edit form</h2>
  <form id="formid" >
  <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
      <input type="hidden" id="sid">
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
    <button type="button" class="btn btn-primary" onclick="updateSubmit()">Submit</button>
    
  </form>
</div>
        </div>
        <div class="modal-footer">s
          <!-- <button type="button" class="btn btn-default" data-dismiss="modal">Close</button> -->
        </div>
      </div>
      
    </div>
  </div>
  
</div>

</body>
</html>