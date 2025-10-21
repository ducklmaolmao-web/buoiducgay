package ThiThu2.controller;


import ThiThu2.model.LoaiSanPham;
import ThiThu2.model.SanPham;
import ThiThu2.repository.LoaiSanPhamRepo;
import ThiThu2.repository.SanPhamRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "sanPhamController", value = {
        "/san-pham/hien-thi",
        "/san-pham/delete",
        "/san-pham/view-update",
        "/san-pham/update",
        "/san-pham/add"

})
public class SanPhamController extends HttpServlet {
    LoaiSanPhamRepo loaiSanPhamRepo = new LoaiSanPhamRepo();
    SanPhamRepo sanPhamRepo = new SanPhamRepo();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.equals("/san-pham/hien-thi")) {
            hienThi(req, resp);
        } else if (uri.equals("/san-pham/delete")) {
            delete(req, resp);
        } else if (uri.equals("/san-pham/view-update")) {
            viewUpdate(req, resp);
        }
    }
    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listLoaiSanPham", loaiSanPhamRepo.getAll());
        req.setAttribute("listSanPham", sanPhamRepo.getAll());
        req.getRequestDispatcher("/De1/hien-thi.jsp").forward(req, resp);
    }
    public void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("listLoaiSanPham", loaiSanPhamRepo.getAll());
        req.setAttribute("sanPham", sanPhamRepo.getOne(id));
        req.getRequestDispatcher("/De1/view-update.jsp").forward(req, resp);
    }
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        sanPhamRepo.deletesp(id);
        resp.sendRedirect("/san-pham/hien-thi");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.equals("/san-pham/add")){
            addSanPham(req, resp);
        } else if (uri.equals("/san-pham/update")) {
            updateSanPham(req, resp);
        }
    }
    private void addSanPham(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String ma = req.getParameter("ma");
        String ten = req.getParameter("ten");
        String mota = req.getParameter("mota");

        Integer idLoaiSP = Integer.valueOf(req.getParameter("loaiSanPham"));
        LoaiSanPham loai = loaiSanPhamRepo.getOne(idLoaiSP);

        SanPham sp = new SanPham(id, ma, ten, mota, loai);
        sanPhamRepo.addsp(sp);

        resp.sendRedirect("/san-pham/hien-thi");
    }


    private void updateSanPham(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String ma = req.getParameter("ma");
        String ten = req.getParameter("ten");
        String mota = req.getParameter("mota");

        Integer idLoaiSP = Integer.valueOf(req.getParameter("loaiSanPham"));
        LoaiSanPham loai = loaiSanPhamRepo.getOne(idLoaiSP);

        SanPham sp = new SanPham(id, ma, ten, mota, loai);
        sanPhamRepo.updatesp(sp);

        resp.sendRedirect("/san-pham/hien-thi");
    }
}
