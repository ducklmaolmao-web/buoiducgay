package ThiThu1.repository;

import ThiThu1.model.NhanVien;
import ThiThu1.ultil.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class NhanVienRepo {
    private Session session = null;

    public NhanVienRepo(){
        session = HibernateConfig.getFACTORY().openSession();
    }
    public List<NhanVien> getAll(){
        return session.createQuery("from NhanVien").list();
    }
    public NhanVien getOne(Integer id){
        return session.find(NhanVien.class, id);
    }

    public void addNhanVien(NhanVien nhanVien){
        try{
            session.getTransaction().begin();
            session.save(nhanVien);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void updateNhanVien(NhanVien nhanVien){
        try{
            session.getTransaction().begin();
            session.merge(nhanVien);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deleteNhanVien(Integer id){
        try{
            session.getTransaction().begin();
            session.delete(getOne(id));
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

}
