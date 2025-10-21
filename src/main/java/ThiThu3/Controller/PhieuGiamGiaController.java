package ThiThu3.Controller;

import ThiThu2.model.SanPham;
import ThiThu2.repository.LoaiSanPhamRepo;
import ThiThu3.Model.LoaiPhieuGiamGia;
import ThiThu3.Model.PhieuGiamGia;
import ThiThu3.Repository.LoaiPhieuGiamGiaRepo;
import ThiThu3.Repository.PhieuGiamGiaRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "PhieuGiamGiaController", value = {
        "/phieu-giam-gia/hien-thi",
        "/phieu-giam-gia/delete",
        "/phieu-giam-gia/view-update",
        "/phieu-giam-gia/add",
        "/phieu-giam-gia/update"
})
public class PhieuGiamGiaController extends HttpServlet {
    LoaiPhieuGiamGiaRepo loaiPhieuGiamGiaRepo = new LoaiPhieuGiamGiaRepo();
    PhieuGiamGiaRepo  phieuGiamGiaRepo = new PhieuGiamGiaRepo();

    @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String uri = req.getRequestURI();
            if(uri.equals("/phieu-giam-gia/hien-thi")){
                hienThi(req, resp);
            }else if (uri.equals("/phieu-giam-gia/delete")){
                delete(req, resp);
            }else if (uri.equals("/phieu-giam-gia/view-update")){
                viewUpdate(req, resp);
            }
        }
        public void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setAttribute("listLoaiPhieuGiamGia", loaiPhieuGiamGiaRepo.getALl());
            req.setAttribute("listPhieuGiamGia", phieuGiamGiaRepo.getAll());
            req.getRequestDispatcher("/De2/hien-thi.jsp").forward(req, resp);
        }
        public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Integer id = Integer.parseInt(req.getParameter("id"));
            phieuGiamGiaRepo.deletegg(id);
            resp.sendRedirect("/phieu-giam-gia/hien-thi");

        }
        public void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Integer id = Integer.parseInt(req.getParameter("id"));
            req.setAttribute("listLoaiPhieuGiamGia", loaiPhieuGiamGiaRepo.getALl());
            req.setAttribute("phieuGiamGia", phieuGiamGiaRepo.getOne(id));
            req.getRequestDispatcher("/De2/view-update.jsp").forward(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String uri = req.getRequestURI();
            if(uri.equals("/phieu-giam-gia/add")){
                addGG(req, resp);
            } else if (uri.equals("/phieu-giam-gia/update")) {
                updateGG(req, resp);
            }
        }
    private void addGG(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String ma = req.getParameter("ma");
        String ten = req.getParameter("ten");
        Integer soLuong = Integer.valueOf(req.getParameter("soLuong"));

        Integer idLoaiGG = Integer.valueOf(req.getParameter("loaiPhieuGiamGia"));
        LoaiPhieuGiamGia loai = loaiPhieuGiamGiaRepo.getOne(idLoaiGG);

        PhieuGiamGia gg = new PhieuGiamGia(id, ma, ten, soLuong, loai);
        phieuGiamGiaRepo.addgg(gg);

        resp.sendRedirect("/phieu-giam-gia/hien-thi");
    }

    private void updateGG(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String ma = req.getParameter("ma");
        String ten = req.getParameter("ten");
        Integer soLuong = Integer.valueOf(req.getParameter("soLuong"));

        Integer idLoaiGG = Integer.valueOf(req.getParameter("loaiPhieuGiamGia"));
        LoaiPhieuGiamGia loai = loaiPhieuGiamGiaRepo.getOne(idLoaiGG);

        PhieuGiamGia gg = new PhieuGiamGia(id, ma, ten, soLuong, loai);
        phieuGiamGiaRepo.updategg(gg);

        resp.sendRedirect("/phieu-giam-gia/hien-thi");
    }
}
