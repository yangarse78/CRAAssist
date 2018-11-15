<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <jsp:include page="headIncludes.jsp" />


    <body>
    
    <div class="container">
	     <h2>User</h2>

    </div>
    
        <h1>Input Form</h1>
        <form:form action="addUser" method="post" modelAttribute="user">
            <table>
                <tr>
                    <td>First Name</td>
                    <td>
                        <form:input path="firstName" /> <br />
                        <form:errors path="firstName" cssClass="error" />
                    </td>
                </tr>
                 <tr>
                    <td>Last Name</td>
                    <td>
                        <form:input path="lastName" /> <br />
                        <form:errors path="lastName" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td>
                        <form:input path="email" /> <br />
                        <form:errors path="email" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td>Age</td>
                    <td>
                        <form:input path="age" /> <br />
                        <form:errors path="age" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><button type="submit">Submit</button></td>
                </tr>
            </table>
        </form:form>
         
        <h2>Users List</h2>
        <table>
            <tr>
                <td><strong>Name</strong></td>
                <td><strong>Email</strong></td>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.firstName}</td>
                    <td>${user.email}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>