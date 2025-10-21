<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 8/15/2025
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Nhan vien</h1>

    <table border="1">
        <thead>
        <tr>
            <th>i d</th>
            <th>m a</th>
            <th>t en</th>
            <th>g ioiTinh</th>
            <th>d iaChi</th>
            <th>m a</th>
            <th>t en</th>
            <th>h anh dong</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listNhanVien}" var="nv">
            <tr>
                <td>${nv.id}</td>
                <td>${nv.ma}</td>
                <td>${nv.ten}</td>
                <td>${nv.gioiTinh}</td>
                <td>${nv.diaChi}</td>
                <td>${nv.chucVu.ma}</td>
                <td>${nv.chucVu.ten}</td>
                <td>
                    <a href="/nhan-vien/delete?id=${nv.id}">xoa</a>
                    <a href="/nhan-vien/view-update?id=${nv.id}">update</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
