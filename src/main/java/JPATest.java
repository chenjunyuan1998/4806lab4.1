
import com.example.servingwebcontent.app.AddressBook;
import com.example.servingwebcontent.app.BuddyInfo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPATest {

    public void performJPA() {

        // Creating objects representing some products
        BuddyInfo product1 = new BuddyInfo();
        product1.setId(1L);
        product1.setName("aaa");
        product1.setPhone("111");
        product1.setAddress("abcd");

        BuddyInfo product2 = new BuddyInfo();
        product2.setId(2L);
        product2.setName("bbb");
        product2.setPhone("222");
        product2.setAddress("efgh");

        AddressBook addressBook = new AddressBook();
        addressBook.setId(3L);
        addressBook.addBuddy(product1);
        addressBook.addBuddy(product2);

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Persisting the product entity objects
        em.persist(product1);
        em.persist(product2);
        //em.persist(addressBook);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT b FROM com.example.servingwebcontent.BuddyInfo b");

        @SuppressWarnings("unchecked")
        List<BuddyInfo> results = q.getResultList();

        System.out.println("List of buddyInfos\n----------------");

        for (BuddyInfo p : results) {

            System.out.println(p.getName() + " (id=" + p.getId() + ")");
        }

        // Closing connection
        em.close();

        emf.close();
    }
    public void performJPA1(){
        BuddyInfo product3 = new BuddyInfo();
        product3.setId(5L);
        product3.setName("dgaffasd");
        product3.setPhone("21321321");
        product3.setAddress("abcdssa");
        BuddyInfo product4 = new BuddyInfo();
        product4.setId(6L);
        product4.setName("bbbsda");
        product4.setPhone("222333");
        product4.setAddress("efghsad");

        AddressBook a = new AddressBook();
        List<BuddyInfo> list = new ArrayList<BuddyInfo>();
        list.add(product3);
        list.add(product4);

        a.setId(1L);
        a.setBuddyInfos(list);

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Persisting the product entity objects
        em.persist(product3);
        em.persist(product4);
        em.persist(a);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT a FROM AddressBook a");

        @SuppressWarnings("unchecked")
        List<AddressBook> results = q.getResultList();

        System.out.println("List of com.example.servingwebcontent.app.AddressBook\n----------------");

        for (AddressBook p : results) {

            System.out.println(p.getBuddyInfos() + " (id=" + p.getId() + ")");
        }

        // Closing connection
        em.close();

        emf.close();

    }

    //Switch cases by calling performJPA(for com.example.servingwebcontent.app.BuddyInfo) and PerformJPA1(for addressBook)
    public static void main(String[] args){
        JPATest test = new JPATest();
        test.performJPA1();
        //test.performJPA();
    }
}