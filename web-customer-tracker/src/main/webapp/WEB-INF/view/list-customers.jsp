<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.luv2code.springdemo.util.SortUtils" %>

<!DOCTYPE HTML>

<html>

<head>
<title>List Customers</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/CSS/style.css" />
</head>
<body>
<div id="wrapper">
  <div id="header">
      <h2>CRM - Customer Relationship Manager</h2>
  </div>
</div>
<div id="container">
<div id="content">
<!--Add customer-->

<input type="button" value="Add customer" onClick="window.location.href='showFormForAdd'; return false;"
  class="add-button"/>
  
  
 <form:form action="search" method="GET">Search Customer:
 
 <input type="text" name="thesearchname"/>
 
 <input type="submit" value="Search" class="add-button"/>
 
 <c:url var="sortLinkFirstName" value="/customer/list">
					<c:param name="sort" value="<%= Integer.toString(SortUtils.FIRST_NAME) %>" />
				</c:url>	

<c:url var="sortLinkLastName" value="/customer/list">
					<c:param name="sort" value="<%= Integer.toString(SortUtils.LAST_NAME) %>" />
				</c:url>

<c:url var="sortLinkEmail" value="/customer/list">
					<c:param name="sort" value="<%= Integer.toString(SortUtils.EMAIL) %>" />
				</c:url>	
 
 </form:form>

 <!--Add out html table here -->
 <table>
    <tr>
    <th><a href="${sortLinkFirstName}">First Name</a></th>
    <th><a href="${sortLinkLastName}">Last Name</a></th>
    <th><a href="${sortLinkEmail}"> Email</a></th>
    <th> Action</th>
 </tr>
 
 <!-- Loop to print the customers -->
 
 <c:forEach var="tempcustomer" items="${customers}">
 <!-- construct the update link to customer id -->
 <c:url var="updatelink" value="/customer/showupdateform">
 
     <c:param name="id" value="${tempcustomer.id}">
 
 </c:param>
 </c:url>
 
 <c:url var="deletelink" value="/customer/showdeleteform">
 
     <c:param name="id" value="${tempcustomer.id}">
 
 </c:param>
 </c:url>
 
 <tr>
    <td>${tempcustomer.firstname}</td>
    <td>${tempcustomer.lastname}</td>
    <td> ${tempcustomer.email}</td>
    <td> <a href="${updatelink}">Update</a>
          | 
         <a href="${deletelink}" onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
    </td>
 
 </tr>
 
 
 
 
 </c:forEach>
 
 
 </table>
</div>
</div>
</body>







</html>