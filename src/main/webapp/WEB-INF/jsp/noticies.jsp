<%--
  Created by IntelliJ IDEA.
  User: Freeroed
  Date: 18.02.2020
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<p align="center">Список напоминаний: </p>
<table border="3" width="50%" cellpadding="2" align="center">
    <tr>
        <th>ID</th>
        <th>ИМЯ</th>
        <th>Описание</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach var="notice" items="${list}">
        <tr>
            <td>${notice.id}</td>
            <td>${notice.name}</td>
            <td>${notice.description}</td>
            <td><a href="edit-notice/${notice.id}">Редактировать</a></td>
            <td><a href="delete-notice/${notice.id}" methods="DELETE">Удалить</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="index">Назад</a>
