package ThiThu2.repository;


import ThiThu2.model.SanPham;
import ThiThu2.ultil.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class SanPhamRepo {
    private Session session = null;

    public SanPhamRepo() {
        session = HibernateConfig.getFACTORY().openSession();
    }
    public List<SanPham> getAll() {
        return session.createQuery("from SanPham").list();
    }
    public SanPham getOne(Integer id) {
        return session.find(SanPham.class, id);
    }
    public void deletesp(Integer id) {
        try {
            session.getTransaction().begin();
            session.delete(getOne(id));
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void addsp(SanPham sp) {
        try {
            session.getTransaction().begin();
            session.save(sp);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void updatesp(SanPham sp) {
        try {
            session.getTransaction().begin();
            session.merge(sp);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
