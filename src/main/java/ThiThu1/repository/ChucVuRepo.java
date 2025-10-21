package ThiThu1.repository;

import ThiThu1.model.ChucVu;
import ThiThu1.ultil.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class ChucVuRepo {
    private Session session = null;

    public ChucVuRepo() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<ChucVu> getALl(){
        return session.createQuery("FROM ChucVu").list();
    }
    public ChucVu getOne(Integer id){
        return session.find(ChucVu.class, id);
    }
}
