package hellopjpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
//            Member member = new Member();
//            member.setId(100L);
//            member.setName("Hello A");
//            em.persist(member);

            Member member1 = em.find(Member.class, 100L);
            Member member2 = em.find(Member.class, 100L);

            System.out.println(member1.getName());
            System.out.println(member2.getName());
            System.out.println(member1 == member2);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        em.close();
        emf.close();
    }
}
