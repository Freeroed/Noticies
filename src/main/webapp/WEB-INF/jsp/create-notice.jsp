<%--
  Created by IntelliJ IDEA.
  User: Freeroed
  Date: 18.02.2020
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<p align="center">Create Notice: </p>
<form:form method="post" action="create">
    <table align="center" border="3">
        <tr>
            <td>Введите название: </td>
            <td><form:input path="name"  /></td>
        </tr>
        <tr>
            <td>Введите описание :</td>
            <td><form:input path="description" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Сохранить" /></td>
        </tr>
    </table>
</form:form>
