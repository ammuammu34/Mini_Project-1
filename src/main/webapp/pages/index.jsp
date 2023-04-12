<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class = "container">
<h3 class ="pb-3 pt-3">Report Application</h3>
<form:form action ="save" modelAttribute ="search" method = "POST" >

     <table>
           <tr>
           <td>PlanName: </td>
           <td>
           <form:select path="PlanNames">
           <form:option value="">-select-</form:option>
           <form:options items= "${names}"/>
           </form:select></td>
           
           <td>PlanStatus: </td>
           <td>
           <form:select path="Status">
           <form:option value="">-select-</form:option>
           <form:options items = "${status}"/>
           </form:select></td>
           <td>Gender: </td>
           <td>
            <form:select path="gender">
           <form:option value="">-select-</form:option>
           <form:option value="M">Male</form:option>
           <form:option value="F">Fe-Male</form:option>
           
           </form:select>
               
                          
          </td>
           </tr>
           <tr>
           <td>Start Date</td>
           <td>
           <form:input path="StartDate" type = "date" /></td>

           <td>End Date</td>
           <td>
           <form:input path="EndDate" type="date" /></td>
           
           </tr>
           <tr>
           <td ><a href = "/" class = "btn btn-secondary">Reset</a></td>
           <td><input type = "submit" value = "Search" class = "btn btn-primary"></td>
           </tr>
           
</table>

</form:form>
</hr>
     <table class="table table-dark table-hover">
     <thead>
     <tr class="table-primary">
         <th>S.No</th>
         <th>Customer Name</th>
          <th>PlanNames</th>
          <th>Gender</th>
           <th>Status</th>
           <th>StartDate</th>
           <th>EndDate</th>
           <th>BenifitAmount</th>
     </tr>
     <tbody>
     <c:forEach items = "${plans}" var = "plan" varStatus="index">
     <tr>
     <td>${index.count}</td>
     <td>${plan.citizenName}</td>
     <td>${plan.planNames}</td>
     <td>${plan.gender}</td>
     <td>${plan.status}</td>
     <td>${plan.startDate}</td>
      <td>${plan.endDate}</td>
      <td>${plan.benifitAmount}</td>
     </tr>
     </c:forEach>
     <tr>
     <c:if test = "${empty plans}">
    <td colspan="7" style = "text-align = center"> No Records Available</td>
     
     </c:if>
     </tr>
     </tbody>

         </table>
</hr>
<p>${export}</p>
Export: <a href = "excel">Excel</a>
         <a href = "pdf">PDF</a>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>