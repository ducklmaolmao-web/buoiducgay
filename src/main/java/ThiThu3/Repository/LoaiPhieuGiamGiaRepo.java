package ThiThu3.Repository;

import ThiThu3.Model.LoaiPhieuGiamGia;
import ThiThu3.ultil.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class LoaiPhieuGiamGiaRepo {
    private Session session = null;

    public LoaiPhieuGiamGiaRepo() {
        session = HibernateConfig.getFACTORY().openSession();
    }
    public List<LoaiPhieuGiamGia> getALl() {
        return session.createQuery("from LoaiPhieuGiamGia").list();
    }
    public LoaiPhieuGiamGia getOne(Integer id) {
        return session.find(LoaiPhieuGiamGia.class, id);
    }
}
