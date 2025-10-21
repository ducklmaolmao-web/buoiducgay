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


    <form action="/phieu-giam-gia/update" method="post">
            id: <input type="text" name="id" value="${phieuGiamGia.id}"required><br>
            ma: <input type="text" name="ma" value="${phieuGiamGia.ma}"required><br>
            ten: <input type="text" name="ten" value="${phieuGiamGia.ten}"required><br>
            so luong: <input type="text" name="soLuong" value="${phieuGiamGia.soLuong}"required><br>

            ma gg:
            <select name="loaiPhieuGiamGia">
                <c:forEach items="${listLoaiPhieuGiamGia}" var="loaiPhieuGiamGia">
                    <option value="${loaiPhieuGiamGia.id}"
                            label="${loaiPhieuGiamGia.ten}"
                            ${sanPham.loaiPhieuGiamGia.id == loaiPhieuGiamGia.id? "selected" : " "}></option>
                </c:forEach>
            </select><br>

            <button>Sua</button>
        </form>


</body>
</html>
