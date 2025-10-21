package ThiThu2.repository;


import ThiThu2.model.LoaiSanPham;
import ThiThu2.ultil.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class LoaiSanPhamRepo {
    private Session session = null;

    public LoaiSanPhamRepo() {
        session = HibernateConfig.getFACTORY().openSession();
    }
    public List<LoaiSanPham> getAll() {
        return session.createQuery("FROM LoaiSanPham ").list();
    }
    public LoaiSanPham getOne(Integer id) {
        return session.find(LoaiSanPham.class, id);
    }
}
