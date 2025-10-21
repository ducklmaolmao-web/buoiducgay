<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 8/15/2025
  Time: 7:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quản lý Sản phẩm</title>
</head>
<body>
    <h1>quan ly san pham</h1>
    <form action="/san-pham/add" method="post">
        id: <input type="text" name="id"><br>
        mã sản phẩm: <input type="text" name="ma"><br>
        tên sản phẩm: <input type="text" name="ten"><br>
        mô tả: <input type="text" name="mota"><br>

        loại SP:
        <select name="loaiSanPham">
            <c:forEach items="${listLoaiSanPham}" var="loaiSanPham">
                <option value="${loaiSanPham.id}">${loaiSanPham.ten}</option>
            </c:forEach>
        </select><br><br>

        <button>Save</button>
    </form>
    <table>
            <thead>
            <tr>
                <th>#</th>
                <th>Ma san pham</th>
                <th>Ten san pham</th>
                <th>Mo ta</th>
                <th>Ma loai san pham</th>
                <th>Ten loai san pham</th>
                <th>Hanh dong</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listSanPham}" var="sp">
                <tr>
                    <td>${sp.id}</td>
                    <td>${sp.ma}</td>
                    <td>${sp.ten}</td>
                    <td>${sp.mota}</td>
                    <td>${sp.loaiSanPham.ma}</td>
                    <td>${sp.loaiSanPham.ten}</td>
                    <td>
                        <a href="/san-pham/delete?id=${sp.id}">xoa</a>
                        <a href="/san-pham/view-update?id=${sp.id}">sua</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
</body>
</html>
