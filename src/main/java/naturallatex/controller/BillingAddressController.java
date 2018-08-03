package naturallatex.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import naturallatex.entity.BillingAddress;
import naturallatex.service.BillingAddressService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
@RequestMapping("/")
public class BillingAddressController {

    @Autowired
    private BillingAddressService billingAddressService;

    @GetMapping("billingAddress/{id}")
    public ResponseEntity<BillingAddress> findByBillingAddressId(@PathVariable("id") Integer id) {
        BillingAddress billingAddress = billingAddressService.findByBillingAddressId(id);
        return new ResponseEntity<BillingAddress>(billingAddress, HttpStatus.OK);
    }

    @GetMapping("billingAddresses")
    public ResponseEntity<List<BillingAddress>> findAll() {
        List<BillingAddress> list = (List<BillingAddress>) billingAddressService.findAll();
        return new ResponseEntity<List<BillingAddress>>(list, HttpStatus.OK);
    }
//
//    @PostMapping("billingAddress")
//    public ResponseEntity<Void> create(@RequestBody BillingAddress billingAddress, UriComponentsBuilder builder) {
//        billingAddressService.create(billingAddress);
////        if (flag == false) {
////        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
////        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/billingAddress/{id}").buildAndExpand(billingAddress.getBillingAddressId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }

    @PostMapping("/billingAddress")
    public ResponseEntity<Void> createBillingAddress(@RequestBody BillingAddress billingAddress) {

        BillingAddress address = billingAddressService.create(billingAddress);

        if (address == null) {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("").buildAndExpand(address.getBillingAddressId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("billingAddress")
    public ResponseEntity<BillingAddress> edit(@RequestBody BillingAddress billingAddress) {
        billingAddressService.edit(billingAddress);
        return new ResponseEntity<BillingAddress>(billingAddress, HttpStatus.OK);
    }

    @DeleteMapping("billingAddress/{id}")
    public ResponseEntity<Void> remove(@PathVariable("id") Integer id) {
        billingAddressService.remove(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
