package ThiThu1.controller;

import ThiThu1.repository.ChucVuRepo;
import ThiThu1.repository.NhanVienRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "nhanVienController", value = {
        "/nhan-vien/hien-thi",
        "/nhan-vien/update",
        "/nhan-vien/view-update",
        "/nhan-vien/add",
        "/nhan-vien/delete"
})
public class NhanVienController extends HttpServlet {
    ChucVuRepo chucVuRepo = new ChucVuRepo();
    NhanVienRepo nhanVienRepo = new NhanVienRepo();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.equals("/nhan-vien/hien-thi")){
            hienThi(req, resp);
        } else if (uri.equals("/nhan-vien/view-update")) {
            viewUpdate(req,resp);
        } else if (uri.equals("/nhan-vien/delete")) {
            delete(req, resp);
        }
    }
    public void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listChucVu", chucVuRepo.getALl());
        req.setAttribute("listNhanVien", nhanVienRepo.getAll());
        req.getRequestDispatcher("/view/hien-thi.jsp").forward(req, resp);
    }
    public void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("listChucVu", chucVuRepo.getALl());
        req.setAttribute("danhSach", nhanVienRepo.getOne(id));
        req.getRequestDispatcher("/view/view-update.jsp").forward(req, resp);
    }
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        nhanVienRepo.deleteNhanVien(id);
        resp.sendRedirect("/nhan-vien/hien-thi");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.equals("/nhan-vien/add")) {
            addNhanVien(req, resp);
        } else if (uri.equals("/nhan-vien/update")) {
            updateNhanVien(req, resp);
        }
    }
    public void addNhanVien(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public void updateNhanVien(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
