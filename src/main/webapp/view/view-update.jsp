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


    <form action="nhan-vien/update" method="post">
        Ma: <input type="text" name="ma" value="${danhSach.ma}" required><br>
        Ten: <input type="text" name="ten" value="${danhSach.ten}" required><br>
        Gioi tinh: <input type="text" name="gioiTinh" value="${danhSach.gioiTinh}" required><br>
        Dia chi: <input type="text" name="diaChi" value="${danhSach.diaChi}" required><br>

        LoaiSp: <select name="chucVu"> <c:forEach
            items="${listChucVu}" var="chucVu">
        <option value="${chucVu.id}"
                label="${chucVu.ten}"
            ${danhSach.chucVu.id == chucVu.id? "selected" : " "}
        ></option>
    </c:forEach></select> <br>
        <button>sua</button>

    </form>


</body>
</html>
