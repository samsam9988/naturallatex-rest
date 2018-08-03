/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.facade;

 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import naturallatex.entity.Customer;
import naturallatex.utils.RandomNumberUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sam
 */
 @Transactional
@Repository
public class CustomerFacade extends AbstractFacade<Customer> implements CustomerFacadeLocal {
    private static final Logger logger = Logger.getLogger(CustomerFacade.class);
    
    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }
    
    @Override
    public Customer findByCustId(Integer id) {
        Query q = em.createNamedQuery("Customer.findByCustId");
        q.setParameter("custId", id);
         if (q.getResultList().isEmpty()) {
            return null;
        }
         Customer cust =  (Customer) q.getResultList().get(0);
         cust.getCustId();
        return (Customer) q.getResultList().get(0);
    }
    
    @Override
    public Customer findByEmailAddress(String email) {
        Query q = em.createNamedQuery("Customer.findByEmailAddress");
        q.setParameter("emailAddress", email);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (Customer) q.getResultList().get(0);
    }


    
    
//    @Override
//    public Customer findByFirstNullAddressOfCustId(Integer custId) {
//        Customer cust = this.findByCustId(custId);
//        Collection<BillingAddress> billlingAdressList = cust.getBillingAddressCollection();
//        Collection<ShippingAddress> shipplingAdressList = cust.getShippingAddressCollection();
//        if (CollectionUtils.isEmpty(billlingAdressList) || CollectionUtils.isEmpty(shipplingAdressList)) {
//            return cust;
//        }
//        
//        return null;
//    }
//
//        
//    /**
//     * return 
//     * @param custId
//     * @param billingAddress
//     * @param shippingAddress
//     * @return 
//     */
//    @Override
//    public MatchingAddress findByBillingShippingAddressOfCustId(Integer custId, BillingAddress billingAddress, ShippingAddress shippingAddress) {
//        Customer cust = this.findByCustId(custId);
//        if (CollectionUtils.isEmpty(cust.getBillingAddressCollection()) || CollectionUtils.isEmpty(cust.getShippingAddressCollection())) {
//            return new MatchingAddress(custId);
//        }
//        List<BillingAddress> bAddrList = (List<BillingAddress>) cust.getBillingAddressCollection();
//        List<ShippingAddress> sAddrList  =  (List<ShippingAddress>) cust.getShippingAddressCollection();
////        int min = Math.min(bAddrList.size(), sAddrList.size());
//        Iterator<BillingAddress> bIter = bAddrList.iterator();
//        BillingAddress _billingAddr = null;
//        while (bIter.hasNext()) {
//            if (bIter.next().equals(billingAddress)) {
//                _billingAddr = billingAddress;
//                break;
//            }
//        }
//        
//        Iterator<ShippingAddress> sIter = sAddrList.iterator();
//        ShippingAddress _shippingAddr = null;
//        while (sIter.hasNext()) {
//            if (sIter.next().equals(shippingAddress)) {
//                _shippingAddr = shippingAddress;
//                break;
//            }
//        }
//        return new MatchingAddress(custId, 
//                        _billingAddr != null ? _billingAddr.getBillingAddressId():null, 
//                        _shippingAddr != null ? _shippingAddr.getShippingAddressId():null);
//       
//    }
    
//    @Override
//    public CustomerRegistration findByBillingOrShippingAddressOfCustId(Integer custId, BillingAddress billingAddress, ShippingAddress shippingAddress) {
//        Collection<CustomerRegistration> custRegs = this.findByCustId(custId);
//        if (CollectionUtils.isEmpty(custRegs)) {
//            return null;
//        }
//        for (CustomerRegistration custReg : custRegs) {
//            BillingAddress _billingAddr = custReg.getBillingAddressId();
//            ShippingAddress _shippingAddr = custReg.getShippingAddressId();
//            if (_billingAddr == null && _shippingAddr != null) {
//                if (StringUtils.equalsIgnoreCase(_shippingAddr.getCity(), shippingAddress.getCity())
//                       && StringUtils.equalsIgnoreCase(_shippingAddr.getState(), shippingAddress.getState())
//                       && StringUtils.equalsIgnoreCase(_shippingAddr.getCountry(), shippingAddress.getCountry())
//                       && StringUtils.equalsIgnoreCase(_shippingAddr.getFirstName(), shippingAddress.getFirstName())
//                       && StringUtils.equalsIgnoreCase(_shippingAddr.getLastName(), shippingAddress.getLastName())) {
//
//                   return custReg;
//               } 
//            }
//            else if (_billingAddr != null) {
//                if (StringUtils.equalsIgnoreCase(_billingAddr.getAddress(), billingAddress.getAddress())
//                    && StringUtils.equalsIgnoreCase(_billingAddr.getCity(), billingAddress.getCity())
//                    && StringUtils.equalsIgnoreCase(_billingAddr.getState(), billingAddress.getState())
//                    && StringUtils.equalsIgnoreCase(_billingAddr.getCountry(), billingAddress.getCountry())
//                    && StringUtils.equalsIgnoreCase(_billingAddr.getFirstName(), billingAddress.getFirstName())
//                    && StringUtils.equalsIgnoreCase(_billingAddr.getLastName(), billingAddress.getLastName())) {
//                    
//                    return custReg;
//                }
//            }
//            
//        }
//        return null;
//    }

//    private BillingAddress findBillingAddress(BillingAddress billingAddress, Collection<BillingAddress> existingAddr) {
//        if (CollectionUtils.isNotEmpty(existingAddr)) {
//            Iterator<BillingAddress> iter = existingAddr.iterator();
//            while (iter.hasNext()) {
//                BillingAddress addr = iter.next();
//                if (addr.equals(billingAddress)) {
//                    return addr;
//                }
//            }
//        }
//        return null;
//    }
//    
//    private ShippingAddress findShippingAddress(ShippingAddress shippingAddress, Collection<ShippingAddress> existingAddr) {
//        if (CollectionUtils.isNotEmpty(existingAddr)) {
//            Iterator<ShippingAddress> iter = existingAddr.iterator();
//            while (iter.hasNext()) {
//                ShippingAddress addr = iter.next();
//                if (addr.equals(shippingAddress)) {
//                    return addr;
//                }
//            }
//        }
//        return null;
//    }
    
//    private Collection<PurchaseOrder> setPaymentId(Integer paymentDetailId, Collection<PurchaseOrder> posList) {
//        CopyOnWriteArrayList<PurchaseOrder> newList = new CopyOnWriteArrayList<PurchaseOrder>();
//        if (CollectionUtils.isNotEmpty(posList)) {
//            CopyOnWriteArrayList<PurchaseOrder> origList = new CopyOnWriteArrayList<PurchaseOrder>(posList);
//            Iterator<PurchaseOrder> iter = origList.iterator();
//            while (iter.hasNext()) {
//                PurchaseOrder po = iter.next();
//                po.setPaymentDate(new Date());
//                po.setPaymentDetailId(paymentDetailId);
//                newList.add(po);
//            }
//        }
//        return newList;
//    }
    
//    private Collection<PurchaseOrder> setAddressId(Integer billingAddressId, Integer shippingAddressId, Collection<PurchaseOrder> posList, Integer orderLineNumber) {
//        
//        CopyOnWriteArrayList<PurchaseOrder> newList = new CopyOnWriteArrayList<PurchaseOrder>();
//        if (CollectionUtils.isNotEmpty(posList)) {
//            CopyOnWriteArrayList<PurchaseOrder> origList = new CopyOnWriteArrayList<PurchaseOrder>(posList);
//            Iterator<PurchaseOrder> iter = origList.iterator();
//            while (iter.hasNext()) {
//                PurchaseOrder po = iter.next();
//                po.setPaymentDate(new Date());
//                po.setBillingAddressId(billingAddressId);
//                po.setShippingAddressId(shippingAddressId);
//                po.setOrderLineNumber(orderLineNumber);
//                newList.add(po);
//            }
//        }
//        return newList;
//    }
    
//    @Override
//    public Integer createAddressAndOrder(Customer customer, PaymentDetail paymentDetail, BillingAddress billingAddress, ShippingAddress shippingAddress, Collection<PurchaseOrder> poList) {
//        Customer cust = null;
//        if (customer == null) {
//           cust = this.findByCustId(customer.getCustId());
//        }
//        Integer orderLineNumber = -1;
//        if (cust != null) {
//            Collection<PaymentDetail> paymentDetailList = new ArrayList<PaymentDetail>();
//            Collection<PaymentDetail> existingPaymentDetailList = cust.getPaymentDetailCollection();
//            Integer paymentDetailId = null;
//            if (CollectionUtils.isNotEmpty(existingPaymentDetailList)) {
//                Iterator<PaymentDetail> iterDetail = existingPaymentDetailList.iterator();
//                while (iterDetail.hasNext()) {
//                    PaymentDetail _paymentDetail = iterDetail.next();
//                    if (_paymentDetail.equals(paymentDetail)) {
//                        paymentDetailId = _paymentDetail.getPaymentDetailId();
//                    }
//                }
//            }
//            if (paymentDetailId == null) {
//                paymentDetailId = RandomNumberUtil.bigId();
//            }
//            paymentDetail.setPaymentDetailId(paymentDetailId);
//            paymentDetail.setCustId(cust);
//            paymentDetailList.add(paymentDetail);
//            
//            cust.setPaymentDetailCollection(paymentDetailList);
//            Collection<PurchaseOrder> posList = new ArrayList<PurchaseOrder>(poList);
//            posList = setPaymentId(paymentDetailId, posList);
//            
//            Collection<BillingAddress> bAddrList = new ArrayList<BillingAddress>();
//            if (CollectionUtils.isEmpty(cust.getBillingAddressCollection())) {
//                billingAddress.setBillingAddressId(RandomNumberUtil.bigId());
//                billingAddress.setDefaultAddress(Boolean.TRUE);
//            }
//            else {
//                BillingAddress existingAddr = findBillingAddress(billingAddress, cust.getBillingAddressCollection());
//                if (existingAddr == null) {
//                    logger.debug("\n====null exsitingA billing ddr");
//                    billingAddress.setBillingAddressId(RandomNumberUtil.bigId());
//                }
//                else {
//logger.debug("\n====NOT null exsitingA billing ddr: "+existingAddr.toString());
//                    billingAddress = existingAddr;
//                }
//            }
//            bAddrList.add(billingAddress);
//            cust.setBillingAddressCollection(bAddrList);
//            
//            Collection<ShippingAddress> sAddrList = new ArrayList<ShippingAddress>();
//            if (CollectionUtils.isEmpty(cust.getShippingAddressCollection())) {
//                shippingAddress.setShippingAddressId(RandomNumberUtil.bigId());
//                shippingAddress.setDefaultAddress(Boolean.TRUE);
//            }
//            else {
//                ShippingAddress existingAddr = findShippingAddress(shippingAddress, cust.getShippingAddressCollection());
//                if (existingAddr == null) {
//                    logger.debug("\n====null exsitingA shipping ddr");
//                    shippingAddress.setShippingAddressId(RandomNumberUtil.bigId());
//                }
//                else {
//                    logger.debug("\n====NOT null exsitingA shipping ddr: "+existingAddr.toString());
//                    shippingAddress = existingAddr;
//                }
//            }
//            orderLineNumber = RandomNumberUtil.bigId();
//            posList = setAddressId(billingAddress.getBillingAddressId(), shippingAddress.getShippingAddressId(), posList, orderLineNumber);
//            cust.getPurchaseOrderCollection().addAll(posList);
//            sAddrList.add(shippingAddress);
//            cust.setShippingAddressCollection(sAddrList);
//
//            flush();
//            edit(cust); 
//
//        }
//        else {// Guest or New Customer PlaceOrder in checkout page
//            cust = customer;
//            Collection<PaymentDetail> paymentDetailList = new ArrayList<PaymentDetail>();
//            Integer paymentDetailId = RandomNumberUtil.bigId();
//            paymentDetail.setPaymentDetailId(paymentDetailId);
//            paymentDetail.setCustId(cust);
//            paymentDetailList.add(paymentDetail);
//            
//            cust.setPaymentDetailCollection(paymentDetailList);
//            Collection<PurchaseOrder> posList = new ArrayList<PurchaseOrder>(poList);
//            posList = setPaymentId(paymentDetailId, posList);
//            
//            Collection<BillingAddress> bAddrList = new ArrayList<BillingAddress>();
//            if (CollectionUtils.isEmpty(cust.getBillingAddressCollection())) {
//                billingAddress.setBillingAddressId(RandomNumberUtil.bigId());
//                billingAddress.setDefaultAddress(Boolean.TRUE);
//            }
//            else {
//                BillingAddress existingAddr = findBillingAddress(billingAddress, cust.getBillingAddressCollection());
//                if (existingAddr == null) {
//                    logger.debug("\n====null exsitingA billing ddr");
//                    billingAddress.setBillingAddressId(RandomNumberUtil.bigId());
//                }
//                else {
//logger.debug("\n====NOT null exsitingA billing ddr: "+existingAddr.toString());
//                    billingAddress = existingAddr;
//                }
//            }
//            bAddrList.add(billingAddress);
//            cust.setBillingAddressCollection(bAddrList);
//            
//            Collection<ShippingAddress> sAddrList = new ArrayList<ShippingAddress>();
//            if (CollectionUtils.isEmpty(cust.getShippingAddressCollection())) {
//                shippingAddress.setShippingAddressId(RandomNumberUtil.bigId());
//                shippingAddress.setDefaultAddress(Boolean.TRUE);
//            }
//            else {
//                ShippingAddress existingAddr = findShippingAddress(shippingAddress, cust.getShippingAddressCollection());
//                if (existingAddr == null) {
//                    logger.debug("\n====null exsitingA shipping ddr");
//                    shippingAddress.setShippingAddressId(RandomNumberUtil.bigId());
//                }
//                else {
//                    logger.debug("\n====NOT null exsitingA shipping ddr: "+existingAddr.toString());
//                    shippingAddress = existingAddr;
//                }
//            }
//            orderLineNumber = RandomNumberUtil.bigId();
//            posList = setAddressId(billingAddress.getBillingAddressId(), shippingAddress.getShippingAddressId(), posList, orderLineNumber);
//            cust.setPurchaseOrderCollection(posList);
////            cust.getPurchaseOrderCollection().addAll(posList);
//            sAddrList.add(shippingAddress);
//            cust.setShippingAddressCollection(sAddrList);
//            
//            flush();
//            edit(cust); 
//
//        }
//        return orderLineNumber;
//    }

//    @Override
//    public Integer createAddressAndOrderForNewRegUser(Customer customer, PaymentDetail paymentDetail, BillingAddress billingAddress, ShippingAddress shippingAddress, Collection<PurchaseOrder> poList) {
////        Customer cust = this.findByEmailAddress(customer.getEmailAddress());
////        if (cust != null) {
////            customer = cust;
////        }
////        else {
//        if (customer == null) {
//            Customer cust = this.findByEmailAddress(customer.getEmailAddress());
//            if (cust == null) {
//                customer = new Customer();
//            }
//            else {
//                customer = cust;
//            }
//        }
////        customer.setCustId(RandomNumberUtil.bigId());
//        Collection<CustomerRegistration> custRegsList = new ArrayList<CustomerRegistration>();
//        CustomerRegistration custReg = new CustomerRegistration();
//        custReg.setRegDate(new Date());
//        custReg.setRegId(RandomNumberUtil.bigId());
//        custReg.setCustId(customer);
//        custRegsList.add(custReg);
//        customer.setCustomerRegistrationCollection(custRegsList);
//        return this.createAddressAndOrder(customer, paymentDetail, billingAddress, shippingAddress, poList);
//
//    }
    
//    @Override
//    public BillingAddress getDefaultBillingAddress(Customer cust) {
//        Collection<BillingAddress> billingAddressList = cust.getBillingAddressCollection();
//        if (CollectionUtils.isEmpty(billingAddressList)) {
//            return null;
//        }
//        Iterator<BillingAddress> iter = billingAddressList.iterator();
//        while (iter.hasNext()) {
//            BillingAddress bAddr =iter.next();
//            if (bAddr.getDefaultAddress()) {
//                return bAddr;
//            }
//        }
//        return null;
//    }
//    
//    @Override
//    public Collection<BillingAddress> findBillingAddressesByCust(Customer cust) {
//        Customer c = this.findByCustId(cust.getCustId());
//        Collection<BillingAddress> pos = c.getBillingAddressCollection();
//        if (CollectionUtils.isNotEmpty(pos)) {
//            Iterator<BillingAddress> iter = pos.iterator();
//            while (iter.hasNext()) {
//                iter.next();
//            }
//        }
//        return pos;
//    }
//    
//    @Override
//    public Collection<ShippingAddress> findShippingAddressesByCust(Customer cust) {
//        Customer c = this.findByCustId(cust.getCustId());
//        Collection<ShippingAddress> pos = c.getShippingAddressCollection();
//        if (CollectionUtils.isNotEmpty(pos)) {
//            Iterator<ShippingAddress> iter = pos.iterator();
//            while (iter.hasNext()) {
//                iter.next();
//            }
//        }
//        return pos;
//    }
    
//    @Override
//    public Collection<PurchaseOrder> findPurchaseOrdersByCust(Customer cust) {
//        Customer c = this.findByCustId(cust.getCustId());
//        Collection<PurchaseOrder> pos = c.getPurchaseOrderCollection();
//        if (CollectionUtils.isNotEmpty(pos)) {
//            Iterator<PurchaseOrder> iter = pos.iterator();
//            while (iter.hasNext()) {
//                iter.next();
//            }
//        }
//        return pos;
//    }

    /***
     * Pre condition: Customer is not in customerRegistration table. 
     * Customer could be in Customer table or not in Customer table.
     *
     * @param preOrder 
     */
//    @Override
//    public void create(Customer cust, ShippingAddress shippingAddress, PreOrder preOrder) {
//        if (preOrder == null) {
//            logger.info("====failed to create PreOrder. preOrder is null");
//            return;
//        }
//        if (cust == null) {
//            logger.info("====failed to create PreOrder. customer is null");
//            return;
//        }
//        if (preOrder.getProductId() == null) {
//            logger.info("====failed to create PreOrder. preOrde.product is null");
//            return;
//        }
//
//        logger.info("----shippingAddress: "+shippingAddress.toString());
//        
//        preOrder.setCustId(cust);
//        preOrder.setOrderNumber(RandomNumberUtil.bigId());
//        shippingAddress.setShippingAddressId(RandomNumberUtil.bigId());
//        Customer _cust = this.findByEmailAddress(cust.getEmailAddress());
//        if (_cust == null) { // Customer not in Customer table.
//            _cust = new Customer();
//            _cust.setCustId(RandomNumberUtil.bigId());
//            Collection<ShippingAddress> addrs = new ArrayList<ShippingAddress>();
//            shippingAddress.setCustId(cust);
//            shippingAddress.setFirstName(cust.getFirstName());
//            shippingAddress.setLastName(cust.getLastName());
//            addrs.add(shippingAddress);
//            _cust.setShippingAddressCollection(addrs);
//            
//        }
//        else { // Customer in Customer table.
//            ShippingAddress addr = findShippingAddress(shippingAddress, _cust.getShippingAddressCollection());
//            if (addr == null) {
//                Collection<ShippingAddress> addrs = new ArrayList<ShippingAddress>();
//                shippingAddress.setCustId(_cust);
//                addrs.add(shippingAddress);
//                _cust.setShippingAddressCollection(addrs);
//            }
//        }
//        Collection<PreOrder> preOrders = new ArrayList<PreOrder>();
//        preOrders.add(preOrder);
//        _cust.setPreOrderCollection(preOrders);
//        logger.debug("===========create Pre-order======");
//        
//        flush();
//        edit(_cust);
        
//        customer.setCustId(RandomNumberUtil.bigId());
//        Collection<PreOrder> preOrderList = new ArrayList<PreOrder>();
//        CustomerRegistration custReg = new CustomerRegistration();
//        custReg.setRegDate(new Date());
//        custReg.setRegId(RandomNumberUtil.bigId());
//        custReg.setCustId(customer);
//        custRegsList.add(custReg);
//        customer.setCustomerRegistrationCollection(custRegsList);
//
//        this.createAddressAndOrder(customer, paymentDetail, billingAddress, shippingAddress, poList);

//    }
}
