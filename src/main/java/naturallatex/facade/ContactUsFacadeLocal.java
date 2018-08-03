/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.facade;

import java.util.Collection;
 
import naturallatex.entity.ContactUs;


/**
 *
 * @author sam
 */
 
public interface ContactUsFacadeLocal {

    ContactUs create(ContactUs contactUs);

    void edit(ContactUs contactUs);

    void remove(ContactUs contactUs);

    ContactUs find(Object id);

    Collection<ContactUs> findAll();

    Collection<ContactUs> findRange(int[] range);

    int count();
    
    public ContactUs findByContactId(Integer id);
    public Collection<ContactUs> findBySubject(String subject);
    public ContactUs findByEmailAddress(String emailAddress);
    public Collection<ContactUs> findByName(String lastName);
    public ContactUs findByEmailAndMessage(String email, String message);
}
