package service.customer;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import repository.CustomerRepository;

public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /*private static SessionFactory sessionFactory;

    private static void config(){
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(registry);
    }

    private static HashMap<Long, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1L, new Customer(1L, "John", "john@codegym.vn", "Hanoi"));
        customers.put(2L, new Customer(2L, "Bill", "bill@codegym.vn", "Danang"));
        customers.put(3L, new Customer(3L, "Alex", "alex@codegym.vn", "Saigon"));
        customers.put(4L, new Customer(4L, "Adam", "adam@codegym.vn", "Beijin"));
        customers.put(5L, new Customer(5L, "Sophia", "sophia@codegym.vn", "Miami"));
        customers.put(6L, new Customer(6L, "Rose", "rose@codegym.vn", "Newyork"));
    }
*/
    @Override
    public Iterable<Customer> selectAll() {
        //ArrayList<Customer> arrayList = new ArrayList<>(customers.values());
        /*Session session = sessionFactory.openSession();
        session.beginTransaction();
        String queryStr = "SELECT * FROM customer;";
        Query query = session.createQuery(queryStr);
        session.getTransaction().commit();
        sessionFactory.close();
        ArrayList<Customer> arrayList =*/
        //return arrayList;
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        //return customers.get(id);
        return customerRepository.findOne(id);
    }

    @Override
    public void save(Customer customer) {
        //customers.put(customer.getId(),customer);
        /*Session session = sessionFactory.openSession();
        session.save(customer);
        session.getTransaction().commit();
        sessionFactory.close();*/
        customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        //customers.put(customer.getId(),customer);
        /*Session session = sessionFactory.openSession();
        session.update(customer);
        session.getTransaction().commit();
        sessionFactory.close();*/
        customerRepository.save(customer);
    }

    @Override
    public void remote(Long id) {
        //customers.remove(id);
        /*Session session = sessionFactory.openSession();
        session.remove(id);
        session.getTransaction().commit();
        sessionFactory.close();*/
        customerRepository.delete(id);
    }
}
