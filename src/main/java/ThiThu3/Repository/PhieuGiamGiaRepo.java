package ThiThu3.Repository;

import ThiThu3.Model.PhieuGiamGia;
import ThiThu3.ultil.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class PhieuGiamGiaRepo {
    private Session session = null;

    public PhieuGiamGiaRepo() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<PhieuGiamGia> getAll(){
        return session.createQuery("from PhieuGiamGia").list();
    }

    public PhieuGiamGia getOne(Integer id) {
        return session.find(PhieuGiamGia.class, id);
    }

    public void deletegg(Integer id) {
        try {
            session.getTransaction().begin();
            session.delete(getOne(id));
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void addgg(PhieuGiamGia phieuGiamGia) {
        try {
            session.getTransaction().begin();
            session.save(phieuGiamGia);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void updategg(PhieuGiamGia phieuGiamGia) {
        try {
            session.getTransaction().begin();
            session.merge(phieuGiamGia);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
