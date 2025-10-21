<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 8/16/2025
  Time: 5:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


    <form action="/phieu-giam-gia/add" method="post">
        id: <input type="text" name="id"><br>
        mã: <input type="text" name="ma"><br>
        tên: <input type="text" name="ten"><br>
        so luong: <input type="text" name="soLuong"><br>

        ma gg:
        <select name="loaiPhieuGiamGia">
            <c:forEach items="${listPhieuGiamGia}" var="loaiPhieuGiamGia">
                <option value="${loaiPhieuGiamGia.id}">${loaiPhieuGiamGia.ten}</option>
            </c:forEach>
        </select><br><br>

        <button>Save</button>
    </form>
    <table>
            <thead>
            <tr>
                <th>#</th>
                <th>Ma phieu</th>
                <th>Ten phieu</th>
                <th>so luong</th>
                <th>ma loai phieu</th>
                <th>ten loai phieu</th>
                <th>Hanh dong</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listPhieuGiamGia}" var="gg">
                <tr>
                    <td>${gg.id}</td>
                    <td>${gg.ma}</td>
                    <td>${gg.ten}</td>
                    <td>${gg.soLuong}</td>
                    <td>${gg.loaiPhieuGiamGia.ma}</td>
                    <td>${gg.loaiPhieuGiamGia.ten}</td>
                    <td>
                        <a href="/phieu-giam-gia/delete?id=${gg.id}">xoa</a>
                        <a href="/phieu-giam-gia/view-update?id=${gg.id}">sua</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>


</body>
</html>
