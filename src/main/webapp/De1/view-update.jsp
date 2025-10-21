<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 8/15/2025
  Time: 8:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/san-pham/update" method="post">
        id: <input type="text" name="id" value="${sanPham.id}"required><br>
        ma san pham: <input type="text" name="ma" value="${sanPham.ma}"required><br>
        ten san pham: <input type="text" name="ten" value="${sanPham.ten}"required><br>
        mo ta: <input type="text" name="mota" value="${sanPham.mota}"required><br>

        loai sp:
        <select name="loaiSanPham">
            <c:forEach items="${listLoaiSanPham}" var="loaiSanPham">
                <option value="${loaiSanPham.id}"
                        label="${loaiSanPham.ten}"
                        ${sanPham.loaiSanPham.id == loaiSanPham.id? "selected" : " "}></option>
            </c:forEach>
        </select><br>

        <button>Sua</button>
    </form>

</body>
</html>
